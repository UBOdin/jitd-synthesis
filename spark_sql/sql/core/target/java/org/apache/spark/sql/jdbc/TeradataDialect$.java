package org.apache.spark.sql.jdbc;
public  class TeradataDialect$ extends org.apache.spark.sql.jdbc.JdbcDialect implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TeradataDialect$ MODULE$ = null;
  public   TeradataDialect$ ()  { throw new RuntimeException(); }
  public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.jdbc.JdbcType> getJDBCType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> isCascadingTruncateTable ()  { throw new RuntimeException(); }
  /**
   * The SQL query used to truncate a table. Teradata does not support the 'TRUNCATE' syntax that
   * other dialects use. Instead, we need to use a 'DELETE FROM' statement.
   * @param table The table to truncate.
   * @param cascade Whether or not to cascade the truncation. Default value is the
   *                value of isCascadingTruncateTable(). Teradata does not support cascading a
   *                'DELETE FROM' statement (and as mentioned, does not support 'TRUNCATE' syntax)
   * @return The SQL query to use for truncating a table
   */
  public  java.lang.String getTruncateQuery (java.lang.String table, scala.Option<java.lang.Object> cascade)  { throw new RuntimeException(); }
  public  java.lang.String renameTable (java.lang.String oldTable, java.lang.String newTable)  { throw new RuntimeException(); }
}
