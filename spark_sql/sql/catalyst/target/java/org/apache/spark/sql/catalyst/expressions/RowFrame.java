package org.apache.spark.sql.catalyst.expressions;
/**
 * RowFrame treats rows in a partition individually. Values used in a row frame are considered
 * to be physical offsets.
 * For example, <code>ROW BETWEEN 1 PRECEDING AND 1 FOLLOWING</code> represents a 3-row frame,
 * from the row that precedes the current row to the row that follows the current row.
 */
public  class RowFrame {
  static public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  static public  java.lang.String sql ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
