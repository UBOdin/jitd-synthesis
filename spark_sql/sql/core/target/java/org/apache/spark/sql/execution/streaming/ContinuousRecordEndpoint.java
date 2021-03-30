package org.apache.spark.sql.execution.streaming;
/**
 * A RPC end point for continuous readers to poll for
 * records from the driver.
 * <p>
 * param:  buckets the data buckets. Each bucket contains a sequence of items to be
 *                returned for a partition. The number of buckets should be equal to
 *                to the number of partitions.
 * param:  lock a lock object for locking the buckets for read
 */
public  class ContinuousRecordEndpoint implements org.apache.spark.rpc.ThreadSafeRpcEndpoint {
  public   ContinuousRecordEndpoint (scala.collection.Seq<scala.collection.mutable.Seq<org.apache.spark.sql.catalyst.expressions.UnsafeRow>> buckets, java.lang.Object lock)  { throw new RuntimeException(); }
  /**
   * Process messages from <code>RpcEndpointRef.ask</code>. If receiving a unmatched message,
   * <code>SparkException</code> will be thrown and sent to <code>onError</code>.
   * @param context (undocumented)
   * @return (undocumented)
   */
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receiveAndReply (org.apache.spark.rpc.RpcCallContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.rpc.RpcEnv rpcEnv ()  { throw new RuntimeException(); }
  /**
   * Sets the start offset.
   * <p>
   * @param offsets the base offset per partition to be used
   *                while retrieving the data in {#receiveAndReply}.
   */
  public  void setStartOffsets (scala.collection.Seq<java.lang.Object> offsets)  { throw new RuntimeException(); }
}
