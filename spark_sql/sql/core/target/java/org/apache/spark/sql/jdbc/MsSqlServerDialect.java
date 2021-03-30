package org.apache.spark.sql.jdbc;
public  class MsSqlServerDialect {
  static public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> getCatalystType (int sqlType, java.lang.String typeName, int size, org.apache.spark.sql.types.MetadataBuilder md)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.jdbc.JdbcType> getJDBCType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static public  scala.Option<java.lang.Object> isCascadingTruncateTable ()  { throw new RuntimeException(); }
  static public  java.lang.String renameTable (java.lang.String oldTable, java.lang.String newTable)  { throw new RuntimeException(); }
  static public  java.lang.String getAddColumnQuery (java.lang.String tableName, java.lang.String columnName, java.lang.String dataType)  { throw new RuntimeException(); }
  static public  java.lang.String getRenameColumnQuery (java.lang.String tableName, java.lang.String columnName, java.lang.String newName, int dbMajorVersion)  { throw new RuntimeException(); }
  static public  java.lang.String getUpdateColumnNullabilityQuery (java.lang.String tableName, java.lang.String columnName, boolean isNullable)  { throw new RuntimeException(); }
  static public  java.lang.String getTableCommentQuery (java.lang.String table, java.lang.String comment)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static public  java.lang.String quoteIdentifier (java.lang.String colName)  { throw new RuntimeException(); }
  static public  java.lang.String getTableExistsQuery (java.lang.String table)  { throw new RuntimeException(); }
  static public  java.lang.String getSchemaQuery (java.lang.String table)  { throw new RuntimeException(); }
  static public  java.lang.String getTruncateQuery (java.lang.String table)  { throw new RuntimeException(); }
  static public  java.lang.String getTruncateQuery (java.lang.String table, scala.Option<java.lang.Object> cascade)  { throw new RuntimeException(); }
  static public  scala.Option<java.lang.Object> getTruncateQuery$default$2 ()  { throw new RuntimeException(); }
  static public  void beforeFetch (java.sql.Connection connection, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  static protected  java.lang.String escapeSql (java.lang.String value)  { throw new RuntimeException(); }
  static public  Object compileValue (Object value)  { throw new RuntimeException(); }
  static public  java.lang.String[] alterTable (java.lang.String tableName, scala.collection.Seq<org.apache.spark.sql.connector.catalog.TableChange> changes, int dbMajorVersion)  { throw new RuntimeException(); }
  static public  java.lang.String getDeleteColumnQuery (java.lang.String tableName, java.lang.String columnName)  { throw new RuntimeException(); }
  static public  java.lang.String getUpdateColumnTypeQuery (java.lang.String tableName, java.lang.String columnName, java.lang.String newDataType)  { throw new RuntimeException(); }
  static public  java.lang.String getSchemaCommentQuery (java.lang.String schema, java.lang.String comment)  { throw new RuntimeException(); }
  static public  java.lang.String removeSchemaCommentQuery (java.lang.String schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.AnalysisException classifyException (java.lang.String message, java.lang.Throwable e)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
