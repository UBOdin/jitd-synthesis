package org.apache.spark.sql.execution.datasources;
/**
 * The base class file format that is based on text file.
 */
public abstract class TextBasedFileFormat implements org.apache.spark.sql.execution.datasources.FileFormat {
  public   TextBasedFileFormat ()  { throw new RuntimeException(); }
  public  boolean isSplitable (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
}
