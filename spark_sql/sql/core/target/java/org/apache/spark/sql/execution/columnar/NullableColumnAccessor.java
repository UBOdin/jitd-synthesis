package org.apache.spark.sql.execution.columnar;
public  interface NullableColumnAccessor extends org.apache.spark.sql.execution.columnar.ColumnAccessor {
  public  void extractTo (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  boolean hasNext ()  ;
  public  void initialize ()  ;
}
