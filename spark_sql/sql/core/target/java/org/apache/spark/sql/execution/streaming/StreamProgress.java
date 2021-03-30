package org.apache.spark.sql.execution.streaming;
/**
 * A helper class that looks like a Map[Source, Offset].
 */
public  class StreamProgress implements scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.connector.read.streaming.Offset> {
  public  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.connector.read.streaming.Offset> baseMap ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamProgress (scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.connector.read.streaming.Offset> baseMap)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.OffsetSeq toOffsetSeq (scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.SparkDataStream> source, org.apache.spark.sql.execution.streaming.OffsetSeqMetadata metadata)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.read.streaming.Offset> get (org.apache.spark.sql.connector.read.streaming.SparkDataStream key)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.connector.read.streaming.Offset>> iterator ()  { throw new RuntimeException(); }
}
