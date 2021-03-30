package org.apache.spark.sql.catalyst.util;
public  interface TimestampFormatter extends scala.Serializable {
  /**
   * Parses a timestamp in a string and converts it to microseconds.
   * <p>
   * @param s - string with timestamp to parse
   * @return microseconds since epoch.
   * @throws ParseException can be thrown by legacy parser
   * @throws DateTimeParseException can be thrown by new parser
   * @throws DateTimeException unable to obtain local date or time
   */
  public  long parse (java.lang.String s) throws java.text.ParseException, java.time.format.DateTimeParseException, java.time.DateTimeException ;
  public  java.lang.String format (long us)  ;
  public  java.lang.String format (java.sql.Timestamp ts)  ;
  public  java.lang.String format (java.time.Instant instant)  ;
  public  void validatePatternString ()  ;
}
