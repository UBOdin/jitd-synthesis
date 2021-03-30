package org.apache.spark.sql.execution.streaming;
/**
 * Policy to choose the *max* of the operator watermark values as the global watermark value. So the
 * global watermark will advance if any of the individual operator watermarks has advanced.
 * In other words, in a streaming query with multiple input streams and watermarks defined on all
 * of them, the global watermark will advance as fast as the fastest input. So if there is watermark
 * based state cleanup or late-data dropping, then this policy is the most aggressive one and
 * may lead to unexpected behavior if the data of the slow stream is delayed.
 */
public  class MaxWatermark {
  static public  long chooseGlobalWatermark (scala.collection.Seq<java.lang.Object> operatorWatermarks)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
