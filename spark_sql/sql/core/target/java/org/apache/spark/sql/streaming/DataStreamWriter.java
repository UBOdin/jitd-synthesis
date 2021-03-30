package org.apache.spark.sql.streaming;
/**
 * Interface used to write a streaming <code>Dataset</code> to external storage systems (e.g. file systems,
 * key-value stores, etc). Use <code>Dataset.writeStream</code> to access this.
 * <p>
 * @since 2.0.0
 */
public final class DataStreamWriter<T extends java.lang.Object> {
  static public  java.lang.String SOURCE_NAME_MEMORY ()  { throw new RuntimeException(); }
  static public  java.lang.String SOURCE_NAME_FOREACH ()  { throw new RuntimeException(); }
  static public  java.lang.String SOURCE_NAME_FOREACH_BATCH ()  { throw new RuntimeException(); }
  static public  java.lang.String SOURCE_NAME_CONSOLE ()  { throw new RuntimeException(); }
  static public  java.lang.String SOURCE_NAME_TABLE ()  { throw new RuntimeException(); }
  static public  java.lang.String SOURCE_NAME_NOOP ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<java.lang.String> SOURCES_ALLOW_ONE_TIME_QUERY ()  { throw new RuntimeException(); }
  /**
   * Partitions the output by the given columns on the file system. If specified, the output is
   * laid out on the file system similar to Hive's partitioning scheme. As an example, when we
   * partition a dataset by year and then month, the directory layout would look like:
   * <p>
   * <ul>
   * <li> year=2016/month=01/</li>
   * <li> year=2016/month=02/</li>
   * </ul>
   * <p>
   * Partitioning is one of the most widely used techniques to optimize physical data layout.
   * It provides a coarse-grained index for skipping unnecessary data reads when queries have
   * predicates on the partitioned columns. In order for partitioning to work well, the number
   * of distinct values in each column should typically be less than tens of thousands.
   * <p>
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> partitionBy (java.lang.String... colNames)  { throw new RuntimeException(); }
  // not preceding
     DataStreamWriter (org.apache.spark.sql.Dataset<T> ds)  { throw new RuntimeException(); }
  /**
   * Specifies how data of a streaming DataFrame/Dataset is written to a streaming sink.
   * <ul>
   * <li> <code>OutputMode.Append()</code>: only the new rows in the streaming DataFrame/Dataset will be
   * written to the sink.</li>
   * <li> <code>OutputMode.Complete()</code>: all the rows in the streaming DataFrame/Dataset will be written
   * to the sink every time there are some updates.</li>
   * <li> <code>OutputMode.Update()</code>: only the rows that were updated in the streaming
   * DataFrame/Dataset will be written to the sink every time there are some updates.
   * If the query doesn't contain aggregations, it will be equivalent to
   * <code>OutputMode.Append()</code> mode.</li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param outputMode (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> outputMode (org.apache.spark.sql.streaming.OutputMode outputMode)  { throw new RuntimeException(); }
  /**
   * Specifies how data of a streaming DataFrame/Dataset is written to a streaming sink.
   * <ul>
   * <li> <code>append</code>: only the new rows in the streaming DataFrame/Dataset will be written to
   * the sink.</li>
   * <li> <code>complete</code>: all the rows in the streaming DataFrame/Dataset will be written to the sink
   * every time there are some updates.</li>
   * <li> <code>update</code>: only the rows that were updated in the streaming DataFrame/Dataset will
   * be written to the sink every time there are some updates. If the query doesn't
   * contain aggregations, it will be equivalent to <code>append</code> mode.</li>
   * </ul>
   * <p>
   * @since 2.0.0
   * @param outputMode (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> outputMode (java.lang.String outputMode)  { throw new RuntimeException(); }
  /**
   * Set the trigger for the stream query. The default value is <code>ProcessingTime(0)</code> and it will run
   * the query as fast as possible.
   * <p>
   * Scala Example:
   * <pre><code>
   *   df.writeStream.trigger(ProcessingTime("10 seconds"))
   *
   *   import scala.concurrent.duration._
   *   df.writeStream.trigger(ProcessingTime(10.seconds))
   * </code></pre>
   * <p>
   * Java Example:
   * <pre><code>
   *   df.writeStream().trigger(ProcessingTime.create("10 seconds"))
   *
   *   import java.util.concurrent.TimeUnit
   *   df.writeStream().trigger(ProcessingTime.create(10, TimeUnit.SECONDS))
   * </code></pre>
   * <p>
   * @since 2.0.0
   * @param trigger (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> trigger (org.apache.spark.sql.streaming.Trigger trigger)  { throw new RuntimeException(); }
  /**
   * Specifies the name of the {@link StreamingQuery} that can be started with <code>start()</code>.
   * This name must be unique among all the currently active queries in the associated SQLContext.
   * <p>
   * @since 2.0.0
   * @param queryName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> queryName (java.lang.String queryName)  { throw new RuntimeException(); }
  /**
   * Specifies the underlying output data source.
   * <p>
   * @since 2.0.0
   * @param source (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> format (java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Partitions the output by the given columns on the file system. If specified, the output is
   * laid out on the file system similar to Hive's partitioning scheme. As an example, when we
   * partition a dataset by year and then month, the directory layout would look like:
   * <p>
   * <ul>
   * <li> year=2016/month=01/</li>
   * <li> year=2016/month=02/</li>
   * </ul>
   * <p>
   * Partitioning is one of the most widely used techniques to optimize physical data layout.
   * It provides a coarse-grained index for skipping unnecessary data reads when queries have
   * predicates on the partitioned columns. In order for partitioning to work well, the number
   * of distinct values in each column should typically be less than tens of thousands.
   * <p>
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> partitionBy (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
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
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> option (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> option (java.lang.String key, boolean value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> option (java.lang.String key, long value)  { throw new RuntimeException(); }
  /**
   * Adds an output option for the underlying data source.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> option (java.lang.String key, double value)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Adds output options for the underlying data source.
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
   * @since 2.0.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> options (scala.collection.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Adds output options for the underlying data source.
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
   * @since 2.0.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> options (java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Starts the execution of the streaming query, which will continually output results to the given
   * path as new data arrives. The returned {@link StreamingQuery} object can be used to interact with
   * the stream.
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery start (java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Starts the execution of the streaming query, which will continually output results to the given
   * path as new data arrives. The returned {@link StreamingQuery} object can be used to interact with
   * the stream. Throws a <code>TimeoutException</code> if the following conditions are met:
   *  - Another run of the same streaming query, that is a streaming query
   *    sharing the same checkpoint location, is already active on the same
   *    Spark Driver
   *  - The SQL configuration <code>spark.sql.streaming.stopActiveRunOnRestart</code>
   *    is enabled
   *  - The active run cannot be stopped within the timeout controlled by
   *    the SQL configuration <code>spark.sql.streaming.stopTimeout</code>
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery start () throws java.util.concurrent.TimeoutException { throw new RuntimeException(); }
  /**
   * Starts the execution of the streaming query, which will continually output results to the given
   * table as new data arrives. The returned {@link StreamingQuery} object can be used to interact with
   * the stream.
   * <p>
   * For v1 table, partitioning columns provided by <code>partitionBy</code> will be respected no matter the
   * table exists or not. A new table will be created if the table not exists.
   * <p>
   * For v2 table, <code>partitionBy</code> will be ignored if the table already exists. <code>partitionBy</code> will be
   * respected only if the v2 table does not exist. Besides, the v2 table created by this API lacks
   * some functionalities (e.g., customized properties, options, and serde info). If you need them,
   * please create the v2 table manually before the execution to avoid creating a table with
   * incomplete information.
   * <p>
   * @since 3.1.0
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.StreamingQuery toTable (java.lang.String tableName) throws java.util.concurrent.TimeoutException { throw new RuntimeException(); }
  /**
   * Sets the output of the streaming query to be processed using the provided writer object.
   * object. See {@link org.apache.spark.sql.ForeachWriter} for more details on the lifecycle and
   * semantics.
   * @since 2.0.0
   * @param writer (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> foreach (org.apache.spark.sql.ForeachWriter<T> writer)  { throw new RuntimeException(); }
  /**
   * :: Experimental ::
   * <p>
   * (Scala-specific) Sets the output of the streaming query to be processed using the provided
   * function. This is supported only in the micro-batch execution modes (that is, when the
   * trigger is not continuous). In every micro-batch, the provided function will be called in
   * every micro-batch with (i) the output rows as a Dataset and (ii) the batch identifier.
   * The batchId can be used to deduplicate and transactionally write the output
   * (that is, the provided Dataset) to external systems. The output Dataset is guaranteed
   * to be exactly the same for the same batchId (assuming all operations are deterministic
   * in the query).
   * <p>
   * @since 2.4.0
   * @param function (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> foreachBatch (scala.Function2<org.apache.spark.sql.Dataset<T>, java.lang.Object, scala.runtime.BoxedUnit> function)  { throw new RuntimeException(); }
  /**
   * :: Experimental ::
   * <p>
   * (Java-specific) Sets the output of the streaming query to be processed using the provided
   * function. This is supported only in the micro-batch execution modes (that is, when the
   * trigger is not continuous). In every micro-batch, the provided function will be called in
   * every micro-batch with (i) the output rows as a Dataset and (ii) the batch identifier.
   * The batchId can be used to deduplicate and transactionally write the output
   * (that is, the provided Dataset) to external systems. The output Dataset is guaranteed
   * to be exactly the same for the same batchId (assuming all operations are deterministic
   * in the query).
   * <p>
   * @since 2.4.0
   * @param function (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> foreachBatch (org.apache.spark.api.java.function.VoidFunction2<org.apache.spark.sql.Dataset<T>, java.lang.Long> function)  { throw new RuntimeException(); }
}
