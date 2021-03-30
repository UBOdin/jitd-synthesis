package org.apache.spark.sql.execution.window;
/**
 * Compare the value of the input index to the value bound of the output index.
 */
 final class RangeBoundOrdering extends org.apache.spark.sql.execution.window.BoundOrdering implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow> ordering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Projection current ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Projection bound ()  { throw new RuntimeException(); }
  // not preceding
  public   RangeBoundOrdering (scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow> ordering, org.apache.spark.sql.catalyst.expressions.Projection current, org.apache.spark.sql.catalyst.expressions.Projection bound)  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.catalyst.InternalRow inputRow, int inputIndex, org.apache.spark.sql.catalyst.InternalRow outputRow, int outputIndex)  { throw new RuntimeException(); }
}
