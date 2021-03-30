package org.apache.spark.sql.execution;
public  interface BinaryExecNode {
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  ;
  public  org.apache.spark.sql.execution.SparkPlan left ()  ;
  public  org.apache.spark.sql.execution.SparkPlan right ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
