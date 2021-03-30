package org.apache.spark.sql.streaming;
/**
 * Interface for listening to events related to {@link StreamingQuery StreamingQueries}.
 * @note The methods are not thread-safe as they may be called from different threads.
 * <p>
 * @since 2.0.0
 */
public abstract class StreamingQueryListener {
  /**
   * Base type of {@link StreamingQueryListener} events
   * @since 2.0.0
   */
  static public  interface Event extends org.apache.spark.scheduler.SparkListenerEvent {
  }
  /**
   * Event representing the start of a query
   * param:  id A unique query id that persists across restarts. See <code>StreamingQuery.id()</code>.
   * param:  runId A query id that is unique for every start/restart. See <code>StreamingQuery.runId()</code>.
   * param:  name User-specified name of the query, null if not specified.
   * param:  timestamp The timestamp to start a query.
   * @since 2.1.0
   */
  static public  class QueryStartedEvent implements org.apache.spark.sql.streaming.StreamingQueryListener.Event {
    // not preceding
       QueryStartedEvent (java.util.UUID id, java.util.UUID runId, java.lang.String name, java.lang.String timestamp)  { throw new RuntimeException(); }
    public  java.util.UUID id ()  { throw new RuntimeException(); }
    public  java.lang.String name ()  { throw new RuntimeException(); }
    public  java.util.UUID runId ()  { throw new RuntimeException(); }
    public  java.lang.String timestamp ()  { throw new RuntimeException(); }
  }
  /**
   * Event representing any progress updates in a query.
   * param:  progress The query progress updates.
   * @since 2.1.0
   */
  static public  class QueryProgressEvent implements org.apache.spark.sql.streaming.StreamingQueryListener.Event {
    // not preceding
       QueryProgressEvent (org.apache.spark.sql.streaming.StreamingQueryProgress progress)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.streaming.StreamingQueryProgress progress ()  { throw new RuntimeException(); }
  }
  /**
   * Event representing that termination of a query.
   * <p>
   * param:  id A unique query id that persists across restarts. See <code>StreamingQuery.id()</code>.
   * param:  runId A query id that is unique for every start/restart. See <code>StreamingQuery.runId()</code>.
   * param:  exception The exception message of the query if the query was terminated
   *                  with an exception. Otherwise, it will be <code>None</code>.
   * @since 2.1.0
   */
  static public  class QueryTerminatedEvent implements org.apache.spark.sql.streaming.StreamingQueryListener.Event {
    // not preceding
       QueryTerminatedEvent (java.util.UUID id, java.util.UUID runId, scala.Option<java.lang.String> exception)  { throw new RuntimeException(); }
    public  scala.Option<java.lang.String> exception ()  { throw new RuntimeException(); }
    public  java.util.UUID id ()  { throw new RuntimeException(); }
    public  java.util.UUID runId ()  { throw new RuntimeException(); }
  }
  public   StreamingQueryListener ()  { throw new RuntimeException(); }
  /**
   * Called when a query is started.
   * @note This is called synchronously with
   *       {@link org.apache.spark.sql.streaming.DataStreamWriter <code>DataStreamWriter.start()</code>},
   *       that is, <code>onQueryStart</code> will be called on all listeners before
   *       <code>DataStreamWriter.start()</code> returns the corresponding {@link StreamingQuery}. Please
   *       don't block this method as it will block your query.
   * @since 2.0.0
   * @param event (undocumented)
   */
  public abstract  void onQueryStarted (org.apache.spark.sql.streaming.StreamingQueryListener.QueryStartedEvent event)  ;
  /**
   * Called when there is some status update (ingestion rate updated, etc.)
   * <p>
   * @note This method is asynchronous. The status in {@link StreamingQuery} will always be
   *       latest no matter when this method is called. Therefore, the status of {@link StreamingQuery}
   *       may be changed before/when you process the event. E.g., you may find {@link StreamingQuery}
   *       is terminated when you are processing <code>QueryProgressEvent</code>.
   * @since 2.0.0
   * @param event (undocumented)
   */
  public abstract  void onQueryProgress (org.apache.spark.sql.streaming.StreamingQueryListener.QueryProgressEvent event)  ;
  /**
   * Called when a query is stopped, with or without error.
   * @since 2.0.0
   * @param event (undocumented)
   */
  public abstract  void onQueryTerminated (org.apache.spark.sql.streaming.StreamingQueryListener.QueryTerminatedEvent event)  ;
}
