package org.apache.spark.sql.execution.ui;
public  class LiveStageMetrics {
  // not preceding
  public   LiveStageMetrics (int stageId, int attemptId, int numTasks, scala.collection.immutable.Map<java.lang.Object, java.lang.String> accumIdsToMetricType)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.String> accumIdsToMetricType ()  { throw new RuntimeException(); }
  public  int attemptId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple5<java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object>> maxMetricValues ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.Object, long[]>> metricValues ()  { throw new RuntimeException(); }
  public  int numTasks ()  { throw new RuntimeException(); }
  public  void registerTask (long taskId, int taskIdx)  { throw new RuntimeException(); }
  public  int stageId ()  { throw new RuntimeException(); }
  public  void updateTaskMetrics (long taskId, int eventIdx, boolean finished, scala.collection.Seq<org.apache.spark.scheduler.AccumulableInfo> accumUpdates)  { throw new RuntimeException(); }
}
