package org.apache.spark.sql.catalyst.expressions.aggregate;
public  class MinBy extends org.apache.spark.sql.catalyst.expressions.aggregate.MaxMinBy implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression orderingExpr ()  { throw new RuntimeException(); }
  // not preceding
  public   MinBy (org.apache.spark.sql.catalyst.expressions.Expression valueExpr, org.apache.spark.sql.catalyst.expressions.Expression orderingExpr)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression predicate (org.apache.spark.sql.catalyst.expressions.Expression oldExpr, org.apache.spark.sql.catalyst.expressions.Expression newExpr)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression orderingUpdater (org.apache.spark.sql.catalyst.expressions.Expression oldExpr, org.apache.spark.sql.catalyst.expressions.Expression newExpr)  { throw new RuntimeException(); }
}
