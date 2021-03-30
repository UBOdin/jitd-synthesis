package org.apache.spark.sql.catalyst.expressions;
public  class MakeDate extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression year ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression month ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression day ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   MakeDate (org.apache.spark.sql.catalyst.expressions.Expression year, org.apache.spark.sql.catalyst.expressions.Expression month, org.apache.spark.sql.catalyst.expressions.Expression day, boolean failOnError)  { throw new RuntimeException(); }
  public   MakeDate (org.apache.spark.sql.catalyst.expressions.Expression year, org.apache.spark.sql.catalyst.expressions.Expression month, org.apache.spark.sql.catalyst.expressions.Expression day)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object year, Object month, Object day)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
