package org.apache.spark.sql.catalyst.expressions;
/**
 * Converts a CSV input string to a {@link StructType} with the specified schema.
 */
public  class CsvToStructs extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> requiredSchema ()  { throw new RuntimeException(); }
  // not preceding
  public   CsvToStructs (org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<java.lang.String> timeZoneId, scala.Option<org.apache.spark.sql.types.StructType> requiredSchema)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType nullableSchema ()  { throw new RuntimeException(); }
  public   CsvToStructs (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public   CsvToStructs (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression schema)  { throw new RuntimeException(); }
  public   CsvToStructs (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression schema, org.apache.spark.sql.catalyst.expressions.Expression options)  { throw new RuntimeException(); }
  // not preceding
  public  scala.Function1<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.catalyst.InternalRow> converter ()  { throw new RuntimeException(); }
  public  java.lang.String nameOfCorruptRecord ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.util.FailureSafeParser<java.lang.String> parser ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
