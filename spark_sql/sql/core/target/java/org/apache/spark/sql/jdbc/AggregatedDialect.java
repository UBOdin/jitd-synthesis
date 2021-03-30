package org.apache.spark.sql.jdbc;
/**
 * AggregatedDialect can unify multiple dialects into one virtual Dialect.
 * Dialects are tried in order, and the first dialect that does not return a
 * neutral element will win.
 * <p>
 * param:  dialects List of dialects.
 */
public  class AggregatedDialect extends org.apache.spark.sql.jdbc.JdbcDialect {
  public   AggregatedDialect (scala.collection.immutable.List<org.apache.spark.sql.jdbc.JdbcDialect> dialects)  { throw new RuntimeException(); }
  public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> getCatalystType (int sqlType, java.lang.String typeName, int size, org.apache.spark.sql.types.MetadataBuilder md)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.jdbc.JdbcType> getJDBCType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  java.lang.String getSchemaQuery (java.lang.String table)  { throw new RuntimeException(); }
  public  java.lang.String getTableExistsQuery (java.lang.String table)  { throw new RuntimeException(); }
  /**
   * The SQL query used to truncate a table.
   * @param table The table to truncate.
   * @param cascade Whether or not to cascade the truncation. Default value is the
   *                value of isCascadingTruncateTable()
   * @return The SQL query to use for truncating a table
   */
  public  java.lang.String getTruncateQuery (java.lang.String table, scala.Option<java.lang.Object> cascade)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> isCascadingTruncateTable ()  { throw new RuntimeException(); }
  public  java.lang.String quoteIdentifier (java.lang.String colName)  { throw new RuntimeException(); }
}
