package org.apache.spark.sql.catalyst.parser;
/**
 * Concrete SQL parser for Catalyst-only SQL statements.
 */
public  class CatalystSqlParser extends org.apache.spark.sql.catalyst.parser.AbstractSqlParser {
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
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
  static public  org.apache.spark.sql.types.DataType parseDataType (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression parseExpression (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.TableIdentifier parseTableIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.FunctionIdentifier parseFunctionIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<java.lang.String> parseMultipartIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType parseTableSchema (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan parsePlan (java.lang.String sqlText)  { throw new RuntimeException(); }
  static protected <T extends java.lang.Object> T parse (java.lang.String command, scala.Function1<org.apache.spark.sql.catalyst.parser.SqlBaseParser, T> toResult)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  public   CatalystSqlParser ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.parser.AstBuilder astBuilder ()  { throw new RuntimeException(); }
}
