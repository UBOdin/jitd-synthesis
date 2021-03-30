package org.apache.spark.sql.execution.streaming;
public  class GroupStateImpl$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GroupStateImpl$ MODULE$ = null;
  public   GroupStateImpl$ ()  { throw new RuntimeException(); }
  public  long NO_TIMESTAMP ()  { throw new RuntimeException(); }
  public <S extends java.lang.Object> org.apache.spark.sql.execution.streaming.GroupStateImpl<S> createForStreaming (scala.Option<S> optionalValue, long batchProcessingTimeMs, long eventTimeWatermarkMs, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, boolean hasTimedOut, boolean watermarkPresent)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.GroupStateImpl<java.lang.Object> createForBatch (org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, boolean watermarkPresent)  { throw new RuntimeException(); }
}
