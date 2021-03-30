package org.apache.spark.sql.execution.streaming;
/**
 * Used to mark a column as the containing the event time for a given record. In addition to
 * adding appropriate metadata to this column, this operator also tracks the maximum observed event
 * time. Based on the maximum observed time and a user specified delay, we can calculate the
 * <code>watermark</code> after which we assume we will no longer see late records for a particular time
 * period. Note that event time is measured in milliseconds.
 */
public  class EventTimeWatermarkExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute eventTime ()  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval delay ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   EventTimeWatermarkExec (org.apache.spark.sql.catalyst.expressions.Attribute eventTime, org.apache.spark.unsafe.types.CalendarInterval delay, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.EventTimeStatsAccum eventTimeStats ()  { throw new RuntimeException(); }
  public  long delayMs ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
