package org.apache.spark.sql.execution.history;
/**
 * This class accepts events which are related to the live SQL executions based on the given
 * information.
 * <p>
 * Note that acceptFn will not match the event ("Don't mind") instead of returning false on
 * job related events, because it cannot determine whether the job is related to the finished
 * SQL executions, or job is NOT related to the SQL executions. For this case, it just gives up
 * the decision and let other filters decide it.
 */
  class SQLLiveEntitiesEventFilter extends org.apache.spark.deploy.history.JobEventFilter implements org.apache.spark.internal.Logging {
  public   SQLLiveEntitiesEventFilter (scala.collection.immutable.Set<java.lang.Object> liveSQLExecutions, scala.collection.immutable.Set<java.lang.Object> liveJobs, scala.collection.immutable.Set<java.lang.Object> liveStages, scala.collection.immutable.Set<java.lang.Object> liveTasks, scala.collection.immutable.Set<java.lang.Object> liveRDDs)  { throw new RuntimeException(); }
  public  scala.PartialFunction<org.apache.spark.scheduler.SparkListenerEvent, java.lang.Object> acceptFn ()  { throw new RuntimeException(); }
}
