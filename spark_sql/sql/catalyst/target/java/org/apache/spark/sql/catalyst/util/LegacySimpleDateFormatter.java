package org.apache.spark.sql.catalyst.util;
/**
 * The legacy formatter is based on <code>java.text.SimpleDateFormat</code>. The formatter uses the default
 * JVM time zone intentionally for compatibility with Spark 2.4 and earlier versions.
 * <p>
 * Note: Using of the default JVM time zone makes the formatter compatible with the legacy
 *       <code>DateTimeUtils</code> methods <code>toJavaDate</code> and <code>fromJavaDate</code> that are based on the default
 *       JVM time zone too.
 * <p>
 * param:  pattern The pattern describing the date and time format.
 *                See <a href="https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html">
 *                Date and Time Patterns</a>
 * param:  locale  The locale whose date format symbols should be used. It overrides the system
 *                locale in parsing/formatting.
 */
public  class LegacySimpleDateFormatter implements org.apache.spark.sql.catalyst.util.LegacyDateFormatter {
  public   LegacySimpleDateFormatter (java.lang.String pattern, java.util.Locale locale)  { throw new RuntimeException(); }
  public  java.lang.String format (java.util.Date d)  { throw new RuntimeException(); }
  public  java.util.Date parseToDate (java.lang.String s)  { throw new RuntimeException(); }
  public  void validatePatternString ()  { throw new RuntimeException(); }
}
