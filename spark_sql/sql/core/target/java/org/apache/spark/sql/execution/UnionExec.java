package org.apache.spark.sql.execution;
/**
 * Physical plan for unioning two plans, without a distinct. This is UNION ALL in SQL.
 * <p>
 * If we change how this is implemented physically, we'd need to update
 * {@link org.apache.spark.sql.catalyst.plans.logical.Union.maxRowsPerPartition}.
 */
public  class UnionExec extends org.apache.spark.sql.execution.SparkPlan implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  { throw new RuntimeException(); }
  // not preceding
  public   UnionExec (scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
