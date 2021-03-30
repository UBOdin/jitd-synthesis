package org.apache.spark.sql.execution.datasources;
/**
 * Used to read and write data stored in files to/from the {@link InternalRow} format.
 */
public  interface FileFormat {
  /**
   * Returns a function that can be used to read a single file in as an Iterator of InternalRow.
   * <p>
   * @param dataSchema The global data schema. It can be either specified by the user, or
   *                   reconciled/merged from all underlying data files. If any partition columns
   *                   are contained in the files, they are preserved in this schema.
   * @param partitionSchema The schema of the partition column row that will be present in each
   *                        PartitionedFile. These columns should be appended to the rows that
   *                        are produced by the iterator.
   * @param requiredSchema The schema of the data that should be output for each row.  This may be a
   *                       subset of the columns that are present in the file if column pruning has
   *                       occurred.
   * @param filters A set of filters than can optionally be used to reduce the number of rows output
   * @param options A set of string -> string configuration options.
   * @return
   * @param sparkSession (undocumented)
   * @param hadoopConf (undocumented)
   */
  public  scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> buildReader (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.conf.Configuration hadoopConf)  ;
  /**
   * Exactly the same as {@link buildReader} except that the reader function returned by this method
   * appends partition values to {@link InternalRow}s produced by the reader function {@link buildReader}
   * returns.
   * @param sparkSession (undocumented)
   * @param dataSchema (undocumented)
   * @param partitionSchema (undocumented)
   * @param requiredSchema (undocumented)
   * @param filters (undocumented)
   * @param options (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> buildReaderWithPartitionValues (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.conf.Configuration hadoopConf)  ;
  /**
   * When possible, this method should return the schema of the given <code>files</code>.  When the format
   * does not support inference, or no valid files are given should return None.  In these cases
   * Spark will require that user specify the schema manually.
   * @param sparkSession (undocumented)
   * @param options (undocumented)
   * @param files (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  ;
  /**
   * Returns whether a file with <code>path</code> could be split or not.
   * @param sparkSession (undocumented)
   * @param options (undocumented)
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  boolean isSplitable (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.fs.Path path)  ;
  /**
   * Prepares a write job and returns an {@link OutputWriterFactory}.  Client side job preparation can
   * be put here.  For example, user defined output committer can be configured here
   * by setting the output committer class in the conf of spark.sql.sources.outputCommitterClass.
   * @param sparkSession (undocumented)
   * @param job (undocumented)
   * @param options (undocumented)
   * @param dataSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.datasources.OutputWriterFactory prepareWrite (org.apache.spark.sql.SparkSession sparkSession, org.apache.hadoop.mapreduce.Job job, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.types.StructType dataSchema)  ;
  /**
   * Returns whether this format supports returning columnar batch or not.
   * <p>
   * TODO: we should just have different traits for the different formats.
   * @param sparkSession (undocumented)
   * @param dataSchema (undocumented)
   * @return (undocumented)
   */
  public  boolean supportBatch (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema)  ;
  /**
   * Returns whether this format supports the given {@link DataType} in read/write path.
   * By default all data types are supported.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  boolean supportDataType (org.apache.spark.sql.types.DataType dataType)  ;
  /**
   * Returns concrete column vector class names for each column to be used in a columnar batch
   * if this format supports returning columnar batch.
   * @param requiredSchema (undocumented)
   * @param partitionSchema (undocumented)
   * @param sqlConf (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes (org.apache.spark.sql.types.StructType requiredSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.internal.SQLConf sqlConf)  ;
}
