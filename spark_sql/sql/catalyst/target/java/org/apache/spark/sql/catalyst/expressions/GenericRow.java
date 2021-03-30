package org.apache.spark.sql.catalyst.expressions;
/**
 * A row implementation that uses an array of objects as the underlying storage.  Note that, while
 * the array is not copied, and thus could technically be mutated after creation, this is not
 * allowed.
 */
public  class GenericRow implements org.apache.spark.sql.Row {
  // not preceding
  public   GenericRow (java.lang.Object[] values)  { throw new RuntimeException(); }
  /** No-arg constructor for serialization. */
  protected   GenericRow ()  { throw new RuntimeException(); }
  public   GenericRow (int size)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.GenericRow copy ()  { throw new RuntimeException(); }
  public  Object get (int i)  { throw new RuntimeException(); }
  public  int length ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> toSeq ()  { throw new RuntimeException(); }
  protected  java.lang.Object[] values ()  { throw new RuntimeException(); }
}
