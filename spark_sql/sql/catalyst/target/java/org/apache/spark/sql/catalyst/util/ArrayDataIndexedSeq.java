package org.apache.spark.sql.catalyst.util;
/**
 * Implements an <code>IndexedSeq</code> interface for <code>ArrayData</code>. Notice that if the original <code>ArrayData</code>
 * is a primitive array and contains null elements, it is better to ask for <code>IndexedSeq[Any]</code>,
 * instead of <code>IndexedSeq[Int]</code>, in order to keep the null elements.
 */
public  class ArrayDataIndexedSeq<T extends java.lang.Object> implements scala.collection.IndexedSeq<T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   ArrayDataIndexedSeq (org.apache.spark.sql.catalyst.util.ArrayData arrayData, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  T apply (int idx)  { throw new RuntimeException(); }
  public  int length ()  { throw new RuntimeException(); }
}
