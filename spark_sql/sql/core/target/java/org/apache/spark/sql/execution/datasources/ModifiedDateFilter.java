package org.apache.spark.sql.execution.datasources;
/**
 * Provide modifiedAfter and modifiedBefore options when
 * filtering from a batch-based file data source.
 * <p>
 * Example Usages
 * Load all CSV files modified after date:
 * <pre><code>
 *   spark.read.format("csv").option("modifiedAfter","2020-06-15T05:00:00").load()
 * </code></pre>
 * <p>
 * Load all CSV files modified before date:
 * <pre><code>
 *   spark.read.format("csv").option("modifiedBefore","2020-06-15T05:00:00").load()
 * </code></pre>
 * <p>
 * Load all CSV files modified between two dates:
 * <pre><code>
 *   spark.read.format("csv").option("modifiedAfter","2019-01-15T05:00:00")
 *     .option("modifiedBefore","2020-06-15T05:00:00").load()
 * </code></pre>
 */
public abstract class ModifiedDateFilter implements org.apache.spark.sql.execution.datasources.PathFilterStrategy {
  static public  java.lang.String getTimeZoneId (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> options)  { throw new RuntimeException(); }
  static public  long toThreshold (java.lang.String timeString, java.lang.String timeZoneId, java.lang.String strategy)  { throw new RuntimeException(); }
  public   ModifiedDateFilter ()  { throw new RuntimeException(); }
  public abstract  java.lang.String timeZoneId ()  ;
  protected  long localTime (long micros)  { throw new RuntimeException(); }
}
