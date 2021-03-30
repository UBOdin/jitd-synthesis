package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired before a function is dropped.
 */
public  class DropFunctionPreEvent implements org.apache.spark.sql.catalyst.catalog.FunctionEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  public   DropFunctionPreEvent (java.lang.String database, java.lang.String name)  { throw new RuntimeException(); }
}
