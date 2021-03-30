package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Tracks the current continuous processing epoch within a task. Call
 * EpochTracker.getCurrentEpoch to get the current epoch.
 */
public  class EpochTracker {
  /**
   * Get the current epoch for the current task, or None if the task has no current epoch.
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.Object> getCurrentEpoch ()  { throw new RuntimeException(); }
  /**
   * Increment the current epoch for this task thread. Should be called by {@link ContinuousWriteRDD}
   * between epochs.
   */
  static public  void incrementCurrentEpoch ()  { throw new RuntimeException(); }
  /**
   * Initialize the current epoch for this task thread. Should be called by {@link ContinuousWriteRDD}
   * at the beginning of a task.
   * @param startEpoch (undocumented)
   */
  static public  void initializeCurrentEpoch (long startEpoch)  { throw new RuntimeException(); }
}
