package org.apache.spark.sql.execution.streaming.state;
/**
 * Helper class to manage state required by a single side of
 * {@link org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinExec}.
 * The interface of this class is basically that of a multi-map:
 * - Get: Returns an iterator of multiple values for given key
 * - Append: Append a new value to the given key
 * - Remove Data by predicate: Drop any state using a predicate condition on keys or values
 * <p>
 * param:  joinSide              Defines the join side
 * param:  inputValueAttributes  Attributes of the input row which will be stored as value
 * param:  joinKeys              Expressions to generate rows that will be used to key the value rows
 * param:  stateInfo             Information about how to retrieve the correct version of state
 * param:  storeConf             Configuration for the state store.
 * param:  hadoopConf            Hadoop configuration for reading state data from storage
 * param:  partitionId           A partition ID of source RDD.
 * param:  stateFormatVersion    The version of format for state.
 * <p>
 * Internally, the key -> multiple values is stored in two {@link StateStore}s.
 * - Store 1 ({@link KeyToNumValuesStore}) maintains mapping between key -> number of values
 * - Store 2 ({@link KeyWithIndexToValueStore}) maintains mapping; the mapping depends on the state
 *   format version:
 *   - version 1: [(key, index) -> value]
 *   - version 2: [(key, index) -> (value, matched)]
 * - Put:   update count in KeyToNumValuesStore,
 *          insert new (key, count) -> value in KeyWithIndexToValueStore
 * - Get:   read count from KeyToNumValuesStore,
 *          read each of the n values in KeyWithIndexToValueStore
 * - Remove state by predicate on keys:
 *          scan all keys in KeyToNumValuesStore to find keys that do match the predicate,
 *          delete from key from KeyToNumValuesStore, delete values in KeyWithIndexToValueStore
 * - Remove state by condition on values:
 *          scan all elements in KeyWithIndexToValueStore to find values that match
 *          the predicate, delete corresponding (key, indexToDelete) from KeyWithIndexToValueStore
 *          by overwriting with the value of (key, maxIndex), and removing [(key, maxIndex),
 *          decrement corresponding num values in KeyToNumValuesStore
 */
public  class SymmetricHashJoinStateManager implements org.apache.spark.internal.Logging {
  public  interface KeyWithIndexToValueRowConverter {
    /**
     * Build the value row from (actual value, match) pair. This is expected to be called just
     * before storing to the state store.
     * <p>
     * NOTE: depending on the implementation, the result row "may" be reused during execution
     * (to avoid initialization of object), so the caller should ensure that the logic doesn't
     * affect by such behavior. Call copy() against the result row if needed.
     * @param value (undocumented)
     * @param matched (undocumented)
     * @return (undocumented)
     */
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow convertToValueRow (org.apache.spark.sql.catalyst.expressions.UnsafeRow value, boolean matched)  ;
    /**
     * Convert the value row to (actual value, match) pair.
     * <p>
     * NOTE: implementations should ensure the result row is NOT reused during execution, so
     * that caller can safely read the value in any time.
     * @param value (undocumented)
     * @return (undocumented)
     */
    public  org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.ValueAndMatchPair convertValue (org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  ;
    /** Defines the schema of the value row (the value side of K-V in state store). */
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> valueAttributes ()  ;
  }
  /** Helper class for representing data (value, matched). */
  static public  class ValueAndMatchPair implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow value ()  { throw new RuntimeException(); }
    public  boolean matched ()  { throw new RuntimeException(); }
    // not preceding
    public   ValueAndMatchPair (org.apache.spark.sql.catalyst.expressions.UnsafeRow value, boolean matched)  { throw new RuntimeException(); }
  }
  static public  class ValueAndMatchPair$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object, org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.ValueAndMatchPair> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ValueAndMatchPair$ MODULE$ = null;
    public   ValueAndMatchPair$ ()  { throw new RuntimeException(); }
  }
  /**
   * Helper class for representing data key to (value, matched).
   * Designed for object reuse.
   */
  static public  class KeyToValuePair implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow key ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow value ()  { throw new RuntimeException(); }
    public  boolean matched ()  { throw new RuntimeException(); }
    // not preceding
    public   KeyToValuePair (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value, boolean matched)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.KeyToValuePair withNew (org.apache.spark.sql.catalyst.expressions.UnsafeRow newKey, org.apache.spark.sql.catalyst.expressions.UnsafeRow newValue, boolean newMatched)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.KeyToValuePair withNew (org.apache.spark.sql.catalyst.expressions.UnsafeRow newKey, org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.ValueAndMatchPair newValue)  { throw new RuntimeException(); }
  }
  static public  class KeyToValuePair$ extends scala.runtime.AbstractFunction3<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object, org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.KeyToValuePair> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final KeyToValuePair$ MODULE$ = null;
    public   KeyToValuePair$ ()  { throw new RuntimeException(); }
  }
  static public  interface StateStoreType {
  }
  static public  scala.collection.Seq<java.lang.Object> supportedVersions ()  { throw new RuntimeException(); }
  static public  int legacyVersion ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<java.lang.String> allStateStoreNames (scala.collection.Seq<org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinSide> joinSides)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinSide joinSide ()  { throw new RuntimeException(); }
  // not preceding
  public   SymmetricHashJoinStateManager (org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinSide joinSide, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputValueAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> joinKeys, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConf, org.apache.hadoop.conf.Configuration hadoopConf, int partitionId, int stateFormatVersion)  { throw new RuntimeException(); }
  /** Get all the values of a key */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
  /** Append a new value to the key */
  public  void append (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value, boolean matched)  { throw new RuntimeException(); }
  /**
   * Get all the matched values for given join condition, with marking matched.
   * This method is designed to mark joined rows properly without exposing internal index of row.
   * <p>
   * @param excludeRowsAlreadyMatched Do not join with rows already matched previously.
   *                                  This is used for right side of left semi join in
   *                                  {@link StreamingSymmetricHashJoinExec} only.
   * @param key (undocumented)
   * @param generateJoinedRow (undocumented)
   * @param predicate (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.JoinedRow> getJoinedRows (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.expressions.JoinedRow> generateJoinedRow, scala.Function1<org.apache.spark.sql.catalyst.expressions.JoinedRow, java.lang.Object> predicate, boolean excludeRowsAlreadyMatched)  { throw new RuntimeException(); }
  /**
   * Remove using a predicate on keys.
   * <p>
   * This produces an iterator over the (key, value, matched) tuples satisfying condition(key),
   * where the underlying store is updated as a side-effect of producing next.
   * <p>
   * This implies the iterator must be consumed fully without any other operations on this manager
   * or the underlying store being interleaved.
   * @param removalCondition (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.KeyToValuePair> removeByKeyCondition (scala.Function1<org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object> removalCondition)  { throw new RuntimeException(); }
  /**
   * Remove using a predicate on values.
   * <p>
   * At a high level, this produces an iterator over the (key, value, matched) tuples such that
   * value satisfies the predicate, where producing an element removes the value from the
   * state store and producing all elements with a given key updates it accordingly.
   * <p>
   * This implies the iterator must be consumed fully without any other operations on this manager
   * or the underlying store being interleaved.
   * @param removalCondition (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.SymmetricHashJoinStateManager.KeyToValuePair> removeByValueCondition (scala.Function1<org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object> removalCondition)  { throw new RuntimeException(); }
  /** Commit all the changes to all the state stores */
  public  void commit ()  { throw new RuntimeException(); }
  /** Abort any changes to the state stores if needed */
  public  void abortIfNeeded ()  { throw new RuntimeException(); }
  /** Get the combined metrics of all the state stores */
  public  org.apache.spark.sql.execution.streaming.state.StateStoreMetrics metrics ()  { throw new RuntimeException(); }
}
