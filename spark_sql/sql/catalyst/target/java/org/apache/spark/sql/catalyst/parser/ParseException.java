package org.apache.spark.sql.catalyst.parser;
/**
 * A {@link ParseException} is an {@link AnalysisException} that is thrown during the parse process. It
 * contains fields and an extended error message that make reporting and diagnosing errors easier.
 */
public  class ParseException extends org.apache.spark.sql.AnalysisException {
  // not preceding
  public   ParseException (scala.Option<java.lang.String> command, java.lang.String message, org.apache.spark.sql.catalyst.trees.Origin start, org.apache.spark.sql.catalyst.trees.Origin stop)  { throw new RuntimeException(); }
  public   ParseException (java.lang.String message, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> command ()  { throw new RuntimeException(); }
  public  java.lang.String getMessage ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.Origin start ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.Origin stop ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.parser.ParseException withCommand (java.lang.String cmd)  { throw new RuntimeException(); }
}
