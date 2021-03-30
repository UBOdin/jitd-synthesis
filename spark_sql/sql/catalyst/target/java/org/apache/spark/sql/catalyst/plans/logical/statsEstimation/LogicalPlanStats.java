package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/**
 * A trait to add statistics propagation to {@link LogicalPlan}.
 */
public  interface LogicalPlanStats {
  /** Invalidates the stats cache. See {@link stats} for more information. */
  public  void invalidateStatsCache ()  ;
  /**
   * Returns the estimated statistics for the current logical plan node. Under the hood, this
   * method caches the return value, which is computed based on the configuration passed in the
   * first time. If the configuration changes, the cache can be invalidated by calling
   * {@link invalidateStatsCache()}.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics stats ()  ;
  /** A cache for the estimated statistics, such that it will only be computed once. */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> statsCache ()  ;
}
