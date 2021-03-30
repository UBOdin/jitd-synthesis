package org.apache.spark.sql.catalyst.expressions;
/**
 * Cast the child expression to the target data type, but will throw error if the cast might
 * truncate, e.g. long -> int, timestamp -> data.
 * <p>
 * Note: <code>target</code> is <code>AbstractDataType</code>, so that we can put <code>object DecimalType</code>, which means
 * we accept <code>DecimalType</code> with any valid precision/scale.
 */
public  class UpCast extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType target ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> walkedTypePath ()  { throw new RuntimeException(); }
  // not preceding
  public   UpCast (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.AbstractDataType target, scala.collection.Seq<java.lang.String> walkedTypePath)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
}
