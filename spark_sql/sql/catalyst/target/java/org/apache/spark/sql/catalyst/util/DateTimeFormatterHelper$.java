package org.apache.spark.sql.catalyst.util;
public  class DateTimeFormatterHelper$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DateTimeFormatterHelper$ MODULE$ = null;
  public   DateTimeFormatterHelper$ ()  { throw new RuntimeException(); }
  public  com.google.common.cache.Cache<scala.Tuple3<java.lang.String, java.util.Locale, java.lang.Object>, java.time.format.DateTimeFormatter> cache ()  { throw new RuntimeException(); }
  public final  scala.util.matching.Regex extractor ()  { throw new RuntimeException(); }
  public  java.time.format.DateTimeFormatterBuilder createBuilder ()  { throw new RuntimeException(); }
  public  java.time.format.DateTimeFormatter toFormatter (java.time.format.DateTimeFormatterBuilder builder, java.util.Locale locale)  { throw new RuntimeException(); }
  /**
   * Building a formatter for parsing seconds fraction with variable length
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  java.time.format.DateTimeFormatterBuilder createBuilderWithVarLengthSecondFraction (java.lang.String pattern)  { throw new RuntimeException(); }
  public  java.time.format.DateTimeFormatter buildFormatter (java.lang.String pattern, java.util.Locale locale, boolean varLenEnabled)  { throw new RuntimeException(); }
  // not preceding
  public  java.time.format.DateTimeFormatter fractionFormatter ()  { throw new RuntimeException(); }
  public final  scala.collection.immutable.Set<java.lang.Object> weekBasedLetters ()  { throw new RuntimeException(); }
  public final  scala.collection.immutable.Set<java.lang.Object> unsupportedLetters ()  { throw new RuntimeException(); }
  public final  scala.collection.immutable.Set<java.lang.Object> unsupportedLettersForParsing ()  { throw new RuntimeException(); }
  public final  scala.collection.immutable.Set<java.lang.String> unsupportedPatternLengths ()  { throw new RuntimeException(); }
  /**
   * In Spark 3.0, we switch to the Proleptic Gregorian calendar and use DateTimeFormatter for
   * parsing/formatting datetime values. The pattern string is incompatible with the one defined
   * by SimpleDateFormat in Spark 2.4 and earlier. This function converts all incompatible pattern
   * for the new parser in Spark 3.0. See more details in SPARK-31030.
   * @param pattern The input pattern.
   * @return The pattern for new parser
   * @param isParsing (undocumented)
   */
  public  java.lang.String convertIncompatiblePattern (java.lang.String pattern, boolean isParsing)  { throw new RuntimeException(); }
}
