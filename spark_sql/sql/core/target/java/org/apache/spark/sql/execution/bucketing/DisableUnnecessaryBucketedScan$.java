package org.apache.spark.sql.execution.bucketing;
/**
 * Disable unnecessary bucketed table scan based on actual physical query plan.
 * NOTE: this rule is designed to be applied right after {@link EnsureRequirements},
 * where all {@link ShuffleExchangeExec} and {@link SortExec} have been added to plan properly.
 * <p>
 * When BUCKETING_ENABLED and AUTO_BUCKETED_SCAN_ENABLED are set to true, go through
 * query plan to check where bucketed table scan is unnecessary, and disable bucketed table
 * scan if:
 * <p>
 * 1. The sub-plan from root to bucketed table scan, does not contain
 *    {@link hasInterestingPartition} operator.
 * <p>
 * 2. The sub-plan from the nearest downstream {@link hasInterestingPartition} operator
 *    to the bucketed table scan, contains only {@link isAllowedUnaryExecNode} operators
 *    and at least one {@link Exchange}.
 * <p>
 * Examples:
 * 1. no {@link hasInterestingPartition} operator:
 *                Project
 *                   |
 *                 Filter
 *                   |
 *             Scan(t1: i, j)
 *  (bucketed on column j, DISABLE bucketed scan)
 * <p>
 * 2. join:
 *         SortMergeJoin(t1.i = t2.j)
 *            /            \
 *        Sort(i)        Sort(j)
 *          /               \
 *      Shuffle(i)       Scan(t2: i, j)
 *        /         (bucketed on column j, enable bucketed scan)
 *   Scan(t1: i, j)
 * (bucketed on column j, DISABLE bucketed scan)
 * <p>
 * 3. aggregate:
 *         HashAggregate(i, ..., Final)
 *                      |
 *                  Shuffle(i)
 *                      |
 *         HashAggregate(i, ..., Partial)
 *                      |
 *                    Filter
 *                      |
 *                  Scan(t1: i, j)
 *  (bucketed on column j, DISABLE bucketed scan)
 * <p>
 * The idea of {@link hasInterestingPartition} is inspired from "interesting order" in
 * the paper "Access Path Selection in a Relational Database Management System"
 * (https://dl.acm.org/doi/10.1145/582095.582099).
 */
public  class DisableUnnecessaryBucketedScan$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DisableUnnecessaryBucketedScan$ MODULE$ = null;
  public   DisableUnnecessaryBucketedScan$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
