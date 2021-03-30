package org.apache.spark.sql.catalyst.expressions;
/**
 * This is a common function for databases supporting TIMESTAMP WITHOUT TIMEZONE. This function
 * takes a timestamp which is timezone-agnostic, and interprets it as a timestamp in the given
 * timezone, and renders that timestamp as a timestamp in UTC.
 * <p>
 * However, timestamp in Spark represents number of microseconds from the Unix epoch, which is not
 * timezone-agnostic. So in Spark this function just shift the timestamp value from the given
 * timezone to UTC timezone.
 * <p>
 * This function may return confusing result if the input is a string with timezone, e.g.
 * '2018-03-13T06:18:23+00:00'. The reason is that, Spark firstly cast the string to timestamp
 * according to the timezone in the string, and finally display the result by converting the
 * timestamp to string according to the session local timezone.
 */
public  class ToUTCTimestamp extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.UTCTimestamp, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  // not preceding
  public   ToUTCTimestamp (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.Object, java.lang.String, java.lang.Object> func ()  { throw new RuntimeException(); }
  public  java.lang.String funcName ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
