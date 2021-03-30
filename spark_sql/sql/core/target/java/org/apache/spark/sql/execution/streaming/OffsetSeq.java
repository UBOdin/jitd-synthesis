package org.apache.spark.sql.execution.streaming;
/**
 * An ordered collection of offsets, used to track the progress of processing data from one or more
 * {@link Source}s that are present in a streaming query. This is similar to simplified, single-instance
 * vector clock that must progress linearly forward.
 */
public  class OffsetSeq implements scala.Product, scala.Serializable {
  /**
   * Returns a {@link OffsetSeq} with a variable sequence of offsets.
   * <code>nulls</code> in the sequence are converted to <code>None</code>s.
   * @param offsets (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.streaming.OffsetSeq fill (scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.Offset> offsets)  { throw new RuntimeException(); }
  /**
   * Returns a {@link OffsetSeq} with metadata and a variable sequence of offsets.
   * <code>nulls</code> in the sequence are converted to <code>None</code>s.
   * @param metadata (undocumented)
   * @param offsets (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.streaming.OffsetSeq fill (scala.Option<java.lang.String> metadata, scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.Offset> offsets)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Option<org.apache.spark.sql.connector.read.streaming.Offset>> offsets ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.OffsetSeqMetadata> metadata ()  { throw new RuntimeException(); }
  // not preceding
  public   OffsetSeq (scala.collection.Seq<scala.Option<org.apache.spark.sql.connector.read.streaming.Offset>> offsets, scala.Option<org.apache.spark.sql.execution.streaming.OffsetSeqMetadata> metadata)  { throw new RuntimeException(); }
  /**
   * Unpacks an offset into {@link StreamProgress} by associating each offset with the ordered list of
   * sources.
   * <p>
   * This method is typically used to associate a serialized offset with actual sources (which
   * cannot be serialized).
   * @param sources (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress toStreamProgress (scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.SparkDataStream> sources)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
