package org.apache.spark.sql.execution.streaming;
/**
 * A physical operator for executing limits locally on each partition. The main difference from
 * LocalLimitExec is that this will fully consume <code>child</code> plan's iterators to ensure that any
 * stateful operation within <code>child</code> commits all the state changes (many stateful operations
 * commit state changes only after the iterator is consumed).
 */
public  class StreamingLocalLimitExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LimitExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int limit ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingLocalLimitExec (int limit, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
