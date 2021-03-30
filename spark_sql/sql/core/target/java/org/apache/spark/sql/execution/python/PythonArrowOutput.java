package org.apache.spark.sql.execution.python;
/**
 * A trait that can be mixed-in with {@link BasePythonRunner}. It implements the logic from
 * Python (Arrow) to JVM (ColumnarBatch).
 */
public  interface PythonArrowOutput {
  public  scala.collection.Iterator<org.apache.spark.sql.vectorized.ColumnarBatch> newReaderIterator (java.io.DataInputStream stream, org.apache.spark.api.python.BasePythonRunner.WriterThread writerThread, long startTime, org.apache.spark.SparkEnv env, java.net.Socket worker, java.util.concurrent.atomic.AtomicBoolean releasedOrClosed, org.apache.spark.TaskContext context)  ;
}
