package org.apache.spark.sql.catalyst.parser;
/**
 * The post-processor validates &amp; cleans-up the parse tree during the parse process.
 */
public  class PostProcessor$ extends org.apache.spark.sql.catalyst.parser.SqlBaseBaseListener implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PostProcessor$ MODULE$ = null;
  public   PostProcessor$ ()  { throw new RuntimeException(); }
  /** Throws error message when exiting a explicitly captured wrong identifier rule */
  public  void exitErrorIdent (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ErrorIdentContext ctx)  { throw new RuntimeException(); }
  /** Remove the back ticks from an Identifier. */
  public  void exitQuotedIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QuotedIdentifierContext ctx)  { throw new RuntimeException(); }
  /** Treat non-reserved keywords as Identifiers. */
  public  void exitNonReserved (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NonReservedContext ctx)  { throw new RuntimeException(); }
}
