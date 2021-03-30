package org.apache.spark.sql.catalyst.expressions;
/**
 * Gets timestamps from strings using given pattern.
 */
public  class GetTimestamp extends org.apache.spark.sql.catalyst.expressions.ToTimestamp implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   GetTimestamp (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right, scala.Option<java.lang.String> timeZoneId, boolean failOnError)  { throw new RuntimeException(); }
  public  long downScaleFactor ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
}
