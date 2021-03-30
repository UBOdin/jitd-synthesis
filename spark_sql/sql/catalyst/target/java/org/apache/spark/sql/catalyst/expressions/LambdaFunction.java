package org.apache.spark.sql.catalyst.expressions;
/**
 * A lambda function and its arguments. A lambda function can be hidden when a user wants to
 * process an completely independent expression in a {@link HigherOrderFunction}, the lambda function
 * and its variables are then only used for internal bookkeeping within the higher order function.
 */
public  class LambdaFunction extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.LambdaFunction identity ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> arguments ()  { throw new RuntimeException(); }
  public  boolean hidden ()  { throw new RuntimeException(); }
  // not preceding
  public   LambdaFunction (org.apache.spark.sql.catalyst.expressions.Expression function, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> arguments, boolean hidden)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean bound ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
}
