package org.apache.spark.sql.execution.streaming;
/**
 * Policy to define how to choose a new global watermark value if there are
 * multiple watermark operators in a streaming query.
 */
public  interface MultipleWatermarkPolicy {
  public  long chooseGlobalWatermark (scala.collection.Seq<java.lang.Object> operatorWatermarks)  ;
}
