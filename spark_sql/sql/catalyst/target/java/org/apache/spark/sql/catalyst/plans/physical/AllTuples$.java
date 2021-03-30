package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a distribution that only has a single partition and all tuples of the dataset
 * are co-located.
 */
public  class AllTuples$ implements org.apache.spark.sql.catalyst.plans.physical.Distribution, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AllTuples$ MODULE$ = null;
  public   AllTuples$ ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> requiredNumPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  { throw new RuntimeException(); }
}
