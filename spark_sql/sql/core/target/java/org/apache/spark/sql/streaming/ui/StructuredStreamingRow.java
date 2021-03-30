package org.apache.spark.sql.streaming.ui;
  class StructuredStreamingRow implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long duration ()  { throw new RuntimeException(); }
  public  double avgInput ()  { throw new RuntimeException(); }
  public  double avgProcess ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.ui.StreamingQueryUIData streamingUIData ()  { throw new RuntimeException(); }
  // not preceding
  public   StructuredStreamingRow (long duration, double avgInput, double avgProcess, org.apache.spark.sql.streaming.ui.StreamingQueryUIData streamingUIData)  { throw new RuntimeException(); }
}
