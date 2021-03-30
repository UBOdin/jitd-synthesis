package org.apache.spark.sql.execution;
/**
 * Applies a {@link Generator} to a stream of input rows, combining the
 * output of each into a new stream of rows.  This operation is similar to a <code>flatMap</code> in functional
 * programming with one important additional feature, which allows the input rows to be joined with
 * their output.
 * <p>
 * This operator supports whole stage code generation for generators that do not implement
 * terminate().
 * <p>
 * param:  generator the generator expression
 * param:  requiredChildOutput required attributes from child's output
 * param:  outer when true, each input row will be output at least once, even if the output of the
 *              given <code>generator</code> is empty.
 * param:  generatorOutput the qualified output attributes of the generator of this node, which
 *                        constructed in analysis phase, and we can not change it, as the
 *                        parent node bound with it already.
 */
public  class GenerateExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.CodegenSupport, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Generator generator ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> requiredChildOutput ()  { throw new RuntimeException(); }
  public  boolean outer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> generatorOutput ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   GenerateExec (org.apache.spark.sql.catalyst.expressions.Generator generator, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> requiredChildOutput, boolean outer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> generatorOutput, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Generator boundGenerator ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  boolean supportCodegen ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  protected  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  boolean needCopyResult ()  { throw new RuntimeException(); }
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  { throw new RuntimeException(); }
}
