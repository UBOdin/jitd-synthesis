package org.apache.spark.sql.execution.command;
public  class DataWritingCommand$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataWritingCommand$ MODULE$ = null;
  public   DataWritingCommand$ ()  { throw new RuntimeException(); }
  /**
   * Returns output attributes with provided names.
   * The length of provided names should be the same of the length of {@link LogicalPlan.output}.
   * @param query (undocumented)
   * @param names (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> logicalPlanOutputWithNames (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, scala.collection.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  /**
   * When execute CTAS operators, Spark will use {@link InsertIntoHadoopFsRelationCommand}
   * or {@link InsertIntoHiveTable} command to write data, they both inherit metrics from
   * {@link DataWritingCommand}, but after running {@link InsertIntoHadoopFsRelationCommand}
   * or {@link InsertIntoHiveTable}, we only update metrics in these two command through
   * {@link BasicWriteJobStatsTracker}, we also need to propogate metrics to the command
   * that actually calls {@link InsertIntoHadoopFsRelationCommand} or {@link InsertIntoHiveTable}.
   * <p>
   * @param sparkContext Current SparkContext.
   * @param command Command to execute writing data.
   * @param metrics Metrics of real DataWritingCommand.
   */
  public  void propogateMetrics (org.apache.spark.SparkContext sparkContext, org.apache.spark.sql.execution.command.DataWritingCommand command, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics)  { throw new RuntimeException(); }
}
