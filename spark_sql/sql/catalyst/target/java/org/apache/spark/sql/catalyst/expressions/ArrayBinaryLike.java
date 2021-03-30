package org.apache.spark.sql.catalyst.expressions;
/**
 * Will become common base class for {@link ArrayUnion}, {@link ArrayIntersect}, and {@link ArrayExcept}.
 */
public  interface ArrayBinaryLike extends org.apache.spark.sql.catalyst.expressions.BinaryArrayExpressionWithImplicitCast, org.apache.spark.sql.catalyst.expressions.ArraySetLike, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public  org.apache.spark.sql.types.DataType dt ()  ;
  public  org.apache.spark.sql.types.DataType et ()  ;
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  ;
}
