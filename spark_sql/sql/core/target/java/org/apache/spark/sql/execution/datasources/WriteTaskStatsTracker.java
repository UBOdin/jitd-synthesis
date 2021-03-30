package org.apache.spark.sql.execution.datasources;
/**
 * A trait for classes that are capable of collecting statistics on data that's being processed by
 * a single write task in {@link FileFormatWriter} - i.e. there should be one instance per executor.
 * <p>
 * This trait is coupled with the way {@link FileFormatWriter} works, in the sense that its methods
 * will be called according to how tuples are being written out to disk, namely in sorted order
 * according to partitionValue(s), then bucketId.
 * <p>
 * As such, a typical call scenario is:
 * <p>
 * newPartition -> newBucket -> newFile -> newRow -.
 *    ^        |______^___________^ ^         ^____|
 *    |               |             |______________|
 *    |               |____________________________|
 *    |____________________________________________|
 * <p>
 * newPartition and newBucket events are only triggered if the relation to be written out is
 * partitioned and/or bucketed, respectively.
 */
public  interface WriteTaskStatsTracker {
  /**
   * Returns the final statistics computed so far.
   * @note This may only be called once. Further use of the object may lead to undefined behavior.
   * @return An object of subtype of {@link WriteTaskStats}, to be sent to the driver.
   */
  public  org.apache.spark.sql.execution.datasources.WriteTaskStats getFinalStats ()  ;
  /**
   * Process the fact that a new bucket is about to written.
   * Only triggered when the relation is bucketed by a (non-empty) sequence of columns.
   * @param bucketId The bucket number.
   */
  public  void newBucket (int bucketId)  ;
  /**
   * Process the fact that a new file is about to be written.
   * @param filePath Path of the file into which future rows will be written.
   */
  public  void newFile (java.lang.String filePath)  ;
  /**
   * Process the fact that a new partition is about to be written.
   * Only triggered when the relation is partitioned by a (non-empty) sequence of columns.
   * @param partitionValues The values that define this new partition.
   */
  public  void newPartition (org.apache.spark.sql.catalyst.InternalRow partitionValues)  ;
  /**
   * Process the fact that a new row to update the tracked statistics accordingly.
   * The row will be written to the most recently witnessed file (via <code>newFile</code>).
   * @note Keep in mind that any overhead here is per-row, obviously,
   *       so implementations should be as lightweight as possible.
   * @param row Current data row to be processed.
   */
  public  void newRow (org.apache.spark.sql.catalyst.InternalRow row)  ;
}
