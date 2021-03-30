package org.apache.spark.sql.catalyst.expressions;
/**
 * Tests whether a predicate holds for one or more elements in the array.
 */
public  class ArrayExists extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ArrayBasedSimpleHigherOrderFunction, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.ArrayExists apply (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function)  { throw new RuntimeException(); }
  public  boolean argumentsResolved ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  { throw new RuntimeException(); }
  public  boolean followThreeValuedLogic ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayExists (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function, boolean followThreeValuedLogic)  { throw new RuntimeException(); }
  public   ArrayExists (org.apache.spark.sql.catalyst.expressions.Expression argument, org.apache.spark.sql.catalyst.expressions.Expression function)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType functionType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ArrayExists bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.NamedLambdaVariable elementVar ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (org.apache.spark.sql.catalyst.InternalRow inputRow, Object argumentValue)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
