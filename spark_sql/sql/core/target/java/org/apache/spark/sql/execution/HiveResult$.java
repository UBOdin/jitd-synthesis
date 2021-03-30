package org.apache.spark.sql.execution;
/**
 * Runs a query returning the result in Hive compatible form.
 */
public  class HiveResult$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveResult$ MODULE$ = null;
  public   HiveResult$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.HiveResult.TimeFormatters getTimeFormatters ()  { throw new RuntimeException(); }
  /**
   * Returns the result as a hive compatible sequence of strings. This is used in tests and
   * <code>SparkSQLDriver</code> for CLI applications.
   * @param executedPlan (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> hiveResultString (org.apache.spark.sql.execution.SparkPlan executedPlan)  { throw new RuntimeException(); }
  /** Formats a datum (based on the given data type) and returns the string representation. */
  public  java.lang.String toHiveString (scala.Tuple2<java.lang.Object, org.apache.spark.sql.types.DataType> a, boolean nested, org.apache.spark.sql.execution.HiveResult.TimeFormatters formatters)  { throw new RuntimeException(); }
}
