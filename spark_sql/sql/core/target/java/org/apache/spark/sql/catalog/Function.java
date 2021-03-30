package org.apache.spark.sql.catalog;
/**
 * A user-defined function in Spark, as returned by <code>listFunctions</code> method in {@link Catalog}.
 * <p>
 * param:  name name of the function.
 * param:  database name of the database the function belongs to.
 * param:  description description of the function; description can be null.
 * param:  className the fully qualified class name of the function.
 * param:  isTemporary whether the function is a temporary function or not.
 * @since 2.0.0
 */
public  class Function implements org.apache.spark.sql.catalyst.DefinedByConstructorParams {
  // not preceding
  public   Function (java.lang.String name, java.lang.String database, java.lang.String description, java.lang.String className, boolean isTemporary)  { throw new RuntimeException(); }
  public  java.lang.String className ()  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  boolean isTemporary ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
