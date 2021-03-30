package org.apache.spark.sql.execution.exchange;
/**
 * Find out duplicated exchanges in the spark plan, then use the same exchange for all the
 * references.
 */
public  class ReuseExchange$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReuseExchange$ MODULE$ = null;
  public   ReuseExchange$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
