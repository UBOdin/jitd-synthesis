package org.apache.spark.sql.catalyst.util;
public  class Iso8601TimestampFormatter implements org.apache.spark.sql.catalyst.util.TimestampFormatter, org.apache.spark.sql.catalyst.util.DateTimeFormatterHelper {
  public   Iso8601TimestampFormatter (java.lang.String pattern, java.time.ZoneId zoneId, java.util.Locale locale, scala.Enumeration.Value legacyFormat, boolean isParsing)  { throw new RuntimeException(); }
  // not preceding
  protected  java.time.format.DateTimeFormatter formatter ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.util.TimestampFormatter legacyFormatter ()  { throw new RuntimeException(); }
  public  long parse (java.lang.String s)  { throw new RuntimeException(); }
  public  java.lang.String format (java.time.Instant instant)  { throw new RuntimeException(); }
  public  java.lang.String format (long us)  { throw new RuntimeException(); }
  public  java.lang.String format (java.sql.Timestamp ts)  { throw new RuntimeException(); }
  public  void validatePatternString ()  { throw new RuntimeException(); }
}
