package org.apache.spark.sql.streaming.ui;
  class StreamingQueryProgressWrapper {
  /**
   * Adding <code>timestamp</code> into unique id to support reporting <code>empty</code> query progress
   * in which no data comes but with the same batchId.
   * @param runId (undocumented)
   * @param batchId (undocumented)
   * @param timestamp (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String getUniqueId (java.util.UUID runId, long batchId, java.lang.String timestamp)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryProgress progress ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingQueryProgressWrapper (org.apache.spark.sql.streaming.StreamingQueryProgress progress)  { throw new RuntimeException(); }
}
