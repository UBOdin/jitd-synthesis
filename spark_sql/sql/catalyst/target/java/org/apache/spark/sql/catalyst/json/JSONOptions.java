package org.apache.spark.sql.catalyst.json;
/**
 * Options for parsing JSON data into Spark SQL rows.
 * <p>
 * Most of these map directly to Jackson's internal options, specified in {@link JsonReadFeature}.
 */
  class JSONOptions implements org.apache.spark.internal.Logging, scala.Serializable {
  public  org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters ()  { throw new RuntimeException(); }
  // not preceding
  public   JSONOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public   JSONOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public  double samplingRatio ()  { throw new RuntimeException(); }
  public  boolean primitivesAsString ()  { throw new RuntimeException(); }
  public  boolean prefersDecimal ()  { throw new RuntimeException(); }
  public  boolean allowComments ()  { throw new RuntimeException(); }
  public  boolean allowUnquotedFieldNames ()  { throw new RuntimeException(); }
  public  boolean allowSingleQuotes ()  { throw new RuntimeException(); }
  public  boolean allowNumericLeadingZeros ()  { throw new RuntimeException(); }
  public  boolean allowNonNumericNumbers ()  { throw new RuntimeException(); }
  public  boolean allowBackslashEscapingAnyCharacter ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> compressionCodec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ParseMode parseMode ()  { throw new RuntimeException(); }
  public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  public  boolean dropFieldIfAllNull ()  { throw new RuntimeException(); }
  public  boolean ignoreNullFields ()  { throw new RuntimeException(); }
  public  java.util.Locale locale ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  java.lang.String dateFormat ()  { throw new RuntimeException(); }
  public  java.lang.String timestampFormat ()  { throw new RuntimeException(); }
  public  boolean multiLine ()  { throw new RuntimeException(); }
  /**
   * A string between two consecutive JSON records.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> lineSeparator ()  { throw new RuntimeException(); }
  protected  java.lang.String checkedEncoding (java.lang.String enc)  { throw new RuntimeException(); }
  /**
   * Standard encoding (charset) name. For example UTF-8, UTF-16LE and UTF-32BE.
   * If the encoding is not specified (None) in read, it will be detected automatically
   * when the multiLine option is set to <code>true</code>. If encoding is not specified in write,
   * UTF-8 is used by default.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> encoding ()  { throw new RuntimeException(); }
  public  scala.Option<byte[]> lineSeparatorInRead ()  { throw new RuntimeException(); }
  public  java.lang.String lineSeparatorInWrite ()  { throw new RuntimeException(); }
  /**
   * Generating JSON strings in pretty representation if the parameter is enabled.
   * @return (undocumented)
   */
  public  boolean pretty ()  { throw new RuntimeException(); }
  /**
   * Enables inferring of TimestampType from strings matched to the timestamp pattern
   * defined by the timestampFormat option.
   * @return (undocumented)
   */
  public  boolean inferTimestamp ()  { throw new RuntimeException(); }
  /** Build a Jackson {@link JsonFactory} using JSON options. */
  public  com.fasterxml.jackson.core.JsonFactory buildJsonFactory ()  { throw new RuntimeException(); }
}
