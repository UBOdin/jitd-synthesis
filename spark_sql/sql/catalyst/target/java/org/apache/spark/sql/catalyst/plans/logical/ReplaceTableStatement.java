package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A REPLACE TABLE command, as parsed from SQL.
 * <p>
 * If the table exists prior to running this command, executing this statement
 * will replace the table's metadata and clear the underlying rows from the table.
 */
public  class ReplaceTableStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType tableSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> location ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> serde ()  { throw new RuntimeException(); }
  public  boolean orCreate ()  { throw new RuntimeException(); }
  // not preceding
  public   ReplaceTableStatement (scala.collection.Seq<java.lang.String> tableName, org.apache.spark.sql.types.StructType tableSchema, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, scala.Option<java.lang.String> provider, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.Option<java.lang.String> location, scala.Option<java.lang.String> comment, scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> serde, boolean orCreate)  { throw new RuntimeException(); }
}
