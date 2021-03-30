package org.apache.spark.sql.jdbc;
public  class DerbyDialect$ extends org.apache.spark.sql.jdbc.JdbcDialect {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DerbyDialect$ MODULE$ = null;
  public   DerbyDialect$ ()  { throw new RuntimeException(); }
  public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> getCatalystType (int sqlType, java.lang.String typeName, int size, org.apache.spark.sql.types.MetadataBuilder md)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.jdbc.JdbcType> getJDBCType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> isCascadingTruncateTable ()  { throw new RuntimeException(); }
  public  java.lang.String renameTable (java.lang.String oldTable, java.lang.String newTable)  { throw new RuntimeException(); }
  public  java.lang.String getTableCommentQuery (java.lang.String table, java.lang.String comment)  { throw new RuntimeException(); }
}
