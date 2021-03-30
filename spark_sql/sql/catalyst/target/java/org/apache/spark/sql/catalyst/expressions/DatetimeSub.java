package org.apache.spark.sql.catalyst.expressions;
/**
 * Subtract an interval from timestamp or date, which is only used to give a pretty sql string
 * for <code>datetime - interval</code> operations
 */
public  class DatetimeSub extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.RuntimeReplaceable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression start ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression interval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   DatetimeSub (org.apache.spark.sql.catalyst.expressions.Expression start, org.apache.spark.sql.catalyst.expressions.Expression interval, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String mkString (scala.collection.Seq<java.lang.String> childrenString)  { throw new RuntimeException(); }
}
