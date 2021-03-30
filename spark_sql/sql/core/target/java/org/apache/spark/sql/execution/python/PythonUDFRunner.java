package org.apache.spark.sql.execution.python;
/**
 * A helper class to run Python UDFs in Spark.
 */
public  class PythonUDFRunner extends org.apache.spark.api.python.BasePythonRunner<byte[], byte[]> {
  static public  void writeUDFs (java.io.DataOutputStream dataOut, scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int[][] argOffsets)  { throw new RuntimeException(); }
  public   PythonUDFRunner (scala.collection.Seq<org.apache.spark.api.python.ChainedPythonFunctions> funcs, int evalType, int[][] argOffsets)  { throw new RuntimeException(); }
  public  boolean simplifiedTraceback ()  { throw new RuntimeException(); }
  protected  org.apache.spark.api.python.BasePythonRunner<byte[], byte[]>.WriterThread newWriterThread (org.apache.spark.SparkEnv env, java.net.Socket worker, scala.collection.Iterator<byte[]> inputIterator, int partitionIndex, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<byte[]> newReaderIterator (java.io.DataInputStream stream, org.apache.spark.api.python.BasePythonRunner<byte[], byte[]>.WriterThread writerThread, long startTime, org.apache.spark.SparkEnv env, java.net.Socket worker, java.util.concurrent.atomic.AtomicBoolean releasedOrClosed, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
}
