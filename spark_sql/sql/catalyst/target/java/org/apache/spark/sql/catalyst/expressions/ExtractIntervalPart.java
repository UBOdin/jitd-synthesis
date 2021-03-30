package org.apache.spark.sql.catalyst.expressions;
public abstract class ExtractIntervalPart extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.Expression parseExtractField (java.lang.String extractField, org.apache.spark.sql.catalyst.expressions.Expression source, scala.Function0<scala.runtime.Nothing$> errorHandleFunc)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   ExtractIntervalPart (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType dataType, scala.Function1<org.apache.spark.unsafe.types.CalendarInterval, java.lang.Object> func, java.lang.String funcName)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object interval)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
