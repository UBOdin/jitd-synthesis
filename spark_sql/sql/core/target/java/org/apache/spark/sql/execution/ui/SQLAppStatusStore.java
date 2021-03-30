package org.apache.spark.sql.execution.ui;
/**
 * Provides a view of a KVStore with methods that make it easy to query SQL-specific state. There's
 * no state kept in this class, so it's ok to have multiple instances of it in an application.
 */
public  class SQLAppStatusStore {
  public  scala.Option<org.apache.spark.sql.execution.ui.SQLAppStatusListener> listener ()  { throw new RuntimeException(); }
  // not preceding
  public   SQLAppStatusStore (org.apache.spark.util.kvstore.KVStore store, scala.Option<org.apache.spark.sql.execution.ui.SQLAppStatusListener> listener)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLExecutionUIData> executionsList ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLExecutionUIData> executionsList (int offset, int length)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.ui.SQLExecutionUIData> execution (long executionId)  { throw new RuntimeException(); }
  public  long executionsCount ()  { throw new RuntimeException(); }
  public  long planGraphCount ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.String> executionMetrics (long executionId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ui.SparkPlanGraph planGraph (long executionId)  { throw new RuntimeException(); }
}
