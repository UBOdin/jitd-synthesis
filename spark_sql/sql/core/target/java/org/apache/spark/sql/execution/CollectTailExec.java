package org.apache.spark.sql.execution;
/**
 * Take the last <code>limit</code> elements and collect them to a single partition.
 * <p>
 * This operator will be used when a logical <code>Tail</code> operation is the final operator in an
 * logical plan, which happens when the user is collecting results back to the driver.
 */
public  class CollectTailExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LimitExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int limit ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   CollectTailExec (int limit, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
