package org.apache.spark.sql.execution.streaming;
/**
 * Contains metadata associated with a {@link OffsetSeq}. This information is
 * persisted to the offset log in the checkpoint location via the {@link OffsetSeq} metadata field.
 * <p>
 * param:  batchWatermarkMs: The current eventTime watermark, used to
 * bound the lateness of data that will processed. Time unit: milliseconds
 * param:  batchTimestampMs: The current batch processing timestamp.
 * Time unit: milliseconds
 * param:  conf: Additional conf_s to be persisted across batches, e.g. number of shuffle partitions.
 */
public  class OffsetSeqMetadata implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata apply (java.lang.String json)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata apply (long batchWatermarkMs, long batchTimestampMs, org.apache.spark.sql.RuntimeConfig sessionConf)  { throw new RuntimeException(); }
  /** Set the SparkSession configuration with the values in the metadata */
  static public  void setSessionConf (org.apache.spark.sql.execution.streaming.OffsetSeqMetadata metadata, org.apache.spark.sql.RuntimeConfig sessionConf)  { throw new RuntimeException(); }
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
  public  long batchWatermarkMs ()  { throw new RuntimeException(); }
  public  long batchTimestampMs ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> conf ()  { throw new RuntimeException(); }
  // not preceding
  public   OffsetSeqMetadata (long batchWatermarkMs, long batchTimestampMs, scala.collection.immutable.Map<java.lang.String, java.lang.String> conf)  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
