package org.apache.spark.sql.hive;
/**
 * Relation conversion from metastore relations to data source relations for better performance
 * <p>
 * - When writing to non-partitioned Hive-serde Parquet/Orc tables
 * - When scanning Hive-serde Parquet/ORC tables
 * <p>
 * This rule must be run before all other DDL post-hoc resolution rules, i.e.
 * <code>PreprocessTableCreation</code>, <code>PreprocessTableInsertion</code>, <code>DataSourceAnalysis</code> and <code>HiveAnalysis</code>.
 */
public  class RelationConversions extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveSessionCatalog sessionCatalog ()  { throw new RuntimeException(); }
  // not preceding
  public   RelationConversions (org.apache.spark.sql.hive.HiveSessionCatalog sessionCatalog)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
