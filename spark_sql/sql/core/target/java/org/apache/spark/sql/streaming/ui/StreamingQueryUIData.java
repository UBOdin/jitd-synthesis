package org.apache.spark.sql.streaming.ui;
/**
 * This class contains all message related to UI display, each instance corresponds to a single
 * {@link org.apache.spark.sql.streaming.StreamingQuery}.
 */
  class StreamingQueryUIData implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.ui.StreamingQueryData summary ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryProgress[] recentProgress ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingQueryUIData (org.apache.spark.sql.streaming.ui.StreamingQueryData summary, org.apache.spark.sql.streaming.StreamingQueryProgress[] recentProgress)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StreamingQueryProgress lastProgress ()  { throw new RuntimeException(); }
}
