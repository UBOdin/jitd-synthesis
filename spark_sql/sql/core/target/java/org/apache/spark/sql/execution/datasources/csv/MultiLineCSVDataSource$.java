package org.apache.spark.sql.execution.datasources.csv;
public  class MultiLineCSVDataSource$ extends org.apache.spark.sql.execution.datasources.csv.CSVDataSource {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MultiLineCSVDataSource$ MODULE$ = null;
  public   MultiLineCSVDataSource$ ()  { throw new RuntimeException(); }
  public  boolean isSplitable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType requiredSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
}
