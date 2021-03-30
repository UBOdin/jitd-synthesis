package org.apache.spark.sql.execution.datasources;
public  interface PathFilterStrategy extends scala.Serializable {
  public  boolean accept (org.apache.hadoop.fs.FileStatus fileStatus)  ;
}
