package org.apache.spark.sql.execution.window;
/**
 * Compare the input index to the bound of the output index.
 */
 final class RowBoundOrdering extends org.apache.spark.sql.execution.window.BoundOrdering implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int offset ()  { throw new RuntimeException(); }
  // not preceding
  public   RowBoundOrdering (int offset)  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.catalyst.InternalRow inputRow, int inputIndex, org.apache.spark.sql.catalyst.InternalRow outputRow, int outputIndex)  { throw new RuntimeException(); }
}
