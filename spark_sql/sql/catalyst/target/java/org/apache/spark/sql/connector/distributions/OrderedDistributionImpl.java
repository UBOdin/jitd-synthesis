package org.apache.spark.sql.connector.distributions;
 final class OrderedDistributionImpl implements org.apache.spark.sql.connector.distributions.OrderedDistribution, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.SortOrder> orderingExprs ()  { throw new RuntimeException(); }
  // not preceding
  public   OrderedDistributionImpl (scala.collection.Seq<org.apache.spark.sql.connector.expressions.SortOrder> orderingExprs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.SortOrder[] ordering ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
