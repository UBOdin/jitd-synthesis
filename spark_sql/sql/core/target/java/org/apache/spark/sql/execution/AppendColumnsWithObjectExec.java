package org.apache.spark.sql.execution;
/**
 * An optimized version of {@link AppendColumnsExec}, that can be executed
 * on deserialized object directly.
 */
public  class AppendColumnsWithObjectExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.ObjectConsumerExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  scala.Function1<java.lang.Object, java.lang.Object> func ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> inputSerializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> newColumnsSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendColumnsWithObjectExec (scala.Function1<java.lang.Object, java.lang.Object> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> inputSerializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> newColumnsSerializer, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
