package org.apache.spark.sql.execution.datasources.json;
/**
 * Common functions for parsing JSON files
 */
public abstract class JsonDataSource implements scala.Serializable {
  static public  org.apache.spark.sql.execution.datasources.json.JsonDataSource apply (org.apache.spark.sql.catalyst.json.JSONOptions options)  { throw new RuntimeException(); }
  public   JsonDataSource ()  { throw new RuntimeException(); }
  public abstract  boolean isSplitable ()  ;
  /**
   * Parse a {@link PartitionedFile} into 0 or more {@link InternalRow} instances
   * @param conf (undocumented)
   * @param file (undocumented)
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public abstract  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.json.JacksonParser parser, org.apache.spark.sql.types.StructType schema)  ;
  public final  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  ;
}
