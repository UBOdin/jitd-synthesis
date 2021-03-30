package org.apache.spark.sql.execution.python;
/**
 * A physical plan that evaluates a {@link PythonUDF}, one partition of tuples at a time.
 * <p>
 * Python evaluation works by sending the necessary (projected) input data via a socket to an
 * external Python process, and combine the result from the Python process with the original row.
 * <p>
 * For each row we send to Python, we also put it in a queue first. For each output row from Python,
 * we drain the queue to find the original input row. Note that if the Python process is way too
 * slow, this could lead to the queue growing unbounded and spill into disk when run out of memory.
 * <p>
 * Here is a diagram to show how this works:
 * <p>
 *            Downstream (for parent)
 *             /      \
 *            /     socket  (output of UDF)
 *           /         \
 *        RowQueue    Python
 *           \         /
 *            \     socket  (input of UDF)
 *             \     /
 *          upstream (from child)
 * <p>
 * The rows sent to and received from Python are packed into batches (100 rows) and serialized,
 * there should be always some rows buffered in the socket or Python process, so the pulling from
 * RowQueue ALWAYS happened after pushing into it.
 */
public  interface EvalPythonExec extends org.apache.spark.sql.execution.UnaryExecNode {
  public  scala.Tuple2<org.apache.spark.api.python.ChainedPythonFunctions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> collectFunctions (org.apache.spark.sql.catalyst.expressions.PythonUDF udf)  ;
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> evaluate (scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int[][] argOffsets, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter, org.apache.spark.sql.types.StructType schema, org.apache.spark.TaskContext context)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs ()  ;
}
