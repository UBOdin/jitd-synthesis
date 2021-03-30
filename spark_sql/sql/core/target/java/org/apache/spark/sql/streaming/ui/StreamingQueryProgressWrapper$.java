package org.apache.spark.sql.streaming.ui;
public  class StreamingQueryProgressWrapper$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StreamingQueryProgressWrapper$ MODULE$ = null;
  public   StreamingQueryProgressWrapper$ ()  { throw new RuntimeException(); }
  /**
   * Adding <code>timestamp</code> into unique id to support reporting <code>empty</code> query progress
   * in which no data comes but with the same batchId.
   * @param runId (undocumented)
   * @param batchId (undocumented)
   * @param timestamp (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getUniqueId (java.util.UUID runId, long batchId, java.lang.String timestamp)  { throw new RuntimeException(); }
}
