package org.apache.spark.sql.execution.r;
/**
 * Similar to <code>ArrowPythonRunner</code>, but exchange data with R worker via Arrow stream.
 */
public  class ArrowRRunner extends org.apache.spark.api.r.BaseRRunner<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.vectorized.ColumnarBatch> {
  public   ArrowRRunner (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId, int mode)  { throw new RuntimeException(); }
  protected  void bufferedWrite (java.io.DataOutputStream dataOut, scala.Function1<java.io.ByteArrayOutputStream, scala.runtime.BoxedUnit> writeFunc)  { throw new RuntimeException(); }
  protected  org.apache.spark.api.r.BaseRRunner<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.vectorized.ColumnarBatch>.ReaderIterator newReaderIterator (java.io.DataInputStream dataStream, org.apache.spark.api.r.BufferedStreamThread errThread)  { throw new RuntimeException(); }
  protected  org.apache.spark.api.r.BaseRRunner<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.sql.vectorized.ColumnarBatch>.WriterThread newWriterThread (java.io.OutputStream output, scala.collection.Iterator<scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> inputIterator, int partitionIndex)  { throw new RuntimeException(); }
}
