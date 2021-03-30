package org.apache.spark.sql.execution.python;
/**
 * Physical node for {@link org.apache.spark.sql.catalyst.plans.logical.FlatMapCoGroupsInPandas}
 * <p>
 * The input dataframes are first Cogrouped.  Rows from each side of the cogroup are passed to the
 * Python worker via Arrow.  As each side of the cogroup may have a different schema we send every
 * group in its own Arrow stream.
 * The Python worker turns the resulting record batches to <code>pandas.DataFrame</code>s, invokes the
 * user-defined function, and passes the resulting <code>pandas.DataFrame</code>
 * as an Arrow record batch. Finally, each record batch is turned to
 * Iterator[InternalRow] using ColumnarBatch.
 * <p>
 * Note on memory usage:
 * Both the Python worker and the Java executor need to have enough memory to
 * hold the largest cogroup. The memory on the Java side is used to construct the
 * record batches (off heap memory). The memory on the Python side is used for
 * holding the <code>pandas.DataFrame</code>. It's possible to further split one group into
 * multiple record batches to reduce the memory footprint on the Java side, this
 * is left as future work.
 */
public  class FlatMapCoGroupsInPandasExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.BinaryExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftGroup ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightGroup ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression func ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan right ()  { throw new RuntimeException(); }
  // not preceding
  public   FlatMapCoGroupsInPandasExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftGroup, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightGroup, org.apache.spark.sql.catalyst.expressions.Expression func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.execution.SparkPlan left, org.apache.spark.sql.execution.SparkPlan right)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
