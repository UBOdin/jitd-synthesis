package org.apache.spark.sql.execution.bucketing;
/**
 * An extractor that extracts <code>SortMergeJoinExec</code> and <code>ShuffledHashJoin</code>,
 * where both sides of the join have the bucketed tables,
 * are consisted of only the scan operation,
 * and numbers of buckets are not equal but divisible.
 */
public  class ExtractJoinWithBuckets$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractJoinWithBuckets$ MODULE$ = null;
  public   ExtractJoinWithBuckets$ ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple3<org.apache.spark.sql.execution.joins.BaseJoinExec, java.lang.Object, java.lang.Object>> unapply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
