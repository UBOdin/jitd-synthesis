package org.apache.spark.sql.execution.streaming;
public  class MicroBatchExecution extends org.apache.spark.sql.execution.streaming.StreamExecution {
  static public  java.lang.String BATCH_ID_KEY ()  { throw new RuntimeException(); }
  // not preceding
  public   MicroBatchExecution (org.apache.spark.sql.SparkSession sparkSession, java.lang.String name, java.lang.String checkpointRoot, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzedPlan, org.apache.spark.sql.connector.catalog.Table sink, org.apache.spark.sql.streaming.Trigger trigger, org.apache.spark.util.Clock triggerClock, org.apache.spark.sql.streaming.OutputMode outputMode, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraOptions, boolean deleteCheckpointOnStop)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.connector.read.streaming.SparkDataStream> sources ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  /**
   * Signals to the thread executing micro-batches that it should stop running after the next
   * batch. This method blocks until the thread stops running.
   */
  public  void stop ()  { throw new RuntimeException(); }
  /** Begins recording statistics about query progress for a given trigger. */
  protected  void startTrigger ()  { throw new RuntimeException(); }
  /**
   * Repeatedly attempts to run batches as data arrives.
   * @param sparkSessionForStream (undocumented)
   */
  protected  void runActivatedStream (org.apache.spark.sql.SparkSession sparkSessionForStream)  { throw new RuntimeException(); }
  /** Execute a function while locking the stream from making an progress */
   <T extends java.lang.Object> T withProgressLocked (scala.Function0<T> f)  { throw new RuntimeException(); }
}
