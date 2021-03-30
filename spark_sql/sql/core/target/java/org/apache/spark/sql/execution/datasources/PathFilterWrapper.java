package org.apache.spark.sql.execution.datasources;
public  class PathFilterWrapper implements org.apache.hadoop.fs.PathFilter, scala.Serializable {
  // not preceding
  public   PathFilterWrapper (org.apache.hadoop.fs.PathFilter filter)  { throw new RuntimeException(); }
  public  boolean accept (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.PathFilter filter ()  { throw new RuntimeException(); }
}
