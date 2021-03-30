package org.apache.spark.sql.catalyst.expressions;
public  class Nvl2 extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.RuntimeReplaceable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression expr1 ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression expr2 ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression expr3 ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   Nvl2 (org.apache.spark.sql.catalyst.expressions.Expression expr1, org.apache.spark.sql.catalyst.expressions.Expression expr2, org.apache.spark.sql.catalyst.expressions.Expression expr3, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   Nvl2 (org.apache.spark.sql.catalyst.expressions.Expression expr1, org.apache.spark.sql.catalyst.expressions.Expression expr2, org.apache.spark.sql.catalyst.expressions.Expression expr3)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  { throw new RuntimeException(); }
}
