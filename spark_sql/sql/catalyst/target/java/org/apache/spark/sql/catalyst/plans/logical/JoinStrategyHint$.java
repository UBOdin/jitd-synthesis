package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The enumeration of join strategy hints.
 * <p>
 * The hinted strategy will be used for the join with which it is associated if doable. In case
 * of contradicting strategy hints specified for each side of the join, hints are prioritized as
 * BROADCAST over SHUFFLE_MERGE over SHUFFLE_HASH over SHUFFLE_REPLICATE_NL.
 */
public  class JoinStrategyHint$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JoinStrategyHint$ MODULE$ = null;
  public   JoinStrategyHint$ ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint> strategies ()  { throw new RuntimeException(); }
}
