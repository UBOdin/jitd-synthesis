package org.apache.spark.sql.catalyst.expressions;
/**
 * Converts the number of seconds from unix epoch (1970-01-01 00:00:00 UTC) to a string
 * representing the timestamp of that moment in the current system time zone in the given
 * format. If the format is missing, using format like "1970-01-01 00:00:00".
 * Note that Hive Language Manual says it returns 0 if fail, but in fact it returns null.
 */
public  class FromUnixTime extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.TimestampFormatterHelper, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected final  scala.Option<org.apache.spark.sql.catalyst.util.TimestampFormatter> formatterOption ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression sec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression format ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   FromUnixTime (org.apache.spark.sql.catalyst.expressions.Expression sec, org.apache.spark.sql.catalyst.expressions.Expression format, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public   FromUnixTime (org.apache.spark.sql.catalyst.expressions.Expression sec, org.apache.spark.sql.catalyst.expressions.Expression format)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public   FromUnixTime (org.apache.spark.sql.catalyst.expressions.Expression unix)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object seconds, Object format)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression formatString ()  { throw new RuntimeException(); }
  protected  boolean isParsing ()  { throw new RuntimeException(); }
}
