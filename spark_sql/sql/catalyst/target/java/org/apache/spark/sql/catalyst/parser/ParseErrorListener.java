package org.apache.spark.sql.catalyst.parser;
/**
 * The ParseErrorListener converts parse errors into AnalysisExceptions.
 */
public  class ParseErrorListener {
  static public  void syntaxError (org.antlr.v4.runtime.Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, java.lang.String msg, org.antlr.v4.runtime.RecognitionException e)  { throw new RuntimeException(); }
  static public  void reportAmbiguity (org.antlr.v4.runtime.Parser x$1, org.antlr.v4.runtime.dfa.DFA x$2, int x$3, int x$4, boolean x$5, java.util.BitSet x$6, org.antlr.v4.runtime.atn.ATNConfigSet x$7)  { throw new RuntimeException(); }
  static public  void reportAttemptingFullContext (org.antlr.v4.runtime.Parser x$1, org.antlr.v4.runtime.dfa.DFA x$2, int x$3, int x$4, java.util.BitSet x$5, org.antlr.v4.runtime.atn.ATNConfigSet x$6)  { throw new RuntimeException(); }
  static public  void reportContextSensitivity (org.antlr.v4.runtime.Parser x$1, org.antlr.v4.runtime.dfa.DFA x$2, int x$3, int x$4, int x$5, org.antlr.v4.runtime.atn.ATNConfigSet x$6)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
