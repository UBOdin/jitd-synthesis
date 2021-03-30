package org.apache.spark.sql.execution;
/**
 * Runs a query returning the result in Hive compatible form.
 */
public  class HiveResult {
  static public  class TimeFormatters implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.catalyst.util.DateFormatter date ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.util.TimestampFormatter timestamp ()  { throw new RuntimeException(); }
    // not preceding
    public   TimeFormatters (org.apache.spark.sql.catalyst.util.DateFormatter date, org.apache.spark.sql.catalyst.util.TimestampFormatter timestamp)  { throw new RuntimeException(); }
  }
  static public  class TimeFormatters$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.catalyst.util.DateFormatter, org.apache.spark.sql.catalyst.util.TimestampFormatter, org.apache.spark.sql.execution.HiveResult.TimeFormatters> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final TimeFormatters$ MODULE$ = null;
    public   TimeFormatters$ ()  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.sql.execution.HiveResult.TimeFormatters getTimeFormatters ()  { throw new RuntimeException(); }
  /**
   * Returns the result as a hive compatible sequence of strings. This is used in tests and
   * <code>SparkSQLDriver</code> for CLI applications.
   * @param executedPlan (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<java.lang.String> hiveResultString (org.apache.spark.sql.execution.SparkPlan executedPlan)  { throw new RuntimeException(); }
  /** Formats a datum (based on the given data type) and returns the string representation. */
  static public  java.lang.String toHiveString (scala.Tuple2<java.lang.Object, org.apache.spark.sql.types.DataType> a, boolean nested, org.apache.spark.sql.execution.HiveResult.TimeFormatters formatters)  { throw new RuntimeException(); }
}
