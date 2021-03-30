package org.apache.spark.sql.execution.datasources;
/**
 * An implementation that caches partition file statuses in memory.
 * <p>
 * param:  maxSizeInBytes max allowable cache size before entries start getting evicted
 */
public  class SharedInMemoryCache implements org.apache.spark.internal.Logging {
  public   SharedInMemoryCache (long maxSizeInBytes, long cacheTTL)  { throw new RuntimeException(); }
  /**
   * @return a FileStatusCache that does not share any entries with any other client, but does
   *         share memory resources for the purpose of cache eviction.
   */
  public  org.apache.spark.sql.execution.datasources.FileStatusCache createForNewClient ()  { throw new RuntimeException(); }
}
