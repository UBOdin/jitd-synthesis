package org.apache.spark.sql.execution.datasources.parquet;
/**
 * A Parquet {@link WriteSupport} implementation that writes Catalyst {@link InternalRow}s as Parquet
 * messages.  This class can write Parquet data in two modes:
 * <p>
 *  - Standard mode: Parquet data are written in standard format defined in parquet-format spec.
 *  - Legacy mode: Parquet data are written in legacy format compatible with Spark 1.4 and prior.
 * <p>
 * This behavior can be controlled by SQL option <code>spark.sql.parquet.writeLegacyFormat</code>.  The value
 * of this option is propagated to this class by the <code>init()</code> method and its Hadoop configuration
 * argument.
 */
public  class ParquetWriteSupport extends org.apache.parquet.hadoop.api.WriteSupport<org.apache.spark.sql.catalyst.InternalRow> implements org.apache.spark.internal.Logging {
  static public  java.lang.String SPARK_ROW_SCHEMA ()  { throw new RuntimeException(); }
  static public  void setSchema (org.apache.spark.sql.types.StructType schema, org.apache.hadoop.conf.Configuration configuration)  { throw new RuntimeException(); }
  public   ParquetWriteSupport ()  { throw new RuntimeException(); }
  public  org.apache.parquet.hadoop.api.WriteSupport.WriteContext init (org.apache.hadoop.conf.Configuration configuration)  { throw new RuntimeException(); }
  public  void prepareForWrite (org.apache.parquet.io.api.RecordConsumer recordConsumer)  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, scala.runtime.BoxedUnit> makeArrayWriter (org.apache.spark.sql.types.ArrayType arrayType)  { throw new RuntimeException(); }
}
