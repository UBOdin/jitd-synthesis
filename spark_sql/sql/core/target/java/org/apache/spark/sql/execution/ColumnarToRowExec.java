package org.apache.spark.sql.execution;
/**
 * Provides a common executor to translate an {@link RDD} of {@link ColumnarBatch} into an {@link RDD} of
 * {@link InternalRow}. This is inserted whenever such a transition is determined to be needed.
 * <p>
 * The implementation is based off of similar implementations in
 * {@link org.apache.spark.sql.execution.python.ArrowEvalPythonExec} and
 * {@link MapPartitionsInRWithArrowExec}. Eventually this should replace those implementations.
 */
public  class ColumnarToRowExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.ColumnarToRowTransition, org.apache.spark.sql.execution.CodegenSupport, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   ColumnarToRowExec (org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  protected  boolean canCheckLimitNotReached ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  /**
   * Produce code to process the input iterator as {@link ColumnarBatch}es.
   * This produces an {@link org.apache.spark.sql.catalyst.expressions.UnsafeRow} for each row in
   * each batch.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
}
