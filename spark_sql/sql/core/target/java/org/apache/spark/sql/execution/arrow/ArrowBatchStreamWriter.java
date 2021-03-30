package org.apache.spark.sql.execution.arrow;
/**
 * Writes serialized ArrowRecordBatches to a DataOutputStream in the Arrow stream format.
 */
  class ArrowBatchStreamWriter {
  public   ArrowBatchStreamWriter (org.apache.spark.sql.types.StructType schema, java.io.OutputStream out, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.types.pojo.Schema arrowSchema ()  { throw new RuntimeException(); }
  /**
   * End the Arrow stream, does not close output stream.
   */
  public  void end ()  { throw new RuntimeException(); }
  /**
   * Consume iterator to write each serialized ArrowRecordBatch to the stream.
   * @param arrowBatchIter (undocumented)
   */
  public  void writeBatches (scala.collection.Iterator<byte[]> arrowBatchIter)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.ipc.WriteChannel writeChannel ()  { throw new RuntimeException(); }
}
