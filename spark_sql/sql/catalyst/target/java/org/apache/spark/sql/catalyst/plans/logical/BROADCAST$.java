package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The hint for broadcast hash join or broadcast nested loop join, depending on the availability of
 * equi-join keys.
 */
public  class BROADCAST$ extends org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final BROADCAST$ MODULE$ = null;
  public   BROADCAST$ ()  { throw new RuntimeException(); }
  public  java.lang.String displayName ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> hintAliases ()  { throw new RuntimeException(); }
}
