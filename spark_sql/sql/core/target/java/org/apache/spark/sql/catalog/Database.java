package org.apache.spark.sql.catalog;
/**
 * A database in Spark, as returned by the <code>listDatabases</code> method defined in {@link Catalog}.
 * <p>
 * param:  name name of the database.
 * param:  description description of the database.
 * param:  locationUri path (in the form of a uri) to data files.
 * @since 2.0.0
 */
public  class Database implements org.apache.spark.sql.catalyst.DefinedByConstructorParams {
  // not preceding
  public   Database (java.lang.String name, java.lang.String description, java.lang.String locationUri)  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  java.lang.String locationUri ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
