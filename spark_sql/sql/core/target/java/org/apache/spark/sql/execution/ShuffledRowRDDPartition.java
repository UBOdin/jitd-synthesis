package org.apache.spark.sql.execution;
/**
 * The {@link Partition} used by {@link ShuffledRowRDD}.
 */
public final class ShuffledRowRDDPartition implements org.apache.spark.Partition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int index ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ShufflePartitionSpec spec ()  { throw new RuntimeException(); }
  // not preceding
  public   ShuffledRowRDDPartition (int index, org.apache.spark.sql.execution.ShufflePartitionSpec spec)  { throw new RuntimeException(); }
}
