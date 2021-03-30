package org.apache.spark.sql.execution.streaming.sources;
/**
 * A sink that stores the results in memory. This {@link org.apache.spark.sql.execution.streaming.Sink}
 * is primarily intended for use in unit tests and does not provide durability.
 */
public  class MemorySink implements org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.SupportsWrite, org.apache.spark.internal.Logging {
  public   MemorySink ()  { throw new RuntimeException(); }
  /** Returns all rows that are stored in this {@link Sink}. */
  public  scala.collection.Seq<org.apache.spark.sql.Row> allData ()  { throw new RuntimeException(); }
  public  java.util.Set<org.apache.spark.sql.connector.catalog.TableCapability> capabilities ()  { throw new RuntimeException(); }
  public  void clear ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> dataSinceBatch (long sinceBatchId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> latestBatchData ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> latestBatchId ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriteBuilder newWriteBuilder (org.apache.spark.sql.connector.write.LogicalWriteInfo info)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  java.lang.String toDebugString ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  void write (long batchId, boolean needTruncate, org.apache.spark.sql.Row[] newRows)  { throw new RuntimeException(); }
}
