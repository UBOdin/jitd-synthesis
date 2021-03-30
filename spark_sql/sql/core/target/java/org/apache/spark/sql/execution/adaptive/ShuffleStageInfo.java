package org.apache.spark.sql.execution.adaptive;
public  class ShuffleStageInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.ShuffleQueryStageExec shuffleStage ()  { throw new RuntimeException(); }
  public  org.apache.spark.MapOutputStatistics mapStats ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.execution.CoalescedPartitionSpec, java.lang.Object>> partitionsWithSizes ()  { throw new RuntimeException(); }
  // not preceding
  public   ShuffleStageInfo (org.apache.spark.sql.execution.adaptive.ShuffleQueryStageExec shuffleStage, org.apache.spark.MapOutputStatistics mapStats, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.execution.CoalescedPartitionSpec, java.lang.Object>> partitionsWithSizes)  { throw new RuntimeException(); }
}
