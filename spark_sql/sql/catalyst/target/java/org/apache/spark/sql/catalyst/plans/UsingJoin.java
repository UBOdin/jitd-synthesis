package org.apache.spark.sql.catalyst.plans;
public  class UsingJoin extends org.apache.spark.sql.catalyst.plans.JoinType implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.JoinType tpe ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> usingColumns ()  { throw new RuntimeException(); }
  // not preceding
  public   UsingJoin (org.apache.spark.sql.catalyst.plans.JoinType tpe, scala.collection.Seq<java.lang.String> usingColumns)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
