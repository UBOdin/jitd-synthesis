package org.apache.spark.sql.catalyst.expressions;
/**
 * Cast the child expression to the target data type as per ANSI SQL standard.
 * A runtime exception will be thrown on casting failure such as converting an out-of-range value
 * to an integral type.
 * <p>
 * When cast from/to timezone related types, we need timeZoneId, which will be resolved with
 * session local timezone by an analyzer {@link ResolveTimeZone}.
 */
public  class AnsiCast extends org.apache.spark.sql.catalyst.expressions.CastBase implements scala.Product, scala.Serializable {
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   AnsiCast (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType dataType, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  protected  boolean ansiEnabled ()  { throw new RuntimeException(); }
  public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  public  java.lang.String typeCheckFailureMessage ()  { throw new RuntimeException(); }
}
