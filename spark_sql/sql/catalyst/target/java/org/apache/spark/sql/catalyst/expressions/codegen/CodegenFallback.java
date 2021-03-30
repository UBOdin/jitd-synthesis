package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A trait that can be used to provide a fallback mode for expression code generation.
 */
public  interface CodegenFallback {
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
}
