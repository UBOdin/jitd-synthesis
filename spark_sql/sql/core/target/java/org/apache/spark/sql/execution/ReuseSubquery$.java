package org.apache.spark.sql.execution;
/**
 * Find out duplicated subqueries in the spark plan, then use the same subquery result for all the
 * references.
 */
public  class ReuseSubquery$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReuseSubquery$ MODULE$ = null;
  public   ReuseSubquery$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
