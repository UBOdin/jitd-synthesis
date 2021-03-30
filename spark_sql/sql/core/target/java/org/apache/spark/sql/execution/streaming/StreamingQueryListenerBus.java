package org.apache.spark.sql.execution.streaming;
/**
 * A bus to forward events to {@link StreamingQueryListener}s. This one will send received
 * {@link StreamingQueryListener.Event}s to the Spark listener bus. It also registers itself with
 * Spark listener bus, so that it can receive {@link StreamingQueryListener.Event}s and dispatch them
 * to StreamingQueryListeners.
 * <p>
 * Note 1: Each bus and its registered listeners are associated with a single SparkSession
 * and StreamingQueryManager. So this bus will dispatch events to registered listeners for only
 * those queries that were started in the associated SparkSession.
 * <p>
 * Note 2: To rebuild Structured Streaming UI in SHS, this bus will be registered into
 * {@link org.apache.spark.scheduler.ReplayListenerBus}. We check <code>sparkListenerBus</code> defined or not to
 * determine how to process {@link StreamingQueryListener.Event}. If false, it means this bus is used to
 * replay all streaming query event from eventLog.
 */
public  class StreamingQueryListenerBus extends org.apache.spark.scheduler.SparkListener implements org.apache.spark.util.ListenerBus<org.apache.spark.sql.streaming.StreamingQueryListener, org.apache.spark.sql.streaming.StreamingQueryListener.Event> {
  static public  java.lang.String STREAM_EVENT_QUERY ()  { throw new RuntimeException(); }
  public   StreamingQueryListenerBus (scala.Option<org.apache.spark.scheduler.LiveListenerBus> sparkListenerBus)  { throw new RuntimeException(); }
  /**
   * Post a StreamingQueryListener event to the added StreamingQueryListeners.
   * Note that only the QueryStarted event is posted to the listener synchronously. Other events
   * are dispatched to Spark listener bus. This method is guaranteed to be called by queries in
   * the same SparkSession as this listener.
   * @param event (undocumented)
   */
  public  void post (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
  /**
   * Override the parent <code>postToAll</code> to remove the query id from <code>activeQueryRunIds</code> after all
   * the listeners process <code>QueryTerminatedEvent</code>. (SPARK-19594)
   * @param event (undocumented)
   */
  public  void postToAll (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
  public  void onOtherEvent (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
  /**
   * Dispatch events to registered StreamingQueryListeners. Only the events associated queries
   * started in the same SparkSession as this ListenerBus will be dispatched to the listeners.
   * @param listener (undocumented)
   * @param event (undocumented)
   */
  protected  void doPostEvent (org.apache.spark.sql.streaming.StreamingQueryListener listener, org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
}
