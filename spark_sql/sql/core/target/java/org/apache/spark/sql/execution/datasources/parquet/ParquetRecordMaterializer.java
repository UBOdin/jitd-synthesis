package org.apache.spark.sql.execution.datasources.parquet;
/**
 * A {@link RecordMaterializer} for Catalyst rows.
 * <p>
 * param:  parquetSchema Parquet schema of the records to be read
 * param:  catalystSchema Catalyst schema of the rows to be constructed
 * param:  schemaConverter A Parquet-Catalyst schema converter that helps initializing row converters
 * param:  convertTz the optional time zone to convert to int96 data
 * param:  datetimeRebaseMode the mode of rebasing date/timestamp from Julian to Proleptic Gregorian
 *                           calendar
 * param:  int96RebaseMode the mode of rebasing INT96 timestamp from Julian to Proleptic Gregorian
 *                           calendar
 */
  class ParquetRecordMaterializer extends org.apache.parquet.io.api.RecordMaterializer<org.apache.spark.sql.catalyst.InternalRow> {
  public   ParquetRecordMaterializer (org.apache.parquet.schema.MessageType parquetSchema, org.apache.spark.sql.types.StructType catalystSchema, org.apache.spark.sql.execution.datasources.parquet.ParquetToSparkSchemaConverter schemaConverter, scala.Option<java.time.ZoneId> convertTz, scala.Enumeration.Value datetimeRebaseMode, scala.Enumeration.Value int96RebaseMode)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getCurrentRecord ()  { throw new RuntimeException(); }
  public  org.apache.parquet.io.api.GroupConverter getRootConverter ()  { throw new RuntimeException(); }
}
