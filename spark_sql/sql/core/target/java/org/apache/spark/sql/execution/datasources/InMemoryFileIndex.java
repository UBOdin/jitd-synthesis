package org.apache.spark.sql.execution.datasources;
/**
 * A {@link FileIndex} that generates the list of files to process by recursively listing all the
 * files present in <code>paths</code>.
 * <p>
 * param:  rootPathsSpecified the list of root table paths to scan (some of which might be
 *                           filtered out later)
 * param:  parameters as set of options to control discovery
 * param:  userSpecifiedSchema an optional user specified schema that will be use to provide
 *                            types for the discovered partitions
 */
public  class InMemoryFileIndex extends org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex {
  static   scala.collection.Seq<scala.Tuple2<org.apache.hadoop.fs.Path, scala.collection.Seq<org.apache.hadoop.fs.FileStatus>>> bulkListLeafFiles (scala.collection.Seq<org.apache.hadoop.fs.Path> paths, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.hadoop.fs.PathFilter filter, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
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
  public  scala.Option<java.lang.Object> metadataOpsTimeNs ()  { throw new RuntimeException(); }
  // not preceding
  public   InMemoryFileIndex (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.Path> rootPathsSpecified, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema, org.apache.spark.sql.execution.datasources.FileStatusCache fileStatusCache, scala.Option<org.apache.spark.sql.execution.datasources.PartitionSpec> userSpecifiedPartitionSpec, scala.Option<java.lang.Object> metadataOpsTimeNs)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.fs.Path> rootPaths ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.PartitionSpec partitionSpec ()  { throw new RuntimeException(); }
  protected  scala.collection.mutable.LinkedHashMap<org.apache.hadoop.fs.Path, org.apache.hadoop.fs.FileStatus> leafFiles ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Map<org.apache.hadoop.fs.Path, org.apache.hadoop.fs.FileStatus[]> leafDirToChildrenFiles ()  { throw new RuntimeException(); }
  public  void refresh ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  /**
   * List leaf files of given paths. This method will submit a Spark job to do parallel
   * listing whenever there is a path having more files than the parallel partition discovery
   * discovery threshold.
   * <p>
   * This is publicly visible for testing.
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.mutable.LinkedHashSet<org.apache.hadoop.fs.FileStatus> listLeafFiles (scala.collection.Seq<org.apache.hadoop.fs.Path> paths)  { throw new RuntimeException(); }
}
