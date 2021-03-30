package org.apache.spark.sql.execution.python;
/**
 * A RowQueue is an FIFO queue for UnsafeRow.
 * <p>
 * This RowQueue is ONLY designed and used for Python UDF, which has only one writer and only one
 * reader, the reader ALWAYS ran behind the writer. See the doc of class {@link BatchEvalPythonExec}
 * on how it works.
 */
public  interface RowQueue {
  /**
   * Add a row to the end of it, returns true iff the row has been added to the queue.
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  boolean add (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  ;
  /**
   * Cleanup all the resources.
   */
  public  void close ()  ;
  /**
   * Retrieve and remove the first row, returns null if it's empty.
   * <p>
   * It can only be called after add is called, otherwise it will fail (NPE).
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow remove ()  ;
}
