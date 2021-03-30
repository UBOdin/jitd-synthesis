package org.apache.spark.sql.execution.datasources.csv;
public  class TextInputCSVDataSource$ extends org.apache.spark.sql.execution.datasources.csv.CSVDataSource {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TextInputCSVDataSource$ MODULE$ = null;
  public   TextInputCSVDataSource$ ()  { throw new RuntimeException(); }
  public  boolean isSplitable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType requiredSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
  /**
   * Infers the schema from <code>Dataset</code> that stores CSV string records.
   * @param sparkSession (undocumented)
   * @param csv (undocumented)
   * @param maybeFirstLine (undocumented)
   * @param parsedOptions (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType inferFromDataset (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.Dataset<java.lang.String> csv, scala.Option<java.lang.String> maybeFirstLine, org.apache.spark.sql.catalyst.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
}
