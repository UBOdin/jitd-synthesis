package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Create a new table with a v2 catalog.
 */
public  class CreateV2Table extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, org.apache.spark.sql.catalyst.plans.logical.V2CreateTablePlan, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier tableName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType tableSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  boolean ignoreIfExists ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateV2Table (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier tableName, org.apache.spark.sql.types.StructType tableSchema, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.V2CreateTablePlan withPartitioning (scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> rewritten)  { throw new RuntimeException(); }
}
