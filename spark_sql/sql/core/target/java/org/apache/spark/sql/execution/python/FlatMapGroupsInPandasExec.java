package org.apache.spark.sql.execution.python;
/**
 * Physical node for {@link org.apache.spark.sql.catalyst.plans.logical.FlatMapGroupsInPandas}
 * <p>
 * Rows in each group are passed to the Python worker as an Arrow record batch.
 * The Python worker turns the record batch to a <code>pandas.DataFrame</code>, invoke the
 * user-defined function, and passes the resulting <code>pandas.DataFrame</code>
 * as an Arrow record batch. Finally, each record batch is turned to
 * Iterator[InternalRow] using ColumnarBatch.
 * <p>
 * Note on memory usage:
 * Both the Python worker and the Java executor need to have enough memory to
 * hold the largest group. The memory on the Java side is used to construct the
 * record batch (off heap memory). The memory on the Python side is used for
 * holding the <code>pandas.DataFrame</code>. It's possible to further split one group into
 * multiple record batches to reduce the memory footprint on the Java side, this
 * is left as future work.
 */
public  class FlatMapGroupsInPandasExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression func ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   FlatMapGroupsInPandasExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, org.apache.spark.sql.catalyst.expressions.Expression func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
