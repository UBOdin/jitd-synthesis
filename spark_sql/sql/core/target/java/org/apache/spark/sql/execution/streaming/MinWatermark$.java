package org.apache.spark.sql.execution.streaming;
/**
 * Policy to choose the *min* of the operator watermark values as the global watermark value.
 * Note that this is the safe (hence default) policy as the global watermark will advance
 * only if all the individual operator watermarks have advanced. In other words, in a
 * streaming query with multiple input streams and watermarks defined on all of them,
 * the global watermark will advance as slowly as the slowest input. So if there is watermark
 * based state cleanup or late-data dropping, then this policy is the most conservative one.
 */
public  class MinWatermark$ implements org.apache.spark.sql.execution.streaming.MultipleWatermarkPolicy, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MinWatermark$ MODULE$ = null;
  public   MinWatermark$ ()  { throw new RuntimeException(); }
  public  long chooseGlobalWatermark (scala.collection.Seq<java.lang.Object> operatorWatermarks)  { throw new RuntimeException(); }
}
