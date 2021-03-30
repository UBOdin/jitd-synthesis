package org.apache.spark.sql.execution.ui;
public  class LiveExecutionData extends org.apache.spark.status.LiveEntity {
  // not preceding
  public   LiveExecutionData (long executionId)  { throw new RuntimeException(); }
  public  scala.Option<java.util.Date> completionTime ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  java.lang.String details ()  { throw new RuntimeException(); }
  protected  Object doUpdate ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.Object, java.lang.Object>> driverAccumUpdates ()  { throw new RuntimeException(); }
  public  java.util.concurrent.atomic.AtomicInteger endEvents ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, org.apache.spark.JobExecutionStatus> jobs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLPlanMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.String> metricsValues ()  { throw new RuntimeException(); }
  public  java.lang.String physicalPlanDescription ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.Object> stages ()  { throw new RuntimeException(); }
  public  long submissionTime ()  { throw new RuntimeException(); }
}
