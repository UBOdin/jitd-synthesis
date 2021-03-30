package org.apache.spark.sql.execution.adaptive;
/**
 * A query stage is an independent subgraph of the query plan. Query stage materializes its output
 * before proceeding with further operators of the query plan. The data statistics of the
 * materialized output can be used to optimize subsequent query stages.
 * <p>
 * There are 2 kinds of query stages:
 *   1. Shuffle query stage. This stage materializes its output to shuffle files, and Spark launches
 *      another job to execute the further operators.
 *   2. Broadcast query stage. This stage materializes its output to an array in driver JVM. Spark
 *      broadcasts the array before executing the further operators.
 */
public abstract class QueryStageExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LeafExecNode {
  public   QueryStageExec ()  { throw new RuntimeException(); }
  /**
   * The canonicalized plan before applying query stage optimizer rules.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.execution.SparkPlan _canonicalized ()  ;
  protected  java.util.concurrent.atomic.AtomicReference<scala.Option<java.lang.Object>> _resultOption ()  { throw new RuntimeException(); }
  /**
   * Cancel the stage materialization if in progress; otherwise do nothing.
   */
  public abstract  void cancel ()  ;
  /**
   * Compute the statistics of the query stage if executed, otherwise None.
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan doCanonicalize ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> doExecuteBroadcast ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
  /**
   * Materialize this query stage, to prepare for the execution, like submitting map stages,
   * broadcasting data, etc. The caller side can use the returned {@link Future} to wait until this
   * stage is ready.
   * @return (undocumented)
   */
  public abstract  scala.concurrent.Future<java.lang.Object> doMaterialize ()  ;
  protected  void doPrepare ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTail (int n)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTake (int n)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> executeToIterator ()  { throw new RuntimeException(); }
  public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  /**
   * Returns the runtime statistics after stage materialization.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalyst.plans.logical.Statistics getRuntimeStatistics ()  ;
  /**
   * An id of this query stage which is unique in the entire query plan.
   * @return (undocumented)
   */
  public abstract  int id ()  ;
  /**
   * Materialize this query stage, to prepare for the execution, like submitting map stages,
   * broadcasting data, etc. The caller side can use the returned {@link Future} to wait until this
   * stage is ready.
   * @return (undocumented)
   */
  public final  scala.concurrent.Future<java.lang.Object> materialize ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.execution.adaptive.QueryStageExec newReuseInstance (int newStageId, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> newOutput)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  /**
   * The sub-tree of the query plan that belongs to this query stage.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.execution.SparkPlan plan ()  ;
    java.util.concurrent.atomic.AtomicReference<scala.Option<java.lang.Object>> resultOption ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
}
