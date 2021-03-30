package org.apache.spark.status.api.v1.sql;
public  class ExecutionData {
  // not preceding
     ExecutionData (long id, java.lang.String status, java.lang.String description, java.lang.String planDescription, java.util.Date submissionTime, long duration, scala.collection.Seq<java.lang.Object> runningJobIds, scala.collection.Seq<java.lang.Object> successJobIds, scala.collection.Seq<java.lang.Object> failedJobIds, scala.collection.Seq<org.apache.spark.status.api.v1.sql.Node> nodes, scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphEdge> edges)  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  long duration ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphEdge> edges ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> failedJobIds ()  { throw new RuntimeException(); }
  public  long id ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.status.api.v1.sql.Node> nodes ()  { throw new RuntimeException(); }
  public  java.lang.String planDescription ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> runningJobIds ()  { throw new RuntimeException(); }
  public  java.lang.String status ()  { throw new RuntimeException(); }
  public  java.util.Date submissionTime ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> successJobIds ()  { throw new RuntimeException(); }
}
