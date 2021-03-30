package org.apache.spark.sql.execution.streaming;
/** Tracks the watermark value of a streaming query based on a given `policy` */
public  class WatermarkTracker implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.WatermarkTracker apply (org.apache.spark.sql.RuntimeConfig conf)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.MultipleWatermarkPolicy policy ()  { throw new RuntimeException(); }
  // not preceding
  public   WatermarkTracker (org.apache.spark.sql.execution.streaming.MultipleWatermarkPolicy policy)  { throw new RuntimeException(); }
  public  void setWatermark (long newWatermarkMs)  { throw new RuntimeException(); }
  public  void updateWatermark (org.apache.spark.sql.execution.SparkPlan executedPlan)  { throw new RuntimeException(); }
  public  long currentWatermark ()  { throw new RuntimeException(); }
}
