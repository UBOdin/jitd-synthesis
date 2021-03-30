package org.apache.spark.sql.catalyst.expressions;
/**
 * Common trait for {@link GetMapValue} and {@link ElementAt}.
 */
public  interface GetMapValueUtil extends org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGetValueGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, org.apache.spark.sql.types.MapType mapType, boolean failOnError)  ;
  public  Object getValueEval (Object value, Object ordinal, org.apache.spark.sql.types.DataType keyType, scala.math.Ordering<java.lang.Object> ordering, boolean failOnError)  ;
}
