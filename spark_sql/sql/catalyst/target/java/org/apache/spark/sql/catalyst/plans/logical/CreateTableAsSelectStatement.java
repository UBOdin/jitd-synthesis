package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A CREATE TABLE AS SELECT command, as parsed from SQL.
 */
public  class CreateTableAsSelectStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12, T13 v13)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan asSelect ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> location ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> serde ()  { throw new RuntimeException(); }
  public  boolean external ()  { throw new RuntimeException(); }
  public  boolean ifNotExists ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateTableAsSelectStatement (scala.collection.Seq<java.lang.String> tableName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan asSelect, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, scala.Option<java.lang.String> provider, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.Option<java.lang.String> location, scala.Option<java.lang.String> comment, scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions, scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> serde, boolean external, boolean ifNotExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
