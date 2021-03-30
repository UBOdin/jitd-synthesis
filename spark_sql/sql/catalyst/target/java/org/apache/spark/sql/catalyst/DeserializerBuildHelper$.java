package org.apache.spark.sql.catalyst;
public  class DeserializerBuildHelper$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DeserializerBuildHelper$ MODULE$ = null;
  public   DeserializerBuildHelper$ ()  { throw new RuntimeException(); }
  /** Returns the current path with a sub-field extracted. */
  public  org.apache.spark.sql.catalyst.expressions.Expression addToPath (org.apache.spark.sql.catalyst.expressions.Expression path, java.lang.String part, org.apache.spark.sql.types.DataType dataType, org.apache.spark.sql.catalyst.WalkedTypePath walkedTypePath)  { throw new RuntimeException(); }
  /** Returns the current path with a field at ordinal extracted. */
  public  org.apache.spark.sql.catalyst.expressions.Expression addToPathOrdinal (org.apache.spark.sql.catalyst.expressions.Expression path, int ordinal, org.apache.spark.sql.types.DataType dataType, org.apache.spark.sql.catalyst.WalkedTypePath walkedTypePath)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializerForWithNullSafetyAndUpcast (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.catalyst.WalkedTypePath walkedTypePath, scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.WalkedTypePath, org.apache.spark.sql.catalyst.expressions.Expression> funcForCreatingDeserializer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression expressionWithNullSafety (org.apache.spark.sql.catalyst.expressions.Expression expr, boolean nullable, org.apache.spark.sql.catalyst.WalkedTypePath walkedTypePath)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForTypesSupportValueOf (org.apache.spark.sql.catalyst.expressions.Expression path, java.lang.Class<?> clazz)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForString (org.apache.spark.sql.catalyst.expressions.Expression path, boolean returnNullable)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForSqlDate (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForLocalDate (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForInstant (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForSqlTimestamp (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForJavaBigDecimal (org.apache.spark.sql.catalyst.expressions.Expression path, boolean returnNullable)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForScalaBigDecimal (org.apache.spark.sql.catalyst.expressions.Expression path, boolean returnNullable)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForJavaBigInteger (org.apache.spark.sql.catalyst.expressions.Expression path, boolean returnNullable)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForScalaBigInt (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForDuration (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression createDeserializerForPeriod (org.apache.spark.sql.catalyst.expressions.Expression path)  { throw new RuntimeException(); }
}
