package org.apache.spark.sql.test;
/**
 * An example class to demonstrate UDT in Scala, Java, and Python.
 * param:  x x coordinate
 * param:  y y coordinate
 */
  class ExamplePoint implements scala.Serializable {
  // not preceding
  public   ExamplePoint (double x, double y)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  double x ()  { throw new RuntimeException(); }
  public  double y ()  { throw new RuntimeException(); }
}
