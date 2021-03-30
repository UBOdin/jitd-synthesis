package org.apache.spark.sql.execution;
/**
 * An interface for those physical operators that support codegen.
 */
public  interface CodegenSupport {
  /**
   * Check if the node is supposed to produce limit not reached checks.
   * @return (undocumented)
   */
  public  boolean canCheckLimitNotReached ()  ;
  /**
   * Returns arguments for calling method and method definition parameters of the consume function.
   * And also returns the list of <code>ExprCode</code> for the parameters.
   * @param ctx (undocumented)
   * @param attributes (undocumented)
   * @param variables (undocumented)
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple3<scala.collection.Seq<java.lang.String>, scala.collection.Seq<java.lang.String>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode>> constructConsumeParameters (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables, java.lang.String row)  ;
  /**
   * To prevent concatenated function growing too long to be optimized by JIT. We can separate the
   * parent's <code>doConsume</code> codes of a <code>CodegenSupport</code> operator into a function to call.
   * @param ctx (undocumented)
   * @param inputVars (undocumented)
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String constructDoConsumeFunction (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> inputVars, java.lang.String row)  ;
  /**
   * Consume the generated columns or row from current SparkPlan, call its parent's <code>doConsume()</code>.
   * <p>
   * Note that <code>outputVars</code> and <code>row</code> can't both be null.
   * @param ctx (undocumented)
   * @param outputVars (undocumented)
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String consume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> outputVars, java.lang.String row)  ;
  /**
   * Generate the Java source code to process the rows from child SparkPlan. This should only be
   * called from <code>consume</code>.
   * <p>
   * This should be override by subclass to support codegen.
   * <p>
   * Note: The operator should not assume the existence of an outer processing loop,
   *       which it can jump from with "continue;"!
   * <p>
   * For example, filter could generate this:
   *   # code to evaluate the predicate expression, result is isNull1 and value2
   *   if (!isNull1 &amp;&amp; value2) {
   *     # call consume(), which will call parent.doConsume()
   *   }
   * <p>
   * Note: A plan can either consume the rows as UnsafeRow (row), or a list of variables (input).
   *       When consuming as a listing of variables, the code to produce the input is already
   *       generated and <code>CodegenContext.currentVars</code> is already set. When consuming as UnsafeRow,
   *       implementations need to put <code>row.code</code> in the generated code and set
   *       <code>CodegenContext.INPUT_ROW</code> manually. Some plans may need more tweaks as they have
   *       different inputs(join build side, aggregate buffer, etc.), or other special cases.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  ;
  /**
   * Generate the Java source code to process, should be overridden by subclass to support codegen.
   * <p>
   * doProduce() usually generate the framework, for example, aggregation could generate this:
   * <p>
   *   if (!initialized) {
   *     # create a hash map, then build the aggregation hash map
   *     # call child.produce()
   *     initialized = true;
   *   }
   *   while (hashmap.hasNext()) {
   *     row = hashmap.next();
   *     # build the aggregation results
   *     # create variables for results
   *     # call consume(), which will call parent.doConsume()
   *      if (shouldStop()) return;
   *   }
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
  /**
   * Returns source code to evaluate the variables for non-deterministic expressions, and clear the
   * code of evaluated variables, to prevent them to be evaluated twice.
   * @param attributes (undocumented)
   * @param variables (undocumented)
   * @param expressions (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String evaluateNondeterministicVariables (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expressions)  ;
  /**
   * Returns source code to evaluate the variables for required attributes, and clear the code
   * of evaluated variables, to prevent them to be evaluated twice.
   * @param attributes (undocumented)
   * @param variables (undocumented)
   * @param required (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String evaluateRequiredVariables (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables, org.apache.spark.sql.catalyst.expressions.AttributeSet required)  ;
  /**
   * Returns source code to evaluate all the variables, and clear the code of them, to prevent
   * them to be evaluated twice.
   * @param variables (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String evaluateVariables (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables)  ;
  /**
   * Returns all the RDDs of InternalRow which generates the input rows.
   * <p>
   * @note Right now we support up to two RDDs
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  ;
  /**
   * A sequence of checks which evaluate to true if the downstream Limit operators have not received
   * enough records and reached the limit. If current node is a data producing node, it can leverage
   * this information to stop producing data and complete the data flow earlier. Common data
   * producing nodes are leaf nodes like Range and Scan, and blocking nodes like Sort and Aggregate.
   * These checks should be put into the loop condition of the data producing loop.
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> limitNotReachedChecks ()  ;
  /**
   * A helper method to generate the data producing loop condition according to the
   * limit-not-reached checks.
   * @return (undocumented)
   */
  public  java.lang.String limitNotReachedCond ()  ;
  /**
   * Creates a metric using the specified name.
   * <p>
   * @return name of the variable representing the metric
   * @param ctx (undocumented)
   * @param name (undocumented)
   */
  public  java.lang.String metricTerm (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String name)  ;
  /**
   * Whether or not the result rows of this operator should be copied before putting into a buffer.
   * <p>
   * If any operator inside WholeStageCodegen generate multiple rows from a single row (for
   * example, Join), this should be true.
   * <p>
   * If an operator starts a new pipeline, this should be false.
   * @return (undocumented)
   */
  public  boolean needCopyResult ()  ;
  /**
   * Whether or not the children of this operator should generate a stop check when consuming input
   * rows. This is used to suppress shouldStop() in a loop of WholeStageCodegen.
   * <p>
   * This should be false if an operator starts a new pipeline, which means it consumes all rows
   * produced by children but doesn't output row to buffer by calling append(),  so the children
   * don't require shouldStop() in the loop of producing rows.
   * @return (undocumented)
   */
  public  boolean needStopCheck ()  ;
  /**
   * Which SparkPlan is calling produce() of this one. It's itself for the first SparkPlan.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.CodegenSupport parent ()  ;
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode prepareRowVar (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String row, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> colVars)  ;
  /**
   * Returns Java source code to process the rows from input RDD.
   * @param ctx (undocumented)
   * @param parent (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String produce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.execution.CodegenSupport parent)  ;
  /**
   * Helper default should stop check code.
   * @return (undocumented)
   */
  public  java.lang.String shouldStopCheckCode ()  ;
  /**
   * Whether this SparkPlan supports whole stage codegen or not.
   * @return (undocumented)
   */
  public  boolean supportCodegen ()  ;
  /**
   * The subset of inputSet those should be evaluated before this plan.
   * <p>
   * We will use this to insert some code to access those columns that are actually used by current
   * plan before calling doConsume().
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet usedInputs ()  ;
  /** Prefix used in the current operator's variable names. */
  public  java.lang.String variablePrefix ()  ;
}
