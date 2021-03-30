package org.apache.spark.sql;
/**
 * Interface used to write a {@link Dataset} to external storage systems (e.g. file systems,
 * key-value stores, etc). Use <code>Dataset.write</code> to access this.
 * <p>
 * @since 1.4.0
 */
public final class DataFrameWriter<T extends java.lang.Object> {
  // not preceding
     DataFrameWriter (org.apache.spark.sql.Dataset<T> ds)  { throw new RuntimeException(); }
  /**
   * Buckets the output by the given columns. If specified, the output is laid out on the file
   * system similar to Hive's bucketing scheme, but with a different bucket hash function
   * and is not compatible with Hive's bucketing.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 2.0
   * @param numBuckets (undocumented)
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> bucketBy (int numBuckets, java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Buckets the output by the given columns. If specified, the output is laid out on the file
   * system similar to Hive's bucketing scheme, but with a different bucket hash function
   * and is not compatible with Hive's bucketing.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 2.0
   * @param numBuckets (undocumented)
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> bucketBy (int numBuckets, java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> in CSV format at the specified path.
   * This is equivalent to:
   * <pre><code>
   *   format("csv").save(path)
   * </code></pre>
   * <p>
   * You can set the following CSV-specific option(s) for writing CSV files:
   * <ul>
   * <li><code>sep</code> (default <code>,</code>): sets a single character as a separator for each
   * field and value.</li>
   * <li><code>quote</code> (default <code>"</code>): sets a single character used for escaping quoted values where
   * the separator can be part of the value. If an empty string is set, it uses <code>u0000</code>
   * (null character).</li>
   * <li><code>escape</code> (default <code>\</code>): sets a single character used for escaping quotes inside
   * an already quoted value.</li>
   * <li><code>charToEscapeQuoteEscaping</code> (default <code>escape</code> or <code>\0</code>): sets a single character used for
   * escaping the escape for the quote character. The default value is escape character when escape
   * and quote characters are different, <code>\0</code> otherwise.</li>
   * <li><code>escapeQuotes</code> (default <code>true</code>): a flag indicating whether values containing
   * quotes should always be enclosed in quotes. Default is to escape all values containing
   * a quote character.</li>
   * <li><code>quoteAll</code> (default <code>false</code>): a flag indicating whether all values should always be
   * enclosed in quotes. Default is to only escape values containing a quote character.</li>
   * <li><code>header</code> (default <code>false</code>): writes the names of columns as the first line.</li>
   * <li><code>nullValue</code> (default empty string): sets the string representation of a null value.</li>
   * <li><code>emptyValue</code> (default <code>""</code>): sets the string representation of an empty value.</li>
   * <li><code>encoding</code> (by default it is not set): specifies encoding (charset) of saved csv
   * files. If it is not set, the UTF-8 charset will be used.</li>
   * <li><code>compression</code> (default <code>null</code>): compression codec to use when saving to file. This can be
   * one of the known case-insensitive shorten names (<code>none</code>, <code>bzip2</code>, <code>gzip</code>, <code>lz4</code>,
   * <code>snappy</code> and <code>deflate</code>). </li>
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
   * <li><code>ignoreLeadingWhiteSpace</code> (default <code>true</code>): a flag indicating whether or not leading
   * whitespaces from values being written should be skipped.</li>
   * <li><code>ignoreTrailingWhiteSpace</code> (default <code>true</code>): a flag indicating defines whether or not
   * trailing whitespaces from values being written should be skipped.</li>
   * <li><code>lineSep</code> (default <code>\n</code>): defines the line separator that should be used for writing.
   * Maximum length is 1 character.</li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   */
  public  void csv (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Specifies the underlying output data source. Built-in options include "parquet", "json", etc.
   * <p>
   * @since 1.4.0
   * @param source (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> format (java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Inserts the content of the <code>DataFrame</code> to the specified table. It requires that
   * the schema of the <code>DataFrame</code> is the same as the schema of the table.
   * <p>
   * @note Unlike <code>saveAsTable</code>, <code>insertInto</code> ignores the column names and just uses position-based
   * resolution. For example:
   * <p>
   * @note SaveMode.ErrorIfExists and SaveMode.Ignore behave as SaveMode.Append in <code>insertInto</code> as
   *       <code>insertInto</code> is not a table creating operation.
   * <p>
   * <pre><code>
   *    scala&gt; Seq((1, 2)).toDF("i", "j").write.mode("overwrite").saveAsTable("t1")
   *    scala&gt; Seq((3, 4)).toDF("j", "i").write.insertInto("t1")
   *    scala&gt; Seq((5, 6)).toDF("a", "b").write.insertInto("t1")
   *    scala&gt; sql("select * from t1").show
   *    +---+---+
   *    |  i|  j|
   *    +---+---+
   *    |  5|  6|
   *    |  3|  4|
   *    |  1|  2|
   *    +---+---+
   * </code></pre>
   * <p>
   * Because it inserts data to an existing table, format or options will be ignored.
   * <p>
   * @since 1.4.0
   * @param tableName (undocumented)
   */
  public  void insertInto (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> to an external database table via JDBC. In the case the
   * table already exists in the external database, behavior of this function depends on the
   * save mode, specified by the <code>mode</code> function (default to throwing an exception).
   * <p>
   * Don't create too many partitions in parallel on a large cluster; otherwise Spark might crash
   * your external database systems.
   * <p>
   * You can set the following JDBC-specific option(s) for storing JDBC:
   * <ul>
   * <li><code>truncate</code> (default <code>false</code>): use <code>TRUNCATE TABLE</code> instead of <code>DROP TABLE</code>.</li>
   * </ul>
   * <p>
   * In case of failures, users should turn off <code>truncate</code> option to use <code>DROP TABLE</code> again. Also,
   * due to the different behavior of <code>TRUNCATE TABLE</code> among DBMS, it's not always safe to use this.
   * MySQLDialect, DB2Dialect, MsSqlServerDialect, DerbyDialect, and OracleDialect supports this
   * while PostgresDialect and default JDBCDirect doesn't. For unknown and unsupported JDBCDirect,
   * the user option <code>truncate</code> is ignored.
   * <p>
   * @param url JDBC database url of the form <code>jdbc:subprotocol:subname</code>
   * @param table Name of the table in the external database.
   * @param connectionProperties JDBC database connection arguments, a list of arbitrary string
   *                             tag/value. Normally at least a "user" and "password" property
   *                             should be included. "batchsize" can be used to control the
   *                             number of rows per insert. "isolationLevel" can be one of
   *                             "NONE", "READ_COMMITTED", "READ_UNCOMMITTED", "REPEATABLE_READ",
   *                             or "SERIALIZABLE", corresponding to standard transaction
   *                             isolation levels defined by JDBC's Connection object, with default
   *                             of "READ_UNCOMMITTED".
   * @since 1.4.0
   */
  public  void jdbc (java.lang.String url, java.lang.String table, java.util.Properties connectionProperties)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> in JSON format (<a href="http://jsonlines.org/">
   * JSON Lines text format or newline-delimited JSON</a>) at the specified path.
   * This is equivalent to:
   * <pre><code>
   *   format("json").save(path)
   * </code></pre>
   * <p>
   * You can set the following JSON-specific option(s) for writing JSON files:
   * <ul>
   * <li><code>compression</code> (default <code>null</code>): compression codec to use when saving to file. This can be
   * one of the known case-insensitive shorten names (<code>none</code>, <code>bzip2</code>, <code>gzip</code>, <code>lz4</code>,
   * <code>snappy</code> and <code>deflate</code>). </li>
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
   * <li><code>encoding</code> (by default it is not set): specifies encoding (charset) of saved json
   * files. If it is not set, the UTF-8 charset will be used. </li>
   * <li><code>lineSep</code> (default <code>\n</code>): defines the line separator that should be used for writing.</li>
   * <li><code>ignoreNullFields</code> (default <code>true</code>): Whether to ignore null fields
   * when generating JSON objects. </li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param path (undocumented)
   */
  public  void json (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Specifies the behavior when data or table already exists. Options include:
   * <ul>
   * <li><code>SaveMode.Overwrite</code>: overwrite the existing data.</li>
   * <li><code>SaveMode.Append</code>: append the data.</li>
   * <li><code>SaveMode.Ignore</code>: ignore the operation (i.e. no-op).</li>
   * <li><code>SaveMode.ErrorIfExists</code>: throw an exception at runtime.</li>
   * </ul>
   * <p>
   * The default option is <code>ErrorIfExists</code>.
   * <p>
   * @since 1.4.0
   * @param saveMode (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> mode (org.apache.spark.sql.SaveMode saveMode)  { throw new RuntimeException(); }
  /**
   * Specifies the behavior when data or table already exists. Options include:
   * <ul>
   * <li><code>overwrite</code>: overwrite the existing data.</li>
   * <li><code>append</code>: append the data.</li>
   * <li><code>ignore</code>: ignore the operation (i.e. no-op).</li>
   * <li><code>error</code> or <code>errorifexists</code>: default option, throw an exception at runtime.</li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param saveMode (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> mode (java.lang.String saveMode)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to format timestamps in the JSON/CSV datasources or partition values. The following
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
  public  org.apache.spark.sql.DataFrameWriter<T> option (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> option (java.lang.String key, boolean value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> option (java.lang.String key, long value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> option (java.lang.String key, double value)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Adds output options for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to format timestamps in the JSON/CSV datasources or partition values. The following
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
  public  org.apache.spark.sql.DataFrameWriter<T> options (scala.collection.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Adds output options for the underlying data source.
   * <p>
   * All options are maintained in a case-insensitive way in terms of key names.
   * If a new option has the same key case-insensitively, it will override the existing option.
   * <p>
   * You can set the following option(s):
   * <ul>
   * <li><code>timeZone</code> (default session local timezone): sets the string that indicates a time zone ID
   * to be used to format timestamps in the JSON/CSV datasources or partition values. The following
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
  public  org.apache.spark.sql.DataFrameWriter<T> options (java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> in ORC format at the specified path.
   * This is equivalent to:
   * <pre><code>
   *   format("orc").save(path)
   * </code></pre>
   * <p>
   * You can set the following ORC-specific option(s) for writing ORC files:
   * <ul>
   * <li><code>compression</code> (default is the value specified in <code>spark.sql.orc.compression.codec</code>):
   * compression codec to use when saving to file. This can be one of the known case-insensitive
   * shorten names(<code>none</code>, <code>snappy</code>, <code>zlib</code>, <code>lzo</code>, and <code>zstd</code>). This will override
   * <code>orc.compress</code> and <code>spark.sql.orc.compression.codec</code>. If <code>orc.compress</code> is given,
   * it overrides <code>spark.sql.orc.compression.codec</code>.</li>
   * </ul>
   * <p>
   * @since 1.5.0
   * @param path (undocumented)
   */
  public  void orc (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> in Parquet format at the specified path.
   * This is equivalent to:
   * <pre><code>
   *   format("parquet").save(path)
   * </code></pre>
   * <p>
   * You can set the following Parquet-specific option(s) for writing Parquet files:
   * <ul>
   * <li><code>compression</code> (default is the value specified in <code>spark.sql.parquet.compression.codec</code>):
   * compression codec to use when saving to file. This can be one of the known case-insensitive
   * shorten names(<code>none</code>, <code>uncompressed</code>, <code>snappy</code>, <code>gzip</code>, <code>lzo</code>, <code>brotli</code>, <code>lz4</code>, and <code>zstd</code>).
   * This will override <code>spark.sql.parquet.compression.codec</code>.</li>
   * </ul>
   * <p>
   * @since 1.4.0
   * @param path (undocumented)
   */
  public  void parquet (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Partitions the output by the given columns on the file system. If specified, the output is
   * laid out on the file system similar to Hive's partitioning scheme. As an example, when we
   * partition a dataset by year and then month, the directory layout would look like:
   * <ul>
   * <li>year=2016/month=01/</li>
   * <li>year=2016/month=02/</li>
   * </ul>
   * <p>
   * Partitioning is one of the most widely used techniques to optimize physical data layout.
   * It provides a coarse-grained index for skipping unnecessary data reads when queries have
   * predicates on the partitioned columns. In order for partitioning to work well, the number
   * of distinct values in each column should typically be less than tens of thousands.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 1.4.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> partitionBy (java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Partitions the output by the given columns on the file system. If specified, the output is
   * laid out on the file system similar to Hive's partitioning scheme. As an example, when we
   * partition a dataset by year and then month, the directory layout would look like:
   * <ul>
   * <li>year=2016/month=01/</li>
   * <li>year=2016/month=02/</li>
   * </ul>
   * <p>
   * Partitioning is one of the most widely used techniques to optimize physical data layout.
   * It provides a coarse-grained index for skipping unnecessary data reads when queries have
   * predicates on the partitioned columns. In order for partitioning to work well, the number
   * of distinct values in each column should typically be less than tens of thousands.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 1.4.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> partitionBy (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> at the specified path.
   * <p>
   * @since 1.4.0
   * @param path (undocumented)
   */
  public  void save (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> as the specified table.
   * <p>
   * @since 1.4.0
   */
  public  void save ()  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> as the specified table.
   * <p>
   * In the case the table already exists, behavior of this function depends on the
   * save mode, specified by the <code>mode</code> function (default to throwing an exception).
   * When <code>mode</code> is <code>Overwrite</code>, the schema of the <code>DataFrame</code> does not need to be
   * the same as that of the existing table.
   * <p>
   * When <code>mode</code> is <code>Append</code>, if there is an existing table, we will use the format and options of
   * the existing table. The column order in the schema of the <code>DataFrame</code> doesn't need to be same
   * as that of the existing table. Unlike <code>insertInto</code>, <code>saveAsTable</code> will use the column names to
   * find the correct column positions. For example:
   * <p>
   * <pre><code>
   *    scala&gt; Seq((1, 2)).toDF("i", "j").write.mode("overwrite").saveAsTable("t1")
   *    scala&gt; Seq((3, 4)).toDF("j", "i").write.mode("append").saveAsTable("t1")
   *    scala&gt; sql("select * from t1").show
   *    +---+---+
   *    |  i|  j|
   *    +---+---+
   *    |  1|  2|
   *    |  4|  3|
   *    +---+---+
   * </code></pre>
   * <p>
   * In this method, save mode is used to determine the behavior if the data source table exists in
   * Spark catalog. We will always overwrite the underlying data of data source (e.g. a table in
   * JDBC data source) if the table doesn't exist in Spark catalog, and will always append to the
   * underlying data of data source if the table already exists.
   * <p>
   * When the DataFrame is created from a non-partitioned <code>HadoopFsRelation</code> with a single input
   * path, and the data source provider can be mapped to an existing Hive builtin SerDe (i.e. ORC
   * and Parquet), the table is persisted in a Hive compatible format, which means other systems
   * like Hive will be able to read this table. Otherwise, the table is persisted in a Spark SQL
   * specific format.
   * <p>
   * @since 1.4.0
   * @param tableName (undocumented)
   */
  public  void saveAsTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Sorts the output in each bucket by the given columns.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 2.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> sortBy (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Sorts the output in each bucket by the given columns.
   * <p>
   * This is applicable for all file-based data sources (e.g. Parquet, JSON) starting with Spark
   * 2.1.0.
   * <p>
   * @since 2.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> sortBy (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Saves the content of the <code>DataFrame</code> in a text file at the specified path.
   * The DataFrame must have only one column that is of string type.
   * Each row becomes a new line in the output file. For example:
   * <pre><code>
   *   // Scala:
   *   df.write.text("/path/to/output")
   *
   *   // Java:
   *   df.write().text("/path/to/output")
   * </code></pre>
   * The text files will be encoded as UTF-8.
   * <p>
   * You can set the following option(s) for writing text files:
   * <ul>
   * <li><code>compression</code> (default <code>null</code>): compression codec to use when saving to file. This can be
   * one of the known case-insensitive shorten names (<code>none</code>, <code>bzip2</code>, <code>gzip</code>, <code>lz4</code>,
   * <code>snappy</code> and <code>deflate</code>). </li>
   * <li><code>lineSep</code> (default <code>\n</code>): defines the line separator that should be used for writing.</li>
   * </ul>
   * <p>
   * @since 1.6.0
   * @param path (undocumented)
   */
  public  void text (java.lang.String path)  { throw new RuntimeException(); }
}
