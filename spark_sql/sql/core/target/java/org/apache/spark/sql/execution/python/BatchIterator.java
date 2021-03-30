package org.apache.spark.sql.execution.python;
/**
 * Grouped a iterator into batches.
 * This is similar to iter.grouped but returns Iterator[T] instead of Seq[T].
 * This is necessary because sometimes we cannot hold reference of input rows
 * because the some input rows are mutable and can be reused.
 */
  class BatchIterator<T extends java.lang.Object> implements scala.collection.Iterator<scala.collection.Iterator<T>> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   BatchIterator (scala.collection.Iterator<T> iter, int batchSize)  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<T> next ()  { throw new RuntimeException(); }
}
