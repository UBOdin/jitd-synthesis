package org.apache.spark.sql.catalyst.expressions;
public  class DateAddYMInterval extends org.apache.spark.sql.catalyst.expressions.AddMonthsBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression date ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression interval ()  { throw new RuntimeException(); }
  // not preceding
  public   DateAddYMInterval (org.apache.spark.sql.catalyst.expressions.Expression date, org.apache.spark.sql.catalyst.expressions.Expression interval)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
