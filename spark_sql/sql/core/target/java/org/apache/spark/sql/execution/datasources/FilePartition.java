package org.apache.spark.sql.execution.datasources;
/**
 * A collection of file blocks that should be read as a single task
 * (possibly from multiple partitioned directories).
 */
public  class FilePartition implements org.apache.spark.Partition, org.apache.spark.sql.connector.read.InputPartition, scala.Product, scala.Serializable {
  static public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.FilePartition> getFilePartitions (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionedFile> partitionedFiles, long maxSplitBytes)  { throw new RuntimeException(); }
  static public  long maxSplitBytes (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> selectedPartitions)  { throw new RuntimeException(); }
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
  public  int index ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.PartitionedFile[] files ()  { throw new RuntimeException(); }
  // not preceding
  public   FilePartition (int index, org.apache.spark.sql.execution.datasources.PartitionedFile[] files)  { throw new RuntimeException(); }
  public  java.lang.String[] preferredLocations ()  { throw new RuntimeException(); }
}
