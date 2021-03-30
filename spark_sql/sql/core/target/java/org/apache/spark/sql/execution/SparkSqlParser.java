package org.apache.spark.sql.execution;
/**
 * Concrete parser for Spark SQL statements.
 */
public  class SparkSqlParser extends org.apache.spark.sql.catalyst.parser.AbstractSqlParser {
  public   SparkSqlParser ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkSqlAstBuilder astBuilder ()  { throw new RuntimeException(); }
  protected <T extends java.lang.Object> T parse (java.lang.String command, scala.Function1<org.apache.spark.sql.catalyst.parser.SqlBaseParser, T> toResult)  { throw new RuntimeException(); }
}
