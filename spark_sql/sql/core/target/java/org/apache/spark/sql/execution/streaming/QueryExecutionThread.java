package org.apache.spark.sql.execution.streaming;
/**
 * A special thread to run the stream query. Some codes require to run in the QueryExecutionThread
 * and will use <code>classOf[QueryExecutionThread]</code> to check.
 */
public abstract class QueryExecutionThread extends org.apache.spark.util.UninterruptibleThread {
  public   QueryExecutionThread (java.lang.String name)  { throw new RuntimeException(); }
}
