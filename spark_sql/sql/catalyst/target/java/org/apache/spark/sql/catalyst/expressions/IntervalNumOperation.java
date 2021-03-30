package org.apache.spark.sql.catalyst.expressions;
public abstract class IntervalNumOperation extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Serializable {
  public   IntervalNumOperation (org.apache.spark.sql.catalyst.expressions.Expression interval, org.apache.spark.sql.catalyst.expressions.Expression num)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object interval, Object num)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  protected abstract  scala.Function2<org.apache.spark.unsafe.types.CalendarInterval, java.lang.Object, org.apache.spark.unsafe.types.CalendarInterval> operation ()  ;
  protected abstract  java.lang.String operationName ()  ;
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
}
