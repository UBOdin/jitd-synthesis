package org.apache.spark.sql.execution.python;
/**
 * Similar to <code>PythonUDFRunner</code>, but exchange data with Python worker via Arrow stream.
 */
public  class ArrowPythonRunner extends org.apache.spark.api.python.BasePythonRunner<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.vectorized.ColumnarBatch> implements org.apache.spark.sql.execution.python.PythonArrowOutput {
  public   ArrowPythonRunner (scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int evalType, int[][] argOffsets, org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId, scala.collection.immutable.Map<java.lang.String, java.lang.String> conf)  { throw new RuntimeException(); }
  public  int bufferSize ()  { throw new RuntimeException(); }
  protected  org.apache.spark.api.python.BasePythonRunner<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.vectorized.ColumnarBatch>.WriterThread newWriterThread (org.apache.spark.SparkEnv env, java.net.Socket worker, scala.collection.Iterator<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  boolean simplifiedTraceback ()  { throw new RuntimeException(); }
}
