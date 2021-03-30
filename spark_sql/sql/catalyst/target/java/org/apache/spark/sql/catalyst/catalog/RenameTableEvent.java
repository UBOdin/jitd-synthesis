package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired after a table has been renamed.
 */
public  class RenameTableEvent implements org.apache.spark.sql.catalyst.catalog.TableEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String newName ()  { throw new RuntimeException(); }
  // not preceding
  public   RenameTableEvent (java.lang.String database, java.lang.String name, java.lang.String newName)  { throw new RuntimeException(); }
}
