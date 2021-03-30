package org.apache.spark.sql.catalyst.expressions;
public  interface DivModLike {
  public  java.lang.String decimalToDataTypeCodeGen (java.lang.String decimalResult)  ;
  /**
   * Special case handling due to division/remainder by 0 =&gt; null or ArithmeticException.
   * @param ctx (undocumented)
   * @param ev (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  Object evalOperation (Object left, Object right)  ;
  public  boolean nullable ()  ;
}
