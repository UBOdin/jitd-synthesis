package org.apache.spark.sql.execution.history;
/**
 * This class tracks live SQL executions, and pass the list to the {@link SQLLiveEntitiesEventFilter}
 * to help SQLLiveEntitiesEventFilter to accept live SQL executions as well as relevant
 * jobs (+ stages/tasks/RDDs).
 * <p>
 * Note that this class only tracks the jobs which are relevant to SQL executions - cannot classify
 * between finished job and live job without relation of SQL execution.
 */
  class SQLEventFilterBuilder extends org.apache.spark.scheduler.SparkListener implements org.apache.spark.deploy.history.EventFilterBuilder {
  public   SQLEventFilterBuilder ()  { throw new RuntimeException(); }
  public  org.apache.spark.deploy.history.EventFilter createFilter ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.Object> liveJobs ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.Object> liveRDDs ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.Object> liveSQLExecutions ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.Object> liveStages ()  { throw new RuntimeException(); }
    scala.collection.immutable.Set<java.lang.Object> liveTasks ()  { throw new RuntimeException(); }
  public  void onJobStart (org.apache.spark.scheduler.SparkListenerJobStart jobStart)  { throw new RuntimeException(); }
  public  void onOtherEvent (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
  public  void onStageSubmitted (org.apache.spark.scheduler.SparkListenerStageSubmitted stageSubmitted)  { throw new RuntimeException(); }
  public  void onTaskStart (org.apache.spark.scheduler.SparkListenerTaskStart taskStart)  { throw new RuntimeException(); }
}
