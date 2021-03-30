package org.apache.spark.sql.execution.datasources.parquet;
public  class ParquetUtils {
  static public  class FileTypes implements scala.Product, scala.Serializable {
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> data ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> metadata ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> commonMetadata ()  { throw new RuntimeException(); }
    // not preceding
    public   FileTypes (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> data, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> metadata, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> commonMetadata)  { throw new RuntimeException(); }
  }
  static public  class FileTypes$ extends scala.runtime.AbstractFunction3<scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, org.apache.spark.sql.execution.datasources.parquet.ParquetUtils.FileTypes> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final FileTypes$ MODULE$ = null;
    public   FileTypes$ ()  { throw new RuntimeException(); }
  }
  static public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
}
