package org.apache.spark.sql.catalyst.util;
/**
 * The legacy formatter is based on Apache Commons FastDateFormat. The formatter uses the default
 * JVM time zone intentionally for compatibility with Spark 2.4 and earlier versions.
 * <p>
 * Note: Using of the default JVM time zone makes the formatter compatible with the legacy
 *       <code>DateTimeUtils</code> methods <code>toJavaDate</code> and <code>fromJavaDate</code> that are based on the default
 *       JVM time zone too.
 * <p>
 * param:  pattern <code>java.text.SimpleDateFormat</code> compatible pattern.
 * param:  locale The locale overrides the system locale and is used in parsing/formatting.
 */
public  class LegacyFastDateFormatter implements org.apache.spark.sql.catalyst.util.LegacyDateFormatter {
  public   LegacyFastDateFormatter (java.lang.String pattern, java.util.Locale locale)  { throw new RuntimeException(); }
  public  java.lang.String format (java.util.Date d)  { throw new RuntimeException(); }
  public  java.util.Date parseToDate (java.lang.String s)  { throw new RuntimeException(); }
  public  void validatePatternString ()  { throw new RuntimeException(); }
}
