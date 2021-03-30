package org.apache.spark.sql.execution.datasources.jdbc;
/**
 * Data corresponding to one partition of a JDBCRDD.
 */
public  class JDBCPartition implements org.apache.spark.Partition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String whereClause ()  { throw new RuntimeException(); }
  public  int idx ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCPartition (java.lang.String whereClause, int idx)  { throw new RuntimeException(); }
  public  int index ()  { throw new RuntimeException(); }
}
