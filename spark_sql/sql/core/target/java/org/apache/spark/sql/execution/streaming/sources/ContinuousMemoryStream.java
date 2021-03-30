package org.apache.spark.sql.execution.streaming.sources;
/**
 * The overall strategy here is:
 *  * ContinuousMemoryStream maintains a list of records for each partition. addData() will
 *    distribute records evenly-ish across partitions.
 *  * RecordEndpoint is set up as an endpoint for executor-side
 *    ContinuousMemoryStreamInputPartitionReader instances to poll. It returns the record at
 *    the specified offset within the list, or null if that offset doesn't yet have a record.
 */
public  class ContinuousMemoryStream<A extends java.lang.Object> extends org.apache.spark.sql.execution.streaming.MemoryStreamBase<A> implements org.apache.spark.sql.connector.read.streaming.ContinuousStream {
  static protected  java.util.concurrent.atomic.AtomicInteger memoryStreamId ()  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.sources.ContinuousMemoryStream<A> apply (org.apache.spark.sql.Encoder<A> evidence$2, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> org.apache.spark.sql.execution.streaming.sources.ContinuousMemoryStream<A> singlePartition (org.apache.spark.sql.Encoder<A> evidence$3, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   ContinuousMemoryStream (int id, org.apache.spark.sql.SQLContext sqlContext, int numPartitions, org.apache.spark.sql.Encoder<A> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset addData (scala.collection.TraversableOnce<A> data)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.ContinuousMemoryStreamOffset deserializeOffset (java.lang.String json)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.ContinuousMemoryStreamOffset mergeOffsets (org.apache.spark.sql.connector.read.streaming.PartitionOffset[] offsets)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.InputPartition[] planInputPartitions (org.apache.spark.sql.connector.read.streaming.Offset start)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReaderFactory createContinuousReaderFactory ()  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
}
