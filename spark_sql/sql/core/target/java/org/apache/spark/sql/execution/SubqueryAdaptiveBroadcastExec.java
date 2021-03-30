package org.apache.spark.sql.execution;
/**
 * Similar to {@link SubqueryBroadcastExec}, this node is used to store the
 * initial physical plan of DPP subquery filters when enabling both AQE and DPP.
 * It is intermediate physical plan and not executable.
 * After the build side is executed, this node will be replaced with the
 * {@link SubqueryBroadcastExec} and the child will be optimized with the ReusedExchange
 * from the build side.
 */
public  class SubqueryAdaptiveBroadcastExec extends org.apache.spark.sql.execution.BaseSubqueryExec implements org.apache.spark.sql.execution.UnaryExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  int index ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   SubqueryAdaptiveBroadcastExec (java.lang.String name, int index, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
