package org.apache.spark.sql.catalyst.expressions;
public  class WindowExpression extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression windowFunction ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.WindowSpecDefinition windowSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   WindowExpression (org.apache.spark.sql.catalyst.expressions.Expression windowFunction, org.apache.spark.sql.catalyst.expressions.WindowSpecDefinition windowSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
