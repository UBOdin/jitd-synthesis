package org.apache.spark.sql.catalyst.expressions;
/**
 * Expression used internally to convert the TimestampType to Long and back without losing
 * precision, i.e. in microseconds. Used in time windowing.
 */
public  class PreciseTimestampConversion extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType fromType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType toType ()  { throw new RuntimeException(); }
  // not preceding
  public   PreciseTimestampConversion (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType fromType, org.apache.spark.sql.types.DataType toType)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
}
