package org.apache.spark.sql.execution;
public  interface UnaryExecNode {
  public  org.apache.spark.sql.execution.SparkPlan child ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
