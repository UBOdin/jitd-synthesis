package org.apache.spark.sql.execution;
/**
 * Applies the given function to input object iterator.
 * The output of its child must be a single-field row containing the input object.
 */
public  class MapPartitionsExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.ObjectConsumerExec, org.apache.spark.sql.execution.ObjectProducerExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  scala.Function1<scala.collection.Iterator<java.lang.Object>, scala.collection.Iterator<java.lang.Object>> func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapPartitionsExec (scala.Function1<scala.collection.Iterator<java.lang.Object>, scala.collection.Iterator<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
