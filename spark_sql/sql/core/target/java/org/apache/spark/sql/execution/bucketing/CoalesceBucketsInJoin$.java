package org.apache.spark.sql.execution.bucketing;
/**
 * This rule coalesces one side of the <code>SortMergeJoin</code> and <code>ShuffledHashJoin</code>
 * if the following conditions are met:
 *   - Two bucketed tables are joined.
 *   - Join keys match with output partition expressions on their respective sides.
 *   - The larger bucket number is divisible by the smaller bucket number.
 *   - COALESCE_BUCKETS_IN_JOIN_ENABLED is set to true.
 *   - The ratio of the number of buckets is less than the value set in
 *     COALESCE_BUCKETS_IN_JOIN_MAX_BUCKET_RATIO.
 */
public  class CoalesceBucketsInJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CoalesceBucketsInJoin$ MODULE$ = null;
  public   CoalesceBucketsInJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
