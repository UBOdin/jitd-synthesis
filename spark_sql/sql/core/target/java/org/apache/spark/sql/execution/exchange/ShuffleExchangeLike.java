package org.apache.spark.sql.execution.exchange;
/**
 * Common trait for all shuffle exchange implementations to facilitate pattern matching.
 */
public  interface ShuffleExchangeLike {
  /**
   * Returns the shuffle RDD with specified partition specs.
   * @param partitionSpecs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.rdd.RDD<?> getShuffleRDD (org.apache.spark.sql.execution.ShufflePartitionSpec[] partitionSpecs)  ;
  /**
   * The asynchronous job that materializes the shuffle.
   * @return (undocumented)
   */
  public  scala.concurrent.Future<org.apache.spark.MapOutputStatistics> mapOutputStatisticsFuture ()  ;
  /**
   * Returns the number of mappers of this shuffle.
   * @return (undocumented)
   */
  public  int numMappers ()  ;
  /**
   * Returns the shuffle partition number.
   * @return (undocumented)
   */
  public  int numPartitions ()  ;
  /**
   * Returns the runtime statistics after shuffle materialization.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics runtimeStatistics ()  ;
  /**
   * The origin of this shuffle operator.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.exchange.ShuffleOrigin shuffleOrigin ()  ;
}
