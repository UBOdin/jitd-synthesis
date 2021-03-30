package org.apache.spark.sql.catalyst.expressions;
/**
 * A mutable wrapper that makes two rows appear as a single concatenated row.  Designed to
 * be instantiated once per thread and reused.
 */
public  class JoinedRow extends org.apache.spark.sql.catalyst.InternalRow {
  public   JoinedRow ()  { throw new RuntimeException(); }
  public   JoinedRow (org.apache.spark.sql.catalyst.InternalRow left, org.apache.spark.sql.catalyst.InternalRow right)  { throw new RuntimeException(); }
  public  boolean anyNull ()  { throw new RuntimeException(); }
  /** Updates this JoinedRow to used point at two new base rows.  Returns itself. */
  public  org.apache.spark.sql.catalyst.expressions.JoinedRow apply (org.apache.spark.sql.catalyst.InternalRow r1, org.apache.spark.sql.catalyst.InternalRow r2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow copy ()  { throw new RuntimeException(); }
  public  java.lang.Object get (int i, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ArrayData getArray (int i)  { throw new RuntimeException(); }
  public  byte[] getBinary (int i)  { throw new RuntimeException(); }
  public  boolean getBoolean (int i)  { throw new RuntimeException(); }
  public  byte getByte (int i)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal getDecimal (int i, int precision, int scale)  { throw new RuntimeException(); }
  public  double getDouble (int i)  { throw new RuntimeException(); }
  public  float getFloat (int i)  { throw new RuntimeException(); }
  public  int getInt (int i)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval getInterval (int i)  { throw new RuntimeException(); }
  /** Gets this JoinedRow's left base row. */
  public  org.apache.spark.sql.catalyst.InternalRow getLeft ()  { throw new RuntimeException(); }
  public  long getLong (int i)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.MapData getMap (int i)  { throw new RuntimeException(); }
  /** Gets this JoinedRow's right base row. */
  public  org.apache.spark.sql.catalyst.InternalRow getRight ()  { throw new RuntimeException(); }
  public  short getShort (int i)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getStruct (int i, int numFields)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.UTF8String getUTF8String (int i)  { throw new RuntimeException(); }
  public  boolean isNullAt (int i)  { throw new RuntimeException(); }
  public  int numFields ()  { throw new RuntimeException(); }
  public  void setNullAt (int i)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> toSeq (scala.collection.Seq<org.apache.spark.sql.types.DataType> fieldTypes)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  void update (int i, Object value)  { throw new RuntimeException(); }
  /** Updates this JoinedRow by updating its left base row.  Returns itself. */
  public  org.apache.spark.sql.catalyst.expressions.JoinedRow withLeft (org.apache.spark.sql.catalyst.InternalRow newLeft)  { throw new RuntimeException(); }
  /** Updates this JoinedRow by updating its right base row.  Returns itself. */
  public  org.apache.spark.sql.catalyst.expressions.JoinedRow withRight (org.apache.spark.sql.catalyst.InternalRow newRight)  { throw new RuntimeException(); }
}
