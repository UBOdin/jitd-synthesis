package org.apache.spark.sql.execution.datasources.jdbc;
/**
 * Instructions on how to partition the table among workers.
 */
  class JDBCPartitioningInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String column ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType columnType ()  { throw new RuntimeException(); }
  public  long lowerBound ()  { throw new RuntimeException(); }
  public  long upperBound ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCPartitioningInfo (java.lang.String column, org.apache.spark.sql.types.DataType columnType, long lowerBound, long upperBound, int numPartitions)  { throw new RuntimeException(); }
}
