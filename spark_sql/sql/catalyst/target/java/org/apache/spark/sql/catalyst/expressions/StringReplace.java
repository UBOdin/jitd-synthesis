package org.apache.spark.sql.catalyst.expressions;
/**
 * Replace all occurrences with string.
 */
public  class StringReplace extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression srcExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression searchExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression replaceExpr ()  { throw new RuntimeException(); }
  // not preceding
  public   StringReplace (org.apache.spark.sql.catalyst.expressions.Expression srcExpr, org.apache.spark.sql.catalyst.expressions.Expression searchExpr, org.apache.spark.sql.catalyst.expressions.Expression replaceExpr)  { throw new RuntimeException(); }
  public   StringReplace (org.apache.spark.sql.catalyst.expressions.Expression srcExpr, org.apache.spark.sql.catalyst.expressions.Expression searchExpr)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object srcEval, Object searchEval, Object replaceEval)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
