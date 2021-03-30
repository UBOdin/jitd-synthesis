package org.apache.spark.sql.execution.columnar;
/**
 * A stackable trait used for building byte buffer for a column containing null values.  Memory
 * layout of the final byte buffer is:
 * <pre><code>
 *    .------------------- Null count N (4 bytes)
 *    |   .--------------- Null positions (4 x N bytes, empty if null count is zero)
 *    |   |     .--------- Non-null elements
 *    V   V     V
 *   +---+-----+---------+
 *   |   | ... | ... ... |
 *   +---+-----+---------+
 * </code></pre>
 */
public  interface NullableColumnBuilder extends org.apache.spark.sql.execution.columnar.ColumnBuilder {
  public  void appendFrom (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  java.nio.ByteBuffer build ()  ;
  public  java.nio.ByteBuffer buildNonNulls ()  ;
  public  void initialize (int initialSize, java.lang.String columnName, boolean useCompression)  ;
  public  int nullCount ()  ;
  public  java.nio.ByteBuffer nulls ()  ;
}
