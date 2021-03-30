package org.apache.spark.sql.catalyst.expressions;
/**
 * Transform Keys for every entry of the map by applying the transform_keys function.
 * Returns map with transformed key entries
 */
public  class TransformKeys extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.MapBasedSimpleHigherOrderFunction, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean argumentsResolved ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  { throw new RuntimeException(); }
  // not preceding
  public   TransformKeys (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType keyType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType valueType ()  { throw new RuntimeException(); }
  public  boolean valueContainsNull ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.MapType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TransformKeys bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable keyVar ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable valueVar ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (org.apache.spark.sql.catalyst.InternalRow inputRow, Object argumentValue)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
