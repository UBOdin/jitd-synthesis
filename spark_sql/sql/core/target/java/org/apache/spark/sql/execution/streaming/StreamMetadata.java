package org.apache.spark.sql.execution.streaming;
/**
 * Contains metadata associated with a {@link org.apache.spark.sql.streaming.StreamingQuery}.
 * This information is written in the checkpoint location the first time a query is started
 * and recovered every time the query is restarted.
 * <p>
 * param:  id  unique id of the {@link org.apache.spark.sql.streaming.StreamingQuery}
 *            that needs to be persisted across restarts
 */
public  class StreamMetadata implements scala.Product, scala.Serializable {
  static public  java.lang.Object format ()  { throw new RuntimeException(); }
  /** Read the metadata from file if it exists */
  static public  scala.Option<org.apache.spark.sql.execution.streaming.StreamMetadata> read (org.apache.hadoop.fs.Path metadataFile, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /** Write metadata to file */
  static public  void write (org.apache.spark.sql.execution.streaming.StreamMetadata metadata, org.apache.hadoop.fs.Path metadataFile, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
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
  public  java.lang.String id ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamMetadata (java.lang.String id)  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
