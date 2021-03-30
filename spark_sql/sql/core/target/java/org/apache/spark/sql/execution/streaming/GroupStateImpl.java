package org.apache.spark.sql.execution.streaming;
/**
 * Internal implementation of the {@link GroupState} interface. Methods are not thread-safe.
 * <p>
 * param:  optionalValue Optional value of the state
 * param:  batchProcessingTimeMs Processing time of current batch, used to calculate timestamp
 *                              for processing time timeouts
 * param:  timeoutConf     Type of timeout configured. Based on this, different operations will
 *                        be supported.
 * param:  hasTimedOut     Whether the key for which this state wrapped is being created is
 *                        getting timed out or not.
 */
  class GroupStateImpl<S extends java.lang.Object> implements org.apache.spark.sql.streaming.GroupState<S> {
  static public  long NO_TIMESTAMP ()  { throw new RuntimeException(); }
  static public <S extends java.lang.Object> org.apache.spark.sql.execution.streaming.GroupStateImpl<S> createForStreaming (scala.Option<S> optionalValue, long batchProcessingTimeMs, long eventTimeWatermarkMs, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, boolean hasTimedOut, boolean watermarkPresent)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.GroupStateImpl<java.lang.Object> createForBatch (org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, boolean watermarkPresent)  { throw new RuntimeException(); }
  public  boolean hasTimedOut ()  { throw new RuntimeException(); }
  public  boolean exists ()  { throw new RuntimeException(); }
  public  S get ()  { throw new RuntimeException(); }
  public  scala.Option<S> getOption ()  { throw new RuntimeException(); }
  public  void update (S newValue)  { throw new RuntimeException(); }
  public  void remove ()  { throw new RuntimeException(); }
  public  void setTimeoutDuration (long durationMs)  { throw new RuntimeException(); }
  public  void setTimeoutDuration (java.lang.String duration)  { throw new RuntimeException(); }
  public  void setTimeoutTimestamp (long timestampMs)  { throw new RuntimeException(); }
  public  void setTimeoutTimestamp (long timestampMs, java.lang.String additionalDuration)  { throw new RuntimeException(); }
  public  void setTimeoutTimestamp (java.sql.Date timestamp)  { throw new RuntimeException(); }
  public  void setTimeoutTimestamp (java.sql.Date timestamp, java.lang.String additionalDuration)  { throw new RuntimeException(); }
  public  long getCurrentWatermarkMs ()  { throw new RuntimeException(); }
  public  long getCurrentProcessingTimeMs ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /** Whether the state has been marked for removing */
  public  boolean hasRemoved ()  { throw new RuntimeException(); }
  /** Whether the state has been updated */
  public  boolean hasUpdated ()  { throw new RuntimeException(); }
  /** Return timeout timestamp or `TIMEOUT_TIMESTAMP_NOT_SET` if not set */
  public  long getTimeoutTimestamp ()  { throw new RuntimeException(); }
}
