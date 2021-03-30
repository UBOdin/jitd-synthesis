package org.apache.spark.sql.catalyst.parser;
/**
 * A collection of utility methods for use during the parsing process.
 */
public  class ParserUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ParserUtils$ MODULE$ = null;
  public   ParserUtils$ ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex U16_CHAR_PATTERN ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex U32_CHAR_PATTERN ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex OCTAL_CHAR_PATTERN ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex ESCAPED_CHAR_PATTERN ()  { throw new RuntimeException(); }
  /** Get the command which created the token. */
  public  java.lang.String command (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  public  scala.runtime.Nothing$ operationNotAllowed (java.lang.String message, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> void checkDuplicateClauses (java.util.List<T> nodes, java.lang.String clauseName, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Check if duplicate keys exist in a set of key-value pairs. */
  public <T extends java.lang.Object> void checkDuplicateKeys (scala.collection.Seq<scala.Tuple2<java.lang.String, T>> keyPairs, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get the code that creates the given node. */
  public  java.lang.String source (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get all the text which comes after the given rule. */
  public  java.lang.String remainder (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get all the text which comes after the given token. */
  public  java.lang.String remainder (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /**
   * Get all the text which between the given start and end tokens.
   * When we need to extract everything between two tokens including all spaces we should use
   * this method instead of defined a named Antlr4 rule for .*?,
   * which somehow parse "a b" -> "ab" in some cases
   * @param start (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String interval (org.antlr.v4.runtime.Token start, org.antlr.v4.runtime.Token end)  { throw new RuntimeException(); }
  /** Convert a string token into a string. */
  public  java.lang.String string (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /** Convert a string node into a string. */
  public  java.lang.String string (org.antlr.v4.runtime.tree.TerminalNode node)  { throw new RuntimeException(); }
  /** Convert a string node into a string without unescaping. */
  public  java.lang.String stringWithoutUnescape (org.antlr.v4.runtime.tree.TerminalNode node)  { throw new RuntimeException(); }
  /** Collect the entries if any. */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> entry (java.lang.String key, org.antlr.v4.runtime.Token value)  { throw new RuntimeException(); }
  /** Get the origin (line and position) of the token. */
  public  org.apache.spark.sql.catalyst.trees.Origin position (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /** Validate the condition. If it doesn't throw a parse exception. */
  public  void validate (scala.Function0<java.lang.Object> f, java.lang.String message, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /**
   * Register the origin of the context. Any TreeNode created in the closure will be assigned the
   * registered origin. This method restores the previously set origin after completion of the
   * closure.
   * @param ctx (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T withOrigin (org.antlr.v4.runtime.ParserRuleContext ctx, scala.Function0<T> f)  { throw new RuntimeException(); }
  /** Unescape backslash-escaped string enclosed by quotes. */
  public  java.lang.String unescapeSQLString (java.lang.String b)  { throw new RuntimeException(); }
  /** the column name pattern in quoted regex without qualifier */
  public  scala.util.matching.Regex escapedIdentifier ()  { throw new RuntimeException(); }
  /** the column name pattern in quoted regex with qualifier */
  public  scala.util.matching.Regex qualifiedEscapedIdentifier ()  { throw new RuntimeException(); }
}
