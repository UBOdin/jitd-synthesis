package org.apache.spark.sql.execution.streaming;
/**
 * A general MetadataLog that supports the following features:
 * <p>
 *  - Allow the user to store a metadata object for each batch.
 *  - Allow the user to query the latest batch id.
 *  - Allow the user to query the metadata object of a specified batch id.
 *  - Allow the user to query metadata objects in a range of batch ids.
 *  - Allow the user to remove obsolete metadata
 */
public  interface MetadataLog<T extends java.lang.Object> {
  /**
   * Store the metadata for the specified batchId and return <code>true</code> if successful. If the batchId's
   * metadata has already been stored, this method will return <code>false</code>.
   * @param batchId (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  boolean add (long batchId, T metadata)  ;
  /**
   * Return the metadata for the specified batchId if it's stored. Otherwise, return None.
   * @param batchId (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<T> get (long batchId)  ;
  /**
   * Return metadata for batches between startId (inclusive) and endId (inclusive). If <code>startId</code> is
   * <code>None</code>, just return all batches before endId (inclusive).
   * @param startId (undocumented)
   * @param endId (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<java.lang.Object, T>[] get (scala.Option<java.lang.Object> startId, scala.Option<java.lang.Object> endId)  ;
  /**
   * Return the latest batch Id and its metadata if exist.
   * @return (undocumented)
   */
  public  scala.Option<scala.Tuple2<java.lang.Object, T>> getLatest ()  ;
  /**
   * Removes all the log entry earlier than thresholdBatchId (exclusive).
   * This operation should be idempotent.
   * @param thresholdBatchId (undocumented)
   */
  public  void purge (long thresholdBatchId)  ;
}
