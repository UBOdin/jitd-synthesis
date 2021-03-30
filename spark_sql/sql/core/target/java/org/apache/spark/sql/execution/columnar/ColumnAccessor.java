package org.apache.spark.sql.execution.columnar;
/**
 * An <code>Iterator</code> like trait used to extract values from columnar byte buffer. When a value is
 * extracted from the buffer, instead of directly returning it, the value is set into some field of
 * a {@link InternalRow}. In this way, boxing cost can be avoided by leveraging the setter methods
 * for primitive values provided by {@link InternalRow}.
 */
public  interface ColumnAccessor {
  public  void initialize ()  ;
  public  boolean hasNext ()  ;
  public  void extractTo (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  java.nio.ByteBuffer underlyingBuffer ()  ;
}
