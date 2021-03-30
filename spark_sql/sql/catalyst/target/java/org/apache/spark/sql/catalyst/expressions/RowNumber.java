package org.apache.spark.sql.catalyst.expressions;
/**
 * The RowNumber function computes a unique, sequential number to each row, starting with one,
 * according to the ordering of rows within the window partition.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class RowNumber extends org.apache.spark.sql.catalyst.expressions.RowNumberLike implements scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public   RowNumber ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
