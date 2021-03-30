package org.apache.spark.sql.execution.command;
public  class CommandUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CommandUtils$ MODULE$ = null;
  public   CommandUtils$ ()  { throw new RuntimeException(); }
  /** Change statistics after changing data by commands. */
  public  void updateTableStats (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  public  scala.math.BigInt calculateTotalSize (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable)  { throw new RuntimeException(); }
  public  long calculateSingleLocationSize (org.apache.spark.sql.internal.SessionState sessionState, org.apache.spark.sql.catalyst.TableIdentifier identifier, scala.Option<java.net.URI> locationUri)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> calculateMultipleLocationSizes (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.TableIdentifier tid, scala.collection.Seq<scala.Option<java.net.URI>> paths)  { throw new RuntimeException(); }
  /**
   * Launch a Job to list all leaf files in <code>paths</code> and compute the total size
   * for each path.
   * @param sparkSession the {@link SparkSession}
   * @param paths the Seq of {@link Option[Path}]s
   * @return a Seq of same size as <code>paths</code> where i-th element is total size of <code>paths(i)</code> or 0
   *         if <code>paths(i)</code> is None
   */
  public  scala.collection.Seq<java.lang.Object> calculateMultipleLocationSizesInParallel (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<scala.Option<org.apache.hadoop.fs.Path>> paths)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> compareAndGetNewStats (scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> oldStats, scala.math.BigInt newTotalSize, scala.Option<scala.math.BigInt> newRowCount)  { throw new RuntimeException(); }
  public  void analyzeTable (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.TableIdentifier tableIdent, boolean noScan)  { throw new RuntimeException(); }
  /**
   * Compute stats for the given columns.
   * @return (row count, map from column name to CatalogColumnStats)
   * @param sparkSession (undocumented)
   * @param relation (undocumented)
   * @param columns (undocumented)
   */
    scala.Tuple2<java.lang.Object, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat>> computeColumnStats (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> columns)  { throw new RuntimeException(); }
  public  void uncacheTableOrView (org.apache.spark.sql.SparkSession sparkSession, java.lang.String name)  { throw new RuntimeException(); }
}
