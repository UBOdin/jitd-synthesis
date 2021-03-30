package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that cannot be evaluated. These expressions don't live past analysis or
 * optimization time (e.g. Star) and should not be evaluated during query planning and
 * execution.
 */
public  interface Unevaluable {
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  /** Unevaluable is not foldable because we don't have an eval for it. */
  public  boolean foldable ()  ;
}
