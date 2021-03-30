package org.apache.spark.sql.execution.streaming;
public  class CommitMetadata implements scala.Product, scala.Serializable {
  static public  java.lang.Object format ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.CommitMetadata apply (java.lang.String json)  { throw new RuntimeException(); }
  public  long nextBatchWatermarkMs ()  { throw new RuntimeException(); }
  // not preceding
  public   CommitMetadata (long nextBatchWatermarkMs)  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
