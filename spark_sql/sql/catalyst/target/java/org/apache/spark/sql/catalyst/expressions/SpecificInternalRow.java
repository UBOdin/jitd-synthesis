package org.apache.spark.sql.catalyst.expressions;
/**
 * A row type that holds an array specialized container objects, of type {@link MutableValue}, chosen
 * based on the dataTypes of each column.  The intent is to decrease garbage when modifying the
 * values of primitive columns.
 */
public final class SpecificInternalRow extends org.apache.spark.sql.catalyst.InternalRow implements org.apache.spark.sql.catalyst.expressions.BaseGenericInternalRow {
  // not preceding
  public   SpecificInternalRow (org.apache.spark.sql.catalyst.expressions.MutableValue[] values)  { throw new RuntimeException(); }
  public   SpecificInternalRow (scala.collection.Seq<org.apache.spark.sql.types.DataType> dataTypes)  { throw new RuntimeException(); }
  public   SpecificInternalRow ()  { throw new RuntimeException(); }
  public   SpecificInternalRow (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  protected  Object genericGet (int i)  { throw new RuntimeException(); }
  public  boolean getBoolean (int i)  { throw new RuntimeException(); }
  public  byte getByte (int i)  { throw new RuntimeException(); }
  public  double getDouble (int i)  { throw new RuntimeException(); }
  public  float getFloat (int i)  { throw new RuntimeException(); }
  public  int getInt (int i)  { throw new RuntimeException(); }
  public  long getLong (int i)  { throw new RuntimeException(); }
  public  short getShort (int i)  { throw new RuntimeException(); }
  public  boolean isNullAt (int i)  { throw new RuntimeException(); }
  public  int numFields ()  { throw new RuntimeException(); }
  public  void setBoolean (int ordinal, boolean value)  { throw new RuntimeException(); }
  public  void setByte (int ordinal, byte value)  { throw new RuntimeException(); }
  public  void setDouble (int ordinal, double value)  { throw new RuntimeException(); }
  public  void setFloat (int ordinal, float value)  { throw new RuntimeException(); }
  public  void setInt (int ordinal, int value)  { throw new RuntimeException(); }
  public  void setLong (int ordinal, long value)  { throw new RuntimeException(); }
  public  void setNullAt (int i)  { throw new RuntimeException(); }
  public  void setShort (int ordinal, short value)  { throw new RuntimeException(); }
  public  void update (int ordinal, Object value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.MutableValue[] values ()  { throw new RuntimeException(); }
}
