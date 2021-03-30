package org.apache.spark.sql.execution.columnar;
/**
 * An helper class to update the fields of UnsafeRow, used by ColumnAccessor
 * <p>
 * WARNING: These setter MUST be called in increasing order of ordinals.
 */
public  class MutableUnsafeRow extends org.apache.spark.sql.catalyst.InternalRow implements org.apache.spark.sql.catalyst.expressions.BaseGenericInternalRow {
  // not preceding
  public   MutableUnsafeRow (org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter writer)  { throw new RuntimeException(); }
  protected  Object genericGet (int ordinal)  { throw new RuntimeException(); }
  public  boolean isNullAt (int i)  { throw new RuntimeException(); }
  public  int numFields ()  { throw new RuntimeException(); }
  public  void setBoolean (int i, boolean v)  { throw new RuntimeException(); }
  public  void setByte (int i, byte v)  { throw new RuntimeException(); }
  public  void setDecimal (int i, org.apache.spark.sql.types.Decimal v, int precision)  { throw new RuntimeException(); }
  public  void setDouble (int i, double v)  { throw new RuntimeException(); }
  public  void setFloat (int i, float v)  { throw new RuntimeException(); }
  public  void setInt (int i, int v)  { throw new RuntimeException(); }
  public  void setInterval (int i, org.apache.spark.unsafe.types.CalendarInterval value)  { throw new RuntimeException(); }
  public  void setLong (int i, long v)  { throw new RuntimeException(); }
  public  void setNullAt (int i)  { throw new RuntimeException(); }
  public  void setShort (int i, short v)  { throw new RuntimeException(); }
  public  void update (int i, Object v)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter writer ()  { throw new RuntimeException(); }
}
