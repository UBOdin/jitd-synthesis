package org.apache.spark.sql.catalyst.expressions;
/**
 * Replace all substrings of str that match regexp with rep.
 * <p>
 * NOTE: this expression is not THREAD-SAFE, as it has some internal mutable status.
 */
public  class RegExpReplace extends org.apache.spark.sql.catalyst.expressions.QuaternaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.RegExpReplace apply (org.apache.spark.sql.catalyst.expressions.Expression subject, org.apache.spark.sql.catalyst.expressions.Expression regexp, org.apache.spark.sql.catalyst.expressions.Expression rep)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression subject ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression regexp ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression rep ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression pos ()  { throw new RuntimeException(); }
  // not preceding
  public   RegExpReplace (org.apache.spark.sql.catalyst.expressions.Expression subject, org.apache.spark.sql.catalyst.expressions.Expression regexp, org.apache.spark.sql.catalyst.expressions.Expression rep, org.apache.spark.sql.catalyst.expressions.Expression pos)  { throw new RuntimeException(); }
  public   RegExpReplace (org.apache.spark.sql.catalyst.expressions.Expression subject, org.apache.spark.sql.catalyst.expressions.Expression regexp, org.apache.spark.sql.catalyst.expressions.Expression rep)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object s, Object p, Object r, Object i)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
