package org.apache.spark.sql.execution.datasources.v2;
public abstract class FileTable implements org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.SupportsRead, org.apache.spark.sql.connector.catalog.SupportsWrite {
  public   FileTable (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.util.CaseInsensitiveStringMap options, scala.collection.Seq<java.lang.String> paths, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Transform[] partitioning ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  java.util.Set<org.apache.spark.sql.connector.catalog.TableCapability> capabilities ()  { throw new RuntimeException(); }
  /**
   * When possible, this method should return the schema of the given <code>files</code>.  When the format
   * does not support inference, or no valid files are given should return None.  In these cases
   * Spark will require that user specify the schema manually.
   * @param files (undocumented)
   * @return (undocumented)
   */
  public abstract  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  ;
  /**
   * Returns whether this format supports the given {@link DataType} in read/write path.
   * By default all data types are supported.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  boolean supportsDataType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * The string that represents the format that this data source provider uses. This is
   * overridden by children to provide a nice alias for the data source. For example:
   * <p>
   * <pre><code>
   *   override def formatName(): String = "ORC"
   * </code></pre>
   * @return (undocumented)
   */
  public abstract  java.lang.String formatName ()  ;
  /**
   * Returns a V1 {@link FileFormat} class of the same file data source.
   * This is a solution for the following cases:
   * 1. File datasource V2 implementations cause regression. Users can disable the problematic data
   *    source via SQL configuration and fall back to FileFormat.
   * 2. Catalog support is required, which is still under development for data source V2.
   * @return (undocumented)
   */
  public abstract  java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> fallbackFileFormat ()  ;
}
