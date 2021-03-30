package org.apache.spark.sql.execution;
/**
 * The base class for physical operators.
 * <p>
 * The naming convention is that physical operators end with "Exec" suffix, e.g. {@link ProjectExec}.
 */
public abstract class SparkPlan extends org.apache.spark.sql.catalyst.plans.QueryPlan<org.apache.spark.sql.execution.SparkPlan> implements org.apache.spark.internal.Logging, scala.Serializable {
  /** The original {@link LogicalPlan} from which this {@link SparkPlan} is converted. */
  static public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> LOGICAL_PLAN_TAG ()  { throw new RuntimeException(); }
  /** The {@link LogicalPlan} inherited from its ancestor. */
  static public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> LOGICAL_PLAN_INHERITED_TAG ()  { throw new RuntimeException(); }
  /** Register a new SparkPlan, returning its SparkPlan ID */
  static   int newPlanId ()  { throw new RuntimeException(); }
  public   SparkPlan ()  { throw new RuntimeException(); }
  /**
   * A handle to the SQL Context that was used to create this plan. Since many operators need
   * access to the sqlContext for RDD operations or configuration this field is automatically
   * populated by the query planning infrastructure.
   * @return (undocumented)
   */
  public final  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  protected  org.apache.spark.SparkContext sparkContext ()  { throw new RuntimeException(); }
  public  int id ()  { throw new RuntimeException(); }
  /**
   * Return true if this stage of the plan supports columnar execution.
   * @return (undocumented)
   */
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
  /**
   * The exact java types of the columns that are output in columnar processing mode. This
   * is a performance optimization for code generation and is optional.
   * @return (undocumented)
   */
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes ()  { throw new RuntimeException(); }
  /** Overridden make copy also propagates sqlContext to copied plan. */
  public  org.apache.spark.sql.execution.SparkPlan makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
  /**
   * @return The logical plan this plan is linked to.
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> logicalLink ()  { throw new RuntimeException(); }
  /**
   * Set logical plan link recursively if unset.
   * @param logicalPlan (undocumented)
   */
  public  void setLogicalLink (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan)  { throw new RuntimeException(); }
  /**
   * @return All metrics containing metrics of this SparkPlan.
   */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  /**
   * Resets all the metrics.
   */
  public  void resetMetrics ()  { throw new RuntimeException(); }
  /**
   * @return {@link SQLMetric} for the <code>name</code>.
   * @param name (undocumented)
   */
  public  org.apache.spark.sql.execution.metric.SQLMetric longMetric (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Specifies how data is partitioned across different nodes in the cluster.
   * Note this method may fail if it is invoked before <code>EnsureRequirements</code> is applied
   * since <code>PartitioningCollection</code> requires all its partitionings to have
   * the same number of partitions.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  /**
   * Specifies the data distribution requirements of all the children for this operator. By default
   * it's {@link UnspecifiedDistribution} for each child, which means each child can have any
   * distribution.
   * <p>
   * If an operator overwrites this method, and specifies distribution requirements(excluding
   * {@link UnspecifiedDistribution} and {@link BroadcastDistribution}) for more than one child, Spark
   * guarantees that the outputs of these children will have same number of partitions, so that the
   * operator can safely zip partitions of these children's result RDDs. Some operators can leverage
   * this guarantee to satisfy some interesting requirement, e.g., non-broadcast joins can specify
   * HashClusteredDistribution(a,b) for its left child, and specify HashClusteredDistribution(c,d)
   * for its right child, then it's guaranteed that left and right child are co-partitioned by
   * a,b/c,d, which means tuples of same value are in the partitions of same index, e.g.,
   * (a=1,b=2) and (c=1,d=2) are both in the second partition of left and right child.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  /** Specifies how data is ordered in each partition. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  /** Specifies sort order for each partition requirements on the input data for this operator. */
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  /**
   * Returns the result of this query as an RDD[InternalRow] by delegating to <code>doExecute</code> after
   * preparations.
   * <p>
   * Concrete implementations of SparkPlan should override <code>doExecute</code>.
   * @return (undocumented)
   */
  public final  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> execute ()  { throw new RuntimeException(); }
  /**
   * Returns the result of this query as a broadcast variable by delegating to <code>doExecuteBroadcast</code>
   * after preparations.
   * <p>
   * Concrete implementations of SparkPlan should override <code>doExecuteBroadcast</code>.
   * @return (undocumented)
   */
  public final <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> executeBroadcast ()  { throw new RuntimeException(); }
  /**
   * Returns the result of this query as an RDD[ColumnarBatch] by delegating to <code>doColumnarExecute</code>
   * after preparations.
   * <p>
   * Concrete implementations of SparkPlan should override <code>doColumnarExecute</code> if <code>supportsColumnar</code>
   * returns true.
   * @return (undocumented)
   */
  public final  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> executeColumnar ()  { throw new RuntimeException(); }
  /**
   * Executes a query after preparing the query and adding query plan information to created RDDs
   * for visualization.
   * @param query (undocumented)
   * @return (undocumented)
   */
  protected final <T extends java.lang.Object> T executeQuery (scala.Function0<T> query)  { throw new RuntimeException(); }
  /**
   * Finds scalar subquery expressions in this plan node and starts evaluating them.
   */
  protected  void prepareSubqueries ()  { throw new RuntimeException(); }
  /**
   * Blocks the thread until all subqueries finish evaluation and update the results.
   */
  protected  void waitForSubqueries ()  { throw new RuntimeException(); }
  /**
   * Prepares this SparkPlan for execution. It's idempotent.
   */
  public final  void prepare ()  { throw new RuntimeException(); }
  /**
   * Overridden by concrete implementations of SparkPlan. It is guaranteed to run before any
   * <code>execute</code> of SparkPlan. This is helpful if we want to set up some state before executing the
   * query, e.g., <code>BroadcastHashJoin</code> uses it to broadcast asynchronously.
   * <p>
   * @note <code>prepare</code> method has already walked down the tree, so the implementation doesn't have
   * to call children's <code>prepare</code> methods.
   * <p>
   * This will only be called once, protected by <code>this</code>.
   */
  protected  void doPrepare ()  { throw new RuntimeException(); }
  /**
   * Produces the result of the query as an <code>RDD[InternalRow]</code>
   * <p>
   * Overridden by concrete implementations of SparkPlan.
   * @return (undocumented)
   */
  protected abstract  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  ;
  /**
   * Produces the result of the query as a broadcast variable.
   * <p>
   * Overridden by concrete implementations of SparkPlan.
   * @return (undocumented)
   */
  protected <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> doExecuteBroadcast ()  { throw new RuntimeException(); }
  /**
   * Produces the result of the query as an <code>RDD[ColumnarBatch]</code> if {@link supportsColumnar} returns
   * true. By convention the executor that creates a ColumnarBatch is responsible for closing it
   * when it is no longer needed. This allows input formats to be able to reuse batches if needed.
   * @return (undocumented)
   */
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
  /**
   * Runs this query returning the result as an array.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
    scala.Tuple2<java.lang.Object, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> executeCollectIterator ()  { throw new RuntimeException(); }
  /**
   * Runs this query returning the result as an iterator of InternalRow.
   * <p>
   * @note Triggers multiple jobs (one for each partition).
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> executeToIterator ()  { throw new RuntimeException(); }
  /**
   * Runs this query returning the result as an array, using external Row format.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Row[] executeCollectPublic ()  { throw new RuntimeException(); }
  /**
   * Runs this query returning the first <code>n</code> rows as an array.
   * <p>
   * This is modeled after <code>RDD.take</code> but never runs any job locally on the driver.
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTake (int n)  { throw new RuntimeException(); }
  /**
   * Runs this query returning the last <code>n</code> rows as an array.
   * <p>
   * This is modeled after <code>RDD.take</code> but never runs any job locally on the driver.
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTail (int n)  { throw new RuntimeException(); }
  /**
   * Cleans up the resources used by the physical operator (if any). In general, all the resources
   * should be cleaned up when the task finishes but operators like SortMergeJoinExec and LimitExec
   * may want eager cleanup to free up tight resources (e.g., memory).
   */
  protected  void cleanupResources ()  { throw new RuntimeException(); }
}
