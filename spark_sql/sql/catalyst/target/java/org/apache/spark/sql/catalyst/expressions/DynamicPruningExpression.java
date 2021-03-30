package org.apache.spark.sql.catalyst.expressions;
/**
 * Marker for a planned {@link DynamicPruning} expression.
 * The expression is created during planning, and it defers to its child for evaluation.
 * <p>
 * param:  child underlying predicate.
 */
public  class DynamicPruningExpression extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.DynamicPruning, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   DynamicPruningExpression (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
