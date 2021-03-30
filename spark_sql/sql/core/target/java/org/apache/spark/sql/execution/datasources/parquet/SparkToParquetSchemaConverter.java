package org.apache.spark.sql.execution.datasources.parquet;
/**
 * This converter class is used to convert Spark SQL {@link StructType} to Parquet {@link MessageType}.
 * <p>
 * param:  writeLegacyParquetFormat Whether to use legacy Parquet format compatible with Spark 1.4
 *        and prior versions when converting a Catalyst {@link StructType} to a Parquet {@link MessageType}.
 *        When set to false, use standard format defined in parquet-format spec.  This argument only
 *        affects Parquet write path.
 * param:  outputTimestampType which parquet timestamp type to use when writing.
 */
public  class SparkToParquetSchemaConverter {
  public   SparkToParquetSchemaConverter (boolean writeLegacyParquetFormat, scala.Enumeration.Value outputTimestampType)  { throw new RuntimeException(); }
  public   SparkToParquetSchemaConverter (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public   SparkToParquetSchemaConverter (org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  /**
   * Converts a Spark SQL {@link StructType} to a Parquet {@link MessageType}.
   * @param catalystSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.parquet.schema.MessageType convert (org.apache.spark.sql.types.StructType catalystSchema)  { throw new RuntimeException(); }
  /**
   * Converts a Spark SQL {@link StructField} to a Parquet {@link Type}.
   * @param field (undocumented)
   * @return (undocumented)
   */
  public  org.apache.parquet.schema.Type convertField (org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
}
