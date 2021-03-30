package org.apache.spark.sql.execution.columnar.compression;
public  interface Encoder<T extends org.apache.spark.sql.types.AtomicType> {
  public  java.nio.ByteBuffer compress (java.nio.ByteBuffer from, java.nio.ByteBuffer to)  ;
  public  int compressedSize ()  ;
  public  double compressionRatio ()  ;
  public  void gatherCompressibilityStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  int uncompressedSize ()  ;
}
