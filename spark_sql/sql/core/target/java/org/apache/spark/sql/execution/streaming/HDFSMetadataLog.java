package org.apache.spark.sql.execution.streaming;
/**
 * A {@link MetadataLog} implementation based on HDFS. {@link HDFSMetadataLog} uses the specified <code>path</code>
 * as the metadata storage.
 * <p>
 * When writing a new batch, {@link HDFSMetadataLog} will firstly write to a temp file and then rename
 * it to the final batch file. If the rename step fails, there must be multiple writers and only
 * one of them will succeed and the others will fail.
 * <p>
 * Note: {@link HDFSMetadataLog} doesn't support S3-like file systems as they don't guarantee listing
 * files in a directory always shows the latest files.
 */
public  class HDFSMetadataLog<T extends java.lang.Object> implements org.apache.spark.sql.execution.streaming.MetadataLog<T>, org.apache.spark.internal.Logging {
  /**
   * Verify if batchIds are continuous and between <code>startId</code> and <code>endId</code> (both inclusive and
   * startId assumed to be <= endId).
   * <p>
   * @param batchIds the sorted ids to verify.
   * @param startId the start id. If it's set, batchIds should start with this id.
   * @param endId the start id. If it's set, batchIds should end with this id.
   */
  static public  void verifyBatchIds (scala.collection.Seq<java.lang.Object> batchIds, scala.Option<java.lang.Object> startId, scala.Option<java.lang.Object> endId)  { throw new RuntimeException(); }
  public   HDFSMetadataLog (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path metadataPath ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.CheckpointFileManager fileManager ()  { throw new RuntimeException(); }
  /**
   * A <code>PathFilter</code> to filter only batch files
   * @return (undocumented)
   */
  protected  java.lang.Object batchFilesFilter ()  { throw new RuntimeException(); }
  protected  org.apache.hadoop.fs.Path batchIdToPath (long batchId)  { throw new RuntimeException(); }
  protected  long pathToBatchId (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  protected  boolean isBatchFile (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  /**
   * Serialize the metadata and write to the output stream. If this method is overridden in a
   * subclass, the overriding method should not close the given output stream, as it will be closed
   * in the caller.
   * @param metadata (undocumented)
   * @param out (undocumented)
   */
  protected  void serialize (T metadata, java.io.OutputStream out)  { throw new RuntimeException(); }
  /**
   * Read and deserialize the metadata from input stream. If this method is overridden in a
   * subclass, the overriding method should not close the given input stream, as it will be closed
   * in the caller.
   * @param in (undocumented)
   * @return (undocumented)
   */
  protected  T deserialize (java.io.InputStream in)  { throw new RuntimeException(); }
  /**
   * Store the metadata for the specified batchId and return <code>true</code> if successful. If the batchId's
   * metadata has already been stored, this method will return <code>false</code>.
   * @param batchId (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  boolean add (long batchId, T metadata)  { throw new RuntimeException(); }
  public  scala.Option<T> get (long batchId)  { throw new RuntimeException(); }
  /**
   * Apply provided function to each entry in the specific batch metadata log.
   * <p>
   * Unlike get which will materialize all entries into memory, this method streamlines the process
   * via READ-AND-PROCESS. This helps to avoid the memory issue on huge metadata log file.
   * <p>
   * NOTE: This no longer fails early on corruption. The caller should handle the exception
   * properly and make sure the logic is not affected by failing in the middle.
   * @param batchId (undocumented)
   * @param fn (undocumented)
   * @return (undocumented)
   */
  public <RET extends java.lang.Object> RET applyFnToBatchByStream (long batchId, scala.Function1<java.io.InputStream, RET> fn)  { throw new RuntimeException(); }
  /**
   * Store the metadata for the specified batchId and return <code>true</code> if successful. This method
   * fills the content of metadata via executing function. If the function throws an exception,
   * writing will be automatically cancelled and this method will propagate the exception.
   * <p>
   * If the batchId's metadata has already been stored, this method will return <code>false</code>.
   * <p>
   * Writing the metadata is done by writing a batch to a temp file then rename it to the batch
   * file.
   * <p>
   * There may be multiple {@link HDFSMetadataLog} using the same metadata path. Although it is not a
   * valid behavior, we still need to prevent it from destroying the files.
   * @param batchId (undocumented)
   * @param fn (undocumented)
   * @return (undocumented)
   */
  public  boolean addNewBatchByStream (long batchId, scala.Function1<java.io.OutputStream, scala.runtime.BoxedUnit> fn)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, T>[] get (scala.Option<java.lang.Object> startId, scala.Option<java.lang.Object> endId)  { throw new RuntimeException(); }
  /**
   * Return the latest batch Id without reading the file. This method only checks for existence of
   * file to avoid cost on reading and deserializing log file.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> getLatestBatchId ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple2<java.lang.Object, T>> getLatest ()  { throw new RuntimeException(); }
  /**
   * Get an array of [FileStatus] referencing batch files.
   * The array is sorted by most recent batch file first to
   * oldest batch file.
   * @return (undocumented)
   */
  public  org.apache.hadoop.fs.FileStatus[] getOrderedBatchFiles ()  { throw new RuntimeException(); }
  /**
   * Removes all the log entry earlier than thresholdBatchId (exclusive).
   * @param thresholdBatchId (undocumented)
   */
  public  void purge (long thresholdBatchId)  { throw new RuntimeException(); }
  /**
   * Removes all log entries later than thresholdBatchId (exclusive).
   * @param thresholdBatchId (undocumented)
   */
  public  void purgeAfter (long thresholdBatchId)  { throw new RuntimeException(); }
    int validateVersion (java.lang.String text, int maxSupportedVersion)  { throw new RuntimeException(); }
}
