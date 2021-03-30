package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the SHOW TABLE EXTENDED command.
 */
public  class ShowTableExtended extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> getOutputAttrs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan namespace ()  { throw new RuntimeException(); }
  public  java.lang.String pattern ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.analysis.PartitionSpec> partitionSpec ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowTableExtended (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan namespace, java.lang.String pattern, scala.Option<org.apache.spark.sql.catalyst.analysis.PartitionSpec> partitionSpec, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
