package org.apache.spark.sql.catalyst.plans.physical;
public  class UnknownPartitioning implements org.apache.spark.sql.catalyst.plans.physical.Partitioning, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   UnknownPartitioning (int numPartitions)  { throw new RuntimeException(); }
}
