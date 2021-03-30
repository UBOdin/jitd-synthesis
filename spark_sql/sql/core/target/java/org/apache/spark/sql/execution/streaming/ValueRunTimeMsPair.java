package org.apache.spark.sql.execution.streaming;
public  class ValueRunTimeMsPair implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long value ()  { throw new RuntimeException(); }
  public  long runTimeMs ()  { throw new RuntimeException(); }
  // not preceding
  public   ValueRunTimeMsPair (long value, long runTimeMs)  { throw new RuntimeException(); }
}
