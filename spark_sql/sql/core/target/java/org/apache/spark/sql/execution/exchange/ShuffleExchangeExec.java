package org.apache.spark.sql.execution.exchange;
/**
 * Performs a shuffle that will result in the desired partitioning.
 */
public  class ShuffleExchangeExec extends org.apache.spark.sql.execution.exchange.Exchange implements org.apache.spark.sql.execution.exchange.ShuffleExchangeLike, scala.Product, scala.Serializable {
  /**
   * Returns a {@link ShuffleDependency} that will partition rows of its child based on
   * the partitioning scheme defined in <code>newPartitioning</code>. Those partitions of
   * the returned ShuffleDependency will be the input of shuffle.
   * @param rdd (undocumented)
   * @param outputAttributes (undocumented)
   * @param newPartitioning (undocumented)
   * @param serializer (undocumented)
   * @param writeMetrics (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.ShuffleDependency<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> prepareShuffleDependency (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> rdd, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputAttributes, org.apache.spark.sql.catalyst.plans.physical.Partitioning newPartitioning, org.apache.spark.serializer.Serializer serializer, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> writeMetrics)  { throw new RuntimeException(); }
  /**
   * Create a customized {@link ShuffleWriteProcessor} for SQL which wrap the default metrics reporter
   * with {@link SQLShuffleWriteMetricsReporter} as new reporter for {@link ShuffleWriteProcessor}.
   * @param metrics (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.shuffle.ShuffleWriteProcessor createShuffleWriteProcessor (scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.exchange.ShuffleOrigin shuffleOrigin ()  { throw new RuntimeException(); }
  // not preceding
  public   ShuffleExchangeExec (org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning, org.apache.spark.sql.execution.SparkPlan child, org.apache.spark.sql.execution.exchange.ShuffleOrigin shuffleOrigin)  { throw new RuntimeException(); }
  // not preceding
    scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> readMetrics ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.concurrent.Future<org.apache.spark.MapOutputStatistics> mapOutputStatisticsFuture ()  { throw new RuntimeException(); }
  public  int numMappers ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> getShuffleRDD (org.apache.spark.sql.execution.ShufflePartitionSpec[] partitionSpecs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics runtimeStatistics ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.ShuffleDependency<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> shuffleDependency ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
