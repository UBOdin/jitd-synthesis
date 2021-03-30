package org.apache.spark.sql.execution.streaming;
public  class CompactibleFileStreamLog$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CompactibleFileStreamLog$ MODULE$ = null;
  public   CompactibleFileStreamLog$ ()  { throw new RuntimeException(); }
  public  java.lang.String COMPACT_FILE_SUFFIX ()  { throw new RuntimeException(); }
  public  int COMPACT_LATENCY_WARN_THRESHOLD_MS ()  { throw new RuntimeException(); }
  public  long getBatchIdFromFileName (java.lang.String fileName)  { throw new RuntimeException(); }
  /**
   * Returns if this is a compaction batch. FileStreamSinkLog will compact old logs every
   * <code>compactInterval</code> commits.
   * <p>
   * E.g., if <code>compactInterval</code> is 3, then 2, 5, 8, ... are all compaction batches.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  public  boolean isCompactionBatch (long batchId, int compactInterval)  { throw new RuntimeException(); }
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
  public  scala.collection.Seq<java.lang.Object> getValidBatchesBeforeCompactionBatch (long compactionBatchId, int compactInterval)  { throw new RuntimeException(); }
  /**
   * Returns all necessary logs before <code>batchId</code> (inclusive). If <code>batchId</code> is a compaction, just
   * return itself. Otherwise, it will find the previous compaction batch and return all batches
   * between it and <code>batchId</code>.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.Object> getAllValidBatches (long batchId, long compactInterval)  { throw new RuntimeException(); }
  /**
   * Returns the next compaction batch id after <code>batchId</code>.
   * @param batchId (undocumented)
   * @param compactInterval (undocumented)
   * @return (undocumented)
   */
  public  long nextCompactionBatchId (long batchId, long compactInterval)  { throw new RuntimeException(); }
  /**
   * Derives a compact interval from the latest compact batch id and
   * a default compact interval.
   * @param defaultInterval (undocumented)
   * @param latestCompactBatchId (undocumented)
   * @return (undocumented)
   */
  public  int deriveCompactInterval (int defaultInterval, int latestCompactBatchId)  { throw new RuntimeException(); }
}
