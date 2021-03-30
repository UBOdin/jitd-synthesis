package org.apache.spark.sql.streaming;
/**
 * A class to manage all the {@link StreamingQuery} active in a <code>SparkSession</code>.
 * <p>
 * @since 2.0.0
 */
public  class StreamingQueryManager implements org.apache.spark.internal.Logging {
     StreamingQueryManager (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Returns a list of active queries associated with this SQLContext
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery[] active ()  { throw new RuntimeException(); }
  /**
   * Register a {@link StreamingQueryListener} to receive up-calls for life cycle events of
   * {@link StreamingQuery}.
   * <p>
   * @since 2.0.0
   * @param listener (undocumented)
   */
  public  void addListener (org.apache.spark.sql.streaming.StreamingQueryListener listener)  { throw new RuntimeException(); }
  /**
   * Wait until any of the queries on the associated SQLContext has terminated since the
   * creation of the context, or since <code>resetTerminated()</code> was called. If any query was terminated
   * with an exception, then the exception will be thrown.
   * <p>
   * If a query has terminated, then subsequent calls to <code>awaitAnyTermination()</code> will either
   * return immediately (if the query was terminated by <code>query.stop()</code>),
   * or throw the exception immediately (if the query was terminated with exception). Use
   * <code>resetTerminated()</code> to clear past terminations and wait for new terminations.
   * <p>
   * In the case where multiple queries have terminated since <code>resetTermination()</code> was called,
   * if any query has terminated with exception, then <code>awaitAnyTermination()</code> will
   * throw any of the exception. For correctly documenting exceptions across multiple queries,
   * users need to stop all of them after any of them terminates with exception, and then check the
   * <code>query.exception()</code> for each query.
   * <p>
   * @throws StreamingQueryException if any query has terminated with an exception
   * <p>
   * @since 2.0.0
   */
  public  void awaitAnyTermination () throws org.apache.spark.sql.streaming.StreamingQueryException { throw new RuntimeException(); }
  /**
   * Wait until any of the queries on the associated SQLContext has terminated since the
   * creation of the context, or since <code>resetTerminated()</code> was called. Returns whether any query
   * has terminated or not (multiple may have terminated). If any query has terminated with an
   * exception, then the exception will be thrown.
   * <p>
   * If a query has terminated, then subsequent calls to <code>awaitAnyTermination()</code> will either
   * return <code>true</code> immediately (if the query was terminated by <code>query.stop()</code>),
   * or throw the exception immediately (if the query was terminated with exception). Use
   * <code>resetTerminated()</code> to clear past terminations and wait for new terminations.
   * <p>
   * In the case where multiple queries have terminated since <code>resetTermination()</code> was called,
   * if any query has terminated with exception, then <code>awaitAnyTermination()</code> will
   * throw any of the exception. For correctly documenting exceptions across multiple queries,
   * users need to stop all of them after any of them terminates with exception, and then check the
   * <code>query.exception()</code> for each query.
   * <p>
   * @throws StreamingQueryException if any query has terminated with an exception
   * <p>
   * @since 2.0.0
   * @param timeoutMs (undocumented)
   * @return (undocumented)
   */
  public  boolean awaitAnyTermination (long timeoutMs) throws org.apache.spark.sql.streaming.StreamingQueryException { throw new RuntimeException(); }
  /**
   * Returns the query if there is an active query with the given id, or null.
   * <p>
   * @since 2.1.0
   * @param id (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery get (java.util.UUID id)  { throw new RuntimeException(); }
  /**
   * Returns the query if there is an active query with the given id, or null.
   * <p>
   * @since 2.1.0
   * @param id (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery get (java.lang.String id)  { throw new RuntimeException(); }
  /**
   * List all {@link StreamingQueryListener}s attached to this {@link StreamingQueryManager}.
   * <p>
   * @since 3.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQueryListener[] listListeners ()  { throw new RuntimeException(); }
  /** Notify (by the StreamingQuery) that the query has been terminated */
    void notifyQueryTermination (org.apache.spark.sql.streaming.StreamingQuery terminatedQuery)  { throw new RuntimeException(); }
  /** Post a listener event */
    void postListenerEvent (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
  /**
   * Deregister a {@link StreamingQueryListener}.
   * <p>
   * @since 2.0.0
   * @param listener (undocumented)
   */
  public  void removeListener (org.apache.spark.sql.streaming.StreamingQueryListener listener)  { throw new RuntimeException(); }
  /**
   * Forget about past terminated queries so that <code>awaitAnyTermination()</code> can be used again to
   * wait for new terminations.
   * <p>
   * @since 2.0.0
   */
  public  void resetTerminated ()  { throw new RuntimeException(); }
  /**
   * Start a {@link StreamingQuery}.
   * <p>
   * @param userSpecifiedName Query name optionally specified by the user.
   * @param userSpecifiedCheckpointLocation  Checkpoint location optionally specified by the user.
   * @param df Streaming DataFrame.
   * @param sink  Sink to write the streaming outputs.
   * @param outputMode  Output mode for the sink.
   * @param useTempCheckpointLocation  Whether to use a temporary checkpoint location when the user
   *                                   has not specified one. If false, then error will be thrown.
   * @param recoverFromCheckpointLocation  Whether to recover query from the checkpoint location.
   *                                       If false and the checkpoint location exists, then error
   *                                       will be thrown.
   * @param trigger {@link Trigger} for the query.
   * @param triggerClock {@link Clock} to use for the triggering.
   * @param extraOptions (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.streaming.StreamingQuery startQuery (scala.Option<java.lang.String> userSpecifiedName, scala.Option<java.lang.String> userSpecifiedCheckpointLocation, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraOptions, org.apache.spark.sql.connector.catalog.Table sink, org.apache.spark.sql.streaming.OutputMode outputMode, boolean useTempCheckpointLocation, boolean recoverFromCheckpointLocation, org.apache.spark.sql.streaming.Trigger trigger, org.apache.spark.util.Clock triggerClock) throws java.util.concurrent.TimeoutException { throw new RuntimeException(); }
    org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorRef stateStoreCoordinator ()  { throw new RuntimeException(); }
}
