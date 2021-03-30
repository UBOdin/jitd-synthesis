package org.apache.spark.sql.catalyst.expressions;
public  class DivideInterval extends org.apache.spark.sql.catalyst.expressions.IntervalNumOperation implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression interval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression num ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   DivideInterval (org.apache.spark.sql.catalyst.expressions.Expression interval, org.apache.spark.sql.catalyst.expressions.Expression num, boolean failOnError)  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.unsafe.types.CalendarInterval, java.lang.Object, org.apache.spark.unsafe.types.CalendarInterval> operation ()  { throw new RuntimeException(); }
  protected  java.lang.String operationName ()  { throw new RuntimeException(); }
}
