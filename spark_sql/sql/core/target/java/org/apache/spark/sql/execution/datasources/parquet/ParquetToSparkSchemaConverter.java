package org.apache.spark.sql.execution.datasources.parquet;
/**
 * This converter class is used to convert Parquet {@link MessageType} to Spark SQL {@link StructType}.
 * <p>
 * Parquet format backwards-compatibility rules are respected when converting Parquet
 * {@link MessageType} schemas.
 * <p>
 * @see https://github.com/apache/parquet-format/blob/master/LogicalTypes.md
 * <p>
 * param:  assumeBinaryIsString Whether unannotated BINARY fields should be assumed to be Spark SQL
 *        {@link StringType} fields.
 * param:  assumeInt96IsTimestamp Whether unannotated INT96 fields should be assumed to be Spark SQL
 *        {@link TimestampType} fields.
 */
public  class ParquetToSparkSchemaConverter {
  public   ParquetToSparkSchemaConverter (boolean assumeBinaryIsString, boolean assumeInt96IsTimestamp)  { throw new RuntimeException(); }
  public   ParquetToSparkSchemaConverter (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public   ParquetToSparkSchemaConverter (org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  /**
   * Converts Parquet {@link MessageType} <code>parquetSchema</code> to a Spark SQL {@link StructType}.
   * @param parquetSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType convert (org.apache.parquet.schema.MessageType parquetSchema)  { throw new RuntimeException(); }
  /**
   * Converts a Parquet {@link Type} to a Spark SQL {@link DataType}.
   * @param parquetType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType convertField (org.apache.parquet.schema.Type parquetType)  { throw new RuntimeException(); }
}
