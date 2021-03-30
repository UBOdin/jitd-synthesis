package org.apache.spark.sql.execution.streaming;
/**
 * A sink that writes out results to parquet files.  Each batch is written out to a unique
 * directory. After all of the files in a batch have been successfully written, the list of
 * file paths is appended to the log atomically. In the case of partial failures, some duplicate
 * data may be present in the target directory, but only one copy of each file will be present
 * in the log.
 */
public  class FileStreamSink implements org.apache.spark.sql.execution.streaming.Sink, org.apache.spark.internal.Logging {
  static public  java.lang.String metadataDir ()  { throw new RuntimeException(); }
  /**
   * Returns true if there is a single path that has a metadata log indicating which files should
   * be read.
   * @param path (undocumented)
   * @param hadoopConf (undocumented)
   * @param sqlConf (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasMetadata (scala.collection.Seq<java.lang.String> path, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  static public  org.apache.hadoop.fs.Path getMetadataLogPath (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  static public  void checkEscapedMetadataPath (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path metadataPath, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
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
  static public  boolean ancestorIsMetadataDirectory (org.apache.hadoop.fs.Path path, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  public   FileStreamSink (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, scala.collection.Seq<java.lang.String> partitionColumnNames, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public  void addBatch (long batchId, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
