package org.apache.spark.sql.execution;
/**
 * For lazy computing, be sure the generator.terminate() called in the very last
 * TODO reusing the CompletionIterator?
 */
  class LazyIterator implements scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow>> func ()  { throw new RuntimeException(); }
  // not preceding
  public   LazyIterator (scala.Function0<scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow>> func)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> results ()  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow next ()  { throw new RuntimeException(); }
}
