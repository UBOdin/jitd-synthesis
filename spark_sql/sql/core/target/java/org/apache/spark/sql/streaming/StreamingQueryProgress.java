package org.apache.spark.sql.streaming;
/**
 * Information about progress made in the execution of a {@link StreamingQuery} during
 * a trigger. Each event relates to processing done for a single trigger of the streaming
 * query. Events are emitted even when no new data is available to be processed.
 * <p>
 * param:  id A unique query id that persists across restarts. See <code>StreamingQuery.id()</code>.
 * param:  runId A query id that is unique for every start/restart. See <code>StreamingQuery.runId()</code>.
 * param:  name User-specified name of the query, null if not specified.
 * param:  timestamp Beginning time of the trigger in ISO8601 format, i.e. UTC timestamps.
 * param:  batchId A unique id for the current batch of data being processed.  Note that in the
 *                case of retries after a failure a given batchId my be executed more than once.
 *                Similarly, when there is no data to be processed, the batchId will not be
 *                incremented.
 * param:  batchDuration The process duration of each batch.
 * param:  durationMs The amount of time taken to perform various operations in milliseconds.
 * param:  eventTime Statistics of event time seen in this batch. It may contain the following keys:
 *                 <pre><code>
 *                   "max" -&gt; "2016-12-05T20:54:20.827Z"  // maximum event time seen in this trigger
 *                   "min" -&gt; "2016-12-05T20:54:20.827Z"  // minimum event time seen in this trigger
 *                   "avg" -&gt; "2016-12-05T20:54:20.827Z"  // average event time seen in this trigger
 *                   "watermark" -&gt; "2016-12-05T20:54:20.827Z"  // watermark used in this trigger
 *                 </code></pre>
 *                 All timestamps are in ISO8601 format, i.e. UTC timestamps.
 * param:  stateOperators Information about operators in the query that store state.
 * param:  sources detailed statistics on data being read from each of the streaming sources.
 * @since 2.1.0
 */
public  class StreamingQueryProgress implements scala.Serializable {
  // not preceding
     StreamingQueryProgress (java.util.UUID id, java.util.UUID runId, java.lang.String name, java.lang.String timestamp, long batchId, long batchDuration, java.util.Map<java.lang.String, java.lang.Long> durationMs, java.util.Map<java.lang.String, java.lang.String> eventTime, org.apache.spark.sql.streaming.StateOperatorProgress[] stateOperators, org.apache.spark.sql.streaming.SourceProgress[] sources, org.apache.spark.sql.streaming.SinkProgress sink, java.util.Map<java.lang.String, org.apache.spark.sql.Row> observedMetrics)  { throw new RuntimeException(); }
  public  long batchDuration ()  { throw new RuntimeException(); }
  public  long batchId ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.Long> durationMs ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> eventTime ()  { throw new RuntimeException(); }
  public  java.util.UUID id ()  { throw new RuntimeException(); }
  /** The aggregate (across all sources) rate of data arriving. */
  public  double inputRowsPerSecond ()  { throw new RuntimeException(); }
  /** The compact JSON representation of this progress. */
  public  java.lang.String json ()  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  /** The aggregate (across all sources) number of records processed in a trigger. */
  public  long numInputRows ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, org.apache.spark.sql.Row> observedMetrics ()  { throw new RuntimeException(); }
  /** The pretty (i.e. indented) JSON representation of this progress. */
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  /** The aggregate (across all sources) rate at which Spark is processing data. */
  public  double processedRowsPerSecond ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.SinkProgress sink ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.SourceProgress[] sources ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.StateOperatorProgress[] stateOperators ()  { throw new RuntimeException(); }
  public  java.lang.String timestamp ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
