package org.apache.spark.sql.execution;
/**
 * :: DeveloperApi ::
 * Stores information about a SQL SparkPlan.
 */
public  class SparkPlanInfo {
  static public  org.apache.spark.sql.execution.SparkPlanInfo fromSparkPlan (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlanInfo> children ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.metric.SQLMetricInfo> metrics ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkPlanInfo (java.lang.String nodeName, java.lang.String simpleString, scala.collection.Seq<org.apache.spark.sql.execution.SparkPlanInfo> children, scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata, scala.collection.Seq<org.apache.spark.sql.execution.metric.SQLMetricInfo> metrics)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
}
