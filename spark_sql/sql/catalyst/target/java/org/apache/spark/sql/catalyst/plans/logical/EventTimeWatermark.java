package org.apache.spark.sql.catalyst.plans.logical;
public  class EventTimeWatermark extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  /** The {@link org.apache.spark.sql.types.Metadata} key used to hold the eventTime watermark delay. */
  static public  java.lang.String delayKey ()  { throw new RuntimeException(); }
  static public  long getDelayMs (org.apache.spark.unsafe.types.CalendarInterval delay)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute eventTime ()  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval delay ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   EventTimeWatermark (org.apache.spark.sql.catalyst.expressions.Attribute eventTime, org.apache.spark.unsafe.types.CalendarInterval delay, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
