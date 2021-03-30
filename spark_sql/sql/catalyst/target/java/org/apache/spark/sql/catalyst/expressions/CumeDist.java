package org.apache.spark.sql.catalyst.expressions;
/**
 * The CumeDist function computes the position of a value relative to all values in the partition.
 * The result is the number of rows preceding or equal to the current row in the ordering of the
 * partition divided by the total number of rows in the window partition. Any tie values in the
 * ordering will evaluate to the same position.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class CumeDist extends org.apache.spark.sql.catalyst.expressions.RowNumberLike implements org.apache.spark.sql.catalyst.expressions.SizeBasedWindowFunction, scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference n ()  { throw new RuntimeException(); }
  public   CumeDist ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SpecifiedWindowFrame frame ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
