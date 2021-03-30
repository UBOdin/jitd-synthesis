package org.apache.spark.sql.catalyst.expressions;
/**
 * Optimized version of LIKE ANY, when all pattern values are literal.
 */
public abstract class LikeAnyBase extends org.apache.spark.sql.catalyst.expressions.MultiLikeBase {
  public   LikeAnyBase ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object matches (java.lang.String exprValue)  { throw new RuntimeException(); }
}
