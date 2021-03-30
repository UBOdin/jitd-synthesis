package org.apache.spark.sql.execution;
/**
 * Groups the input rows together and calls the function with each group and an iterator containing
 * all elements in the group.  The result of this function is flattened before being output.
 */
public  class MapGroupsExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.ObjectProducerExec, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.MapGroupsExec apply (scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, org.apache.spark.sql.catalyst.plans.logical.LogicalGroupState<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapGroupsExec (scala.Function2<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
