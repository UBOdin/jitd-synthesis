package org.apache.spark.sql.catalyst.expressions;
/**
 * Sorts elements in an array using a comparator function.
 */
public  class ArraySort extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ArrayBasedSimpleHigherOrderFunction, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.LambdaFunction defaultComparator ()  { throw new RuntimeException(); }
  public  boolean argumentsResolved ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  { throw new RuntimeException(); }
  // not preceding
  public   ArraySort (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function)  { throw new RuntimeException(); }
  public   ArraySort (org.apache.spark.sql.catalyst.expressions.Expression argument)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType elementType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.ArrayType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ArraySort bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable firstElemVar ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable secondElemVar ()  { throw new RuntimeException(); }
  public  java.util.Comparator<java.lang.Object> comparator (org.apache.spark.sql.catalyst.InternalRow inputRow)  { throw new RuntimeException(); }
  public  Object nullSafeEval (org.apache.spark.sql.catalyst.InternalRow inputRow, Object argumentValue)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
