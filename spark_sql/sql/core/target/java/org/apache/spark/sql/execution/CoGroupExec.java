package org.apache.spark.sql.execution;
/**
 * Co-groups the data from left and right children, and calls the function with each group and 2
 * iterators containing all elements in the group from left and right side.
 * The result of this function is flattened before being output.
 */
public  class CoGroupExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.BinaryExecNode, org.apache.spark.sql.execution.ObjectProducerExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression leftDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression rightDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftGroup ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightGroup ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftAttr ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan right ()  { throw new RuntimeException(); }
  // not preceding
  public   CoGroupExec (scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression leftDeserializer, org.apache.spark.sql.catalyst.expressions.Expression rightDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftGroup, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightGroup, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftAttr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightAttr, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.execution.SparkPlan left, org.apache.spark.sql.execution.SparkPlan right)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
