package org.apache.spark.sql.catalyst.expressions;
/**
 * Optimized version of LIKE ALL, when all pattern values are literal.
 */
public abstract class LikeAllBase extends org.apache.spark.sql.catalyst.expressions.MultiLikeBase {
  public   LikeAllBase ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object matches (java.lang.String exprValue)  { throw new RuntimeException(); }
}
