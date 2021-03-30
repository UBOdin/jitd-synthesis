package org.apache.spark.sql.execution.streaming;
/**
 * Manages the execution of a streaming Spark SQL query that is occurring in a separate thread.
 * Unlike a standard query, a streaming query executes repeatedly each time new data arrives at any
 * {@link Source} present in the query plan. Whenever new data arrives, a {@link QueryExecution} is created
 * and the results are committed transactionally to the given {@link Sink}.
 * <p>
 * param:  deleteCheckpointOnStop whether to delete the checkpoint if the query is stopped without
 *                               errors. Checkpoint deletion can be forced with the appropriate
 *                               Spark configuration.
 */
public abstract class StreamExecution implements org.apache.spark.sql.streaming.StreamingQuery, org.apache.spark.sql.execution.streaming.ProgressReporter, org.apache.spark.internal.Logging {
  static public  java.lang.String QUERY_ID_KEY ()  { throw new RuntimeException(); }
  static public  java.lang.String IS_CONTINUOUS_PROCESSING ()  { throw new RuntimeException(); }
  static public  boolean isInterruptionException (java.lang.Throwable e, org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  /** Whether the path contains special chars that will be escaped when converting to a `URI`. */
  static public  boolean containsSpecialCharsInPath (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.ProgressReporter.ExecutionStats$ ExecutionStats ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.streaming.StreamingQueryStatus currentStatus ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table sink ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.Trigger trigger ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.Clock triggerClock ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.OutputMode outputMode ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamExecution (org.apache.spark.sql.SparkSession sparkSession, java.lang.String name, java.lang.String checkpointRoot, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzedPlan, org.apache.spark.sql.connector.catalog.Table sink, org.apache.spark.sql.streaming.Trigger trigger, org.apache.spark.util.Clock triggerClock, org.apache.spark.sql.streaming.OutputMode outputMode, boolean deleteCheckpointOnStop)  { throw new RuntimeException(); }
  protected  long pollingDelayMs ()  { throw new RuntimeException(); }
  protected  int minLogEntriesToMaintain ()  { throw new RuntimeException(); }
  /**
   * A lock used to wait/notify when batches complete. Use a fair lock to avoid thread starvation.
   * @return (undocumented)
   */
  protected  java.util.concurrent.locks.ReentrantLock awaitProgressLock ()  { throw new RuntimeException(); }
  protected  java.util.concurrent.locks.Condition awaitProgressLockCondition ()  { throw new RuntimeException(); }
  public  java.lang.String resolvedCheckpointRoot ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  ;
  /**
   * Tracks how much data we have processed and committed to the sink or state store from each
   * input source.
   * Only the scheduler thread should modify this field, and only in atomic steps.
   * Other threads should make a shallow copy if they are going to access this field more than
   * once, since the field's value may change at any time.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress committedOffsets ()  { throw new RuntimeException(); }
  /**
   * Tracks the offsets that are available to be processed, but have not yet be committed to the
   * sink.
   * Only the scheduler thread should modify this field, and only in atomic steps.
   * Other threads should make a shallow copy if they are going to access this field more than
   * once, since the field's value may change at any time.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress availableOffsets ()  { throw new RuntimeException(); }
  /**
   * Tracks the latest offsets for each input source.
   * Only the scheduler thread should modify this field, and only in atomic steps.
   * Other threads should make a shallow copy if they are going to access this field more than
   * once, since the field's value may change at any time.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress latestOffsets ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> sinkCommitProgress ()  { throw new RuntimeException(); }
  /** The current batchId or -1 if execution has not yet been initialized. */
  protected  long currentBatchId ()  { throw new RuntimeException(); }
  /** Metadata associated with the whole query */
  protected  org.apache.spark.sql.execution.streaming.StreamMetadata streamMetadata ()  { throw new RuntimeException(); }
  /** Metadata associated with the offset seq of a batch in the query. */
  protected  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata offsetSeqMetadata ()  { throw new RuntimeException(); }
  /**
   * A map of current watermarks, keyed by the position of the watermark operator in the
   * physical plan.
   * <p>
   * This state is 'soft state', which does not affect the correctness and semantics of watermarks
   * and is not persisted across query restarts.
   * The fault-tolerant watermark state is in offsetSeqMetadata.
   * @return (undocumented)
   */
  protected  scala.collection.mutable.Map<java.lang.Object, java.lang.Object> watermarkMsMap ()  { throw new RuntimeException(); }
  public  java.util.UUID id ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  /**
   * Pretty identified string of printing in logs. Format is
   * If name is set "queryName [id = xyz, runId = abc]" else "[id = xyz, runId = abc]"
   * @return (undocumented)
   */
  protected  java.lang.String prettyIdString ()  { throw new RuntimeException(); }
  /**
   * A list of unique sources in the query plan. This will be set when generating logical plan.
   * @return (undocumented)
   */
  protected  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.connector.read.streaming.ReadLimit> uniqueSources ()  { throw new RuntimeException(); }
  /** Defines the internal state of execution */
  protected  java.util.concurrent.atomic.AtomicReference<org.apache.spark.sql.execution.streaming.State> state ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.IncrementalExecution lastExecution ()  { throw new RuntimeException(); }
  /** Holds the most recent input data for each source. */
  protected  scala.collection.immutable.Map<org.apache.spark.sql.connector.read.streaming.SparkDataStream, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> newData ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.streaming.StreamingQueryException streamDeathCause ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.streaming.MetricsReporter streamMetrics ()  { throw new RuntimeException(); }
  /**
   * The thread that runs the micro-batches of this stream. Note that this thread must be
   * {@link org.apache.spark.util.UninterruptibleThread} to workaround KAFKA-1894: interrupting a
   * running <code>KafkaConsumer</code> may cause endless loop.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.QueryExecutionThread queryExecutionThread ()  { throw new RuntimeException(); }
  /**
   * A write-ahead-log that records the offsets that are present in each batch. In order to ensure
   * that a given batch will always consist of the same data, we write to this log *before* any
   * processing is done.  Thus, the Nth record in this log indicated data that is currently being
   * processed and the N-1th entry indicates which offsets have been durably committed to the sink.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.OffsetSeqLog offsetLog ()  { throw new RuntimeException(); }
  /**
   * A log that records the batch ids that have completed. This is used to check if a batch was
   * fully processed, and its output was committed to the sink, hence no need to process it again.
   * This is used (for instance) during restart, to help identify which batch to run next.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.CommitLog commitLog ()  { throw new RuntimeException(); }
  /** Whether the query is currently active or not */
  public  boolean isActive ()  { throw new RuntimeException(); }
  /** Returns the {@link StreamingQueryException} if the query was terminated by an exception. */
  public  scala.Option<org.apache.spark.sql.streaming.StreamingQueryException> exception ()  { throw new RuntimeException(); }
  /** Returns the path of a file with `name` in the checkpoint directory. */
  protected  java.lang.String checkpointFile (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Starts the execution. This returns only after the thread has started and {@link QueryStartedEvent}
   * has been posted to all the listeners.
   */
  public  void start ()  { throw new RuntimeException(); }
  /**
   * Run the activated stream until stopped.
   * @param sparkSessionForStream (undocumented)
   */
  protected abstract  void runActivatedStream (org.apache.spark.sql.SparkSession sparkSessionForStream)  ;
  protected  void postEvent (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
  /** Stops all streaming sources safely. */
  protected  void stopSources ()  { throw new RuntimeException(); }
  /**
   * Interrupts the query execution thread and awaits its termination until until it exceeds the
   * timeout. The timeout can be set on "spark.sql.streaming.stopTimeout".
   * <p>
   * @throws TimeoutException If the thread cannot be stopped within the timeout
   */
  protected  void interruptAndAwaitExecutionThreadTermination () throws java.util.concurrent.TimeoutException { throw new RuntimeException(); }
  /**
   * Blocks the current thread until processing for data from the given <code>source</code> has reached at
   * least the given <code>Offset</code>. This method is intended for use primarily when writing tests.
   * @param sourceIndex (undocumented)
   * @param newOffset (undocumented)
   * @param timeoutMs (undocumented)
   */
    void awaitOffset (int sourceIndex, org.apache.spark.sql.connector.read.streaming.Offset newOffset, long timeoutMs)  { throw new RuntimeException(); }
  /** A flag to indicate that a batch has completed with no new data available. */
  protected  boolean noNewData ()  { throw new RuntimeException(); }
  /**
   * Await until all fields of the query have been initialized.
   * @param timeoutMs (undocumented)
   */
  public  void awaitInitialization (long timeoutMs)  { throw new RuntimeException(); }
  public  void processAllAvailable ()  { throw new RuntimeException(); }
  public  void awaitTermination ()  { throw new RuntimeException(); }
  public  boolean awaitTermination (long timeoutMs)  { throw new RuntimeException(); }
  /** Expose for tests */
  public  java.lang.String explainInternal (boolean extended)  { throw new RuntimeException(); }
  public  void explain (boolean extended)  { throw new RuntimeException(); }
  public  void explain ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  java.lang.String getBatchDescriptionString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.connector.write.streaming.StreamingWrite createStreamingWrite (org.apache.spark.sql.connector.catalog.SupportsWrite table, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan inputPlan)  { throw new RuntimeException(); }
  protected  void purge (long threshold)  { throw new RuntimeException(); }
}
