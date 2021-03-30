package org.apache.spark.sql.execution.streaming;
/**
 * An abstract class for compactible metadata logs. It will write one log file for each batch.
 * The first line of the log file is the version number, and there are multiple serialized
 * metadata lines following.
 * <p>
 * As reading from many small files is usually pretty slow, also too many
 * small files in one folder will mess the FS, {@link CompactibleFileStreamLog} will
 * compact log files every 10 batches by default into a big file. When
 * doing a compaction, it will read all old log files and merge them with the new batch.
 */
public abstract class CompactibleFileStreamLog<T extends java.lang.Object> extends org.apache.spark.sql.execution.streaming.HDFSMetadataLog<T[]> {
  static public  java.lang.String COMPACT_FILE_SUFFIX ()  { throw new RuntimeException(); }
  static public  int COMPACT_LATENCY_WARN_THRESHOLD_MS ()  { throw new RuntimeException(); }
  static public  long getBatchIdFromFileName (java.lang.String fileName)  { throw new RuntimeException(); }
  /**
   * Returns if this is a compaction batch. FileStreamSinkLog will compact old logs every
   * <code>compactInterval</code> commits.
   * <p>
   * E.g., if <code>compactInterval</code> is 3, then 2, 5, 8, ... are all compaction batches.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  static public  boolean isCompactionBatch (long batchId, int compactInterval)  { throw new RuntimeException(); }
  /**
   * Returns all valid batches before the specified <code>compactionBatchId</code>. They contain all logs we
   * need to do a new compaction.
   * <p>
   * E.g., if <code>compactInterval</code> is 3 and <code>compactionBatchId</code> is 5, this method should returns
   * <code>Seq(2, 3, 4)</code> (Note: it includes the previous compaction batch 2).
   * @param compactionBatchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<java.lang.Object> getValidBatchesBeforeCompactionBatch (long compactionBatchId, int compactInterval)  { throw new RuntimeException(); }
  /**
   * Returns all necessary logs before <code>batchId</code> (inclusive). If <code>batchId</code> is a compaction, just
   * return itself. Otherwise, it will find the previous compaction batch and return all batches
   * between it and <code>batchId</code>.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<java.lang.Object> getAllValidBatches (long batchId, long compactInterval)  { throw new RuntimeException(); }
  /**
   * Returns the next compaction batch id after <code>batchId</code>.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  static public  long nextCompactionBatchId (long batchId, long compactInterval)  { throw new RuntimeException(); }
  /**
   * Derives a compact interval from the latest compact batch id and
   * a default compact interval.
   * @param defaultInterval (undocumented)
   * @param latestCompactBatchId (undocumented)
   * @return (undocumented)
   */
  static public  int deriveCompactInterval (int defaultInterval, int latestCompactBatchId)  { throw new RuntimeException(); }
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(Select(Ident(scala), TypeName("AnyRef")))))
  public   CompactibleFileStreamLog (int metadataLogVersion, org.apache.spark.sql.SparkSession sparkSession, java.lang.String path, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  protected  int minBatchesToRetain ()  { throw new RuntimeException(); }
  /**
   * If we delete the old files after compaction at once, there is a race condition in S3: other
   * processes may see the old files are deleted but still cannot see the compaction file using
   * "list". The <code>allFiles</code> handles this by looking for the next compaction file directly, however,
   * a live lock may happen if the compaction happens too frequently: one processing keeps deleting
   * old files while another one keeps retrying. Setting a reasonable cleanup delay could avoid it.
   * @return (undocumented)
   */
  protected abstract  long fileCleanupDelayMs ()  ;
  protected abstract  boolean isDeletingExpiredLog ()  ;
  protected abstract  int defaultCompactInterval ()  ;
  // not preceding
  protected final  int compactInterval ()  { throw new RuntimeException(); }
  /**
   * Determine whether the log should be retained or not.
   * <p>
   * Default implementation retains all log entries. Implementations should override the method
   * to change the behavior.
   * @param log (undocumented)
   * @param currentTime (undocumented)
   * @return (undocumented)
   */
  public  boolean shouldRetain (T log, long currentTime)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path batchIdToPath (long batchId)  { throw new RuntimeException(); }
  public  long pathToBatchId (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  boolean isBatchFile (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  void serialize (T[] logData, java.io.OutputStream out)  { throw new RuntimeException(); }
  public  T[] deserialize (java.io.InputStream in)  { throw new RuntimeException(); }
  public  boolean add (long batchId, T[] logs)  { throw new RuntimeException(); }
  /**
   * CompactibleFileStreamLog maintains logs by itself, and manual purging might break internal
   * state, specifically which latest compaction batch is purged.
   * <p>
   * To simplify the situation, this method just throws UnsupportedOperationException regardless
   * of given parameter, and let CompactibleFileStreamLog handles purging by itself.
   * @param thresholdBatchId (undocumented)
   */
  public  void purge (long thresholdBatchId)  { throw new RuntimeException(); }
  /**
   * Apply function on all entries in the specific batch. The method will throw
   * FileNotFoundException if the metadata log file doesn't exist.
   * <p>
   * NOTE: This doesn't fail early on corruption. The caller should handle the exception
   * properly and make sure the logic is not affected by failing in the middle.
   * @param batchId (undocumented)
   * @param fn (undocumented)
   */
  public  void foreachInBatch (long batchId, scala.Function1<T, scala.runtime.BoxedUnit> fn)  { throw new RuntimeException(); }
  /**
   * Apply filter on all entries in the specific batch.
   * @param batchId (undocumented)
   * @param predicate (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<T[]> filterInBatch (long batchId, scala.Function1<T, java.lang.Object> predicate)  { throw new RuntimeException(); }
  /**
   * Returns all files except the deleted ones.
   * @return (undocumented)
   */
  public  T[] allFiles ()  { throw new RuntimeException(); }
}
