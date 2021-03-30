package org.apache.spark.sql.catalyst.expressions;
public  class MakeInterval extends org.apache.spark.sql.catalyst.expressions.SeptenaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression years ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression months ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression weeks ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression days ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression hours ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression mins ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression secs ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks, org.apache.spark.sql.catalyst.expressions.Expression days, org.apache.spark.sql.catalyst.expressions.Expression hours, org.apache.spark.sql.catalyst.expressions.Expression mins, org.apache.spark.sql.catalyst.expressions.Expression secs, boolean failOnError)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks, org.apache.spark.sql.catalyst.expressions.Expression days, org.apache.spark.sql.catalyst.expressions.Expression hours, org.apache.spark.sql.catalyst.expressions.Expression mins, org.apache.spark.sql.catalyst.expressions.Expression sec)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks, org.apache.spark.sql.catalyst.expressions.Expression days, org.apache.spark.sql.catalyst.expressions.Expression hours, org.apache.spark.sql.catalyst.expressions.Expression mins)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks, org.apache.spark.sql.catalyst.expressions.Expression days, org.apache.spark.sql.catalyst.expressions.Expression hours)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks, org.apache.spark.sql.catalyst.expressions.Expression days)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months, org.apache.spark.sql.catalyst.expressions.Expression weeks)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years, org.apache.spark.sql.catalyst.expressions.Expression months)  { throw new RuntimeException(); }
  public   MakeInterval (org.apache.spark.sql.catalyst.expressions.Expression years)  { throw new RuntimeException(); }
  public   MakeInterval ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object year, Object month, Object week, Object day, Object hour, Object min, scala.Option<java.lang.Object> sec)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
