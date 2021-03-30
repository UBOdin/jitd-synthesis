package org.apache.spark.sql.catalyst.expressions;
/**
 * Transform elements in an array using the transform function. This is similar to
 * a <code>map</code> in functional programming.
 */
public  class ArrayTransform extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ArrayBasedSimpleHigherOrderFunction, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean argumentsResolved ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayTransform (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.ArrayType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ArrayTransform bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable elementVar ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable> indexVar ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (org.apache.spark.sql.catalyst.InternalRow inputRow, Object argumentValue)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
