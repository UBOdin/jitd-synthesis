package org.apache.spark.sql.catalyst.expressions;
public  class Subtract extends org.apache.spark.sql.catalyst.expressions.BinaryArithmetic implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   Subtract (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right, boolean failOnError)  { throw new RuntimeException(); }
  public   Subtract (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  java.lang.String symbol ()  { throw new RuntimeException(); }
  public  java.lang.String decimalMethod ()  { throw new RuntimeException(); }
  public  java.lang.String calendarIntervalMethod ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> exactMathMethod ()  { throw new RuntimeException(); }
}
