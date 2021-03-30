package org.apache.spark.sql.execution.datasources;
/**
 * Filter used to determine whether file was modified after the provided timestamp.
 */
public  class ModifiedAfterFilter extends org.apache.spark.sql.execution.datasources.ModifiedDateFilter {
  static public  java.lang.String PARAM_NAME ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.execution.datasources.PathFilterStrategy> create (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public  java.lang.String timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   ModifiedAfterFilter (long thresholdTime, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  boolean accept (org.apache.hadoop.fs.FileStatus fileStatus)  { throw new RuntimeException(); }
}
