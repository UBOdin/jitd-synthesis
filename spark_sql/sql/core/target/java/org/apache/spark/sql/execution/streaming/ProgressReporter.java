package org.apache.spark.sql.execution.streaming;
/**
 * Responsible for continually reporting statistics about the amount of data processed as well
 * as latency for a streaming query.  This trait is designed to be mixed into the
 * {@link StreamExecution}, who is responsible for calling <code>startTrigger</code> and <code>finishTrigger</code>
 * at the appropriate times. Additionally, the status can updated with <code>updateStatusMessage</code> to
 * allow reporting on the streams current state (i.e. "Fetching more data").
 */
public  interface ProgressReporter extends org.apache.spark.internal.Logging {
  public  class ExecutionStats implements scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, java.lang.Object> inputRows ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.streaming.StateOperatorProgress> stateOperators ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Map<java.lang.String, java.lang.String> eventTimeStats ()  { throw new RuntimeException(); }
    // not preceding
    public   ExecutionStats (scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, java.lang.Object> inputRows, scala.collection.Seq<org.apache.spark.sql.streaming.StateOperatorProgress> stateOperators, scala.collection.immutable.Map<java.lang.String, java.lang.String> eventTimeStats)  { throw new RuntimeException(); }
  }
  public  class ExecutionStats$ extends scala.runtime.AbstractFunction3<scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, java.lang.Object>, scala.collection.Seq<org.apache.spark.sql.streaming.StateOperatorProgress>, scala.collection.immutable.Map<java.lang.String, java.lang.String>, org.apache.spark.sql.execution.streaming.ProgressReporter.ExecutionStats> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ExecutionStats$ MODULE$ = null;
    public   ExecutionStats$ ()  { throw new RuntimeException(); }
  }
  public  long currentBatchId ()  ;
  public  org.apache.spark.sql.streaming.StreamingQueryStatus currentStatus ()  ;
  /** Extracts statistics from the most recent query execution. */
  public  org.apache.spark.sql.execution.streaming.ProgressReporter.ExecutionStats extractExecutionStats (boolean hasNewData, boolean hasExecuted)  ;
  /** Extracts observed metrics from the most recent query execution. */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.Row> extractObservedMetrics (boolean hasNewData, org.apache.spark.sql.execution.QueryExecution lastExecution)  ;
  /** Extract number of input sources for each streaming source in plan */
  public  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, java.lang.Object> extractSourceToNumInputRows ()  ;
  /** Extract statistics about stateful operators from the executed query plan. */
  public  scala.collection.Seq<org.apache.spark.sql.streaming.StateOperatorProgress> extractStateOperatorMetrics (boolean hasExecuted)  ;
  /**
   * Finalizes the query progress and adds it to list of recent status updates.
   * <p>
   * @param hasNewData Whether the sources of this stream had new data for this trigger.
   * @param hasExecuted Whether any batch was executed during this trigger. Streaming queries that
   *                    perform stateful aggregations with timeouts can still run batches even
   *                    though the sources don't have any new data.
   */
  public  void finishTrigger (boolean hasNewData, boolean hasExecuted)  ;
  public  java.lang.String formatTimestamp (long millis)  ;
  public  java.util.UUID id ()  ;
  public  org.apache.spark.sql.execution.QueryExecution lastExecution ()  ;
  /** Returns the most recent query progress update or null if there were no progress updates. */
  public  org.apache.spark.sql.streaming.StreamingQueryProgress lastProgress ()  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  ;
  public  java.lang.String name ()  ;
  public  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> newData ()  ;
  public  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata offsetSeqMetadata ()  ;
  public  void postEvent (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  ;
  /** Returns an array containing the most recent query progress updates. */
  public  org.apache.spark.sql.streaming.StreamingQueryProgress[] recentProgress ()  ;
  /**
   * Record the offsets range this trigger will process. Call this before updating
   * <code>committedOffsets</code> in <code>StreamExecution</code> to make sure that the correct range is recorded.
   * @param from (undocumented)
   * @param to (undocumented)
   * @param latest (undocumented)
   */
  public  void recordTriggerOffsets (org.apache.spark.sql.execution.streaming.StreamProgress from, org.apache.spark.sql.execution.streaming.StreamProgress to, org.apache.spark.sql.execution.streaming.StreamProgress latest)  ;
  /** Records the duration of running `body` for the next query progress update. */
  public <T extends java.lang.Object> T reportTimeTaken (java.lang.String triggerDetailKey, scala.Function0<T> body)  ;
  public  java.util.UUID runId ()  ;
  public  org.apache.spark.sql.connector.catalog.Table sink ()  ;
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> sinkCommitProgress ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.SparkDataStream> sources ()  ;
  public  org.apache.spark.sql.SparkSession sparkSession ()  ;
  /** Begins recording statistics about query progress for a given trigger. */
  public  void startTrigger ()  ;
  /** Returns the current status of the query. */
  public  org.apache.spark.sql.streaming.StreamingQueryStatus status ()  ;
  public  org.apache.spark.util.Clock triggerClock ()  ;
  public  void updateProgress (org.apache.spark.sql.streaming.StreamingQueryProgress newProgress)  ;
  /** Updates the message returned in `status`. */
  public  void updateStatusMessage (java.lang.String message)  ;
}
