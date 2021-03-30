package org.apache.spark.sql.execution.datasources.parquet;
/**
 * A {@link ParquetRowConverter} is used to convert Parquet records into Catalyst {@link InternalRow}s.
 * Since Catalyst <code>StructType</code> is also a Parquet record, this converter can be used as root
 * converter.  Take the following Parquet type as an example:
 * <pre><code>
 *   message root {
 *     required int32 f1;
 *     optional group f2 {
 *       required double f21;
 *       optional binary f22 (utf8);
 *     }
 *   }
 * </code></pre>
 * 5 converters will be created:
 * <p>
 * - a root {@link ParquetRowConverter} for {@link org.apache.parquet.schema.MessageType} <code>root</code>,
 * which contains:
 *   - a {@link ParquetPrimitiveConverter} for required
 *   {@link org.apache.parquet.schema.OriginalType.INT_32} field <code>f1</code>, and
 *   - a nested {@link ParquetRowConverter} for optional {@link GroupType} <code>f2</code>, which contains:
 *     - a {@link ParquetPrimitiveConverter} for required
 *     {@link org.apache.parquet.schema.PrimitiveType.PrimitiveTypeName.DOUBLE} field <code>f21</code>, and
 *     - a {@link ParquetStringConverter} for optional {@link org.apache.parquet.schema.OriginalType.UTF8}
 *     string field <code>f22</code>
 * <p>
 * When used as a root converter, {@link NoopUpdater} should be used since root converters don't have
 * any "parent" container.
 * <p>
 * param:  schemaConverter A utility converter used to convert Parquet types to Catalyst types.
 * param:  parquetType Parquet schema of Parquet records
 * param:  catalystType Spark SQL schema that corresponds to the Parquet record type. User-defined
 *        types should have been expanded.
 * param:  convertTz the optional time zone to convert to int96 data
 * param:  datetimeRebaseMode the mode of rebasing date/timestamp from Julian to Proleptic Gregorian
 *                           calendar
 * param:  int96RebaseMode the mode of rebasing INT96 timestamp from Julian to Proleptic Gregorian
 *                           calendar
 * param:  updater An updater which propagates converted field values to the parent container
 */
  class ParquetRowConverter extends org.apache.spark.sql.execution.datasources.parquet.ParquetGroupConverter implements org.apache.spark.internal.Logging {
  public  interface RepeatedConverter {
    public  java.lang.Object newArrayUpdater (org.apache.spark.sql.execution.datasources.parquet.ParentContainerUpdater updater)  ;
  }
  static public  long binaryToUnscaledLong (org.apache.parquet.io.api.Binary binary)  { throw new RuntimeException(); }
  static public  long binaryToSQLTimestamp (org.apache.parquet.io.api.Binary binary)  { throw new RuntimeException(); }
  public   ParquetRowConverter (org.apache.spark.sql.execution.datasources.parquet.ParquetToSparkSchemaConverter schemaConverter, org.apache.parquet.schema.GroupType parquetType, org.apache.spark.sql.types.StructType catalystType, scala.Option<java.time.ZoneId> convertTz, scala.Enumeration.Value datetimeRebaseMode, scala.Enumeration.Value int96RebaseMode, org.apache.spark.sql.execution.datasources.parquet.ParentContainerUpdater updater)  { throw new RuntimeException(); }
  /**
   * The {@link InternalRow} converted from an entire Parquet record.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow currentRecord ()  { throw new RuntimeException(); }
  public  org.apache.parquet.io.api.Converter getConverter (int fieldIndex)  { throw new RuntimeException(); }
  public  void end ()  { throw new RuntimeException(); }
  public  void start ()  { throw new RuntimeException(); }
}
