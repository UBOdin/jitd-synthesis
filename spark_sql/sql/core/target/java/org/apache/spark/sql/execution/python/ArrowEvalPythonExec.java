package org.apache.spark.sql.execution.python;
/**
 * A physical plan that evaluates a {@link PythonUDF}.
 */
public  class ArrowEvalPythonExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.python.EvalPythonExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  int evalType ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrowEvalPythonExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs, org.apache.spark.sql.execution.SparkPlan child, int evalType)  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> evaluate (scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int[][] argOffsets, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter, org.apache.spark.sql.types.StructType schema, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
}
