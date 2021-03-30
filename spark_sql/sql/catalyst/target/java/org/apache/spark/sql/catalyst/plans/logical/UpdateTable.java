package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the UPDATE TABLE command.
 */
public  class UpdateTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, org.apache.spark.sql.catalyst.plans.logical.SupportsSubquery, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.Assignment> assignments ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition ()  { throw new RuntimeException(); }
  // not preceding
  public   UpdateTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.Assignment> assignments, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
