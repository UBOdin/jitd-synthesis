package org.apache.spark.sql.execution.datasources;
/**
 * Create a table and optionally insert some data into it. Note that this plan is unresolved and
 * has to be replaced by the concrete implementations during analysis.
 * <p>
 * param:  tableDesc the metadata of the table to be created.
 * param:  mode the data writing mode
 * param:  query an optional logical plan representing data to write into the created table.
 */
public  class CreateTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SaveMode mode ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> query ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc, org.apache.spark.sql.SaveMode mode, scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> query)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
