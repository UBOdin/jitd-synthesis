package org.apache.spark.sql.catalyst.plans.logical;
/**
 * An internal hint to discourage broadcast hash join, used by adaptive query execution.
 */
public  class NO_BROADCAST_HASH$ extends org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NO_BROADCAST_HASH$ MODULE$ = null;
  public   NO_BROADCAST_HASH$ ()  { throw new RuntimeException(); }
  public  java.lang.String displayName ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> hintAliases ()  { throw new RuntimeException(); }
}
