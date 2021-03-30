package org.apache.spark.sql.execution.streaming;
/**
 * Policy to choose the *max* of the operator watermark values as the global watermark value. So the
 * global watermark will advance if any of the individual operator watermarks has advanced.
 * In other words, in a streaming query with multiple input streams and watermarks defined on all
 * of them, the global watermark will advance as fast as the fastest input. So if there is watermark
 * based state cleanup or late-data dropping, then this policy is the most aggressive one and
 * may lead to unexpected behavior if the data of the slow stream is delayed.
 */
public  class MaxWatermark$ implements org.apache.spark.sql.execution.streaming.MultipleWatermarkPolicy, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MaxWatermark$ MODULE$ = null;
  public   MaxWatermark$ ()  { throw new RuntimeException(); }
  public  long chooseGlobalWatermark (scala.collection.Seq<java.lang.Object> operatorWatermarks)  { throw new RuntimeException(); }
}
