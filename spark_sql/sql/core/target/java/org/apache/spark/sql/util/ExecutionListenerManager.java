package org.apache.spark.sql.util;
/**
 * Manager for {@link QueryExecutionListener}. See <code>org.apache.spark.sql.SQLContext.listenerManager</code>.
 */
public  class ExecutionListenerManager implements org.apache.spark.internal.Logging {
     ExecutionListenerManager (org.apache.spark.sql.SparkSession session, boolean loadExtensions)  { throw new RuntimeException(); }
  /**
   * Removes all the registered {@link QueryExecutionListener}.
   */
  public  void clear ()  { throw new RuntimeException(); }
  /**
   * Get an identical copy of this listener manager.
   * @param session (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.util.ExecutionListenerManager clone (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /** Only exposed for testing. */
    org.apache.spark.sql.util.QueryExecutionListener[] listListeners ()  { throw new RuntimeException(); }
  /**
   * Registers the specified {@link QueryExecutionListener}.
   * @param listener (undocumented)
   */
  public  void register (org.apache.spark.sql.util.QueryExecutionListener listener)  { throw new RuntimeException(); }
  /**
   * Unregisters the specified {@link QueryExecutionListener}.
   * @param listener (undocumented)
   */
  public  void unregister (org.apache.spark.sql.util.QueryExecutionListener listener)  { throw new RuntimeException(); }
}
