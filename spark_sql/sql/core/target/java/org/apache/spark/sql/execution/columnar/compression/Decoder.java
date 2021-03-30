package org.apache.spark.sql.execution.columnar.compression;
public  interface Decoder<T extends org.apache.spark.sql.types.AtomicType> {
  public  void decompress (org.apache.spark.sql.execution.vectorized.WritableColumnVector columnVector, int capacity)  ;
  public  boolean hasNext ()  ;
  public  void next (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
}
