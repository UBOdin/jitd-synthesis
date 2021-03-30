package org.apache.spark.sql.catalyst.expressions;
/**
 * A frameless offset window function is a window function that cannot specify window frame and
 * returns the value of the input column offset by a number of rows according to the current row
 * within the partition. For instance: a FrameLessOffsetWindowFunction for value x with offset -2,
 * will get the value of x 2 rows back from the current row in the partition.
 */
public abstract class FrameLessOffsetWindowFunction extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.OffsetWindowFunction, org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public   FrameLessOffsetWindowFunction ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SpecifiedWindowFrame fakeFrame ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.WindowFrame frame ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
