package org.apache.spark.sql.connector.distributions;
public  class LogicalDistributions {
  static public  org.apache.spark.sql.connector.distributions.UnspecifiedDistribution unspecified ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.distributions.ClusteredDistribution clustered (org.apache.spark.sql.connector.expressions.Expression[] clustering)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.distributions.OrderedDistribution ordered (org.apache.spark.sql.connector.expressions.SortOrder[] ordering)  { throw new RuntimeException(); }
}
