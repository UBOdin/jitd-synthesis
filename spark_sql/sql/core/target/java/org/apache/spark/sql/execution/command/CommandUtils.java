package org.apache.spark.sql.execution.command;
public  class CommandUtils {
  /** Change statistics after changing data by commands. */
  static public  void updateTableStats (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  static public  scala.math.BigInt calculateTotalSize (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable)  { throw new RuntimeException(); }
  static public  long calculateSingleLocationSize (org.apache.spark.sql.internal.SessionState sessionState, org.apache.spark.sql.catalyst.TableIdentifier identifier, scala.Option<java.net.URI> locationUri)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<java.lang.Object> calculateMultipleLocationSizes (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.TableIdentifier tid, scala.collection.Seq<scala.Option<java.net.URI>> paths)  { throw new RuntimeException(); }
  /**
   * Launch a Job to list all leaf files in <code>paths</code> and compute the total size
   * for each path.
   * @param sparkSession the {@link SparkSession}
   * @param paths the Seq of {@link Option[Path}]s
   * @return a Seq of same size as <code>paths</code> where i-th element is total size of <code>paths(i)</code> or 0
   *         if <code>paths(i)</code> is None
   */
  static public  scala.collection.Seq<java.lang.Object> calculateMultipleLocationSizesInParallel (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<scala.Option<org.apache.hadoop.fs.Path>> paths)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> compareAndGetNewStats (scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> oldStats, scala.math.BigInt newTotalSize, scala.Option<scala.math.BigInt> newRowCount)  { throw new RuntimeException(); }
  static public  void analyzeTable (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.TableIdentifier tableIdent, boolean noScan)  { throw new RuntimeException(); }
  /**
   * Compute stats for the given columns.
   * @return (row count, map from column name to CatalogColumnStats)
   * @param sparkSession (undocumented)
   * @param relation (undocumented)
   * @param columns (undocumented)
   */
  static   scala.Tuple2<java.lang.Object, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat>> computeColumnStats (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> columns)  { throw new RuntimeException(); }
  static public  void uncacheTableOrView (org.apache.spark.sql.SparkSession sparkSession, java.lang.String name)  { throw new RuntimeException(); }
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
}
