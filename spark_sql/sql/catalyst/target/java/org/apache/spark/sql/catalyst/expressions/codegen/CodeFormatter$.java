package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * An utility class that indents a block of code based on the curly braces and parentheses.
 * This is used to prettify generated code when in debug mode (or exceptions).
 * <p>
 * Written by Matei Zaharia.
 */
public  class CodeFormatter$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CodeFormatter$ MODULE$ = null;
  public   CodeFormatter$ ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex commentHolder ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex commentRegexp ()  { throw new RuntimeException(); }
  public  scala.util.matching.Regex extraNewLinesRegexp ()  { throw new RuntimeException(); }
  public  java.lang.String format (org.apache.spark.sql.catalyst.expressions.codegen.CodeAndComment code, int maxLines)  { throw new RuntimeException(); }
  public  java.lang.String stripExtraNewLines (java.lang.String input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.CodeAndComment stripOverlappingComments (org.apache.spark.sql.catalyst.expressions.codegen.CodeAndComment codeAndComment)  { throw new RuntimeException(); }
  public  java.lang.String stripExtraNewLinesAndComments (java.lang.String input)  { throw new RuntimeException(); }
}
