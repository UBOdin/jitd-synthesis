package org.apache.spark.sql.catalyst.expressions;
public  class Rollup extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.GroupingSet, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs ()  { throw new RuntimeException(); }
  // not preceding
  public   Rollup (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs)  { throw new RuntimeException(); }
}
