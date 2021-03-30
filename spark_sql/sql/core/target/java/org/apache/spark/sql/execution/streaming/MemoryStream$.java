package org.apache.spark.sql.execution.streaming;
public  class MemoryStream$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MemoryStream$ MODULE$ = null;
  public   MemoryStream$ ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.util.concurrent.atomic.AtomicInteger currentBlockId ()  { throw new RuntimeException(); }
  protected  java.util.concurrent.atomic.AtomicInteger memoryStreamId ()  { throw new RuntimeException(); }
  public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.MemoryStream<A> apply (org.apache.spark.sql.Encoder<A> evidence$1, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.MemoryStream<A> apply (int numPartitions, org.apache.spark.sql.Encoder<A> evidence$2, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
}
