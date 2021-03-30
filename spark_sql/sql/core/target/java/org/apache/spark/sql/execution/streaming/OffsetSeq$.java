package org.apache.spark.sql.execution.streaming;
public  class OffsetSeq$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OffsetSeq$ MODULE$ = null;
  public   OffsetSeq$ ()  { throw new RuntimeException(); }
  /**
   * Returns a {@link OffsetSeq} with a variable sequence of offsets.
   * <code>nulls</code> in the sequence are converted to <code>None</code>s.
   * @param offsets (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.OffsetSeq fill (scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.Offset> offsets)  { throw new RuntimeException(); }
  /**
   * Returns a {@link OffsetSeq} with metadata and a variable sequence of offsets.
   * <code>nulls</code> in the sequence are converted to <code>None</code>s.
   * @param metadata (undocumented)
   * @param offsets (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.OffsetSeq fill (scala.Option<java.lang.String> metadata, scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.Offset> offsets)  { throw new RuntimeException(); }
}
