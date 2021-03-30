package org.apache.spark.sql.execution.streaming.state;
/**
 * An RDD that allows computations to be executed against {@link StateStore}s. It
 * uses the {@link StateStoreCoordinator} to get the locations of loaded state stores
 * and use that as the preferred locations.
 */
public  class StateStoreRDD<T extends java.lang.Object, U extends java.lang.Object> extends org.apache.spark.sql.execution.streaming.state.BaseStateStoreRDD<T, U> {
  // not preceding
  public   StateStoreRDD (org.apache.spark.rdd.RDD<T> dataRDD, scala.Function2<org.apache.spark.sql.execution.streaming.state.StateStore, scala.collection.Iterator<T>, scala.collection.Iterator<U>> storeUpdateFunction, java.lang.String checkpointLocation, java.util.UUID queryRunId, long operatorId, long storeVersion, org.apache.spark.sql.types.StructType keySchema, org.apache.spark.sql.types.StructType valueSchema, scala.Option<java.lang.Object> indexOrdinal, org.apache.spark.sql.internal.SessionState sessionState, scala.Option<org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorRef> storeCoordinator, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraOptions, scala.reflect.ClassTag<T> evidence$5, scala.reflect.ClassTag<U> evidence$6)  { throw new RuntimeException(); }
  protected  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<U> compute (org.apache.spark.Partition partition, org.apache.spark.TaskContext ctxt)  { throw new RuntimeException(); }
}
