package org.apache.spark.sql.connector.distributions;
 final class ClusteredDistributionImpl implements org.apache.spark.sql.connector.distributions.ClusteredDistribution, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Expression> clusteringExprs ()  { throw new RuntimeException(); }
  // not preceding
  public   ClusteredDistributionImpl (scala.collection.Seq<org.apache.spark.sql.connector.expressions.Expression> clusteringExprs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Expression[] clustering ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
