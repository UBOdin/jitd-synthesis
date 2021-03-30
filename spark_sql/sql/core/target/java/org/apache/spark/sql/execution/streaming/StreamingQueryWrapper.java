package org.apache.spark.sql.execution.streaming;
/**
 * Wrap non-serializable StreamExecution to make the query serializable as it's easy for it to
 * get captured with normal usage. It's safe to capture the query but not use it in executors.
 * However, if the user tries to call its methods, it will throw <code>IllegalStateException</code>.
 */
public  class StreamingQueryWrapper implements org.apache.spark.sql.streaming.StreamingQuery, scala.Serializable {
  // not preceding
  public   StreamingQueryWrapper (org.apache.spark.sql.execution.streaming.StreamExecution _streamingQuery)  { throw new RuntimeException(); }
  public  void awaitTermination ()  { throw new RuntimeException(); }
  public  boolean awaitTermination (long timeoutMs)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.streaming.StreamingQueryException> exception ()  { throw new RuntimeException(); }
  public  void explain ()  { throw new RuntimeException(); }
  public  void explain (boolean extended)  { throw new RuntimeException(); }
  /**
   * This method is called in Python. Python cannot call "explain" directly as it outputs in the JVM
   * process, which may not be visible in Python process.
   * @param extended (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String explainInternal (boolean extended)  { throw new RuntimeException(); }
  public  java.util.UUID id ()  { throw new RuntimeException(); }
  public  boolean isActive ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryProgress lastProgress ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  void processAllAvailable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryProgress[] recentProgress ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryStatus status ()  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.StreamExecution streamingQuery ()  { throw new RuntimeException(); }
}
