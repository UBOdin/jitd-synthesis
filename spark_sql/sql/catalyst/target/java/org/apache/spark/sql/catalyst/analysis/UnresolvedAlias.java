package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the expression that has yet to be aliased.
 * <p>
 * param:  child The computation that is needs to be resolved during analysis.
 * param:  aliasFunc The function if specified to be called to generate an alias to associate
 *                  with the result of computing {@link child}
 * <p>
 */
public  class UnresolvedAlias extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, java.lang.String>> aliasFunc ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedAlias (org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, java.lang.String>> aliasFunc)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
