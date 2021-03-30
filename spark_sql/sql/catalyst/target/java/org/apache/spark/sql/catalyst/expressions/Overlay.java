package org.apache.spark.sql.catalyst.expressions;
public  class Overlay extends org.apache.spark.sql.catalyst.expressions.QuaternaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public  org.apache.spark.unsafe.types.UTF8String calculate (org.apache.spark.unsafe.types.UTF8String input, org.apache.spark.unsafe.types.UTF8String replace, int pos, int len)  { throw new RuntimeException(); }
  static public  byte[] calculate (byte[] input, byte[] replace, int pos, int len)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression input ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression replace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression pos ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression len ()  { throw new RuntimeException(); }
  // not preceding
  public   Overlay (org.apache.spark.sql.catalyst.expressions.Expression input, org.apache.spark.sql.catalyst.expressions.Expression replace, org.apache.spark.sql.catalyst.expressions.Expression pos, org.apache.spark.sql.catalyst.expressions.Expression len)  { throw new RuntimeException(); }
  public   Overlay (org.apache.spark.sql.catalyst.expressions.Expression str, org.apache.spark.sql.catalyst.expressions.Expression replace, org.apache.spark.sql.catalyst.expressions.Expression pos)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object inputEval, Object replaceEval, Object posEval, Object lenEval)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
