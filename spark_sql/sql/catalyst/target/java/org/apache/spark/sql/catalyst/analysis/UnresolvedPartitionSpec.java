package org.apache.spark.sql.catalyst.analysis;
public  class UnresolvedPartitionSpec extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.analysis.PartitionSpec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> spec ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> location ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedPartitionSpec (scala.collection.immutable.Map<java.lang.String, java.lang.String> spec, scala.Option<java.lang.String> location)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
