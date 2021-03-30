package org.apache.spark.sql.execution;
/**
 * Provides a common executor to translate an {@link RDD} of {@link InternalRow} into an {@link RDD} of
 * {@link ColumnarBatch}. This is inserted whenever such a transition is determined to be needed.
 * <p>
 * This is similar to some of the code in ArrowConverters.scala and
 * {@link org.apache.spark.sql.execution.arrow.ArrowWriter}. That code is more specialized
 * to convert {@link InternalRow} to Arrow formatted data, but in the future if we make
 * {@link OffHeapColumnVector} internally Arrow formatted we may be able to replace much of that code.
 * <p>
 * This is also similar to
 * {@link org.apache.spark.sql.execution.vectorized.ColumnVectorUtils.populate()} and
 * {@link org.apache.spark.sql.execution.vectorized.ColumnVectorUtils.toBatch()} toBatch is only ever
 * called from tests and can probably be removed, but populate is used by both Orc and Parquet
 * to initialize partition and missing columns. There is some chance that we could replace
 * populate with {@link RowToColumnConverter}, but the performance requirements are different and it
 * would only be to reduce code.
 */
public  class RowToColumnarExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.RowToColumnarTransition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   RowToColumnarExec (org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> doExecuteBroadcast ()  { throw new RuntimeException(); }
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
}
