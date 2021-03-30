package org.apache.spark.sql.catalyst.expressions;
public  class StringTranslate extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public  java.util.Map<java.lang.String, java.lang.String> buildDict (org.apache.spark.unsafe.types.UTF8String matchingString, org.apache.spark.unsafe.types.UTF8String replaceString)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression srcExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression matchingExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression replaceExpr ()  { throw new RuntimeException(); }
  // not preceding
  public   StringTranslate (org.apache.spark.sql.catalyst.expressions.Expression srcExpr, org.apache.spark.sql.catalyst.expressions.Expression matchingExpr, org.apache.spark.sql.catalyst.expressions.Expression replaceExpr)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object srcEval, Object matchingEval, Object replaceEval)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
