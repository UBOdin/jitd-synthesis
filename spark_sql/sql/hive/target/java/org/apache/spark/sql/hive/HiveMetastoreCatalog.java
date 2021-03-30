package org.apache.spark.sql.hive;
/**
 * Legacy catalog for interacting with the Hive metastore.
 * <p>
 * This is still used for things like creating data source tables, but in the future will be
 * cleaned up to integrate more nicely with {@link HiveExternalCatalog}.
 */
  class HiveMetastoreCatalog implements org.apache.spark.internal.Logging {
  static public  org.apache.spark.sql.types.StructType mergeWithMetastoreSchema (org.apache.spark.sql.types.StructType metastoreSchema, org.apache.spark.sql.types.StructType inferredSchema)  { throw new RuntimeException(); }
  public   HiveMetastoreCatalog (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.plans.logical.LogicalPlan getCachedDataSourceTable (org.apache.spark.sql.catalyst.TableIdentifier table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.LogicalRelation convert (org.apache.spark.sql.catalyst.catalog.HiveTableRelation relation)  { throw new RuntimeException(); }
}
