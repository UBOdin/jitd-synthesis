package org.apache.spark.sql.execution.columnar;
  class LARGE_DECIMAL extends org.apache.spark.sql.execution.columnar.ByteArrayColumnType<org.apache.spark.sql.types.Decimal> implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.columnar.LARGE_DECIMAL apply (org.apache.spark.sql.types.DecimalType dt)  { throw new RuntimeException(); }
  public  int precision ()  { throw new RuntimeException(); }
  public  int scale ()  { throw new RuntimeException(); }
  // not preceding
  public   LARGE_DECIMAL (int precision, int scale)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.sql.types.Decimal value)  { throw new RuntimeException(); }
  public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.spark.sql.types.Decimal value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
