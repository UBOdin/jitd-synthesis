package org.apache.spark.sql.execution.datasources.binaryfile;
/**
 * The binary file data source.
 * <p>
 * It reads binary files and converts each file into a single record that contains the raw content
 * and metadata of the file.
 * <p>
 * Example:
 * <pre><code>
 *   // Scala
 *   val df = spark.read.format("binaryFile")
 *     .load("/path/to/fileDir")
 *
 *   // Java
 *   Dataset&lt;Row&gt; df = spark.read().format("binaryFile")
 *     .load("/path/to/fileDir");
 * </code></pre>
 */
public  class BinaryFileFormat implements org.apache.spark.sql.execution.datasources.FileFormat, org.apache.spark.sql.sources.DataSourceRegister {
  static   java.lang.String PATH ()  { throw new RuntimeException(); }
  static   java.lang.String MODIFICATION_TIME ()  { throw new RuntimeException(); }
  static   java.lang.String LENGTH ()  { throw new RuntimeException(); }
  static   java.lang.String CONTENT ()  { throw new RuntimeException(); }
  static   java.lang.String BINARY_FILE ()  { throw new RuntimeException(); }
  /**
   * Schema for the binary file data source.
   * <p>
   * Schema:
   *  - path (StringType): The path of the file.
   *  - modificationTime (TimestampType): The modification time of the file.
   *    In some Hadoop FileSystem implementation, this might be unavailable and fallback to some
   *    default value.
   *  - length (LongType): The length of the file in bytes.
   *  - content (BinaryType): The content of the file.
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  static   scala.Function1<org.apache.hadoop.fs.FileStatus, java.lang.Object> createFilterFunction (org.apache.spark.sql.sources.Filter filter)  { throw new RuntimeException(); }
  public   BinaryFileFormat ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.OutputWriterFactory prepareWrite (org.apache.spark.sql.SparkSession sparkSession, org.apache.hadoop.mapreduce.Job job, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  boolean isSplitable (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
  protected  scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> buildReader (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
}
