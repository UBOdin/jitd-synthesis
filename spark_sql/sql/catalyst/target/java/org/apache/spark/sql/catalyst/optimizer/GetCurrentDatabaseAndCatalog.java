package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces the expression of CurrentDatabase with the current database name.
 * Replaces the expression of CurrentCatalog with the current catalog name.
 */
public  class GetCurrentDatabaseAndCatalog extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
  // not preceding
  public   GetCurrentDatabaseAndCatalog (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
