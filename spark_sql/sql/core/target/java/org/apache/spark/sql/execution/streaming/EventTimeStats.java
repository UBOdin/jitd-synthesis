package org.apache.spark.sql.execution.streaming;
/** Class for collecting event time stats with an accumulator */
public  class EventTimeStats implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.EventTimeStats zero ()  { throw new RuntimeException(); }
  public  long max ()  { throw new RuntimeException(); }
  public  long min ()  { throw new RuntimeException(); }
  public  double avg ()  { throw new RuntimeException(); }
  public  long count ()  { throw new RuntimeException(); }
  // not preceding
  public   EventTimeStats (long max, long min, double avg, long count)  { throw new RuntimeException(); }
  public  void add (long eventTime)  { throw new RuntimeException(); }
  public  void merge (org.apache.spark.sql.execution.streaming.EventTimeStats that)  { throw new RuntimeException(); }
}
