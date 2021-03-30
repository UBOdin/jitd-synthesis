package org.apache.spark.sql.execution.streaming.state;
/**
 * Base trait for a versioned key-value store which provides both read and write operations. Each
 * instance of a <code>StateStore</code> represents a specific version of state data, and such instances are
 * created through a {@link StateStoreProvider}.
 * <p>
 * Unlike {@link ReadStateStore}, <code>abort</code> method may not be called if the <code>commit</code> method succeeds
 * to commit the change. (<code>hasCommitted</code> returns <code>true</code>.) Otherwise, <code>abort</code> method will be called.
 * Implementation should deal with resource cleanup in both methods, and also need to guard with
 * double resource cleanup.
 */
public  interface StateStore extends org.apache.spark.sql.execution.streaming.state.ReadStateStore {
  /**
   * Runs the <code>task</code> periodically and automatically cancels it if there is an exception. <code>onError</code>
   * will be called when an exception happens.
   */
  static public  class MaintenanceTask {
    public   MaintenanceTask (long periodMs, scala.Function0<scala.runtime.BoxedUnit> task, scala.Function0<scala.runtime.BoxedUnit> onError)  { throw new RuntimeException(); }
    public  boolean isRunning ()  { throw new RuntimeException(); }
    public  void stop ()  { throw new RuntimeException(); }
  }
  /**
   * Put a new value for a non-null key. Implementations must be aware that the UnsafeRows in
   * the params can be reused, and must make copies of the data as needed for persistence.
   * @param key (undocumented)
   * @param value (undocumented)
   */
  public  void put (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  ;
  /**
   * Remove a single non-null key.
   * @param key (undocumented)
   */
  public  void remove (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /**
   * Commit all the updates that have been made to the store, and return the new version.
   * Implementations should ensure that no more updates (puts, removes) can be after a commit in
   * order to avoid incorrect usage.
   * @return (undocumented)
   */
  public  long commit ()  ;
  /**
   * Abort all the updates that have been made to the store. Implementations should ensure that
   * no more updates (puts, removes) can be after an abort in order to avoid incorrect usage.
   */
  public  void abort ()  ;
  /**
   * Return an iterator containing all the key-value pairs in the StateStore. Implementations must
   * ensure that updates (puts, removes) can be made while iterating over this iterator.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator ()  ;
  /** Current metrics of the state store */
  public  org.apache.spark.sql.execution.streaming.state.StateStoreMetrics metrics ()  ;
  /**
   * Whether all updates have been committed
   * @return (undocumented)
   */
  public  boolean hasCommitted ()  ;
}
