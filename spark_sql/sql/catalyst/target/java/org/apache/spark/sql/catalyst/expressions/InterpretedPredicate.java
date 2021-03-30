package org.apache.spark.sql.catalyst.expressions;
public  class InterpretedPredicate extends org.apache.spark.sql.catalyst.expressions.BasePredicate implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression expression ()  { throw new RuntimeException(); }
  // not preceding
  public   InterpretedPredicate (org.apache.spark.sql.catalyst.expressions.Expression expression)  { throw new RuntimeException(); }
  public  boolean eval (org.apache.spark.sql.catalyst.InternalRow r)  { throw new RuntimeException(); }
  public  void initialize (int partitionIndex)  { throw new RuntimeException(); }
}
