package org.apache.spark.sql.execution.datasources.parquet;
/**
 * Options for the Parquet data source.
 */
public  class ParquetOptions implements scala.Serializable {
  static public  java.lang.String MERGE_SCHEMA ()  { throw new RuntimeException(); }
  static public  java.lang.String getParquetCompressionCodecName (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.String DATETIME_REBASE_MODE ()  { throw new RuntimeException(); }
  static public  java.lang.String INT96_REBASE_MODE ()  { throw new RuntimeException(); }
  // not preceding
  public   ParquetOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  public   ParquetOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  /**
   * Compression codec to use. By default use the value specified in SQLConf.
   * Acceptable values are defined in {@link shortParquetCompressionCodecNames}.
   * @return (undocumented)
   */
  public  java.lang.String compressionCodecClassName ()  { throw new RuntimeException(); }
  /**
   * Whether it merges schemas or not. When the given Parquet files have different schemas,
   * the schemas can be merged.  By default use the value specified in SQLConf.
   * @return (undocumented)
   */
  public  boolean mergeSchema ()  { throw new RuntimeException(); }
  /**
   * The rebasing mode for the DATE and TIMESTAMP_MICROS, TIMESTAMP_MILLIS values in reads.
   * @return (undocumented)
   */
  public  java.lang.String datetimeRebaseModeInRead ()  { throw new RuntimeException(); }
  /**
   * The rebasing mode for INT96 timestamp values in reads.
   * @return (undocumented)
   */
  public  java.lang.String int96RebaseModeInRead ()  { throw new RuntimeException(); }
}
