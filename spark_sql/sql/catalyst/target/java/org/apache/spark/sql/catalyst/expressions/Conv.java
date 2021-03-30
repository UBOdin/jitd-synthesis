package org.apache.spark.sql.catalyst.expressions;
/**
 * Convert a num from one base to another
 * <p>
 * param:  numExpr the number to be converted
 * param:  fromBaseExpr from which base
 * param:  toBaseExpr to which base
 */
public  class Conv extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression numExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression fromBaseExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression toBaseExpr ()  { throw new RuntimeException(); }
  // not preceding
  public   Conv (org.apache.spark.sql.catalyst.expressions.Expression numExpr, org.apache.spark.sql.catalyst.expressions.Expression fromBaseExpr, org.apache.spark.sql.catalyst.expressions.Expression toBaseExpr)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object num, Object fromBase, Object toBase)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
