package org.apache.spark.sql.execution.datasources;
/**
 * Inserts the results of <code>query</code> in to a relation that extends {@link InsertableRelation}.
 */
public  class InsertIntoDataSourceCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.LogicalRelation logicalRelation ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoDataSourceCommand (org.apache.spark.sql.execution.datasources.LogicalRelation logicalRelation, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, boolean overwrite)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.QueryPlan<?>> innerChildren ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
