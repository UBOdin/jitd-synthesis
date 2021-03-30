package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Specifies how tuples that share common expressions will be distributed when a query is executed
 * in parallel on many machines.
 * <p>
 * Distribution here refers to inter-node partitioning of data. That is, it describes how tuples
 * are partitioned across physical machines in a cluster. Knowing this property allows some
 * operators (e.g., Aggregate) to perform partition local operations instead of global ones.
 */
public  interface Distribution {
  /**
   * Creates a default partitioning for this distribution, which can satisfy this distribution while
   * matching the given number of partitions.
   * @param numPartitions (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  ;
  /**
   * The required number of partitions for this distribution. If it's None, then any number of
   * partitions is allowed for this distribution.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> requiredNumPartitions ()  ;
}
