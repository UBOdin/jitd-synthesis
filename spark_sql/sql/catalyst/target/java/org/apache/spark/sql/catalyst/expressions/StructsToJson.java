package org.apache.spark.sql.catalyst.expressions;
/**
 * Converts a {@link StructType}, {@link ArrayType} or {@link MapType} to a JSON output string.
 */
public  class StructsToJson extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   StructsToJson (scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public   StructsToJson (scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   StructsToJson (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   StructsToJson (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression options)  { throw new RuntimeException(); }
  // not preceding
  public  java.io.CharArrayWriter writer ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.json.JacksonGenerator gen ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType inputSchema ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.Function1<java.lang.Object, org.apache.spark.unsafe.types.UTF8String> converter ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object value)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
