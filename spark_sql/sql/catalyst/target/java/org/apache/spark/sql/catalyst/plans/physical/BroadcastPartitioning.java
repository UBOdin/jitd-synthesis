package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a partitioning where rows are collected, transformed and broadcasted to each
 * node in the cluster.
 */
public  class BroadcastPartitioning implements org.apache.spark.sql.catalyst.plans.physical.Partitioning, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.BroadcastMode mode ()  { throw new RuntimeException(); }
  // not preceding
  public   BroadcastPartitioning (org.apache.spark.sql.catalyst.plans.physical.BroadcastMode mode)  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  public  boolean satisfies0 (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  { throw new RuntimeException(); }
}
