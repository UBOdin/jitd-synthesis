package org.apache.spark.sql.catalyst.util;
public  class LegacySimpleTimestampFormatter implements org.apache.spark.sql.catalyst.util.TimestampFormatter {
  public   LegacySimpleTimestampFormatter (java.lang.String pattern, java.time.ZoneId zoneId, java.util.Locale locale, boolean lenient)  { throw new RuntimeException(); }
  public  long parse (java.lang.String s)  { throw new RuntimeException(); }
  public  java.lang.String format (long us)  { throw new RuntimeException(); }
  public  java.lang.String format (java.sql.Timestamp ts)  { throw new RuntimeException(); }
  public  java.lang.String format (java.time.Instant instant)  { throw new RuntimeException(); }
  public  void validatePatternString ()  { throw new RuntimeException(); }
}
