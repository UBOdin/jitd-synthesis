package org.apache.spark.sql.catalyst.expressions;
/**
 * An extended version of {@link InternalRow} that implements all special getters, toString
 * and equals/hashCode by <code>genericGet</code>.
 */
public  interface BaseGenericInternalRow {
  public  org.apache.spark.sql.catalyst.expressions.GenericInternalRow copy ()  ;
  public  boolean equals (Object o)  ;
  public  Object genericGet (int ordinal)  ;
  public  java.lang.Object get (int ordinal, org.apache.spark.sql.types.DataType dataType)  ;
  public  org.apache.spark.sql.catalyst.util.ArrayData getArray (int ordinal)  ;
  public <T extends java.lang.Object> T getAs (int ordinal)  ;
  public  byte[] getBinary (int ordinal)  ;
  public  boolean getBoolean (int ordinal)  ;
  public  byte getByte (int ordinal)  ;
  public  org.apache.spark.sql.types.Decimal getDecimal (int ordinal, int precision, int scale)  ;
  public  double getDouble (int ordinal)  ;
  public  float getFloat (int ordinal)  ;
  public  int getInt (int ordinal)  ;
  public  org.apache.spark.unsafe.types.CalendarInterval getInterval (int ordinal)  ;
  public  long getLong (int ordinal)  ;
  public  org.apache.spark.sql.catalyst.util.MapData getMap (int ordinal)  ;
  public  short getShort (int ordinal)  ;
  public  org.apache.spark.sql.catalyst.InternalRow getStruct (int ordinal, int numFields)  ;
  public  org.apache.spark.unsafe.types.UTF8String getUTF8String (int ordinal)  ;
  public  int hashCode ()  ;
  public  boolean isNullAt (int ordinal)  ;
  public  java.lang.String toString ()  ;
}
