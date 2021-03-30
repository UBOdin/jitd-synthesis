package org.apache.spark.sql.execution.streaming.state;
public abstract class BaseStateStoreRDD<T extends java.lang.Object, U extends java.lang.Object> extends org.apache.spark.rdd.RDD<U> {
  // not preceding
  public   BaseStateStoreRDD (org.apache.spark.rdd.RDD<T> dataRDD, java.lang.String checkpointLocation, java.util.UUID queryRunId, long operatorId, org.apache.spark.sql.internal.SessionState sessionState, scala.Option<org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorRef> storeCoordinator, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraOptions, scala.reflect.ClassTag<T> evidence$1, scala.reflect.ClassTag<U> evidence$2)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConf ()  { throw new RuntimeException(); }
  protected  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> hadoopConfBroadcast ()  { throw new RuntimeException(); }
  /**
   * Set the preferred location of each partition using the executor that has the related
   * {@link StateStoreProvider} already loaded.
   * <p>
   * Implementations can simply call this method in getPreferredLocations.
   * @param partition (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> getPreferredLocations (org.apache.spark.Partition partition)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.state.StateStoreProviderId getStateProviderId (org.apache.spark.Partition partition)  { throw new RuntimeException(); }
}
