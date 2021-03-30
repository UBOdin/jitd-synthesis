package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class ValueInterval$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ValueInterval$ MODULE$ = null;
  public   ValueInterval$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval apply (scala.Option<java.lang.Object> min, scala.Option<java.lang.Object> max, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  boolean isIntersected (org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval r1, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval r2)  { throw new RuntimeException(); }
  /**
   * Intersected results of two intervals. This is only for two overlapped intervals.
   * The outputs are the intersected min/max values.
   * @param r1 (undocumented)
   * @param r2 (undocumented)
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<scala.Option<java.lang.Object>, scala.Option<java.lang.Object>> intersect (org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval r1, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval r2, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
}
