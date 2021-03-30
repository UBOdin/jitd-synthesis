package org.apache.spark.sql.catalyst.util;
public  class StringUtils {
  /**
   * Concatenation of sequence of strings to final string with cheap append method
   * and one memory allocation for the final string.  Can also bound the final size of
   * the string.
   */
  static public  class StringConcat {
    public  int maxLength ()  { throw new RuntimeException(); }
    // not preceding
    public   StringConcat (int maxLength)  { throw new RuntimeException(); }
    protected  scala.collection.mutable.ArrayBuffer<java.lang.String> strings ()  { throw new RuntimeException(); }
    protected  int length ()  { throw new RuntimeException(); }
    public  boolean atLimit ()  { throw new RuntimeException(); }
    /**
     * Appends a string and accumulates its length to allocate a string buffer for all
     * appended strings once in the toString method.  Returns true if the string still
     * has room for further appends before it hits its max limit.
     * @param s (undocumented)
     */
    public  void append (java.lang.String s)  { throw new RuntimeException(); }
    /**
     * The method allocates memory for all appended strings, writes them to the memory and
     * returns concatenated string.
     * @return (undocumented)
     */
    public  java.lang.String toString ()  { throw new RuntimeException(); }
  }
  static public  class StringConcat$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final StringConcat$ MODULE$ = null;
    public   StringConcat$ ()  { throw new RuntimeException(); }
  }
  /**
   * A string concatenator for plan strings.  Uses length from a configured value, and
   *  prints a warning the first time a plan is truncated.
   */
  static public  class PlanStringConcat extends org.apache.spark.sql.catalyst.util.StringUtils.StringConcat {
    public   PlanStringConcat ()  { throw new RuntimeException(); }
    public  java.lang.String toString ()  { throw new RuntimeException(); }
  }
  /**
   * Validate and convert SQL 'like' pattern to a Java regular expression.
   * <p>
   * Underscores (_) are converted to '.' and percent signs (%) are converted to '.*', other
   * characters are quoted literally. Escaping is done according to the rules specified in
   * {@link org.apache.spark.sql.catalyst.expressions.Like} usage documentation. An invalid pattern will
   * throw an {@link AnalysisException}.
   * <p>
   * @param pattern the SQL pattern to convert
   * @param escapeChar the escape string contains one character.
   * @return the equivalent Java regular expression of the pattern
   */
  static public  java.lang.String escapeLikeRegex (java.lang.String pattern, char escapeChar)  { throw new RuntimeException(); }
  static public  boolean isTrueString (org.apache.spark.unsafe.types.UTF8String s)  { throw new RuntimeException(); }
  static public  boolean isFalseString (org.apache.spark.unsafe.types.UTF8String s)  { throw new RuntimeException(); }
  /**
   * This utility can be used for filtering pattern in the "Like" of "Show Tables / Functions" DDL
   * @param names the names list to be filtered
   * @param pattern the filter pattern, only '*' and '|' are allowed as wildcards, others will
   *                follow regular expression convention, case insensitive match and white spaces
   *                on both ends will be ignored
   * @return the filtered names list in order
   */
  static public  scala.collection.Seq<java.lang.String> filterPattern (scala.collection.Seq<java.lang.String> names, java.lang.String pattern)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
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
}
