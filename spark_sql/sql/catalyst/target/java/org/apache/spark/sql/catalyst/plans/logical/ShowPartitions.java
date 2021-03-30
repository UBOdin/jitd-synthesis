package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the SHOW PARTITIONS command.
 */
public  class ShowPartitions extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2PartitionCommand, scala.Product, scala.Serializable {
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> getOutputAttrs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.analysis.PartitionSpec> pattern ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowPartitions (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, scala.Option<org.apache.spark.sql.catalyst.analysis.PartitionSpec> pattern, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  boolean allowPartialPartitionSpec ()  { throw new RuntimeException(); }
}
