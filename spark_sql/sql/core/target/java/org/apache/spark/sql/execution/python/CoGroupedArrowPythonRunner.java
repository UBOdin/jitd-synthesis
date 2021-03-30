package org.apache.spark.sql.execution.python;
/**
 * Python UDF Runner for cogrouped udfs. It sends Arrow bathes from two different DataFrames,
 * groups them in Python, and receive it back in JVM as batches of single DataFrame.
 */
public  class CoGroupedArrowPythonRunner extends org.apache.spark.api.python.BasePythonRunner<scala.Tuple2<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>, org.apache.spark.sql.vectorized.ColumnarBatch> implements org.apache.spark.sql.execution.python.PythonArrowOutput {
  public   CoGroupedArrowPythonRunner (scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int evalType, int[][] argOffsets, org.apache.spark.sql.types.StructType leftSchema, org.apache.spark.sql.types.StructType rightSchema, java.lang.String timeZoneId, scala.collection.immutable.Map<java.lang.String, java.lang.String> conf)  { throw new RuntimeException(); }
  protected  org.apache.spark.api.python.BasePythonRunner<scala.Tuple2<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>, org.apache.spark.sql.vectorized.ColumnarBatch>.WriterThread newWriterThread (org.apache.spark.SparkEnv env, java.net.Socket worker, scala.collection.Iterator<scala.Tuple2<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  boolean simplifiedTraceback ()  { throw new RuntimeException(); }
}
