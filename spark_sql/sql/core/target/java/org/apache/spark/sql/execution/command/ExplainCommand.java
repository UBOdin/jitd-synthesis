package org.apache.spark.sql.execution.command;
/**
 * An explain command for users to see how a command will be executed.
 * <p>
 * Note that this command takes in a logical plan, runs the optimizer on the logical plan
 * (but do NOT actually execute it).
 * <p>
 * <pre><code>
 *   EXPLAIN (EXTENDED | CODEGEN | COST | FORMATTED) SELECT * FROM ...
 * </code></pre>
 * <p>
 * param:  logicalPlan plan to explain
 * param:  mode explain mode
 */
public  class ExplainCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ExplainMode mode ()  { throw new RuntimeException(); }
  // not preceding
  public   ExplainCommand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.execution.ExplainMode mode)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
