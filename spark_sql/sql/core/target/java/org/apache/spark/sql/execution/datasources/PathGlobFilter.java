package org.apache.spark.sql.execution.datasources;
public  class PathGlobFilter implements org.apache.spark.sql.execution.datasources.PathFilterStrategy {
  static public  java.lang.String PARAM_NAME ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.execution.datasources.PathFilterStrategy> create (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   PathGlobFilter (java.lang.String filePatten)  { throw new RuntimeException(); }
  public  boolean accept (org.apache.hadoop.fs.FileStatus fileStatus)  { throw new RuntimeException(); }
}
