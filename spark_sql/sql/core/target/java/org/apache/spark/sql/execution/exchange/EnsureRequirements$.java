package org.apache.spark.sql.execution.exchange;
/**
 * Ensures that the {@link org.apache.spark.sql.catalyst.plans.physical.Partitioning Partitioning}
 * of input data meets the
 * {@link org.apache.spark.sql.catalyst.plans.physical.Distribution Distribution} requirements for
 * each operator by inserting {@link ShuffleExchangeExec} Operators where required.  Also ensure that
 * the input partition ordering requirements are met.
 */
public  class EnsureRequirements$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EnsureRequirements$ MODULE$ = null;
  public   EnsureRequirements$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
