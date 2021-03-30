package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A logical node that represents a non-query command to be executed by the system.  For example,
 * commands can be used by parsers to represent DDL operations.  Commands, unlike queries, are
 * eagerly executed.
 */
public  interface Command {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics stats ()  ;
}
