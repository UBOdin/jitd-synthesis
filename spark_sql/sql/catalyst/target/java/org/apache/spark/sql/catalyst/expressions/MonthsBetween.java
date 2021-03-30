package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns number of months between times <code>timestamp1</code> and <code>timestamp2</code>.
 * If <code>timestamp1</code> is later than <code>timestamp2</code>, then the result is positive.
 * If <code>timestamp1</code> and <code>timestamp2</code> are on the same day of month, or both
 * are the last day of month, time of day will be ignored. Otherwise, the
 * difference is calculated based on 31 days per month, and rounded to
 * 8 digits unless roundOff=false.
 */
public  class MonthsBetween extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression date1 ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression date2 ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression roundOff ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   MonthsBetween (org.apache.spark.sql.catalyst.expressions.Expression date1, org.apache.spark.sql.catalyst.expressions.Expression date2, org.apache.spark.sql.catalyst.expressions.Expression roundOff, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public   MonthsBetween (org.apache.spark.sql.catalyst.expressions.Expression date1, org.apache.spark.sql.catalyst.expressions.Expression date2)  { throw new RuntimeException(); }
  public   MonthsBetween (org.apache.spark.sql.catalyst.expressions.Expression date1, org.apache.spark.sql.catalyst.expressions.Expression date2, org.apache.spark.sql.catalyst.expressions.Expression roundOff)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object t1, Object t2, Object roundOff)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
