package org.apache.spark.sql.catalyst.expressions;
public  class SecondWithFraction extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.GetTimeField, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   SecondWithFraction (org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public   SecondWithFraction (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SecondWithFraction withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.Object, java.time.ZoneId, org.apache.spark.sql.types.Decimal> func ()  { throw new RuntimeException(); }
  public  java.lang.String funcName ()  { throw new RuntimeException(); }
}