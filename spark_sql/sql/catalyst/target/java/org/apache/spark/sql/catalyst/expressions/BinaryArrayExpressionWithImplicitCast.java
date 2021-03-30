package org.apache.spark.sql.catalyst.expressions;
/**
 * Base trait for {@link BinaryExpression}s with two arrays of the same element type and implicit
 * casting.
 */
public  interface BinaryArrayExpressionWithImplicitCast extends org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  ;
  public  org.apache.spark.sql.types.DataType elementType ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  ;
}
