package org.apache.spark.sql.catalyst.expressions;
/**
 * The Lead function returns the value of <code>input</code> at the <code>offset</code>th row after the current row in
 * the window. Offsets start at 0, which is the current row. The offset must be constant
 * integer value. The default offset is 1. When the value of <code>input</code> is null at the <code>offset</code>th row,
 * null is returned. If there is no such offset row, the <code>default</code> expression is evaluated.
 */
public  class Lead extends org.apache.spark.sql.catalyst.expressions.FrameLessOffsetWindowFunction implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression input ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression offset ()  { throw new RuntimeException(); }
  public  boolean ignoreNulls ()  { throw new RuntimeException(); }
  // not preceding
  public   Lead (org.apache.spark.sql.catalyst.expressions.Expression input, org.apache.spark.sql.catalyst.expressions.Expression offset, org.apache.spark.sql.catalyst.expressions.Expression default_, boolean ignoreNulls)  { throw new RuntimeException(); }
  public   Lead (org.apache.spark.sql.catalyst.expressions.Expression input, org.apache.spark.sql.catalyst.expressions.Expression offset, org.apache.spark.sql.catalyst.expressions.Expression default_)  { throw new RuntimeException(); }
  public   Lead (org.apache.spark.sql.catalyst.expressions.Expression input, org.apache.spark.sql.catalyst.expressions.Expression offset)  { throw new RuntimeException(); }
  public   Lead (org.apache.spark.sql.catalyst.expressions.Expression input)  { throw new RuntimeException(); }
  public   Lead ()  { throw new RuntimeException(); }
}
