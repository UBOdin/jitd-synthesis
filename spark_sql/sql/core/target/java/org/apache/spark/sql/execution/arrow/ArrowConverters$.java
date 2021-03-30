package org.apache.spark.sql.execution.arrow;
public  class ArrowConverters$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ArrowConverters$ MODULE$ = null;
  public   ArrowConverters$ ()  { throw new RuntimeException(); }
  /**
   * Maps Iterator from InternalRow to serialized ArrowRecordBatches. Limit ArrowRecordBatch size
   * in a batch by setting maxRecordsPerBatch or use 0 to fully consume rowIter.
   * @param rowIter (undocumented)
   * @param schema (undocumented)
   * @param maxRecordsPerBatch (undocumented)
   * @param timeZoneId (undocumented)
   * @param context (undocumented)
   * @return (undocumented)
   */
    scala.collection.Iterator<byte[]> toBatchIterator (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> rowIter, org.apache.spark.sql.types.StructType schema, int maxRecordsPerBatch, java.lang.String timeZoneId, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  /**
   * Maps iterator from serialized ArrowRecordBatches to InternalRows.
   * @param arrowBatchIter (undocumented)
   * @param schema (undocumented)
   * @param timeZoneId (undocumented)
   * @param context (undocumented)
   * @return (undocumented)
   */
    scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> fromBatchIterator (scala.collection.Iterator<byte[]> arrowBatchIter, org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  /**
   * Load a serialized ArrowRecordBatch.
   * @param batchBytes (undocumented)
   * @param allocator (undocumented)
   * @return (undocumented)
   */
    org.apache.arrow.vector.ipc.message.ArrowRecordBatch loadBatch (byte[] batchBytes, org.apache.arrow.memory.BufferAllocator allocator)  { throw new RuntimeException(); }
  /**
   * Create a DataFrame from an RDD of serialized ArrowRecordBatches.
   * @param arrowBatchRDD (undocumented)
   * @param schemaString (undocumented)
   * @param sqlContext (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDataFrame (org.apache.spark.api.java.JavaRDD<byte[]> arrowBatchRDD, java.lang.String schemaString, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  /**
   * Read a file as an Arrow stream and parallelize as an RDD of serialized ArrowRecordBatches.
   * @param sqlContext (undocumented)
   * @param filename (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.api.java.JavaRDD<byte[]> readArrowStreamFromFile (org.apache.spark.sql.SQLContext sqlContext, java.lang.String filename)  { throw new RuntimeException(); }
  /**
   * Read an Arrow stream input and return an iterator of serialized ArrowRecordBatches.
   * @param in (undocumented)
   * @return (undocumented)
   */
    scala.collection.Iterator<byte[]> getBatchesFromStream (java.nio.channels.ReadableByteChannel in)  { throw new RuntimeException(); }
}
