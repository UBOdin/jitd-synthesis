package org.apache.spark.sql.execution.aggregate;
/**
 * Holds common logic for aggregate operators
 */
public  interface BaseAggregateExec extends org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.AliasAwareOutputPartitioning {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggregateBufferAttributes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> outputExpressions ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  scala.collection.immutable.List<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  ;
  public  scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> requiredChildDistributionExpressions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
