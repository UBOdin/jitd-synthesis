package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Describes how an operator's output is split across partitions. It has 2 major properties:
 *   1. number of partitions.
 *   2. if it can satisfy a given distribution.
 */
public  interface Partitioning {
  /** Returns the number of partitions that the data is split across */
  public  int numPartitions ()  ;
  /**
   * Returns true iff the guarantees made by this {@link Partitioning} are sufficient
   * to satisfy the partitioning scheme mandated by the <code>required</code> {@link Distribution},
   * i.e. the current dataset does not need to be re-partitioned for the <code>required</code>
   * Distribution (it is possible that tuples within a partition need to be reorganized).
   * <p>
   * A {@link Partitioning} can never satisfy a {@link Distribution} if its <code>numPartitions</code> doesn't match
   * {@link Distribution.requiredNumPartitions}.
   * @param required (undocumented)
   * @return (undocumented)
   */
  public  boolean satisfies (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  ;
  /**
   * The actual method that defines whether this {@link Partitioning} can satisfy the given
   * {@link Distribution}, after the <code>numPartitions</code> check.
   * <p>
   * By default a {@link Partitioning} can satisfy {@link UnspecifiedDistribution}, and {@link AllTuples} if
   * the {@link Partitioning} only have one partition. Implementations can also overwrite this method
   * with special logic.
   * @param required (undocumented)
   * @return (undocumented)
   */
  public  boolean satisfies0 (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  ;
}
