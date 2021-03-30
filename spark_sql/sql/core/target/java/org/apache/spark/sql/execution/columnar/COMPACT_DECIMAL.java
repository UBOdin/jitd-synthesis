package org.apache.spark.sql.execution.columnar;
  class COMPACT_DECIMAL extends org.apache.spark.sql.execution.columnar.NativeColumnType<org.apache.spark.sql.types.DecimalType> implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.columnar.COMPACT_DECIMAL apply (org.apache.spark.sql.types.DecimalType dt)  { throw new RuntimeException(); }
  public  int precision ()  { throw new RuntimeException(); }
  public  int scale ()  { throw new RuntimeException(); }
  // not preceding
  public   COMPACT_DECIMAL (int precision, int scale)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  void extract (java.nio.ByteBuffer buffer, org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void append (org.apache.spark.sql.types.Decimal v, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  void append (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.sql.types.Decimal value)  { throw new RuntimeException(); }
  public  void copyField (org.apache.spark.sql.catalyst.InternalRow from, int fromOrdinal, org.apache.spark.sql.catalyst.InternalRow to, int toOrdinal)  { throw new RuntimeException(); }
}
