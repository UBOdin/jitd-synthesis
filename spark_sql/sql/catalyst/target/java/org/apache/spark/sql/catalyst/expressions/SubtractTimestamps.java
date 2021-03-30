package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns the interval from startTimestamp to endTimestamp in which the <code>months</code> and <code>day</code> field
 * is set to 0 and the <code>microseconds</code> field is initialized to the microsecond difference
 * between the given timestamps.
 */
public  class SubtractTimestamps extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression endTimestamp ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression startTimestamp ()  { throw new RuntimeException(); }
  // not preceding
  public   SubtractTimestamps (org.apache.spark.sql.catalyst.expressions.Expression endTimestamp, org.apache.spark.sql.catalyst.expressions.Expression startTimestamp)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object end, Object start)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
