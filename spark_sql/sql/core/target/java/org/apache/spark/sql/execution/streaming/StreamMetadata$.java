package org.apache.spark.sql.execution.streaming;
public  class StreamMetadata$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StreamMetadata$ MODULE$ = null;
  public   StreamMetadata$ ()  { throw new RuntimeException(); }
  public  java.lang.Object format ()  { throw new RuntimeException(); }
  /** Read the metadata from file if it exists */
  public  scala.Option<org.apache.spark.sql.execution.streaming.StreamMetadata> read (org.apache.hadoop.fs.Path metadataFile, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /** Write metadata to file */
  public  void write (org.apache.spark.sql.execution.streaming.StreamMetadata metadata, org.apache.hadoop.fs.Path metadataFile, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
}
