package org.apache.spark.sql.execution.datasources;
/**
 * A rule to check whether the functions are supported only when Hive support is enabled
 */
public  class HiveOnlyCheck {
  static public  void apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
