package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the SHOW FUNCTIONS command.
 */
public  class ShowFunctions extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> getOutputAttrs ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> child ()  { throw new RuntimeException(); }
  public  boolean userScope ()  { throw new RuntimeException(); }
  public  boolean systemScope ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> pattern ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowFunctions (scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> child, boolean userScope, boolean systemScope, scala.Option<java.lang.String> pattern, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
