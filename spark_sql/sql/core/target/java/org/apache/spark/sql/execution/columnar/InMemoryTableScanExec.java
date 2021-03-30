package org.apache.spark.sql.execution.columnar;
public  class InMemoryTableScanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LeafExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation relation ()  { throw new RuntimeException(); }
  // not preceding
  public   InMemoryTableScanExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, org.apache.spark.sql.execution.columnar.InMemoryRelation relation)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.QueryPlan<?>> innerChildren ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan doCanonicalize ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes ()  { throw new RuntimeException(); }
  /**
   * If true, get data from ColumnVector in ColumnarBatch, which are generally faster.
   * If false, get data from UnsafeRow build from CachedBatch
   * @return (undocumented)
   */
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean enableAccumulatorsForTest ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.util.LongAccumulator readPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.util.LongAccumulator readBatches ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
}
