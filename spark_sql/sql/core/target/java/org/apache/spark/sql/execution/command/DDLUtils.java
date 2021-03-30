package org.apache.spark.sql.execution.command;
public  class DDLUtils {
  static public  java.lang.String HIVE_PROVIDER ()  { throw new RuntimeException(); }
  static public  boolean isHiveTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  static public  boolean isHiveTable (scala.Option<java.lang.String> provider)  { throw new RuntimeException(); }
  static public  boolean isDatasourceTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.catalog.HiveTableRelation readHiveTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  /**
   * Throws a standard error for actions that require partitionProvider = hive.
   * @param spark (undocumented)
   * @param table (undocumented)
   * @param action (undocumented)
   */
  static public  void verifyPartitionProviderIsHive (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.catalog.CatalogTable table, java.lang.String action)  { throw new RuntimeException(); }
  /**
   * If the command ALTER VIEW is to alter a table or ALTER TABLE is to alter a view,
   * issue an exception {@link AnalysisException}.
   * <p>
   * Note: temporary views can be altered by both ALTER VIEW and ALTER TABLE commands,
   * since temporary views can be also created by CREATE TEMPORARY TABLE. In the future,
   * when we decided to drop the support, we should disallow users to alter temporary views
   * by ALTER TABLE.
   * @param catalog (undocumented)
   * @param tableMetadata (undocumented)
   * @param isView (undocumented)
   */
  static public  void verifyAlterTableType (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, org.apache.spark.sql.catalyst.catalog.CatalogTable tableMetadata, boolean isView)  { throw new RuntimeException(); }
  static   void checkDataColNames (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  static   void checkDataColNames (org.apache.spark.sql.catalyst.catalog.CatalogTable table, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Throws exception if outputPath tries to overwrite inputpath.
   * @param query (undocumented)
   * @param outputPath (undocumented)
   */
  static public  void verifyNotReadPath (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, org.apache.hadoop.fs.Path outputPath)  { throw new RuntimeException(); }
}
