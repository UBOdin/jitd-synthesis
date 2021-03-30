package org.apache.spark.sql.catalog;
/**
 * A column in Spark, as returned by <code>listColumns</code> method in {@link Catalog}.
 * <p>
 * param:  name name of the column.
 * param:  description description of the column.
 * param:  dataType data type of the column.
 * param:  nullable whether the column is nullable.
 * param:  isPartition whether the column is a partition column.
 * param:  isBucket whether the column is a bucket column.
 * @since 2.0.0
 */
public  class Column implements org.apache.spark.sql.catalyst.DefinedByConstructorParams {
  // not preceding
  public   Column (java.lang.String name, java.lang.String description, java.lang.String dataType, boolean nullable, boolean isPartition, boolean isBucket)  { throw new RuntimeException(); }
  public  java.lang.String dataType ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  boolean isBucket ()  { throw new RuntimeException(); }
  public  boolean isPartition ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
