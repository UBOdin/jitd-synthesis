package org.apache.spark.sql.execution.datasources;
/**
 * Create or replace a local/global temporary view with given data source.
 */
public  class CreateTempViewUsing extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableIdent ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema ()  { throw new RuntimeException(); }
  public  boolean replace ()  { throw new RuntimeException(); }
  public  boolean global ()  { throw new RuntimeException(); }
  public  java.lang.String provider ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateTempViewUsing (org.apache.spark.sql.catalyst.TableIdentifier tableIdent, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema, boolean replace, boolean global, java.lang.String provider, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public  java.lang.String argString (int maxFields)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
