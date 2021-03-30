package org.apache.spark.sql.catalyst.expressions;
/**
 * A {@link BinaryExpression} that is an operator, with two properties:
 * <p>
 * 1. The string representation is "x symbol y", rather than "funcName(x, y)".
 * 2. Two inputs are expected to be of the same type. If the two inputs have different types,
 *    the analyzer will find the tightest common type and do the proper type casting.
 */
public abstract class BinaryOperator extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes {
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> unapply (org.apache.spark.sql.catalyst.expressions.BinaryOperator e)  { throw new RuntimeException(); }
  public   BinaryOperator ()  { throw new RuntimeException(); }
  /**
   * Expected input type from both left/right child expressions, similar to the
   * {@link ImplicitCastInputTypes} trait.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.types.AbstractDataType inputType ()  ;
  public abstract  java.lang.String symbol ()  ;
  public  java.lang.String sqlOperator ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
