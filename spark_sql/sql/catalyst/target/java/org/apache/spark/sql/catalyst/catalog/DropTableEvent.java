package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired after a table has been dropped.
 */
public  class DropTableEvent implements org.apache.spark.sql.catalyst.catalog.TableEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  public   DropTableEvent (java.lang.String database, java.lang.String name)  { throw new RuntimeException(); }
}
