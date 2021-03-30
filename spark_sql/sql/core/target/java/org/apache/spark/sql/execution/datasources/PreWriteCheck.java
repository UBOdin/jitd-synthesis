package org.apache.spark.sql.execution.datasources;
/**
 * A rule to do various checks before inserting into or writing to a data source table.
 */
public  class PreWriteCheck {
  static public  void failAnalysis (java.lang.String msg)  { throw new RuntimeException(); }
  static public  void apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
