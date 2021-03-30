package org.apache.spark.sql.catalyst.expressions;
public abstract class BinaryComparison extends org.apache.spark.sql.catalyst.expressions.BinaryOperator implements org.apache.spark.sql.catalyst.expressions.Predicate {
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> unapply (org.apache.spark.sql.catalyst.expressions.BinaryComparison e)  { throw new RuntimeException(); }
  public   BinaryComparison ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  // not preceding
  protected  scala.math.Ordering<java.lang.Object> ordering ()  { throw new RuntimeException(); }
}
