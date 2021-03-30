package org.apache.spark.sql.hive;
public  class HiveUDAFBuffer implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buf ()  { throw new RuntimeException(); }
  public  boolean canDoMerge ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveUDAFBuffer (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buf, boolean canDoMerge)  { throw new RuntimeException(); }
}
