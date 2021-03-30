package org.apache.spark.sql.execution.streaming;
public  class MemoryStream<A extends java.lang.Object> extends org.apache.spark.sql.execution.streaming.MemoryStreamBase<A> implements org.apache.spark.sql.connector.read.streaming.MicroBatchStream, org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  // not preceding
  static protected  java.util.concurrent.atomic.AtomicInteger currentBlockId ()  { throw new RuntimeException(); }
  static protected  java.util.concurrent.atomic.AtomicInteger memoryStreamId ()  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.MemoryStream<A> apply (org.apache.spark.sql.Encoder<A> evidence$1, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.MemoryStream<A> apply (int numPartitions, org.apache.spark.sql.Encoder<A> evidence$2, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  public  int id ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> numPartitions ()  { throw new RuntimeException(); }
  public   MemoryStream (int id, org.apache.spark.sql.SQLContext sqlContext, scala.Option<java.lang.Object> numPartitions, org.apache.spark.sql.Encoder<A> evidence$4)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  /**
   * All batches from <code>lastCommittedOffset + 1</code> to <code>currentOffset</code>, inclusive.
   * Stored in a ListBuffer to facilitate removing committed batches.
   * @return (undocumented)
   */
  protected  scala.collection.mutable.ListBuffer<org.apache.spark.sql.catalyst.expressions.UnsafeRow[]> batches ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.LongOffset currentOffset ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.LongOffset startOffset ()  { throw new RuntimeException(); }
  /**
   * Last offset that was discarded, or -1 if no commits have occurred. Note that the value
   * -1 is used in calculations below and isn't just an arbitrary constant.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.execution.streaming.LongOffset lastOffsetCommitted ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.Offset addData (scala.collection.TraversableOnce<A> data)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset deserializeOffset (java.lang.String json)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset latestOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.InputPartition[] planInputPartitions (org.apache.spark.sql.connector.read.streaming.Offset start, org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReaderFactory createReaderFactory ()  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
}
