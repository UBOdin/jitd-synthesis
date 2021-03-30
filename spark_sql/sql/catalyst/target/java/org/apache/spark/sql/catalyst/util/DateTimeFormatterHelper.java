package org.apache.spark.sql.catalyst.util;
public  interface DateTimeFormatterHelper {
  public  int getOrDefault (java.time.temporal.TemporalAccessor accessor, java.time.temporal.ChronoField field, int default_)  ;
  public  void verifyLocalDate (java.time.temporal.TemporalAccessor accessor, java.time.temporal.ChronoField field, java.time.LocalDate candidate)  ;
  public  java.time.LocalDate toLocalDate (java.time.temporal.TemporalAccessor accessor)  ;
  public  java.time.LocalTime toLocalTime (java.time.temporal.TemporalAccessor accessor)  ;
  public  java.time.ZonedDateTime toZonedDateTime (java.time.temporal.TemporalAccessor accessor, java.time.ZoneId zoneId)  ;
  public  java.time.format.DateTimeFormatter getOrCreateFormatter (java.lang.String pattern, java.util.Locale locale, boolean isParsing)  ;
  public  boolean needConvertToSparkUpgradeException (java.lang.Throwable e)  ;
  public <T extends java.lang.Object> scala.PartialFunction<java.lang.Throwable, T> checkParsedDiff (java.lang.String s, scala.Function1<java.lang.String, T> legacyParseFunc)  ;
  public <T extends java.util.Date> scala.PartialFunction<java.lang.Throwable, java.lang.String> checkFormattedDiff (T d, scala.Function1<T, java.lang.String> legacyFormatFunc)  ;
  /**
   * When the new DateTimeFormatter failed to initialize because of invalid datetime pattern, it
   * will throw IllegalArgumentException. If the pattern can be recognized by the legacy formatter
   * it will raise SparkUpgradeException to tell users to restore the previous behavior via LEGACY
   * policy or follow our guide to correct their pattern. Otherwise, the original
   * IllegalArgumentException will be thrown.
   * <p>
   * @param pattern the date time pattern
   * @param tryLegacyFormatter a func to capture exception, identically which forces a legacy
   *                           datetime formatter to be initialized
   * @return (undocumented)
   */
  public  scala.PartialFunction<java.lang.Throwable, java.time.format.DateTimeFormatter> checkLegacyFormatter (java.lang.String pattern, scala.Function0<scala.runtime.BoxedUnit> tryLegacyFormatter)  ;
}
