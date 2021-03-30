package org.apache.spark.sql.execution.streaming;
/**
 * A variant of {@link QueryExecution} that allows the execution of the given {@link LogicalPlan}
 * plan incrementally. Possibly preserving state in between each execution.
 */
public  class IncrementalExecution extends org.apache.spark.sql.execution.QueryExecution implements org.apache.spark.internal.Logging {
  // not preceding
  public   IncrementalExecution (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.streaming.OutputMode outputMode, java.lang.String checkpointLocation, java.util.UUID queryId, java.util.UUID runId, long currentBatchId, org.apache.spark.sql.execution.streaming.OffsetSeqMetadata offsetSeqMetadata)  { throw new RuntimeException(); }
  /** No need assert supported, as this check has already been done */
  public  void assertSupported ()  { throw new RuntimeException(); }
  public  java.lang.String checkpointLocation ()  { throw new RuntimeException(); }
  public  long currentBatchId ()  { throw new RuntimeException(); }
    int numStateStores ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata offsetSeqMetadata ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optimizedPlan ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.streaming.OutputMode outputMode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  /**
   * Ensures that this plan DOES NOT have any stateful operation in it whose pipelined execution
   * depends on this plan. In other words, this function returns true if this plan does
   * have a narrow dependency on a stateful subplan.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preparations ()  { throw new RuntimeException(); }
  public  java.util.UUID queryId ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  /**
   * Should the MicroBatchExecution run another batch based on this execution and the current
   * updated metadata.
   * @param newMetadata (undocumented)
   * @return (undocumented)
   */
  public  boolean shouldRunAnotherBatch (org.apache.spark.sql.execution.streaming.OffsetSeqMetadata newMetadata)  { throw new RuntimeException(); }
  /** Locates save/restore pairs surrounding aggregation. */
  public  org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> state ()  { throw new RuntimeException(); }
}
