package org.apache.spark.sql.execution;
/**
 * Cost mode means that when printing explain for a DataFrame, if plan node statistics are
 * available, a logical plan and the statistics are expected to be printed to the console.
 */
public  class CostMode {
  static public  java.lang.String name ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
