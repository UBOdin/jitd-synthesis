package org.apache.spark.sql.execution.streaming.state;
/**
 * An implementation of {@link StateStoreProvider} and {@link StateStore} in which all the data is backed
 * by files in an HDFS-compatible file system. All updates to the store has to be done in sets
 * transactionally, and each set of updates increments the store's version. These versions can
 * be used to re-execute the updates (by retries in RDD operations) on the correct version of
 * the store, and regenerate the store version.
 * <p>
 * Usage:
 * To update the data in the state store, the following order of operations are needed.
 * <p>
 * // get the right store
 * - val store = StateStore.get(
 *      StateStoreId(checkpointLocation, operatorId, partitionId), ..., version, ...)
 * - store.put(...)
 * - store.remove(...)
 * - store.commit()    // commits all the updates to made; the new version will be returned
 * - store.iterator()  // key-value data after last commit as an iterator
 * <p>
 * Fault-tolerance model:
 * - Every set of updates is written to a delta file before committing.
 * - The state store is responsible for managing, collapsing and cleaning up of delta files.
 * - Multiple attempts to commit the same version of updates may overwrite each other.
 *   Consistency guarantees depend on whether multiple attempts have the same updates and
 *   the overwrite semantics of underlying file system.
 * - Background maintenance of files ensures that last versions of the store is always recoverable
 * to ensure re-executed RDD operations re-apply updates on the correct past version of the
 * store.
 */
  class HDFSBackedStateStoreProvider implements org.apache.spark.sql.execution.streaming.state.StateStoreProvider, org.apache.spark.internal.Logging {
  public  class HDFSBackedReadStateStore implements org.apache.spark.sql.execution.streaming.state.ReadStateStore {
    // not preceding
    public   HDFSBackedReadStateStore (long version, java.util.concurrent.ConcurrentHashMap<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> map)  { throw new RuntimeException(); }
    public  void abort ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.StateStoreId id ()  { throw new RuntimeException(); }
    public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator ()  { throw new RuntimeException(); }
    public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  long version ()  { throw new RuntimeException(); }
  }
  /** Implementation of {@link StateStore} API which is backed by an HDFS-compatible file system */
  public  class HDFSBackedStateStore implements org.apache.spark.sql.execution.streaming.state.StateStore {
    public  class UPDATING {
      static public abstract  boolean canEqual (Object that)  ;
      static public abstract  boolean equals (Object that)  ;
      static public abstract  Object productElement (int n)  ;
      static public abstract  int productArity ()  ;
      static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
      static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
    }
    public  class UPDATING$ implements org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.STATE, scala.Product, scala.Serializable {
      /**
       * Static reference to the singleton instance of this Scala object.
       */
      public static final UPDATING$ MODULE$ = null;
      public   UPDATING$ ()  { throw new RuntimeException(); }
    }
    public  class COMMITTED {
      static public abstract  boolean canEqual (Object that)  ;
      static public abstract  boolean equals (Object that)  ;
      static public abstract  Object productElement (int n)  ;
      static public abstract  int productArity ()  ;
      static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
      static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
    }
    public  class COMMITTED$ implements org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.STATE, scala.Product, scala.Serializable {
      /**
       * Static reference to the singleton instance of this Scala object.
       */
      public static final COMMITTED$ MODULE$ = null;
      public   COMMITTED$ ()  { throw new RuntimeException(); }
    }
    public  class ABORTED {
      static public abstract  boolean canEqual (Object that)  ;
      static public abstract  boolean equals (Object that)  ;
      static public abstract  Object productElement (int n)  ;
      static public abstract  int productArity ()  ;
      static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
      static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
    }
    public  class ABORTED$ implements org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.STATE, scala.Product, scala.Serializable {
      /**
       * Static reference to the singleton instance of this Scala object.
       */
      public static final ABORTED$ MODULE$ = null;
      public   ABORTED$ ()  { throw new RuntimeException(); }
    }
    /** Trait and classes representing the internal state of the store */
    public  interface STATE {
    }
    public  org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.ABORTED$ ABORTED ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.COMMITTED$ COMMITTED ()  { throw new RuntimeException(); }
    // not preceding
    public   HDFSBackedStateStore (long version, java.util.concurrent.ConcurrentHashMap<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> mapToUpdate)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.HDFSBackedStateStoreProvider.HDFSBackedStateStore.UPDATING$ UPDATING ()  { throw new RuntimeException(); }
    /** Abort all the updates made on this store. This store will not be usable any more. */
    public  void abort ()  { throw new RuntimeException(); }
    /** Commit all the updates that have been made to the store, and return the new version. */
    public  long commit ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
    public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> getRange (scala.Option<org.apache.spark.sql.catalyst.expressions.UnsafeRow> start, scala.Option<org.apache.spark.sql.catalyst.expressions.UnsafeRow> end)  { throw new RuntimeException(); }
    /**
     * Whether all updates have been committed
     * @return (undocumented)
     */
    public  boolean hasCommitted ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.StateStoreId id ()  { throw new RuntimeException(); }
    /**
     * Get an iterator of all the store data.
     * This can be called only after committing all the updates made in the current thread.
     * @return (undocumented)
     */
    public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.streaming.state.StateStoreMetrics metrics ()  { throw new RuntimeException(); }
    public  void put (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  { throw new RuntimeException(); }
    public  void remove (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
    public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  long version ()  { throw new RuntimeException(); }
  }
  public   HDFSBackedStateStoreProvider ()  { throw new RuntimeException(); }
  /**
   * Clean up old snapshots and delta files that are not needed any more. It ensures that last
   * few versions of the store can be recovered from the files, so re-executed RDD operations
   * can re-apply updates on the past versions of the store.
   */
    void cleanup ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  /** Do maintenance backing data files, including creating snapshots and cleaning up old files */
  public  void doMaintenance ()  { throw new RuntimeException(); }
  /** This method is intended to be only used for unit test(s). DO NOT TOUCH ELEMENTS IN MAP! */
    java.util.SortedMap<java.lang.Object, java.util.concurrent.ConcurrentHashMap<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow>> getLoadedMaps ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> getMetricsForProvider ()  { throw new RuntimeException(); }
  /** Get the state store for reading to specific `version` of the store. */
  public  org.apache.spark.sql.execution.streaming.state.ReadStateStore getReadStore (long version)  { throw new RuntimeException(); }
  /** Get the state store for making updates to create a new `version` of the store. */
  public  org.apache.spark.sql.execution.streaming.state.StateStore getStore (long version)  { throw new RuntimeException(); }
  public  void init (org.apache.spark.sql.execution.streaming.state.StateStoreId stateStoreId, org.apache.spark.sql.types.StructType keySchema, org.apache.spark.sql.types.StructType valueSchema, scala.Option<java.lang.Object> indexOrdinal, org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Get iterator of all the data of the latest version of the store.
   * Note that this will look up the files to determined the latest known version.
   * @return (undocumented)
   */
    scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> latestIterator ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.StateStoreId stateStoreId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.streaming.state.StateStoreCustomMetric> supportedCustomMetrics ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
