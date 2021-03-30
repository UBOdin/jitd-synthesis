package org.apache.spark.sql.execution;
/**
 * Groups the input rows together and calls the R function with each group and an iterator
 * containing all elements in the group.
 * The result of this function is flattened before being output.
 */
public  class FlatMapGroupsInRExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.ObjectProducerExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  byte[] func ()  { throw new RuntimeException(); }
  public  byte[] packageNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType inputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType outputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   FlatMapGroupsInRExec (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType inputSchema, org.apache.spark.sql.types.StructType outputSchema, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
