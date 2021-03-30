package org.apache.spark.sql.catalyst.expressions;
public  interface TaggingExpression {
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  boolean nullable ()  ;
}
