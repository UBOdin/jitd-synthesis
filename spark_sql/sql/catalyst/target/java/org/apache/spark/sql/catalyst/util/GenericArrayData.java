package org.apache.spark.sql.catalyst.util;
public  class GenericArrayData extends org.apache.spark.sql.catalyst.util.ArrayData {
  // not preceding
  public   GenericArrayData (java.lang.Object[] array)  { throw new RuntimeException(); }
  public   GenericArrayData (scala.collection.Seq<java.lang.Object> seq)  { throw new RuntimeException(); }
  public   GenericArrayData (java.util.List<java.lang.Object> list)  { throw new RuntimeException(); }
  public   GenericArrayData (int[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (long[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (float[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (double[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (short[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (byte[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (boolean[] primitiveArray)  { throw new RuntimeException(); }
  public   GenericArrayData (Object seqOrArray)  { throw new RuntimeException(); }
  public  java.lang.Object[] array ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ArrayData copy ()  { throw new RuntimeException(); }
  public  boolean equals (Object o)  { throw new RuntimeException(); }
  public  java.lang.Object get (int ordinal, org.apache.spark.sql.types.DataType elementType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ArrayData getArray (int ordinal)  { throw new RuntimeException(); }
  public  byte[] getBinary (int ordinal)  { throw new RuntimeException(); }
  public  boolean getBoolean (int ordinal)  { throw new RuntimeException(); }
  public  byte getByte (int ordinal)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal getDecimal (int ordinal, int precision, int scale)  { throw new RuntimeException(); }
  public  double getDouble (int ordinal)  { throw new RuntimeException(); }
  public  float getFloat (int ordinal)  { throw new RuntimeException(); }
  public  int getInt (int ordinal)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval getInterval (int ordinal)  { throw new RuntimeException(); }
  public  long getLong (int ordinal)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.MapData getMap (int ordinal)  { throw new RuntimeException(); }
  public  short getShort (int ordinal)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getStruct (int ordinal, int numFields)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.UTF8String getUTF8String (int ordinal)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean isNullAt (int ordinal)  { throw new RuntimeException(); }
  public  int numElements ()  { throw new RuntimeException(); }
  public  void setNullAt (int ordinal)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  void update (int ordinal, Object value)  { throw new RuntimeException(); }
}
