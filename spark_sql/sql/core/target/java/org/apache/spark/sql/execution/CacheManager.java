package org.apache.spark.sql.execution;
/**
 * Provides support in a SQLContext for caching query results and automatically using these cached
 * results when subsequent queries are executed.  Data is cached using byte buffers stored in an
 * InMemoryRelation.  This relation is automatically substituted query plans that return the
 * <code>sameResult</code> as the originally cached query.
 * <p>
 * Internal to Spark SQL.
 */
public  class CacheManager implements org.apache.spark.internal.Logging, org.apache.spark.sql.execution.adaptive.AdaptiveSparkPlanHelper {
  public   CacheManager ()  { throw new RuntimeException(); }
    void analyzeColumnCacheQuery (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.CachedData cachedData, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> column)  { throw new RuntimeException(); }
  /**
   * Caches the data produced by the logical representation of the given {@link Dataset}.
   * Unlike <code>RDD.cache()</code>, the default storage level is set to be <code>MEMORY_AND_DISK</code> because
   * recomputing the in-memory columnar representation of the underlying table is expensive.
   * @param query (undocumented)
   * @param tableName (undocumented)
   * @param storageLevel (undocumented)
   */
  public  void cacheQuery (org.apache.spark.sql.Dataset<?> query, scala.Option<java.lang.String> tableName, org.apache.spark.storage.StorageLevel storageLevel)  { throw new RuntimeException(); }
  /**
   * Caches the data produced by the given {@link LogicalPlan}.
   * Unlike <code>RDD.cache()</code>, the default storage level is set to be <code>MEMORY_AND_DISK</code> because
   * recomputing the in-memory columnar representation of the underlying table is expensive.
   * @param spark (undocumented)
   * @param planToCache (undocumented)
   * @param tableName (undocumented)
   */
  public  void cacheQuery (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan planToCache, scala.Option<java.lang.String> tableName)  { throw new RuntimeException(); }
  /**
   * Caches the data produced by the given {@link LogicalPlan}.
   * @param spark (undocumented)
   * @param planToCache (undocumented)
   * @param tableName (undocumented)
   * @param storageLevel (undocumented)
   */
  public  void cacheQuery (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan planToCache, scala.Option<java.lang.String> tableName, org.apache.spark.storage.StorageLevel storageLevel)  { throw new RuntimeException(); }
  /** Clears all cached tables. */
  public  void clearCache ()  { throw new RuntimeException(); }
  /** Checks if the cache is empty. */
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  /** Optionally returns cached data for the given {@link Dataset} */
  public  scala.Option<org.apache.spark.sql.execution.CachedData> lookupCachedData (org.apache.spark.sql.Dataset<?> query)  { throw new RuntimeException(); }
  /** Optionally returns cached data for the given {@link LogicalPlan}. */
  public  scala.Option<org.apache.spark.sql.execution.CachedData> lookupCachedData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Tries to re-cache all the cache entries that contain <code>resourcePath</code> in one or more
   * <code>HadoopFsRelation</code> node(s) as part of its logical plan.
   * @param spark (undocumented)
   * @param resourcePath (undocumented)
   */
  public  void recacheByPath (org.apache.spark.sql.SparkSession spark, java.lang.String resourcePath)  { throw new RuntimeException(); }
  /**
   * Tries to re-cache all the cache entries that contain <code>resourcePath</code> in one or more
   * <code>HadoopFsRelation</code> node(s) as part of its logical plan.
   * @param spark (undocumented)
   * @param resourcePath (undocumented)
   * @param fs (undocumented)
   */
  public  void recacheByPath (org.apache.spark.sql.SparkSession spark, org.apache.hadoop.fs.Path resourcePath, org.apache.hadoop.fs.FileSystem fs)  { throw new RuntimeException(); }
  /**
   * Tries to re-cache all the cache entries that refer to the given plan.
   * @param spark (undocumented)
   * @param plan (undocumented)
   */
  public  void recacheByPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Un-cache the given plan or all the cache entries that refer to the given plan.
   * @param query     The {@link Dataset} to be un-cached.
   * @param cascade   If true, un-cache all the cache entries that refer to the given
   *                  {@link Dataset}; otherwise un-cache the given {@link Dataset} only.
   */
  public  void uncacheQuery (org.apache.spark.sql.Dataset<?> query, boolean cascade)  { throw new RuntimeException(); }
  /**
   * Un-cache the given plan or all the cache entries that refer to the given plan.
   * @param spark     The Spark session.
   * @param plan      The plan to be un-cached.
   * @param cascade   If true, un-cache all the cache entries that refer to the given
   *                  plan; otherwise un-cache the given plan only.
   * @param blocking  Whether to block until all blocks are deleted.
   */
  public  void uncacheQuery (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, boolean cascade, boolean blocking)  { throw new RuntimeException(); }
  /** Replaces segments of the given logical plan with cached versions where possible. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan useCachedData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
