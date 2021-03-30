package org.apache.spark.sql.execution;
public  interface LeafExecNode {
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
