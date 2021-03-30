package org.apache.spark.sql.execution.adaptive;
/**
 * A rule to optimize the shuffle reader to local reader iff no additional shuffles
 * will be introduced:
 * 1. if the input plan is a shuffle, add local reader directly as we can never introduce
 * extra shuffles in this case.
 * 2. otherwise, add local reader to the probe side of broadcast hash join and
 * then run <code>EnsureRequirements</code> to check whether additional shuffle introduced.
 * If introduced, we will revert all the local readers.
 */
public  class OptimizeLocalShuffleReader$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> implements org.apache.spark.sql.execution.adaptive.CustomShuffleReaderRule {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OptimizeLocalShuffleReader$ MODULE$ = null;
  public   OptimizeLocalShuffleReader$ ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.exchange.ShuffleOrigin> supportedShuffleOrigins ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  public  boolean canUseLocalShuffleReader (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
