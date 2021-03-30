package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired before a database is altered.
 */
public  class AlterDatabasePreEvent implements org.apache.spark.sql.catalyst.catalog.DatabaseEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterDatabasePreEvent (java.lang.String database)  { throw new RuntimeException(); }
}
