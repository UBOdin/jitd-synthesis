package org.apache.spark.sql.execution.streaming.state;
/**
 * Base trait for a versioned key-value store which provides read operations. Each instance of a
 * <code>ReadStateStore</code> represents a specific version of state data, and such instances are created
 * through a {@link StateStoreProvider}.
 * <p>
 * <code>abort</code> method will be called when the task is completed - please clean up the resources in
 * the method.
 */
public  interface ReadStateStore {
  /**
   * Clean up the resource.
   * <p>
   * The method name is to respect backward compatibility on {@link StateStore}.
   */
  public  void abort ()  ;
  /**
   * Get the current value of a non-null key.
   * @return a non-null row if the key exists in the store, otherwise null.
   * @param key (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /**
   * Get key value pairs with optional approximate <code>start</code> and <code>end</code> extents.
   * If the State Store implementation maintains indices for the data based on the optional
   * <code>keyIndexOrdinal</code> over fields <code>keySchema</code> (see <code>StateStoreProvider.init()</code>), then it can use
   * <code>start</code> and <code>end</code> to make a best-effort scan over the data. Default implementation returns
   * the full data scan iterator, which is correct but inefficient. Custom implementations must
   * ensure that updates (puts, removes) can be made while iterating over this iterator.
   * <p>
   * @param start UnsafeRow having the <code>keyIndexOrdinal</code> column set with appropriate starting value.
   * @param end UnsafeRow having the <code>keyIndexOrdinal</code> column set with appropriate ending value.
   * @return An iterator of key-value pairs that is guaranteed not miss any key between start and
   *         end, both inclusive.
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> getRange (scala.Option<org.apache.spark.sql.catalyst.expressions.UnsafeRow> start, scala.Option<org.apache.spark.sql.catalyst.expressions.UnsafeRow> end)  ;
  /** Unique identifier of the store */
  public  org.apache.spark.sql.execution.streaming.state.StateStoreId id ()  ;
  /** Return an iterator containing all the key-value pairs in the StateStore. */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator ()  ;
  /** Version of the data in this store before committing updates. */
  public  long version ()  ;
}
