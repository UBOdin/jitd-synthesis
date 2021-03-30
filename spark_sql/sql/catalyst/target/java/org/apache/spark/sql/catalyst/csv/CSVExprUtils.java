package org.apache.spark.sql.catalyst.csv;
public  class CSVExprUtils {
  /**
   * Filter ignorable rows for CSV iterator (lines empty and starting with <code>comment</code>).
   * This is currently being used in CSV reading path and CSV schema inference.
   * @param iter (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<java.lang.String> filterCommentAndEmpty (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<java.lang.String> skipComments (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Extracts header and moves iterator forward so that only data remains in it
   * @param iter (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.String> extractHeader (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Helper method that converts string representation of a character to actual character.
   * It handles some Java escaped strings and throws exception if given string is longer than one
   * character.
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  char toChar (java.lang.String str) throws java.lang.IllegalArgumentException { throw new RuntimeException(); }
  /**
   * Helper method that converts string representation of a character sequence to actual
   * delimiter characters. The input is processed in "chunks", and each chunk is converted
   * by calling {@link CSVExprUtils.toChar()}.  A chunk is either:
   * <ul>
   *   <li>a backslash followed by another character</li>
   *   <li>a non-backslash character by itself</li>
   * </ul>
   * , in that order of precedence. The result of the converting all chunks is returned as
   * a {@link String}.
   * <p>
   * <br/><br/>Examples:
   * <ul><li><code>\t</code> will result in a single tab character as the separator (same as before)
   * </li><li><code>|||</code> will result in a sequence of three pipe characters as the separator
   * </li><li><code>\\</code> will result in a single backslash as the separator (same as before)
   * </li><li><code>\.</code> will result in an error (since a dot is not a character that needs escaped)
   * </li><li><code>\\.</code> will result in a backslash, then dot, as the separator character sequence
   * </li><li><code>.\t.</code> will result in a dot, then tab, then dot as the separator character sequence
   * </li>
   * </ul>
   * <p>
   * @param str the string representing the sequence of separator characters
   * @return a {@link String} representing the multi-character delimiter
   * @throws IllegalArgumentException if any of the individual input chunks are illegal
   */
  static public  java.lang.String toDelimiterStr (java.lang.String str)  { throw new RuntimeException(); }
}
