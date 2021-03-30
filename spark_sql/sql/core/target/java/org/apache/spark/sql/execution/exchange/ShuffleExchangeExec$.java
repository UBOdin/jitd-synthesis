package org.apache.spark.sql.execution.exchange;
public  class ShuffleExchangeExec$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ShuffleExchangeExec$ MODULE$ = null;
  public   ShuffleExchangeExec$ ()  { throw new RuntimeException(); }
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
  public  org.apache.spark.ShuffleDependency<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> prepareShuffleDependency (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> rdd, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputAttributes, org.apache.spark.sql.catalyst.plans.physical.Partitioning newPartitioning, org.apache.spark.serializer.Serializer serializer, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> writeMetrics)  { throw new RuntimeException(); }
  /**
   * Create a customized {@link ShuffleWriteProcessor} for SQL which wrap the default metrics reporter
   * with {@link SQLShuffleWriteMetricsReporter} as new reporter for {@link ShuffleWriteProcessor}.
   * @param metrics (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.shuffle.ShuffleWriteProcessor createShuffleWriteProcessor (scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics)  { throw new RuntimeException(); }
}
