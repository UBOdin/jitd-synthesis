package org.apache.spark.sql.streaming;
/**
 * :: Experimental ::
 * <p>
 * Wrapper class for interacting with per-group state data in <code>mapGroupsWithState</code> and
 * <code>flatMapGroupsWithState</code> operations on <code>KeyValueGroupedDataset</code>.
 * <p>
 * Detail description on <code>[map/flatMap]GroupsWithState</code> operation
 * --------------------------------------------------------------
 * Both, <code>mapGroupsWithState</code> and <code>flatMapGroupsWithState</code> in <code>KeyValueGroupedDataset</code>
 * will invoke the user-given function on each group (defined by the grouping function in
 * <code>Dataset.groupByKey()</code>) while maintaining user-defined per-group state between invocations.
 * For a static batch Dataset, the function will be invoked once per group. For a streaming
 * Dataset, the function will be invoked for each group repeatedly in every trigger.
 * That is, in every batch of the <code>StreamingQuery</code>,
 * the function will be invoked once for each group that has data in the trigger. Furthermore,
 * if timeout is set, then the function will invoked on timed out groups (more detail below).
 * <p>
 * The function is invoked with following parameters.
 *  - The key of the group.
 *  - An iterator containing all the values for this group.
 *  - A user-defined state object set by previous invocations of the given function.
 * <p>
 * In case of a batch Dataset, there is only one invocation and state object will be empty as
 * there is no prior state. Essentially, for batch Datasets, <code>[map/flatMap]GroupsWithState</code>
 * is equivalent to <code>[map/flatMap]Groups</code> and any updates to the state and/or timeouts have
 * no effect.
 * <p>
 * The major difference between <code>mapGroupsWithState</code> and <code>flatMapGroupsWithState</code> is that the
 * former allows the function to return one and only one record, whereas the latter
 * allows the function to return any number of records (including no records). Furthermore, the
 * <code>flatMapGroupsWithState</code> is associated with an operation output mode, which can be either
 * <code>Append</code> or <code>Update</code>. Semantically, this defines whether the output records of one trigger
 * is effectively replacing the previously output records (from previous triggers) or is appending
 * to the list of previously output records. Essentially, this defines how the Result Table (refer
 * to the semantics in the programming guide) is updated, and allows us to reason about the
 * semantics of later operations.
 * <p>
 * Important points to note about the function (both mapGroupsWithState and flatMapGroupsWithState).
 *  - In a trigger, the function will be called only the groups present in the batch. So do not
 *    assume that the function will be called in every trigger for every group that has state.
 *  - There is no guaranteed ordering of values in the iterator in the function, neither with
 *    batch, nor with streaming Datasets.
 *  - All the data will be shuffled before applying the function.
 *  - If timeout is set, then the function will also be called with no values.
 *    See more details on <code>GroupStateTimeout</code> below.
 * <p>
 * Important points to note about using <code>GroupState</code>.
 *  - The value of the state cannot be null. So updating state with null will throw
 *    <code>IllegalArgumentException</code>.
 *  - Operations on <code>GroupState</code> are not thread-safe. This is to avoid memory barriers.
 *  - If <code>remove()</code> is called, then <code>exists()</code> will return <code>false</code>,
 *    <code>get()</code> will throw <code>NoSuchElementException</code> and <code>getOption()</code> will return <code>None</code>
 *  - After that, if <code>update(newState)</code> is called, then <code>exists()</code> will again return <code>true</code>,
 *    <code>get()</code> and <code>getOption()</code>will return the updated value.
 * <p>
 * Important points to note about using <code>GroupStateTimeout</code>.
 *  - The timeout type is a global param across all the groups (set as <code>timeout</code> param in
 *    <code>[map|flatMap]GroupsWithState</code>, but the exact timeout duration/timestamp is configurable per
 *    group by calling <code>setTimeout...()</code> in <code>GroupState</code>.
 *  - Timeouts can be either based on processing time (i.e.
 *    <code>GroupStateTimeout.ProcessingTimeTimeout</code>) or event time (i.e.
 *    <code>GroupStateTimeout.EventTimeTimeout</code>).
 *  - With <code>ProcessingTimeTimeout</code>, the timeout duration can be set by calling
 *    <code>GroupState.setTimeoutDuration</code>. The timeout will occur when the clock has advanced by the set
 *    duration. Guarantees provided by this timeout with a duration of D ms are as follows:
 *    - Timeout will never be occur before the clock time has advanced by D ms
 *    - Timeout will occur eventually when there is a trigger in the query
 *      (i.e. after D ms). So there is a no strict upper bound on when the timeout would occur.
 *      For example, the trigger interval of the query will affect when the timeout actually occurs.
 *      If there is no data in the stream (for any group) for a while, then their will not be
 *      any trigger and timeout function call will not occur until there is data.
 *    - Since the processing time timeout is based on the clock time, it is affected by the
 *      variations in the system clock (i.e. time zone changes, clock skew, etc.).
 *  - With <code>EventTimeTimeout</code>, the user also has to specify the event time watermark in
 *    the query using <code>Dataset.withWatermark()</code>. With this setting, data that is older than the
 *    watermark are filtered out. The timeout can be set for a group by setting a timeout timestamp
 *    using<code>GroupState.setTimeoutTimestamp()</code>, and the timeout would occur when the watermark
 *    advances beyond the set timestamp. You can control the timeout delay by two parameters -
 *    (i) watermark delay and an additional duration beyond the timestamp in the event (which
 *    is guaranteed to be newer than watermark due to the filtering). Guarantees provided by this
 *    timeout are as follows:
 *    - Timeout will never be occur before watermark has exceeded the set timeout.
 *    - Similar to processing time timeouts, there is a no strict upper bound on the delay when
 *      the timeout actually occurs. The watermark can advance only when there is data in the
 *      stream, and the event time of the data has actually advanced.
 *  - When the timeout occurs for a group, the function is called for that group with no values, and
 *    <code>GroupState.hasTimedOut()</code> set to true.
 *  - The timeout is reset every time the function is called on a group, that is,
 *    when the group has new data, or the group has timed out. So the user has to set the timeout
 *    duration every time the function is called, otherwise there will not be any timeout set.
 * <p>
 * Scala example of using GroupState in <code>mapGroupsWithState</code>:
 * <pre><code>
 * // A mapping function that maintains an integer state for string keys and returns a string.
 * // Additionally, it sets a timeout to remove the state if it has not received data for an hour.
 * def mappingFunction(key: String, value: Iterator[Int], state: GroupState[Int]): String = {
 *
 *   if (state.hasTimedOut) {                // If called when timing out, remove the state
 *     state.remove()
 *
 *   } else if (state.exists) {              // If state exists, use it for processing
 *     val existingState = state.get         // Get the existing state
 *     val shouldRemove = ...                // Decide whether to remove the state
 *     if (shouldRemove) {
 *       state.remove()                      // Remove the state
 *
 *     } else {
 *       val newState = ...
 *       state.update(newState)              // Set the new state
 *       state.setTimeoutDuration("1 hour")  // Set the timeout
 *     }
 *
 *   } else {
 *     val initialState = ...
 *     state.update(initialState)            // Set the initial state
 *     state.setTimeoutDuration("1 hour")    // Set the timeout
 *   }
 *   ...
 *   // return something
 * }
 *
 * dataset
 *   .groupByKey(...)
 *   .mapGroupsWithState(GroupStateTimeout.ProcessingTimeTimeout)(mappingFunction)
 * </code></pre>
 * <p>
 * Java example of using <code>GroupState</code>:
 * <pre><code>
 * // A mapping function that maintains an integer state for string keys and returns a string.
 * // Additionally, it sets a timeout to remove the state if it has not received data for an hour.
 * MapGroupsWithStateFunction&lt;String, Integer, Integer, String&gt; mappingFunction =
 *    new MapGroupsWithStateFunction&lt;String, Integer, Integer, String&gt;() {
 *
 *      &#64;Override
 *      public String call(String key, Iterator&lt;Integer&gt; value, GroupState&lt;Integer&gt; state) {
 *        if (state.hasTimedOut()) {            // If called when timing out, remove the state
 *          state.remove();
 *
 *        } else if (state.exists()) {            // If state exists, use it for processing
 *          int existingState = state.get();      // Get the existing state
 *          boolean shouldRemove = ...;           // Decide whether to remove the state
 *          if (shouldRemove) {
 *            state.remove();                     // Remove the state
 *
 *          } else {
 *            int newState = ...;
 *            state.update(newState);             // Set the new state
 *            state.setTimeoutDuration("1 hour"); // Set the timeout
 *          }
 *
 *        } else {
 *          int initialState = ...;               // Set the initial state
 *          state.update(initialState);
 *          state.setTimeoutDuration("1 hour");   // Set the timeout
 *        }
 *        ...
 *         // return something
 *      }
 *    };
 *
 * dataset
 *     .groupByKey(...)
 *     .mapGroupsWithState(
 *         mappingFunction, Encoders.INT, Encoders.STRING, GroupStateTimeout.ProcessingTimeTimeout);
 * </code></pre>
 * <p>
 * @param <S>  User-defined type of the state to be stored for each group. Must be encodable into
 *           Spark SQL types (see <code>Encoder</code> for more details).
 * @since 2.2.0
 */
public  interface GroupState<S extends java.lang.Object> extends org.apache.spark.sql.catalyst.plans.logical.LogicalGroupState<S> {
  /** Whether state exists or not. */
  public  boolean exists ()  ;
  /** Get the state value if it exists, or throw NoSuchElementException. */
  public  S get () throws java.util.NoSuchElementException ;
  /**
   * Get the current processing time as milliseconds in epoch time.
   * @note In a streaming query, this will return a constant value throughout the duration of a
   *       trigger, even if the trigger is re-executed.
   * @return (undocumented)
   */
  public  long getCurrentProcessingTimeMs ()  ;
  /**
   * Get the current event time watermark as milliseconds in epoch time.
   * <p>
   * @note In a streaming query, this can be called only when watermark is set before calling
   *       <code>[map/flatMap]GroupsWithState</code>. In a batch query, this method always returns -1.
   * @return (undocumented)
   */
  public  long getCurrentWatermarkMs () throws java.lang.UnsupportedOperationException ;
  /** Get the state value as a scala Option. */
  public  scala.Option<S> getOption ()  ;
  /**
   * Whether the function has been called because the key has timed out.
   * @note This can return true only when timeouts are enabled in <code>[map/flatMap]GroupsWithState</code>.
   * @return (undocumented)
   */
  public  boolean hasTimedOut ()  ;
  /** Remove this state. */
  public  void remove ()  ;
  /**
   * Set the timeout duration in ms for this key.
   * <p>
   * @note {@link GroupStateTimeout Processing time timeout} must be enabled in
   *       <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no effect when used in a batch query.
   * @param durationMs (undocumented)
   */
  public  void setTimeoutDuration (long durationMs) throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException ;
  /**
   * Set the timeout duration for this key as a string. For example, "1 hour", "2 days", etc.
   * <p>
   * @note {@link GroupStateTimeout Processing time timeout} must be enabled in
   *       <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no effect when used in a batch query.
   * @param duration (undocumented)
   */
  public  void setTimeoutDuration (java.lang.String duration) throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException ;
  /**
   * Set the timeout timestamp for this key as milliseconds in epoch time.
   * This timestamp cannot be older than the current watermark.
   * <p>
   * @note {@link GroupStateTimeout Event time timeout} must be enabled in
   *       <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no effect when used in a batch query.
   * @param timestampMs (undocumented)
   */
  public  void setTimeoutTimestamp (long timestampMs) throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException ;
  /**
   * Set the timeout timestamp for this key as milliseconds in epoch time and an additional
   * duration as a string (e.g. "1 hour", "2 days", etc.).
   * The final timestamp (including the additional duration) cannot be older than the
   * current watermark.
   * <p>
   * @note {@link GroupStateTimeout Event time timeout} must be enabled in
   *       <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no side effect when used in a batch query.
   * @param timestampMs (undocumented)
   * @param additionalDuration (undocumented)
   */
  public  void setTimeoutTimestamp (long timestampMs, java.lang.String additionalDuration) throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException ;
  /**
   * Set the timeout timestamp for this key as a java.sql.Date.
   * This timestamp cannot be older than the current watermark.
   * <p>
   * @note {@link GroupStateTimeout Event time timeout} must be enabled in
   *       <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no side effect when used in a batch query.
   * @param timestamp (undocumented)
   */
  public  void setTimeoutTimestamp (java.sql.Date timestamp) throws java.lang.UnsupportedOperationException ;
  /**
   * Set the timeout timestamp for this key as a java.sql.Date and an additional
   * duration as a string (e.g. "1 hour", "2 days", etc.).
   * The final timestamp (including the additional duration) cannot be older than the
   * current watermark.
   * <p>
   * @note {@link GroupStateTimeout Event time timeout} must be enabled in
   *      <code>[map/flatMap]GroupsWithState</code> for calling this method.
   * @note This method has no side effect when used in a batch query.
   * @param timestamp (undocumented)
   * @param additionalDuration (undocumented)
   */
  public  void setTimeoutTimestamp (java.sql.Date timestamp, java.lang.String additionalDuration) throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException ;
  /** Update the value of the state. */
  public  void update (S newState)  ;
}
