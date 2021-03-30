package org.apache.spark.sql.execution.columnar;
public  class BOOLEAN {
  static public  void append (boolean v, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  static public  void append (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  static public  boolean extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  static public  void extract (java.nio.ByteBuffer buffer, org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, boolean value)  { throw new RuntimeException(); }
  static public  boolean getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  void copyField (org.apache.spark.sql.catalyst.InternalRow from, int fromOrdinal, org.apache.spark.sql.catalyst.InternalRow to, int toOrdinal)  { throw new RuntimeException(); }
  static public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  JvmType clone (JvmType v)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  T dataType ()  { throw new RuntimeException(); }
  static public  int defaultSize ()  { throw new RuntimeException(); }
  static public  scala.reflect.api.TypeTags.TypeTag<java.lang.Object> scalaTag ()  { throw new RuntimeException(); }
}
