package org.apache.spark.sql.execution.adaptive;
/**
 * A simple implementation of {@link Cost}, which takes a number of {@link Long} as the cost value.
 */
public  class SimpleCost implements org.apache.spark.sql.execution.adaptive.Cost, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long value ()  { throw new RuntimeException(); }
  // not preceding
  public   SimpleCost (long value)  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.execution.adaptive.Cost that)  { throw new RuntimeException(); }
}
