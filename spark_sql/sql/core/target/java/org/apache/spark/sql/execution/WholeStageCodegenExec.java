package org.apache.spark.sql.execution;
public  class WholeStageCodegenExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.CodegenSupport, scala.Product, scala.Serializable {
  static public  java.lang.String PIPELINE_DURATION_METRIC ()  { throw new RuntimeException(); }
  static public  boolean isTooManyFields (org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  void increaseCodeGenTime (long time)  { throw new RuntimeException(); }
  static public  long codeGenTime ()  { throw new RuntimeException(); }
  static public  void resetCodeGenTime ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  int codegenStageId ()  { throw new RuntimeException(); }
  // not preceding
  public   WholeStageCodegenExec (org.apache.spark.sql.execution.SparkPlan child, int codegenStageId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  java.lang.String generatedClassName ()  { throw new RuntimeException(); }
  /**
   * Generates code for this subtree.
   * <p>
   * @return the tuple of the codegen context and the actual generated source.
   */
  public  scala.Tuple2<org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext, org.apache.spark.sql.catalyst.expressions.codegen.CodeAndComment> doCodeGen ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  public  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  { throw new RuntimeException(); }
  public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  public  boolean needStopCheck ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> limitNotReachedChecks ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
}
