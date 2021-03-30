package org.apache.spark.sql.execution.streaming;
public  class FileStreamSink$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FileStreamSink$ MODULE$ = null;
  public   FileStreamSink$ ()  { throw new RuntimeException(); }
  public  java.lang.String metadataDir ()  { throw new RuntimeException(); }
  /**
   * Returns true if there is a single path that has a metadata log indicating which files should
   * be read.
   * @param path (undocumented)
   * @param hadoopConf (undocumented)
   * @param sqlConf (undocumented)
   * @return (undocumented)
   */
  public  boolean hasMetadata (scala.collection.Seq<java.lang.String> path, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path getMetadataLogPath (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  public  void checkEscapedMetadataPath (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path metadataPath, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  /**
   * Returns true if the path is the metadata dir or its ancestor is the metadata dir.
   * E.g.:
   *  - ancestorIsMetadataDirectory(/.../_spark_metadata) =&gt; true
   *  - ancestorIsMetadataDirectory(/.../_spark_metadata/0) =&gt; true
   *  - ancestorIsMetadataDirectory(/a/b/c) =&gt; false
   * @param path (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  public  boolean ancestorIsMetadataDirectory (org.apache.hadoop.fs.Path path, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
}
