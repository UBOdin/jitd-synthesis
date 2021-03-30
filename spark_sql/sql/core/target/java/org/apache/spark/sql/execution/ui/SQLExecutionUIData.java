package org.apache.spark.sql.execution.ui;
public  class SQLExecutionUIData {
  // not preceding
  public   SQLExecutionUIData (long executionId, java.lang.String description, java.lang.String details, java.lang.String physicalPlanDescription, scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLPlanMetric> metrics, long submissionTime, scala.Option<java.util.Date> completionTime, scala.collection.immutable.Map<java.lang.Object, org.apache.spark.JobExecutionStatus> jobs, scala.collection.immutable.Set<java.lang.Object> stages, scala.collection.immutable.Map<java.lang.Object, java.lang.String> metricValues)  { throw new RuntimeException(); }
  public  scala.Option<java.util.Date> completionTime ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  java.lang.String details ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, org.apache.spark.JobExecutionStatus> jobs ()  { throw new RuntimeException(); }
  /**
   * This field is only populated after the execution is finished; it will be null while the
   * execution is still running. During execution, aggregate metrics need to be retrieved
   * from the SQL listener instance.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.String> metricValues ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLPlanMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String physicalPlanDescription ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.Object> stages ()  { throw new RuntimeException(); }
  public  long submissionTime ()  { throw new RuntimeException(); }
}
