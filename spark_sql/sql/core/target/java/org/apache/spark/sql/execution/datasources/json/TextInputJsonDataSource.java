package org.apache.spark.sql.execution.datasources.json;
public  class TextInputJsonDataSource {
  static public  boolean isSplitable ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType inferFromDataset (org.apache.spark.sql.Dataset<java.lang.String> json, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.json.JacksonParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public final  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  { throw new RuntimeException(); }
}
