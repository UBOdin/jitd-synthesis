package org.apache.spark.sql.catalyst.csv;
public  class CSVOptions implements org.apache.spark.internal.Logging, scala.Serializable {
  // not preceding
  public   CSVOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, boolean columnPruning, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public   CSVOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, boolean columnPruning, java.lang.String defaultTimeZoneId)  { throw new RuntimeException(); }
  public   CSVOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, boolean columnPruning, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public  com.univocity.parsers.csv.CsvParserSettings asParserSettings ()  { throw new RuntimeException(); }
  public  com.univocity.parsers.csv.CsvWriterSettings asWriterSettings ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> charToEscapeQuoteEscaping ()  { throw new RuntimeException(); }
  public  java.lang.String charset ()  { throw new RuntimeException(); }
  public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  public  boolean columnPruning ()  { throw new RuntimeException(); }
  public  char comment ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> compressionCodec ()  { throw new RuntimeException(); }
  public  java.lang.String dateFormat ()  { throw new RuntimeException(); }
  public  java.lang.String delimiter ()  { throw new RuntimeException(); }
  /**
   * String representation of an empty value in read and in write.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> emptyValue ()  { throw new RuntimeException(); }
  /**
   * The string is returned when CSV reader doesn't have any characters for input value,
   * or an empty quoted string <code>""</code>. Default value is empty string.
   * @return (undocumented)
   */
  public  java.lang.String emptyValueInRead ()  { throw new RuntimeException(); }
  /**
   * The value is used instead of an empty string in write. Default value is <code>""</code>
   * @return (undocumented)
   */
  public  java.lang.String emptyValueInWrite ()  { throw new RuntimeException(); }
  /**
   * Forcibly apply the specified or inferred schema to datasource files.
   * If the option is enabled, headers of CSV files will be ignored.
   * @return (undocumented)
   */
  public  boolean enforceSchema ()  { throw new RuntimeException(); }
  public  char escape ()  { throw new RuntimeException(); }
  public  boolean escapeQuotes ()  { throw new RuntimeException(); }
  public  boolean headerFlag ()  { throw new RuntimeException(); }
  public  boolean ignoreLeadingWhiteSpaceFlagInWrite ()  { throw new RuntimeException(); }
  public  boolean ignoreLeadingWhiteSpaceInRead ()  { throw new RuntimeException(); }
  public  boolean ignoreTrailingWhiteSpaceFlagInWrite ()  { throw new RuntimeException(); }
  public  boolean ignoreTrailingWhiteSpaceInRead ()  { throw new RuntimeException(); }
  public  boolean inferSchemaFlag ()  { throw new RuntimeException(); }
  public  boolean isCommentSet ()  { throw new RuntimeException(); }
  /**
   * A string between two consecutive JSON records.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> lineSeparator ()  { throw new RuntimeException(); }
  public  scala.Option<byte[]> lineSeparatorInRead ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> lineSeparatorInWrite ()  { throw new RuntimeException(); }
  public  java.util.Locale locale ()  { throw new RuntimeException(); }
  public  int maxCharsPerColumn ()  { throw new RuntimeException(); }
  public  int maxColumns ()  { throw new RuntimeException(); }
  /**
   * The max error content length in CSV parser/writer exception message.
   * @return (undocumented)
   */
  public  int maxErrorContentLength ()  { throw new RuntimeException(); }
  public  boolean multiLine ()  { throw new RuntimeException(); }
  public  java.lang.String nanValue ()  { throw new RuntimeException(); }
  public  java.lang.String negativeInf ()  { throw new RuntimeException(); }
  public  java.lang.String nullValue ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ParseMode parseMode ()  { throw new RuntimeException(); }
  public  java.lang.String positiveInf ()  { throw new RuntimeException(); }
  public  char quote ()  { throw new RuntimeException(); }
  public  boolean quoteAll ()  { throw new RuntimeException(); }
  public  double samplingRatio ()  { throw new RuntimeException(); }
  public  java.lang.String timestampFormat ()  { throw new RuntimeException(); }
  /**
   * The handling method to be used when unescaped quotes are found in the input.
   * @return (undocumented)
   */
  public  com.univocity.parsers.csv.UnescapedQuoteHandling unescapedQuoteHandling ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
}
