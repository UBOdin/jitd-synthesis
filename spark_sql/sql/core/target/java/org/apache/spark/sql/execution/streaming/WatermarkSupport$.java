package org.apache.spark.sql.execution.streaming;
public  class WatermarkSupport$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final WatermarkSupport$ MODULE$ = null;
  public   WatermarkSupport$ ()  { throw new RuntimeException(); }
  /** Generate an expression on given attributes that matches data older than the watermark */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> watermarkExpression (scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> optionalWatermarkExpression, scala.Option<java.lang.Object> optionalWatermarkMs)  { throw new RuntimeException(); }
}
