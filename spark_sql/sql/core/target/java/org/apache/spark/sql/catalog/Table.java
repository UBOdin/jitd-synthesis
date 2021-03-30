package org.apache.spark.sql.catalog;
/**
 * A table in Spark, as returned by the <code>listTables</code> method in {@link Catalog}.
 * <p>
 * param:  name name of the table.
 * param:  database name of the database the table belongs to.
 * param:  description description of the table.
 * param:  tableType type of the table (e.g. view, table).
 * param:  isTemporary whether the table is a temporary table.
 * @since 2.0.0
 */
public  class Table implements org.apache.spark.sql.catalyst.DefinedByConstructorParams {
  // not preceding
  public   Table (java.lang.String name, java.lang.String database, java.lang.String description, java.lang.String tableType, boolean isTemporary)  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  boolean isTemporary ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String tableType ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
