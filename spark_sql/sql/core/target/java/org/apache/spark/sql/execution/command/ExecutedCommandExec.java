package org.apache.spark.sql.execution.command;
/**
 * A physical operator that executes the run method of a <code>RunnableCommand</code> and
 * saves the result to prevent multiple executions.
 * <p>
 * param:  cmd the <code>RunnableCommand</code> this operator will run.
 */
public  class ExecutedCommandExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LeafExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.command.RunnableCommand cmd ()  { throw new RuntimeException(); }
  // not preceding
  public   ExecutedCommandExec (org.apache.spark.sql.execution.command.RunnableCommand cmd)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> sideEffectResult ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.QueryPlan<?>> innerChildren ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> executeToIterator ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTake (int limit)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTail (int limit)  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
