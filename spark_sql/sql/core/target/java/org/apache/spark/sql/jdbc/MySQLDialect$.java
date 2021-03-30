package org.apache.spark.sql.jdbc;
public  class MySQLDialect$ extends org.apache.spark.sql.jdbc.JdbcDialect implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MySQLDialect$ MODULE$ = null;
  public   MySQLDialect$ ()  { throw new RuntimeException(); }
  public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> getCatalystType (int sqlType, java.lang.String typeName, int size, org.apache.spark.sql.types.MetadataBuilder md)  { throw new RuntimeException(); }
  public  java.lang.String quoteIdentifier (java.lang.String colName)  { throw new RuntimeException(); }
  public  java.lang.String getTableExistsQuery (java.lang.String table)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> isCascadingTruncateTable ()  { throw new RuntimeException(); }
  public  java.lang.String getUpdateColumnTypeQuery (java.lang.String tableName, java.lang.String columnName, java.lang.String newDataType)  { throw new RuntimeException(); }
  public  java.lang.String getRenameColumnQuery (java.lang.String tableName, java.lang.String columnName, java.lang.String newName, int dbMajorVersion)  { throw new RuntimeException(); }
  public  java.lang.String getUpdateColumnNullabilityQuery (java.lang.String tableName, java.lang.String columnName, boolean isNullable)  { throw new RuntimeException(); }
  public  java.lang.String getTableCommentQuery (java.lang.String table, java.lang.String comment)  { throw new RuntimeException(); }
}
