package org.apache.spark.sql.execution.datasources.csv;
/**
 * Common functions for parsing CSV files
 */
public abstract class CSVDataSource implements scala.Serializable {
  static public  org.apache.spark.sql.execution.datasources.csv.CSVDataSource apply (org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
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
  public   CSVDataSource ()  { throw new RuntimeException(); }
  public abstract  boolean isSplitable ()  ;
  /**
   * Parse a {@link PartitionedFile} into {@link InternalRow} instances.
   * @param conf (undocumented)
   * @param file (undocumented)
   * @param parser (undocumented)
   * @param headerChecker (undocumented)
   * @param requiredSchema (undocumented)
   * @return (undocumented)
   */
  public abstract  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType requiredSchema)  ;
  /**
   * Infers the schema from <code>inputPaths</code> files.
   * @param sparkSession (undocumented)
   * @param inputPaths (undocumented)
   * @param parsedOptions (undocumented)
   * @return (undocumented)
   */
  public final  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.csv.CSVOptions parsedOptions)  ;
}
