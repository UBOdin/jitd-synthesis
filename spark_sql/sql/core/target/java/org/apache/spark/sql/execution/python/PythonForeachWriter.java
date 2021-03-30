package org.apache.spark.sql.execution.python;
public  class PythonForeachWriter extends org.apache.spark.sql.ForeachWriter<org.apache.spark.sql.catalyst.expressions.UnsafeRow> {
  /**
   * A buffer that is designed for the sole purpose of buffering UnsafeRows in PythonForeachWriter.
   * It is designed to be used with only 1 writer thread (i.e. JVM task thread) and only 1 reader
   * thread (i.e. PythonRunner writing thread that reads from the buffer and writes to the Python
   * worker stdin). Adds to the buffer are non-blocking, and reads through the buffer's iterator
   * are blocking, that is, it blocks until new data is available or all data has been added.
   * <p>
   * Internally, it uses a {@link HybridRowQueue} to buffer the rows in a practically unlimited queue
   * across memory and local disk. However, HybridRowQueue is designed to be used only with
   * EvalPythonExec where the reader is always behind the writer, that is, the reader does not
   * try to read n+1 rows if the writer has only written n rows at any point of time. This
   * assumption is not true for PythonForeachWriter where rows may be added at a different rate as
   * they are consumed by the python worker. Hence, to maintain the invariant of the reader being
   * behind the writer while using HybridRowQueue, the buffer does the following
   * - Keeps a count of the rows in the HybridRowQueue
   * - Blocks the buffer's consuming iterator when the count is 0 so that the reader does not
   *   try to read more rows than what has been written.
   * <p>
   * The implementation of the blocking iterator (ReentrantLock, Condition, etc.) has been borrowed
   * from that of ArrayBlockingQueue.
   */
  static public  class UnsafeRowBuffer implements org.apache.spark.internal.Logging {
    public   UnsafeRowBuffer (org.apache.spark.memory.TaskMemoryManager taskMemoryManager, java.io.File tempDir, int numFields)  { throw new RuntimeException(); }
    public  void add (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
    public  void allRowsAdded ()  { throw new RuntimeException(); }
    public  void close ()  { throw new RuntimeException(); }
    public  org.apache.spark.util.NextIterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> iterator ()  { throw new RuntimeException(); }
  }
  public   PythonForeachWriter (org.apache.spark.api.python.PythonFunction func, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  boolean open (long partitionId, long version)  { throw new RuntimeException(); }
  public  void process (org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  { throw new RuntimeException(); }
  public  void close (java.lang.Throwable errorOrNull)  { throw new RuntimeException(); }
}
