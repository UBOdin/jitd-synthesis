package org.apache.spark.sql.connector.expressions;
 final class LiteralValue<T extends java.lang.Object> implements org.apache.spark.sql.connector.expressions.Literal<T>, scala.Product, scala.Serializable {
  public  T value ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   LiteralValue (T value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
