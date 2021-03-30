package org.apache.spark.sql.catalyst.analysis;
public  class ResolvedPartitionSpec extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.analysis.PartitionSpec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> names ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow ident ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> location ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolvedPartitionSpec (scala.collection.Seq<java.lang.String> names, org.apache.spark.sql.catalyst.InternalRow ident, scala.Option<java.lang.String> location)  { throw new RuntimeException(); }
}
