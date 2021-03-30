package org.apache.spark.sql.hive.execution;
/**
 * Create table and insert the query result into it. This creates Hive table but inserts
 * the query result into it by using data source.
 * <p>
 * param:  tableDesc the table description, which may contain serde, storage handler etc.
 * param:  query the query whose result will be insert into the new relation
 * param:  mode SaveMode
 */
public  class OptimizedCreateHiveTableAsSelectCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.hive.execution.CreateHiveTableAsSelectBase, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SaveMode mode ()  { throw new RuntimeException(); }
  // not preceding
  public   OptimizedCreateHiveTableAsSelectCommand (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, scala.collection.Seq<java.lang.String> outputColumnNames, org.apache.spark.sql.SaveMode mode)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.command.DataWritingCommand getWritingCommand (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc, boolean tableExists)  { throw new RuntimeException(); }
  public  java.lang.String writingCommandClassName ()  { throw new RuntimeException(); }
}
