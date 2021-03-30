package org.apache.spark.sql.execution.datasources.noop;
public  class NoopWriteBuilder$ implements org.apache.spark.sql.connector.write.WriteBuilder, org.apache.spark.sql.connector.write.SupportsTruncate, org.apache.spark.sql.internal.connector.SupportsStreamingUpdateAsAppend {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoopWriteBuilder$ MODULE$ = null;
  public   NoopWriteBuilder$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriteBuilder truncate ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.BatchWrite buildForBatch ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.streaming.StreamingWrite buildForStreaming ()  { throw new RuntimeException(); }
}
