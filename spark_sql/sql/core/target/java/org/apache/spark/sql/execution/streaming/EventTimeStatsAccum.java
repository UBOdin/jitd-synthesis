package org.apache.spark.sql.execution.streaming;
/** Accumulator that collects stats on event time in a batch. */
public  class EventTimeStatsAccum extends org.apache.spark.util.AccumulatorV2<java.lang.Object, org.apache.spark.sql.execution.streaming.EventTimeStats> {
  protected  org.apache.spark.sql.execution.streaming.EventTimeStats currentStats ()  { throw new RuntimeException(); }
  // not preceding
  public   EventTimeStatsAccum (org.apache.spark.sql.execution.streaming.EventTimeStats currentStats)  { throw new RuntimeException(); }
  public  boolean isZero ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.EventTimeStats value ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.AccumulatorV2<java.lang.Object, org.apache.spark.sql.execution.streaming.EventTimeStats> copy ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void add (long v)  { throw new RuntimeException(); }
  public  void merge (org.apache.spark.util.AccumulatorV2<java.lang.Object, org.apache.spark.sql.execution.streaming.EventTimeStats> other)  { throw new RuntimeException(); }
}
