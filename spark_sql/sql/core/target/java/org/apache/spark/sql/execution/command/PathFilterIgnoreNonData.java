package org.apache.spark.sql.execution.command;
/**
 * For the purpose of calculating total directory sizes, use this filter to
 * ignore some irrelevant files.
 * param:  stagingDir hive staging dir
 */
public  class PathFilterIgnoreNonData implements org.apache.hadoop.fs.PathFilter, scala.Serializable {
  public   PathFilterIgnoreNonData (java.lang.String stagingDir)  { throw new RuntimeException(); }
  public  boolean accept (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
}
