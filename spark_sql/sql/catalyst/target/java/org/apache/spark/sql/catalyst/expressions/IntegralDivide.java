package org.apache.spark.sql.catalyst.expressions;
public  class IntegralDivide extends org.apache.spark.sql.catalyst.expressions.BinaryArithmetic implements org.apache.spark.sql.catalyst.expressions.DivModLike, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   IntegralDivide (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right, boolean failOnError)  { throw new RuntimeException(); }
  public   IntegralDivide (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String symbol ()  { throw new RuntimeException(); }
  public  java.lang.String decimalMethod ()  { throw new RuntimeException(); }
  public  java.lang.String decimalToDataTypeCodeGen (java.lang.String decimalResult)  { throw new RuntimeException(); }
  public  java.lang.String sqlOperator ()  { throw new RuntimeException(); }
  public  Object evalOperation (Object left, Object right)  { throw new RuntimeException(); }
}
