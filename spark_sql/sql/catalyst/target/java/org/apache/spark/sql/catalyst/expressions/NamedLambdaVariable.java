package org.apache.spark.sql.catalyst.expressions;
/**
 * A named lambda variable.
 */
public  class NamedLambdaVariable extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  java.util.concurrent.atomic.AtomicReference<java.lang.Object> value ()  { throw new RuntimeException(); }
  // not preceding
  public   NamedLambdaVariable (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.catalyst.expressions.ExprId exprId, java.util.concurrent.atomic.AtomicReference<java.lang.Object> value)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
