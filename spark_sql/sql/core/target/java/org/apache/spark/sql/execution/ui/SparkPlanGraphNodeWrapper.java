package org.apache.spark.sql.execution.ui;
/** Only one of the values should be set. */
public  class SparkPlanGraphNodeWrapper {
  // not preceding
  public   SparkPlanGraphNodeWrapper (org.apache.spark.sql.execution.ui.SparkPlanGraphNode node, org.apache.spark.sql.execution.ui.SparkPlanGraphClusterWrapper cluster)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ui.SparkPlanGraphClusterWrapper cluster ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ui.SparkPlanGraphNode node ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ui.SparkPlanGraphNode toSparkPlanGraphNode ()  { throw new RuntimeException(); }
}
