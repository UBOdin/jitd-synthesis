package org.apache.spark.sql.execution.columnar.compression;
public  class BooleanBitSet {
  static public  class Encoder implements org.apache.spark.sql.execution.columnar.compression.Encoder<org.apache.spark.sql.types.BooleanType$> {
    public   Encoder ()  { throw new RuntimeException(); }
    public  java.nio.ByteBuffer compress (java.nio.ByteBuffer from, java.nio.ByteBuffer to)  { throw new RuntimeException(); }
    public  int compressedSize ()  { throw new RuntimeException(); }
    public  void gatherCompressibilityStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
    public  int uncompressedSize ()  { throw new RuntimeException(); }
  }
  static public  class Decoder implements org.apache.spark.sql.execution.columnar.compression.Decoder<org.apache.spark.sql.types.BooleanType$> {
    public   Decoder (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
    public  void decompress (org.apache.spark.sql.execution.vectorized.WritableColumnVector columnVector, int capacity)  { throw new RuntimeException(); }
    public  boolean hasNext ()  { throw new RuntimeException(); }
    public  void next (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  }
  static public  int typeId ()  { throw new RuntimeException(); }
  static public  int BITS_PER_LONG ()  { throw new RuntimeException(); }
  static public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.Decoder<T> decoder (java.nio.ByteBuffer buffer, org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  static public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.Encoder<T> encoder (org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  static public  boolean supports (org.apache.spark.sql.execution.columnar.ColumnType<?> columnType)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
