package org.apache.spark.sql.execution.columnar;
 abstract class NativeColumnBuilder<T extends org.apache.spark.sql.types.AtomicType> extends org.apache.spark.sql.execution.columnar.BasicColumnBuilder<java.lang.Object> implements org.apache.spark.sql.execution.columnar.NullableColumnBuilder, org.apache.spark.sql.execution.columnar.compression.AllCompressionSchemes, org.apache.spark.sql.execution.columnar.compression.CompressibleColumnBuilder<T> {
  // not preceding
  public   NativeColumnBuilder (org.apache.spark.sql.execution.columnar.ColumnStats columnStats, org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.ColumnStats columnStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType ()  { throw new RuntimeException(); }
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(Select(Select(Select(Select(Select(Ident(org), org.apache), org.apache.spark), org.apache.spark.sql), org.apache.spark.sql.types), org.apache.spark.sql.types.AtomicType))))
  public  scala.collection.Seq<org.apache.spark.sql.execution.columnar.compression.Encoder<T>> compressionEncoders ()  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
  protected  java.nio.ByteBuffer nulls ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.columnar.compression.CompressionScheme> schemes ()  { throw new RuntimeException(); }
}
