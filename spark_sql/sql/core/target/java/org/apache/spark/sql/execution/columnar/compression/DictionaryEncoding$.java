package org.apache.spark.sql.execution.columnar.compression;
public  class DictionaryEncoding$ implements org.apache.spark.sql.execution.columnar.compression.CompressionScheme, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DictionaryEncoding$ MODULE$ = null;
  public   DictionaryEncoding$ ()  { throw new RuntimeException(); }
  public  int typeId ()  { throw new RuntimeException(); }
  public  short MAX_DICT_SIZE ()  { throw new RuntimeException(); }
  public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.DictionaryEncoding.Decoder<T> decoder (java.nio.ByteBuffer buffer, org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.DictionaryEncoding.Encoder<T> encoder (org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  public  boolean supports (org.apache.spark.sql.execution.columnar.ColumnType<?> columnType)  { throw new RuntimeException(); }
}
