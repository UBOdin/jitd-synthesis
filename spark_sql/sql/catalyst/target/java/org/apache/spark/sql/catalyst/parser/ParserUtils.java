package org.apache.spark.sql.catalyst.parser;
/**
 * A collection of utility methods for use during the parsing process.
 */
public  class ParserUtils {
  /** Some syntactic sugar which makes it easier to work with optional clauses for LogicalPlans. */
  static public  class EnhancedLogicalPlan extends scala.AnyVal {
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
    // not preceding
    public   EnhancedLogicalPlan (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
    /**
     * Create a plan using the block of code when the given context exists. Otherwise return the
     * original plan.
     * @param ctx (undocumented)
     * @param f (undocumented)
     * @return (undocumented)
     */
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optional (java.lang.Object ctx, scala.Function0<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> f)  { throw new RuntimeException(); }
    /**
     * Map a {@link LogicalPlan} to another {@link LogicalPlan} if the passed context exists using the
     * passed function. The original plan is returned when the context does not exist.
     * @param ctx (undocumented)
     * @param f (undocumented)
     * @return (undocumented)
     */
    public <C extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optionalMap (C ctx, scala.Function2<C, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> f)  { throw new RuntimeException(); }
  }
  static public  class EnhancedLogicalPlan$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final EnhancedLogicalPlan$ MODULE$ = null;
    public   EnhancedLogicalPlan$ ()  { throw new RuntimeException(); }
  }
  static public  scala.util.matching.Regex U16_CHAR_PATTERN ()  { throw new RuntimeException(); }
  static public  scala.util.matching.Regex U32_CHAR_PATTERN ()  { throw new RuntimeException(); }
  static public  scala.util.matching.Regex OCTAL_CHAR_PATTERN ()  { throw new RuntimeException(); }
  static public  scala.util.matching.Regex ESCAPED_CHAR_PATTERN ()  { throw new RuntimeException(); }
  /** Get the command which created the token. */
  static public  java.lang.String command (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  static public  scala.runtime.Nothing$ operationNotAllowed (java.lang.String message, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> void checkDuplicateClauses (java.util.List<T> nodes, java.lang.String clauseName, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Check if duplicate keys exist in a set of key-value pairs. */
  static public <T extends java.lang.Object> void checkDuplicateKeys (scala.collection.Seq<scala.Tuple2<java.lang.String, T>> keyPairs, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get the code that creates the given node. */
  static public  java.lang.String source (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get all the text which comes after the given rule. */
  static public  java.lang.String remainder (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /** Get all the text which comes after the given token. */
  static public  java.lang.String remainder (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /**
   * Get all the text which between the given start and end tokens.
   * When we need to extract everything between two tokens including all spaces we should use
   * this method instead of defined a named Antlr4 rule for .*?,
   * which somehow parse "a b" -> "ab" in some cases
   * @param start (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String interval (org.antlr.v4.runtime.Token start, org.antlr.v4.runtime.Token end)  { throw new RuntimeException(); }
  /** Convert a string token into a string. */
  static public  java.lang.String string (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /** Convert a string node into a string. */
  static public  java.lang.String string (org.antlr.v4.runtime.tree.TerminalNode node)  { throw new RuntimeException(); }
  /** Convert a string node into a string without unescaping. */
  static public  java.lang.String stringWithoutUnescape (org.antlr.v4.runtime.tree.TerminalNode node)  { throw new RuntimeException(); }
  /** Collect the entries if any. */
  static public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> entry (java.lang.String key, org.antlr.v4.runtime.Token value)  { throw new RuntimeException(); }
  /** Get the origin (line and position) of the token. */
  static public  org.apache.spark.sql.catalyst.trees.Origin position (org.antlr.v4.runtime.Token token)  { throw new RuntimeException(); }
  /** Validate the condition. If it doesn't throw a parse exception. */
  static public  void validate (scala.Function0<java.lang.Object> f, java.lang.String message, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /**
   * Register the origin of the context. Any TreeNode created in the closure will be assigned the
   * registered origin. This method restores the previously set origin after completion of the
   * closure.
   * @param ctx (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T withOrigin (org.antlr.v4.runtime.ParserRuleContext ctx, scala.Function0<T> f)  { throw new RuntimeException(); }
  /** Unescape backslash-escaped string enclosed by quotes. */
  static public  java.lang.String unescapeSQLString (java.lang.String b)  { throw new RuntimeException(); }
  /** the column name pattern in quoted regex without qualifier */
  static public  scala.util.matching.Regex escapedIdentifier ()  { throw new RuntimeException(); }
  /** the column name pattern in quoted regex with qualifier */
  static public  scala.util.matching.Regex qualifiedEscapedIdentifier ()  { throw new RuntimeException(); }
}
