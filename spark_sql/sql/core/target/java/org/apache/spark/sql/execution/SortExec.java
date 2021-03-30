package org.apache.spark.sql.execution;
/**
 * Performs (external) sorting.
 * <p>
 * param:  global when true performs a global sort of all partitions by shuffling the data first
 *               if necessary.
 * param:  testSpillFrequency Method for configuring periodic spilling in unit tests. If set, will
 *                           spill every <code>frequency</code> records.
 */
public  class SortExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.BlockingOperatorWithCodegen, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> sortOrder ()  { throw new RuntimeException(); }
  public  boolean global ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  int testSpillFrequency ()  { throw new RuntimeException(); }
  // not preceding
  public   SortExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> sortOrder, boolean global, org.apache.spark.sql.execution.SparkPlan child, int testSpillFrequency)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
    org.apache.spark.sql.execution.UnsafeExternalRowSorter rowSorter ()  { throw new RuntimeException(); }
  /**
   * This method gets invoked only once for each SortExec instance to initialize an
   * UnsafeExternalRowSorter, both <code>plan.execute</code> and code generation are using it.
   * In the code generation code path, we need to call this function outside the class so we
   * should make it public.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.UnsafeExternalRowSorter createSorter ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet usedInputs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  protected  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  { throw new RuntimeException(); }
  /**
   * In SortExec, we overwrites cleanupResources to close UnsafeExternalRowSorter.
   */
  protected  void cleanupResources ()  { throw new RuntimeException(); }
}
