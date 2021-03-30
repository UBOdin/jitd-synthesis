package org.apache.spark.sql;
/**
 * Interface used to load a {@link Dataset} from external storage systems (e.g. file systems,
 * key-value stores, etc). Use <code>SparkSession.read</code> to access this.
 * <p>
 * @since 1.4.0
 */
public  class DataFrameReader implements org.apache.spark.internal.Logging {
  // not preceding
     DataFrameReader (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Loads CSV files and returns the result as a <code>DataFrame</code>.
   * <p>
   * This function will go through the input once to determine the input schema if <code>inferSchema</code>
   * is enabled. To avoid going through the entire data once, disable <code>inferSchema</code> option or
   * specify the schema explicitly using <code>schema</code>.
   * <p>
   * You can set the following CSV-specific options to deal with CSV files:
   * <ul>
   * <li><code>sep</code> (default <code>,</code>): sets a separator for each field and value. This separator can be one
   * or more characters.</li>
   * <li><code>encoding</code> (default <code>UTF-8</code>): decodes the CSV files by the given encoding
   * type.</li>
   * <li><code>quote</code> (default <code>"</code>): sets a single character used for escaping quoted values where
   * the separator can be part of the value. If you would like to turn off quotations, you need to
   * set not <code>null</code> but an empty string. This behaviour is different from
   * <code>com.databricks.spark.csv</code>.</li>
   * <li><code>escape</code> (default <code>\</code>): sets a single character used for escaping quotes inside
   * an already quoted value.</li>
   * <li><code>charToEscapeQuoteEscaping</code> (default <code>escape</code> or <code>\0</code>): sets a single character used for
   * escaping the escape for the quote character. The default value is escape character when escape
   * and quote characters are different, <code>\0</code> otherwise.</li>
   * <li><code>comment</code> (default empty string): sets a single character used for skipping lines
   * beginning with this character. By default, it is disabled.</li>
   * <li><code>header</code> (default <code>false</code>): uses the first line as names of columns.</li>
   * <li><code>enforceSchema</code> (default <code>true</code>): If it is set to <code>true</code>, the specified or inferred schema
   * will be forcibly applied to datasource files, and headers in CSV files will be ignored.
   * If the option is set to <code>false</code>, the schema will be validated against all headers in CSV files
   * in the case when the <code>header</code> option is set to <code>true</code>. Field names in the schema
   * and column names in CSV headers are checked by their positions taking into account
   * <code>spark.sql.caseSensitive</code>. Though the default value is true, it is recommended to disable
   * the <code>enforceSchema</code> option to avoid incorrect results.</li>
   * <li><code>inferSchema</code> (default <code>false</code>): infers the input schema automatically from data. It
   * requires one extra pass over the data.</li>
   * <li><code>samplingRatio</code> (default is 1.0): defines fraction of rows used for schema inferring.</li>
   * <li><code>ignoreLeadingWhiteSpace</code> (default <code>false</code>): a flag indicating whether or not leading
   * whitespaces from values being read should be skipped.</li>
   * <li><code>ignoreTrailingWhiteSpace</code> (default <code>false</code>): a flag indicating whether or not trailing
   * whitespaces from values being read should be skipped.</li>
   * <li><code>nullValue</code> (default empty string): sets the string representation of a null value. Since
   * 2.0.1, this applies to all supported types including the string type.</li>
   * <li><code>emptyValue</code> (default empty string): sets the string representation of an empty value.</li>
   * <li><code>nanValue</code> (default <code>NaN</code>): sets the string representation of a non-number" value.</li>
   * <li><code>positiveInf</code> (default <code>Inf</code>): sets the string representation of a positive infinity
   * value.</li>
   * <li><code>negativeInf</code> (default <code>-Inf</code>): sets the string representation of a negative infinity
   * value.</li>
   * <li><code>dateFormat</code> (default <code>yyyy-MM-dd</code>): sets the string that indicates a date format.
   * Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to date type.</li>
   * <li><code>timestampFormat</code> (default <code>yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]</code>): sets the string that
   * indicates a timestamp format. Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to timestamp type.</li>
   * <li><code>maxColumns</code> (default <code>20480</code>): defines a hard limit of how many columns
   * a record can have.</li>
   * <li><code>maxCharsPerColumn</code> (default <code>-1</code>): defines the maximum number of characters allowed
   * for any given value being read. By default, it is -1 meaning unlimited length</li>
   * <li><code>unescapedQuoteHandling</code> (default <code>STOP_AT_DELIMITER</code>): defines how the CsvParser
   * will handle values with unescaped quotes.
   *   <ul>
   *     <li><code>STOP_AT_CLOSING_QUOTE</code>: If unescaped quotes are found in the input, accumulate
   *     the quote character and proceed parsing the value as a quoted value, until a closing
   *     quote is found.</li>
   *     <li><code>BACK_TO_DELIMITER</code>: If unescaped quotes are found in the input, consider the value
   *     as an unquoted value. This will make the parser accumulate all characters of the current
   *     parsed value until the delimiter is found. If no
   *     delimiter is found in the value, the parser will continue accumulating characters from
   *     the input until a delimiter or line ending is found.</li>
   *     <li><code>STOP_AT_DELIMITER</code>: If unescaped quotes are found in the input, consider the value
   *     as an unquoted value. This will make the parser accumulate all characters until the
   *     delimiter or a line ending is found in the input.</li>
   *     <li><code>STOP_AT_DELIMITER</code>: If unescaped quotes are found in the input, the content parsed
   *     for the given value will be skipped and the value set in nullValue will be produced
   *     instead.</li>
   *     <li><code>RAISE_ERROR</code>: If unescaped quotes are found in the input, a TextParsingException
   *     will be thrown.</li>
   *   </ul>
   * </li>
   * <li><code>mode</code> (default <code>PERMISSIVE</code>): allows a mode for dealing with corrupt records
   *    during parsing. It supports the following case-insensitive modes. Note that Spark tries
   *    to parse only required columns in CSV under column pruning. Therefore, corrupt records
   *    can be different based on required set of fields. This behavior can be controlled by
   *    <code>spark.sql.csv.parser.columnPruning.enabled</code> (enabled by default).
   *   <ul>
   *     <li><code>PERMISSIVE</code> : when it meets a corrupted record, puts the malformed string into a
   *     field configured by <code>columnNameOfCorruptRecord</code>, and sets malformed fields to <code>null</code>.
   *     To keep corrupt records, an user can set a string type field named
   *     <code>columnNameOfCorruptRecord</code> in an user-defined schema. If a schema does not have
   *     the field, it drops corrupt records during parsing. A record with less/more tokens
   *     than schema is not a corrupted record to CSV. When it meets a record having fewer
   *     tokens than the length of the schema, sets <code>null</code> to extra fields. When the record
   *     has more tokens than the length of the schema, it drops extra tokens.</li>
   *     <li><code>DROPMALFORMED</code> : ignores the whole corrupted records.</li>
   *     <li><code>FAILFAST</code> : throws an exception when it meets corrupted records.</li>
   *   </ul>
   * </li>
   * <li><code>columnNameOfCorruptRecord</code> (default is the value specified in
   * <code>spark.sql.columnNameOfCorruptRecord</code>): allows renaming the new field having malformed string
   * created by <code>PERMISSIVE</code> mode. This overrides <code>spark.sql.columnNameOfCorruptRecord</code>.</li>
   * <li><code>multiLine</code> (default <code>false</code>): parse one record, which may span multiple lines.</li>
   * <li><code>locale</code> (default is <code>en-US</code>): sets a locale as language tag in IETF BCP 47 format.
   * For instance, this is used while parsing dates and timestamps.</li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing. Maximum length is 1 character.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> csv (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads a CSV file and returns the result as a <code>DataFrame</code>. See the documentation on the
   * other overloaded <code>csv()</code> method for more details.
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> csv (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads an <code>Dataset[String]</code> storing CSV rows and returns the result as a <code>DataFrame</code>.
   * <p>
   * If the schema is not specified using <code>schema</code> function and <code>inferSchema</code> option is enabled,
   * this function goes through the input once to determine the input schema.
   * <p>
   * If the schema is not specified using <code>schema</code> function and <code>inferSchema</code> option is disabled,
   * it determines the columns as string types and it reads only the first line to determine the
   * names and the number of fields.
   * <p>
   * If the enforceSchema is set to <code>false</code>, only the CSV header in the first line is checked
   * to conform specified or inferred schema.
   * <p>
   * @note if <code>header</code> option is set to <code>true</code> when calling this API, all lines same with
   * the header will be removed if exists.
   * <p>
   * @param csvDataset input Dataset with one CSV row per record
   * @since 2.2.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> csv (org.apache.spark.sql.Dataset<java.lang.String> csvDataset)  { throw new RuntimeException(); }
  /**
   * Loads CSV files and returns the result as a <code>DataFrame</code>.
   * <p>
   * This function will go through the input once to determine the input schema if <code>inferSchema</code>
   * is enabled. To avoid going through the entire data once, disable <code>inferSchema</code> option or
   * specify the schema explicitly using <code>schema</code>.
   * <p>
   * You can set the following CSV-specific options to deal with CSV files:
   * <ul>
   * <li><code>sep</code> (default <code>,</code>): sets a separator for each field and value. This separator can be one
   * or more characters.</li>
   * <li><code>encoding</code> (default <code>UTF-8</code>): decodes the CSV files by the given encoding
   * type.</li>
   * <li><code>quote</code> (default <code>"</code>): sets a single character used for escaping quoted values where
   * the separator can be part of the value. If you would like to turn off quotations, you need to
   * set not <code>null</code> but an empty string. This behaviour is different from
   * <code>com.databricks.spark.csv</code>.</li>
   * <li><code>escape</code> (default <code>\</code>): sets a single character used for escaping quotes inside
   * an already quoted value.</li>
   * <li><code>charToEscapeQuoteEscaping</code> (default <code>escape</code> or <code>\0</code>): sets a single character used for
   * escaping the escape for the quote character. The default value is escape character when escape
   * and quote characters are different, <code>\0</code> otherwise.</li>
   * <li><code>comment</code> (default empty string): sets a single character used for skipping lines
   * beginning with this character. By default, it is disabled.</li>
   * <li><code>header</code> (default <code>false</code>): uses the first line as names of columns.</li>
   * <li><code>enforceSchema</code> (default <code>true</code>): If it is set to <code>true</code>, the specified or inferred schema
   * will be forcibly applied to datasource files, and headers in CSV files will be ignored.
   * If the option is set to <code>false</code>, the schema will be validated against all headers in CSV files
   * in the case when the <code>header</code> option is set to <code>true</code>. Field names in the schema
   * and column names in CSV headers are checked by their positions taking into account
   * <code>spark.sql.caseSensitive</code>. Though the default value is true, it is recommended to disable
   * the <code>enforceSchema</code> option to avoid incorrect results.</li>
   * <li><code>inferSchema</code> (default <code>false</code>): infers the input schema automatically from data. It
   * requires one extra pass over the data.</li>
   * <li><code>samplingRatio</code> (default is 1.0): defines fraction of rows used for schema inferring.</li>
   * <li><code>ignoreLeadingWhiteSpace</code> (default <code>false</code>): a flag indicating whether or not leading
   * whitespaces from values being read should be skipped.</li>
   * <li><code>ignoreTrailingWhiteSpace</code> (default <code>false</code>): a flag indicating whether or not trailing
   * whitespaces from values being read should be skipped.</li>
   * <li><code>nullValue</code> (default empty string): sets the string representation of a null value. Since
   * 2.0.1, this applies to all supported types including the string type.</li>
   * <li><code>emptyValue</code> (default empty string): sets the string representation of an empty value.</li>
   * <li><code>nanValue</code> (default <code>NaN</code>): sets the string representation of a non-number" value.</li>
   * <li><code>positiveInf</code> (default <code>Inf</code>): sets the string representation of a positive infinity
   * value.</li>
   * <li><code>negativeInf</code> (default <code>-Inf</code>): sets the string representation of a negative infinity
   * value.</li>
   * <li><code>dateFormat</code> (default <code>yyyy-MM-dd</code>): sets the string that indicates a date format.
   * Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to date type.</li>
   * <li><code>timestampFormat</code> (default <code>yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]</code>): sets the string that
   * indicates a timestamp format. Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to timestamp type.</li>
   * <li><code>maxColumns</code> (default <code>20480</code>): defines a hard limit of how many columns
   * a record can have.</li>
   * <li><code>maxCharsPerColumn</code> (default <code>-1</code>): defines the maximum number of characters allowed
   * for any given value being read. By default, it is -1 meaning unlimited length</li>
   * <li><code>unescapedQuoteHandling</code> (default <code>STOP_AT_DELIMITER</code>): defines how the CsvParser
   * will handle values with unescaped quotes.
   *   <ul>
   *     <li><code>STOP_AT_CLOSING_QUOTE</code>: If unescaped quotes are found in the input, accumulate
   *     the quote character and proceed parsing the value as a quoted value, until a closing
   *     quote is found.</li>
   *     <li><code>BACK_TO_DELIMITER</code>: If unescaped quotes are found in the input, consider the value
   *     as an unquoted value. This will make the parser accumulate all characters of the current
   *     parsed value until the delimiter is found. If no
   *     delimiter is found in the value, the parser will continue accumulating characters from
   *     the input until a delimiter or line ending is found.</li>
   *     <li><code>STOP_AT_DELIMITER</code>: If unescaped quotes are found in the input, consider the value
   *     as an unquoted value. This will make the parser accumulate all characters until the
   *     delimiter or a line ending is found in the input.</li>
   *     <li><code>STOP_AT_DELIMITER</code>: If unescaped quotes are found in the input, the content parsed
   *     for the given value will be skipped and the value set in nullValue will be produced
   *     instead.</li>
   *     <li><code>RAISE_ERROR</code>: If unescaped quotes are found in the input, a TextParsingException
   *     will be thrown.</li>
   *   </ul>
   * </li>
   * <li><code>mode</code> (default <code>PERMISSIVE</code>): allows a mode for dealing with corrupt records
   *    during parsing. It supports the following case-insensitive modes. Note that Spark tries
   *    to parse only required columns in CSV under column pruning. Therefore, corrupt records
   *    can be different based on required set of fields. This behavior can be controlled by
   *    <code>spark.sql.csv.parser.columnPruning.enabled</code> (enabled by default).
   *   <ul>
   *     <li><code>PERMISSIVE</code> : when it meets a corrupted record, puts the malformed string into a
   *     field configured by <code>columnNameOfCorruptRecord</code>, and sets malformed fields to <code>null</code>.
   *     To keep corrupt records, an user can set a string type field named
   *     <code>columnNameOfCorruptRecord</code> in an user-defined schema. If a schema does not have
   *     the field, it drops corrupt records during parsing. A record with less/more tokens
   *     than schema is not a corrupted record to CSV. When it meets a record having fewer
   *     tokens than the length of the schema, sets <code>null</code> to extra fields. When the record
   *     has more tokens than the length of the schema, it drops extra tokens.</li>
   *     <li><code>DROPMALFORMED</code> : ignores the whole corrupted records.</li>
   *     <li><code>FAILFAST</code> : throws an exception when it meets corrupted records.</li>
   *   </ul>
   * </li>
   * <li><code>columnNameOfCorruptRecord</code> (default is the value specified in
   * <code>spark.sql.columnNameOfCorruptRecord</code>): allows renaming the new field having malformed string
   * created by <code>PERMISSIVE</code> mode. This overrides <code>spark.sql.columnNameOfCorruptRecord</code>.</li>
   * <li><code>multiLine</code> (default <code>false</code>): parse one record, which may span multiple lines.</li>
   * <li><code>locale</code> (default is <code>en-US</code>): sets a locale as language tag in IETF BCP 47 format.
   * For instance, this is used while parsing dates and timestamps.</li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing. Maximum length is 1 character.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> csv (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Specifies the input data source format.
   * <p>
   * @since 1.4.0
   * @param source (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader format (java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Construct a <code>DataFrame</code> representing the database table accessible via JDBC URL
   * url named table and connection properties.
   * <p>
   * @since 1.4.0
   * @param url (undocumented)
   * @param table (undocumented)
   * @param properties (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table, java.util.Properties properties)  { throw new RuntimeException(); }
  /**
   * Construct a <code>DataFrame</code> representing the database table accessible via JDBC URL
   * url named table. Partitions of the table will be retrieved in parallel based on the parameters
   * passed to this function.
   * <p>
   * Don't create too many partitions in parallel on a large cluster; otherwise Spark might crash
   * your external database systems.
   * <p>
   * @param url JDBC database url of the form <code>jdbc:subprotocol:subname</code>.
   * @param table Name of the table in the external database.
   * @param columnName the name of a column of numeric, date, or timestamp type
   *                   that will be used for partitioning.
   * @param lowerBound the minimum value of <code>columnName</code> used to decide partition stride.
   * @param upperBound the maximum value of <code>columnName</code> used to decide partition stride.
   * @param numPartitions the number of partitions. This, along with <code>lowerBound</code> (inclusive),
   *                      <code>upperBound</code> (exclusive), form partition strides for generated WHERE
   *                      clause expressions used to split the column <code>columnName</code> evenly. When
   *                      the input is less than 1, the number is set to 1.
   * @param connectionProperties JDBC database connection arguments, a list of arbitrary string
   *                             tag/value. Normally at least a "user" and "password" property
   *                             should be included. "fetchsize" can be used to control the
   *                             number of rows per fetch and "queryTimeout" can be used to wait
   *                             for a Statement object to execute to the given number of seconds.
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table, java.lang.String columnName, long lowerBound, long upperBound, int numPartitions, java.util.Properties connectionProperties)  { throw new RuntimeException(); }
  /**
   * Construct a <code>DataFrame</code> representing the database table accessible via JDBC URL
   * url named table using connection properties. The <code>predicates</code> parameter gives a list
   * expressions suitable for inclusion in WHERE clauses; each one defines one partition
   * of the <code>DataFrame</code>.
   * <p>
   * Don't create too many partitions in parallel on a large cluster; otherwise Spark might crash
   * your external database systems.
   * <p>
   * @param url JDBC database url of the form <code>jdbc:subprotocol:subname</code>
   * @param table Name of the table in the external database.
   * @param predicates Condition in the where clause for each partition.
   * @param connectionProperties JDBC database connection arguments, a list of arbitrary string
   *                             tag/value. Normally at least a "user" and "password" property
   *                             should be included. "fetchsize" can be used to control the
   *                             number of rows per fetch.
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table, java.lang.String[] predicates, java.util.Properties connectionProperties)  { throw new RuntimeException(); }
  /**
   * Loads JSON files and returns the results as a <code>DataFrame</code>.
   * <p>
   * <a href="http://jsonlines.org/">JSON Lines</a> (newline-delimited JSON) is supported by
   * default. For JSON (one record per file), set the <code>multiLine</code> option to true.
   * <p>
   * This function goes through the input once to determine the input schema. If you know the
   * schema in advance, use the version that specifies the schema to avoid the extra scan.
   * <p>
   * You can set the following JSON-specific options to deal with non-standard JSON files:
   * <ul>
   * <li><code>primitivesAsString</code> (default <code>false</code>): infers all primitive values as a string type</li>
   * <li><code>prefersDecimal</code> (default <code>false</code>): infers all floating-point values as a decimal
   * type. If the values do not fit in decimal, then it infers them as doubles.</li>
   * <li><code>allowComments</code> (default <code>false</code>): ignores Java/C++ style comment in JSON records</li>
   * <li><code>allowUnquotedFieldNames</code> (default <code>false</code>): allows unquoted JSON field names</li>
   * <li><code>allowSingleQuotes</code> (default <code>true</code>): allows single quotes in addition to double quotes
   * </li>
   * <li><code>allowNumericLeadingZeros</code> (default <code>false</code>): allows leading zeros in numbers
   * (e.g. 00012)</li>
   * <li><code>allowBackslashEscapingAnyCharacter</code> (default <code>false</code>): allows accepting quoting of all
   * character using backslash quoting mechanism</li>
   * <li><code>allowUnquotedControlChars</code> (default <code>false</code>): allows JSON Strings to contain unquoted
   * control characters (ASCII characters with value less than 32, including tab and line feed
   * characters) or not.</li>
   * <li><code>mode</code> (default <code>PERMISSIVE</code>): allows a mode for dealing with corrupt records
   * during parsing.
   *   <ul>
   *     <li><code>PERMISSIVE</code> : when it meets a corrupted record, puts the malformed string into a
   *     field configured by <code>columnNameOfCorruptRecord</code>, and sets malformed fields to <code>null</code>. To
   *     keep corrupt records, an user can set a string type field named
   *     <code>columnNameOfCorruptRecord</code> in an user-defined schema. If a schema does not have the
   *     field, it drops corrupt records during parsing. When inferring a schema, it implicitly
   *     adds a <code>columnNameOfCorruptRecord</code> field in an output schema.</li>
   *     <li><code>DROPMALFORMED</code> : ignores the whole corrupted records.</li>
   *     <li><code>FAILFAST</code> : throws an exception when it meets corrupted records.</li>
   *   </ul>
   * </li>
   * <li><code>columnNameOfCorruptRecord</code> (default is the value specified in
   * <code>spark.sql.columnNameOfCorruptRecord</code>): allows renaming the new field having malformed string
   * created by <code>PERMISSIVE</code> mode. This overrides <code>spark.sql.columnNameOfCorruptRecord</code>.</li>
   * <li><code>dateFormat</code> (default <code>yyyy-MM-dd</code>): sets the string that indicates a date format.
   * Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to date type.</li>
   * <li><code>timestampFormat</code> (default <code>yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]</code>): sets the string that
   * indicates a timestamp format. Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to timestamp type.</li>
   * <li><code>multiLine</code> (default <code>false</code>): parse one record, which may span multiple lines,
   * per file</li>
   * <li><code>encoding</code> (by default it is not set): allows to forcibly set one of standard basic
   * or extended encoding for the JSON files. For example UTF-16BE, UTF-32LE. If the encoding
   * is not specified and <code>multiLine</code> is set to <code>true</code>, it will be detected automatically.</li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing.</li>
   * <li><code>samplingRatio</code> (default is 1.0): defines fraction of input JSON objects used
   * for schema inferring.</li>
   * <li><code>dropFieldIfAllNull</code> (default <code>false</code>): whether to ignore column of all null values or
   * empty array/struct during schema inference.</li>
   * <li><code>locale</code> (default is <code>en-US</code>): sets a locale as language tag in IETF BCP 47 format.
   * For instance, this is used while parsing dates and timestamps.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * <li><code>allowNonNumericNumbers</code> (default <code>true</code>): allows JSON parser to recognize set of
   * "Not-a-Number" (NaN) tokens as legal floating number values:
   *   <ul>
   *     <li><code>+INF</code> for positive infinity, as well as alias of <code>+Infinity</code> and <code>Infinity</code>.
   *     <li><code>-INF</code> for negative infinity), alias <code>-Infinity</code>.
   *     <li><code>NaN</code> for other not-a-numbers, like result of division by zero.
   *   </ul>
   * </li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads a JSON file and returns the results as a <code>DataFrame</code>.
   * <p>
   * See the documentation on the overloaded <code>json()</code> method with varargs for more details.
   * <p>
   * @since 1.4.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads JSON files and returns the results as a <code>DataFrame</code>.
   * <p>
   * <a href="http://jsonlines.org/">JSON Lines</a> (newline-delimited JSON) is supported by
   * default. For JSON (one record per file), set the <code>multiLine</code> option to true.
   * <p>
   * This function goes through the input once to determine the input schema. If you know the
   * schema in advance, use the version that specifies the schema to avoid the extra scan.
   * <p>
   * You can set the following JSON-specific options to deal with non-standard JSON files:
   * <ul>
   * <li><code>primitivesAsString</code> (default <code>false</code>): infers all primitive values as a string type</li>
   * <li><code>prefersDecimal</code> (default <code>false</code>): infers all floating-point values as a decimal
   * type. If the values do not fit in decimal, then it infers them as doubles.</li>
   * <li><code>allowComments</code> (default <code>false</code>): ignores Java/C++ style comment in JSON records</li>
   * <li><code>allowUnquotedFieldNames</code> (default <code>false</code>): allows unquoted JSON field names</li>
   * <li><code>allowSingleQuotes</code> (default <code>true</code>): allows single quotes in addition to double quotes
   * </li>
   * <li><code>allowNumericLeadingZeros</code> (default <code>false</code>): allows leading zeros in numbers
   * (e.g. 00012)</li>
   * <li><code>allowBackslashEscapingAnyCharacter</code> (default <code>false</code>): allows accepting quoting of all
   * character using backslash quoting mechanism</li>
   * <li><code>allowUnquotedControlChars</code> (default <code>false</code>): allows JSON Strings to contain unquoted
   * control characters (ASCII characters with value less than 32, including tab and line feed
   * characters) or not.</li>
   * <li><code>mode</code> (default <code>PERMISSIVE</code>): allows a mode for dealing with corrupt records
   * during parsing.
   *   <ul>
   *     <li><code>PERMISSIVE</code> : when it meets a corrupted record, puts the malformed string into a
   *     field configured by <code>columnNameOfCorruptRecord</code>, and sets malformed fields to <code>null</code>. To
   *     keep corrupt records, an user can set a string type field named
   *     <code>columnNameOfCorruptRecord</code> in an user-defined schema. If a schema does not have the
   *     field, it drops corrupt records during parsing. When inferring a schema, it implicitly
   *     adds a <code>columnNameOfCorruptRecord</code> field in an output schema.</li>
   *     <li><code>DROPMALFORMED</code> : ignores the whole corrupted records.</li>
   *     <li><code>FAILFAST</code> : throws an exception when it meets corrupted records.</li>
   *   </ul>
   * </li>
   * <li><code>columnNameOfCorruptRecord</code> (default is the value specified in
   * <code>spark.sql.columnNameOfCorruptRecord</code>): allows renaming the new field having malformed string
   * created by <code>PERMISSIVE</code> mode. This overrides <code>spark.sql.columnNameOfCorruptRecord</code>.</li>
   * <li><code>dateFormat</code> (default <code>yyyy-MM-dd</code>): sets the string that indicates a date format.
   * Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to date type.</li>
   * <li><code>timestampFormat</code> (default <code>yyyy-MM-dd'T'HH:mm:ss[.SSS][XXX]</code>): sets the string that
   * indicates a timestamp format. Custom date formats follow the formats at
   * <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>.
   * This applies to timestamp type.</li>
   * <li><code>multiLine</code> (default <code>false</code>): parse one record, which may span multiple lines,
   * per file</li>
   * <li><code>encoding</code> (by default it is not set): allows to forcibly set one of standard basic
   * or extended encoding for the JSON files. For example UTF-16BE, UTF-32LE. If the encoding
   * is not specified and <code>multiLine</code> is set to <code>true</code>, it will be detected automatically.</li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing.</li>
   * <li><code>samplingRatio</code> (default is 1.0): defines fraction of input JSON objects used
   * for schema inferring.</li>
   * <li><code>dropFieldIfAllNull</code> (default <code>false</code>): whether to ignore column of all null values or
   * empty array/struct during schema inference.</li>
   * <li><code>locale</code> (default is <code>en-US</code>): sets a locale as language tag in IETF BCP 47 format.
   * For instance, this is used while parsing dates and timestamps.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * <li><code>allowNonNumericNumbers</code> (default <code>true</code>): allows JSON parser to recognize set of
   * "Not-a-Number" (NaN) tokens as legal floating number values:
   *   <ul>
   *     <li><code>+INF</code> for positive infinity, as well as alias of <code>+Infinity</code> and <code>Infinity</code>.
   *     <li><code>-INF</code> for negative infinity), alias <code>-Infinity</code>.
   *     <li><code>NaN</code> for other not-a-numbers, like result of division by zero.
   *   </ul>
   * </li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Loads a <code>JavaRDD[String]</code> storing JSON objects (<a href="http://jsonlines.org/">JSON
   * Lines text format or newline-delimited JSON</a>) and returns the result as
   * a <code>DataFrame</code>.
   * <p>
   * Unless the schema is specified using <code>schema</code> function, this function goes through the
   * input once to determine the input schema.
   * <p>
   * @param jsonRDD input RDD with one JSON object per record
   * @since 1.4.0
   * @return (undocumented)
   *
   * @deprecated Use json(Dataset[String]) instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (org.apache.spark.api.java.JavaRDD<java.lang.String> jsonRDD)  { throw new RuntimeException(); }
  /**
   * Loads an <code>RDD[String]</code> storing JSON objects (<a href="http://jsonlines.org/">JSON Lines
   * text format or newline-delimited JSON</a>) and returns the result as a <code>DataFrame</code>.
   * <p>
   * Unless the schema is specified using <code>schema</code> function, this function goes through the
   * input once to determine the input schema.
   * <p>
   * @param jsonRDD input RDD with one JSON object per record
   * @since 1.4.0
   * @return (undocumented)
   *
   * @deprecated Use json(Dataset[String]) instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (org.apache.spark.rdd.RDD<java.lang.String> jsonRDD)  { throw new RuntimeException(); }
  /**
   * Loads a <code>Dataset[String]</code> storing JSON objects (<a href="http://jsonlines.org/">JSON Lines
   * text format or newline-delimited JSON</a>) and returns the result as a <code>DataFrame</code>.
   * <p>
   * Unless the schema is specified using <code>schema</code> function, this function goes through the
   * input once to determine the input schema.
   * <p>
   * @param jsonDataset input Dataset with one JSON object per record
   * @since 2.2.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> json (org.apache.spark.sql.Dataset<java.lang.String> jsonDataset)  { throw new RuntimeException(); }
  /**
   * Loads input in as a <code>DataFrame</code>, for data sources that support multiple paths.
   * Only works if the source is a HadoopFsRelationProvider.
   * <p>
   * @since 1.6.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads input in as a <code>DataFrame</code>, for data sources that don't require a path (e.g. external
   * key-value stores).
   * <p>
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load ()  { throw new RuntimeException(); }
  /**
   * Loads input in as a <code>DataFrame</code>, for data sources that require a path (e.g. data backed by
   * a local or distributed file system).
   * <p>
   * @since 1.4.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads input in as a <code>DataFrame</code>, for data sources that support multiple paths.
   * Only works if the source is a HadoopFsRelationProvider.
   * <p>
   * @since 1.6.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Adds an input option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to parse timestamps in the JSON/CSV datasources or partition values. The following
   * formats of <code>timeZone</code> are supported:
   *   <ul>
   *     <li> Region-based zone ID: It should have the form 'area/city', such as
   *         'America/Los_Angeles'.</li>
   *     <li> Zone offset: It should be in the format '(+|-)HH:mm', for example '-08:00'
   *          or '+01:00'. Also 'UTC' and 'Z' are supported as aliases of '+00:00'.</li>
   *   </ul>
   * Other short names like 'CST' are not recommended to use because they can be ambiguous.
   * If it isn't set, the current value of the SQL config <code>spark.sql.session.timeZone</code> is
   * used by default.
   * </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader option (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Adds an input option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader option (java.lang.String key, boolean value)  { throw new RuntimeException(); }
  /**
   * Adds an input option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader option (java.lang.String key, long value)  { throw new RuntimeException(); }
  /**
   * Adds an input option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader option (java.lang.String key, double value)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Adds input options for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to parse timestamps in the JSON/CSV datasources or partition values. The following
   * formats of <code>timeZone</code> are supported:
   *   <ul>
   *     <li> Region-based zone ID: It should have the form 'area/city', such as
   *         'America/Los_Angeles'.</li>
   *     <li> Zone offset: It should be in the format '(+|-)HH:mm', for example '-08:00'
   *          or '+01:00'. Also 'UTC' and 'Z' are supported as aliases of '+00:00'.</li>
   *   </ul>
   * Other short names like 'CST' are not recommended to use because they can be ambiguous.
   * If it isn't set, the current value of the SQL config <code>spark.sql.session.timeZone</code> is
   * used by default.
   * </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader options (scala.collection.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Adds input options for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to parse timestamps in the JSON/CSV datasources or partition values. The following
   * formats of <code>timeZone</code> are supported:
   *   <ul>
   *     <li> Region-based zone ID: It should have the form 'area/city', such as
   *         'America/Los_Angeles'.</li>
   *     <li> Zone offset: It should be in the format '(+|-)HH:mm', for example '-08:00'
   *          or '+01:00'. Also 'UTC' and 'Z' are supported as aliases of '+00:00'.</li>
   *   </ul>
   * Other short names like 'CST' are not recommended to use because they can be ambiguous.
   * If it isn't set, the current value of the SQL config <code>spark.sql.session.timeZone</code> is
   * used by default.
   * </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader options (java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Loads ORC files and returns the result as a <code>DataFrame</code>.
   * <p>
   * You can set the following ORC-specific option(s) for reading ORC files:
   * <ul>
   * <li><code>mergeSchema</code> (default is the value specified in <code>spark.sql.orc.mergeSchema</code>): sets whether
   * we should merge schemas collected from all ORC part-files. This will override
   * <code>spark.sql.orc.mergeSchema</code>.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @param paths input paths
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> orc (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads an ORC file and returns the result as a <code>DataFrame</code>.
   * <p>
   * @param path input path
   * @since 1.5.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> orc (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads ORC files and returns the result as a <code>DataFrame</code>.
   * <p>
   * You can set the following ORC-specific option(s) for reading ORC files:
   * <ul>
   * <li><code>mergeSchema</code> (default is the value specified in <code>spark.sql.orc.mergeSchema</code>): sets whether
   * we should merge schemas collected from all ORC part-files. This will override
   * <code>spark.sql.orc.mergeSchema</code>.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @param paths input paths
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> orc (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Loads a Parquet file, returning the result as a <code>DataFrame</code>.
   * <p>
   * You can set the following Parquet-specific option(s) for reading Parquet files:
   * <ul>
   * <li><code>mergeSchema</code> (default is the value specified in <code>spark.sql.parquet.mergeSchema</code>): sets
   * whether we should merge schemas collected from all Parquet part-files. This will override
   * <code>spark.sql.parquet.mergeSchema</code>.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * <li><code>datetimeRebaseMode</code> (default is the value specified in the SQL config
   * <code>spark.sql.parquet.datetimeRebaseModeInRead</code>): the rebasing mode for the values
   * of the <code>DATE</code>, <code>TIMESTAMP_MICROS</code>, <code>TIMESTAMP_MILLIS</code> logical types from the Julian to
   * Proleptic Gregorian calendar:
   *   <ul>
   *     <li><code>EXCEPTION</code> : Spark fails in reads of ancient dates/timestamps that are ambiguous
   *     between the two calendars</li>
   *     <li><code>CORRECTED</code> : loading of dates/timestamps without rebasing</li>
   *     <li><code>LEGACY</code> : perform rebasing of ancient dates/timestamps from the Julian to Proleptic
   *     Gregorian calendar</li>
   *   </ul>
   * </li>
   * <li><code>int96RebaseMode</code> (default is the value specified in the SQL config
   * <code>spark.sql.parquet.int96RebaseModeInRead</code>): the rebasing mode for <code>INT96</code> timestamps
   * from the Julian to Proleptic Gregorian calendar:
   *   <ul>
   *     <li><code>EXCEPTION</code> : Spark fails in reads of ancient <code>INT96</code> timestamps that are ambiguous
   *     between the two calendars</li>
   *     <li><code>CORRECTED</code> : loading of timestamps without rebasing</li>
   *     <li><code>LEGACY</code> : perform rebasing of ancient <code>INT96</code> timestamps from the Julian to Proleptic
   *     Gregorian calendar</li>
   *   </ul>
   * </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> parquet (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads a Parquet file, returning the result as a <code>DataFrame</code>. See the documentation
   * on the other overloaded <code>parquet()</code> method for more details.
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> parquet (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads a Parquet file, returning the result as a <code>DataFrame</code>.
   * <p>
   * You can set the following Parquet-specific option(s) for reading Parquet files:
   * <ul>
   * <li><code>mergeSchema</code> (default is the value specified in <code>spark.sql.parquet.mergeSchema</code>): sets
   * whether we should merge schemas collected from all Parquet part-files. This will override
   * <code>spark.sql.parquet.mergeSchema</code>.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * <li><code>datetimeRebaseMode</code> (default is the value specified in the SQL config
   * <code>spark.sql.parquet.datetimeRebaseModeInRead</code>): the rebasing mode for the values
   * of the <code>DATE</code>, <code>TIMESTAMP_MICROS</code>, <code>TIMESTAMP_MILLIS</code> logical types from the Julian to
   * Proleptic Gregorian calendar:
   *   <ul>
   *     <li><code>EXCEPTION</code> : Spark fails in reads of ancient dates/timestamps that are ambiguous
   *     between the two calendars</li>
   *     <li><code>CORRECTED</code> : loading of dates/timestamps without rebasing</li>
   *     <li><code>LEGACY</code> : perform rebasing of ancient dates/timestamps from the Julian to Proleptic
   *     Gregorian calendar</li>
   *   </ul>
   * </li>
   * <li><code>int96RebaseMode</code> (default is the value specified in the SQL config
   * <code>spark.sql.parquet.int96RebaseModeInRead</code>): the rebasing mode for <code>INT96</code> timestamps
   * from the Julian to Proleptic Gregorian calendar:
   *   <ul>
   *     <li><code>EXCEPTION</code> : Spark fails in reads of ancient <code>INT96</code> timestamps that are ambiguous
   *     between the two calendars</li>
   *     <li><code>CORRECTED</code> : loading of timestamps without rebasing</li>
   *     <li><code>LEGACY</code> : perform rebasing of ancient <code>INT96</code> timestamps from the Julian to Proleptic
   *     Gregorian calendar</li>
   *   </ul>
   * </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param paths (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> parquet (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Specifies the input schema. Some data sources (e.g. JSON) can infer the input schema
   * automatically from data. By specifying the schema here, the underlying data source can
   * skip the schema inference step, and thus speed up data loading.
   * <p>
   * @since 1.4.0
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader schema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Specifies the schema by using the input DDL-formatted string. Some data sources (e.g. JSON) can
   * infer the input schema automatically from data. By specifying the schema here, the underlying
   * data source can skip the schema inference step, and thus speed up data loading.
   * <p>
   * <pre><code>
   *   spark.read.schema("a INT, b STRING, c DOUBLE").csv("test.csv")
   * </code></pre>
   * <p>
   * @since 2.3.0
   * @param schemaString (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameReader schema (java.lang.String schemaString)  { throw new RuntimeException(); }
  /**
   * Returns the specified table/view as a <code>DataFrame</code>. If it's a table, it must support batch
   * reading and the returned DataFrame is the batch scan query plan of this table. If it's a view,
   * the returned DataFrame is simply the query plan of the view, which can either be a batch or
   * streaming query plan.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table or view.
   *                  If a database is specified, it identifies the table/view from the database.
   *                  Otherwise, it first attempts to find a temporary view with the given name
   *                  and then match the table/view from the current database.
   *                  Note that, the global temporary view database is also valid here.
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> table (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a <code>DataFrame</code> whose schema starts with a string column named
   * "value", and followed by partitioned columns if there are any.
   * The text files must be encoded as UTF-8.
   * <p>
   * By default, each line in the text files is a new row in the resulting DataFrame. For example:
   * <pre><code>
   *   // Scala:
   *   spark.read.text("/path/to/spark/README.md")
   *
   *   // Java:
   *   spark.read().text("/path/to/spark/README.md")
   * </code></pre>
   * <p>
   * You can set the following text-specific option(s) for reading text files:
   * <ul>
   * <li><code>wholetext</code> (default <code>false</code>): If true, read a file as a single row and not split by "\n".
   * </li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @param paths input paths
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> text (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a <code>DataFrame</code> whose schema starts with a string column named
   * "value", and followed by partitioned columns if there are any. See the documentation on
   * the other overloaded <code>text()</code> method for more details.
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> text (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a <code>DataFrame</code> whose schema starts with a string column named
   * "value", and followed by partitioned columns if there are any.
   * The text files must be encoded as UTF-8.
   * <p>
   * By default, each line in the text files is a new row in the resulting DataFrame. For example:
   * <pre><code>
   *   // Scala:
   *   spark.read.text("/path/to/spark/README.md")
   *
   *   // Java:
   *   spark.read().text("/path/to/spark/README.md")
   * </code></pre>
   * <p>
   * You can set the following text-specific option(s) for reading text files:
   * <ul>
   * <li><code>wholetext</code> (default <code>false</code>): If true, read a file as a single row and not split by "\n".
   * </li>
   * <li><code>lineSep</code> (default covers all <code>\r</code>, <code>\r\n</code> and <code>\n</code>): defines the line separator
   * that should be used for parsing.</li>
   * <li><code>pathGlobFilter</code>: an optional glob pattern to only include files with paths matching
   * the pattern. The syntax follows <code>org.apache.hadoop.fs.GlobFilter</code>.
   * It does not change the behavior of partition discovery.</li>
   * <li><code>modifiedBefore</code> (batch only): an optional timestamp to only include files with
   * modification times  occurring before the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>modifiedAfter</code> (batch only): an optional timestamp to only include files with
   * modification times occurring after the specified Time. The provided timestamp
   * must be in the following form: YYYY-MM-DDTHH:mm:ss (e.g. 2020-06-01T13:00:00)</li>
   * <li><code>recursiveFileLookup</code>: recursively scan a directory for files. Using this option
   * disables partition discovery</li>
   * </ul>
   * <p>
   * @param paths input paths
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> text (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a {@link Dataset} of String. The underlying schema of the Dataset
   * contains a single string column named "value".
   * The text files must be encoded as UTF-8.
   * <p>
   * If the directory structure of the text files contains partitioning information, those are
   * ignored in the resulting Dataset. To include partitioning information as columns, use <code>text</code>.
   * <p>
   * By default, each line in the text files is a new row in the resulting DataFrame. For example:
   * <pre><code>
   *   // Scala:
   *   spark.read.textFile("/path/to/spark/README.md")
   *
   *   // Java:
   *   spark.read().textFile("/path/to/spark/README.md")
   * </code></pre>
   * <p>
   * You can set the text-specific options as specified in <code>DataFrameReader.text</code>.
   * <p>
   * @param paths input path
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> textFile (java.lang.String... paths)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a {@link Dataset} of String. See the documentation on the
   * other overloaded <code>textFile()</code> method for more details.
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> textFile (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Loads text files and returns a {@link Dataset} of String. The underlying schema of the Dataset
   * contains a single string column named "value".
   * The text files must be encoded as UTF-8.
   * <p>
   * If the directory structure of the text files contains partitioning information, those are
   * ignored in the resulting Dataset. To include partitioning information as columns, use <code>text</code>.
   * <p>
   * By default, each line in the text files is a new row in the resulting DataFrame. For example:
   * <pre><code>
   *   // Scala:
   *   spark.read.textFile("/path/to/spark/README.md")
   *
   *   // Java:
   *   spark.read().textFile("/path/to/spark/README.md")
   * </code></pre>
   * <p>
   * You can set the text-specific options as specified in <code>DataFrameReader.text</code>.
   * <p>
   * @param paths input path
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> textFile (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
}
