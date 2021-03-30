package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a distribution where no promises are made about co-location of data.
 */
public  class UnspecifiedDistribution$ implements org.apache.spark.sql.catalyst.plans.physical.Distribution, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UnspecifiedDistribution$ MODULE$ = null;
  public   UnspecifiedDistribution$ ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> requiredNumPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  { throw new RuntimeException(); }
}
