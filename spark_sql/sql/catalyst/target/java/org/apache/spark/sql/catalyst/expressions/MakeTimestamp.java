package org.apache.spark.sql.catalyst.expressions;
public  class MakeTimestamp extends org.apache.spark.sql.catalyst.expressions.SeptenaryExpression implements org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression year ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression month ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression day ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression hour ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression min ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression sec ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> timezone ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   MakeTimestamp (org.apache.spark.sql.catalyst.expressions.Expression year, org.apache.spark.sql.catalyst.expressions.Expression month, org.apache.spark.sql.catalyst.expressions.Expression day, org.apache.spark.sql.catalyst.expressions.Expression hour, org.apache.spark.sql.catalyst.expressions.Expression min, org.apache.spark.sql.catalyst.expressions.Expression sec, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> timezone, scala.Option<java.lang.String> timeZoneId, boolean failOnError)  { throw new RuntimeException(); }
  public   MakeTimestamp (org.apache.spark.sql.catalyst.expressions.Expression year, org.apache.spark.sql.catalyst.expressions.Expression month, org.apache.spark.sql.catalyst.expressions.Expression day, org.apache.spark.sql.catalyst.expressions.Expression hour, org.apache.spark.sql.catalyst.expressions.Expression min, org.apache.spark.sql.catalyst.expressions.Expression sec)  { throw new RuntimeException(); }
  public   MakeTimestamp (org.apache.spark.sql.catalyst.expressions.Expression year, org.apache.spark.sql.catalyst.expressions.Expression month, org.apache.spark.sql.catalyst.expressions.Expression day, org.apache.spark.sql.catalyst.expressions.Expression hour, org.apache.spark.sql.catalyst.expressions.Expression min, org.apache.spark.sql.catalyst.expressions.Expression sec, org.apache.spark.sql.catalyst.expressions.Expression timezone)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object year, Object month, Object day, Object hour, Object min, Object sec, scala.Option<java.lang.Object> timezone)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
