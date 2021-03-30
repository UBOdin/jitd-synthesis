package org.apache.spark.sql.execution.columnar;
 abstract class ComplexColumnBuilder<JvmType extends java.lang.Object> extends org.apache.spark.sql.execution.columnar.BasicColumnBuilder<JvmType> implements org.apache.spark.sql.execution.columnar.NullableColumnBuilder {
  public   ComplexColumnBuilder (org.apache.spark.sql.execution.columnar.ColumnStats columnStats, org.apache.spark.sql.execution.columnar.ColumnType<JvmType> columnType)  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  protected  java.nio.ByteBuffer nulls ()  { throw new RuntimeException(); }
}
