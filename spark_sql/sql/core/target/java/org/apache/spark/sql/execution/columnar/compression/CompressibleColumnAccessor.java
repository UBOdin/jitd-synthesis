package org.apache.spark.sql.execution.columnar.compression;
public  interface CompressibleColumnAccessor<T extends org.apache.spark.sql.types.AtomicType> extends org.apache.spark.sql.execution.columnar.ColumnAccessor {
  public  void decompress (org.apache.spark.sql.execution.vectorized.WritableColumnVector columnVector, int capacity)  ;
  public  void extractSingle (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  boolean hasNext ()  ;
  public  void initialize ()  ;
}
