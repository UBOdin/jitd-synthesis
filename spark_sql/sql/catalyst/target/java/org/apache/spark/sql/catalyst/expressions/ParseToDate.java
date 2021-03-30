package org.apache.spark.sql.catalyst.expressions;
/**
 * Parses a column to a date based on the given format.
 */
public  class ParseToDate extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.RuntimeReplaceable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> format ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   ParseToDate (org.apache.spark.sql.catalyst.expressions.Expression left, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> format, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   ParseToDate (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression format)  { throw new RuntimeException(); }
  public   ParseToDate (org.apache.spark.sql.catalyst.expressions.Expression left)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
