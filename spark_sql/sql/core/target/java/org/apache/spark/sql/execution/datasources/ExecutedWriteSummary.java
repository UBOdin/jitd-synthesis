package org.apache.spark.sql.execution.datasources;
/**
 * Wrapper class for the metrics of writing data out.
 * <p>
 * param:  updatedPartitions the partitions updated during writing data out. Only valid
 *                          for dynamic partition.
 * param:  stats one <code>WriteTaskStats</code> object for every <code>WriteJobStatsTracker</code> that the job had.
 */
public  class ExecutedWriteSummary implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> updatedPartitions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteTaskStats> stats ()  { throw new RuntimeException(); }
  // not preceding
  public   ExecutedWriteSummary (scala.collection.immutable.Set<java.lang.String> updatedPartitions, scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteTaskStats> stats)  { throw new RuntimeException(); }
}
