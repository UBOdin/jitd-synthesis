package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Handles three major epoch coordination tasks for continuous processing:
 * <p>
 * * Maintains a local epoch counter (the "driver epoch"), incremented by IncrementAndGetEpoch
 *   and pollable from executors by GetCurrentEpoch. Note that this epoch is *not* immediately
 *   reflected anywhere in ContinuousExecution.
 * * Collates ReportPartitionOffset messages, and forwards to ContinuousExecution when all
 *   readers have ended a given epoch.
 * * Collates CommitPartitionEpoch messages, and forwards to ContinuousExecution when all readers
 *   have both committed and reported an end offset for a given epoch.
 */
  class EpochCoordinator implements org.apache.spark.rpc.ThreadSafeRpcEndpoint, org.apache.spark.internal.Logging {
  // not preceding
  public   EpochCoordinator (org.apache.spark.sql.connector.write.streaming.StreamingWrite writeSupport, org.apache.spark.sql.connector.read.streaming.ContinuousStream stream, org.apache.spark.sql.execution.streaming.continuous.ContinuousExecution query, long startEpoch, org.apache.spark.sql.SparkSession session, org.apache.spark.rpc.RpcEnv rpcEnv)  { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receive ()  { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receiveAndReply (org.apache.spark.rpc.RpcCallContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEnv rpcEnv ()  { throw new RuntimeException(); }
}
