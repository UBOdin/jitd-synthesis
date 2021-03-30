package org.apache.spark.sql.execution.datasources.parquet;
public  class ParquetFileFormat$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ParquetFileFormat$ MODULE$ = null;
  public   ParquetFileFormat$ ()  { throw new RuntimeException(); }
    scala.Option<org.apache.spark.sql.types.StructType> readSchema (scala.collection.Seq<org.apache.parquet.hadoop.Footer> footers, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Reads Parquet footers in multi-threaded manner.
   * If the config "spark.sql.files.ignoreCorruptFiles" is set to true, we will ignore the corrupted
   * files when reading footers.
   * @param conf (undocumented)
   * @param partFiles (undocumented)
   * @param ignoreCorruptFiles (undocumented)
   * @return (undocumented)
   */
    scala.collection.Seq<org.apache.parquet.hadoop.Footer> readParquetFootersInParallel (org.apache.hadoop.conf.Configuration conf, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> partFiles, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  /**
   * Figures out a merged Parquet schema with a distributed Spark job.
   * <p>
   * Note that locality is not taken into consideration here because:
   * <p>
   *  1. For a single Parquet part-file, in most cases the footer only resides in the last block of
   *     that file.  Thus we only need to retrieve the location of the last block.  However, Hadoop
   *     <code>FileSystem</code> only provides API to retrieve locations of all blocks, which can be
   *     potentially expensive.
   * <p>
   *  2. This optimization is mainly useful for S3, where file metadata operations can be pretty
   *     slow.  And basically locality is not available when using S3 (you can't run computation on
   *     S3 nodes).
   * @param parameters (undocumented)
   * @param filesToTouch (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.types.StructType> mergeSchemasInParallel (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> filesToTouch, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Reads Spark SQL schema from a Parquet footer.  If a valid serialized Spark SQL schema string
   * can be found in the file metadata, returns the deserialized {@link StructType}, otherwise, returns
   * a {@link StructType} converted from the {@link org.apache.parquet.schema.MessageType} stored in this
   * footer.
   * @param footer (undocumented)
   * @param converter (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType readSchemaFromFooter (org.apache.parquet.hadoop.Footer footer, org.apache.spark.sql.execution.datasources.parquet.ParquetToSparkSchemaConverter converter)  { throw new RuntimeException(); }
}
