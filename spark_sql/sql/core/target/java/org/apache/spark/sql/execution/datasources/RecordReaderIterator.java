package org.apache.spark.sql.execution.datasources;
/**
 * An adaptor from a Hadoop {@link RecordReader} to an {@link Iterator} over the values returned.
 * <p>
 * Note that this returns {@link Object}s instead of {@link InternalRow} because we rely on erasure to pass
 * column batches by pretending they are rows.
 */
public  class RecordReaderIterator<T extends java.lang.Object> implements scala.collection.Iterator<T>, java.io.Closeable {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   RecordReaderIterator (org.apache.hadoop.mapreduce.RecordReader<?, T> rowReader)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  T next ()  { throw new RuntimeException(); }
}
