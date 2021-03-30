package org.apache.spark.sql.catalyst.expressions;
/**
 * Creates a map after splitting the input text into key/value pairs using delimiters
 */
public  class StringToMap extends org.apache.spark.sql.catalyst.expressions.TernaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression text ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression pairDelim ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyValueDelim ()  { throw new RuntimeException(); }
  // not preceding
  public   StringToMap (org.apache.spark.sql.catalyst.expressions.Expression text, org.apache.spark.sql.catalyst.expressions.Expression pairDelim, org.apache.spark.sql.catalyst.expressions.Expression keyValueDelim)  { throw new RuntimeException(); }
  public   StringToMap (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression pairDelim)  { throw new RuntimeException(); }
  public   StringToMap (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object inputString, Object stringDelimiter, Object keyValueDelimiter)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
