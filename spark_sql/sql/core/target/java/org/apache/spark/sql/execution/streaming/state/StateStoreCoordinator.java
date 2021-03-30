package org.apache.spark.sql.execution.streaming.state;
/**
 * Class for coordinating instances of {@link StateStore}s loaded in executors across the cluster,
 * and get their locations for job scheduling.
 */
public  class StateStoreCoordinator implements org.apache.spark.rpc.ThreadSafeRpcEndpoint, org.apache.spark.internal.Logging {
  // not preceding
  public   StateStoreCoordinator (org.apache.spark.rpc.RpcEnv rpcEnv)  { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receiveAndReply (org.apache.spark.rpc.RpcCallContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEnv rpcEnv ()  { throw new RuntimeException(); }
}
