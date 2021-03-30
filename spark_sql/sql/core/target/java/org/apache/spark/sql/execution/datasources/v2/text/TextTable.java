package org.apache.spark.sql.execution.datasources.v2.text;
public  class TextTable extends org.apache.spark.sql.execution.datasources.v2.FileTable implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap options ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> paths ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema ()  { throw new RuntimeException(); }
  public  java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> fallbackFileFormat ()  { throw new RuntimeException(); }
  // not preceding
  public   TextTable (java.lang.String name, org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.util.CaseInsensitiveStringMap options, scala.collection.Seq<java.lang.String> paths, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema, java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> fallbackFileFormat)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.v2.text.TextScanBuilder newScanBuilder (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriteBuilder newWriteBuilder (org.apache.spark.sql.connector.write.LogicalWriteInfo info)  { throw new RuntimeException(); }
  public  boolean supportsDataType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  java.lang.String formatName ()  { throw new RuntimeException(); }
}
