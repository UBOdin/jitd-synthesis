package org.apache.spark.sql.catalyst.plans.logical;
public  class Assignment extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression key ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression value ()  { throw new RuntimeException(); }
  // not preceding
  public   Assignment (org.apache.spark.sql.catalyst.expressions.Expression key, org.apache.spark.sql.catalyst.expressions.Expression value)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
}
