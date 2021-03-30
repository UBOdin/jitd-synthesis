package org.apache.spark.sql.execution.datasources.parquet;
public  class ParquetReadSupport$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ParquetReadSupport$ MODULE$ = null;
  public   ParquetReadSupport$ ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_ROW_REQUESTED_SCHEMA ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_METADATA_KEY ()  { throw new RuntimeException(); }
  /**
   * Tailors <code>parquetSchema</code> according to <code>catalystSchema</code> by removing column paths don't exist
   * in <code>catalystSchema</code>, and adding those only exist in <code>catalystSchema</code>.
   * @param parquetSchema (undocumented)
   * @param catalystSchema (undocumented)
   * @param caseSensitive (undocumented)
   * @return (undocumented)
   */
  public  org.apache.parquet.schema.MessageType clipParquetSchema (org.apache.parquet.schema.MessageType parquetSchema, org.apache.spark.sql.types.StructType catalystSchema, boolean caseSensitive)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType expandUDT (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
