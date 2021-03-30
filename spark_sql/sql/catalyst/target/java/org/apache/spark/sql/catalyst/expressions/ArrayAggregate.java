package org.apache.spark.sql.catalyst.expressions;
/**
 * Applies a binary operator to a start value and all elements in the array.
 */
public  class ArrayAggregate extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.HigherOrderFunction, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean argumentsResolved ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression zero ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression merge ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression finish ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayAggregate (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression zero, org.apache.spark.sql.catalyst.expressions.Expression merge, org.apache.spark.sql.catalyst.expressions.Expression finish)  { throw new RuntimeException(); }
  public   ArrayAggregate (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression zero, org.apache.spark.sql.catalyst.expressions.Expression merge)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> argumentTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> functionTypes ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ArrayAggregate bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable accForMergeVar ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable elementVar ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable accForFinishVar ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
