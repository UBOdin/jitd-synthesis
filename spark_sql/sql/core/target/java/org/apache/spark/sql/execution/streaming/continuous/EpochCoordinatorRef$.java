package org.apache.spark.sql.execution.streaming.continuous;
/** Helper object used to create reference to {@link EpochCoordinator}. */
public  class EpochCoordinatorRef$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EpochCoordinatorRef$ MODULE$ = null;
  public   EpochCoordinatorRef$ ()  { throw new RuntimeException(); }
  /**
   * Create a reference to a new {@link EpochCoordinator}.
   * @param writeSupport (undocumented)
   * @param stream (undocumented)
   * @param query (undocumented)
   * @param epochCoordinatorId (undocumented)
   * @param startEpoch (undocumented)
   * @param session (undocumented)
   * @param env (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.rpc.RpcEndpointRef create (org.apache.spark.sql.connector.write.streaming.StreamingWrite writeSupport, org.apache.spark.sql.connector.read.streaming.ContinuousStream stream, org.apache.spark.sql.execution.streaming.continuous.ContinuousExecution query, java.lang.String epochCoordinatorId, long startEpoch, org.apache.spark.sql.SparkSession session, org.apache.spark.SparkEnv env)  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEndpointRef get (java.lang.String id, org.apache.spark.SparkEnv env)  { throw new RuntimeException(); }
}
