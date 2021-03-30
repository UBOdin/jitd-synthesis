package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The hint attributes to be applied on a specific node.
 * <p>
 * param:  strategy The preferred join strategy.
 */
public  class HintInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint> strategy ()  { throw new RuntimeException(); }
  // not preceding
  public   HintInfo (scala.Option<org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint> strategy)  { throw new RuntimeException(); }
  /**
   * Combine this {@link HintInfo} with another {@link HintInfo} and return the new {@link HintInfo}.
   * @param other the other {@link HintInfo}
   * @param hintErrorHandler the error handler to notify if any {@link HintInfo} has been overridden
   *                         in this merge.
   * <p>
   * Currently, for join strategy hints, the new {@link HintInfo} will contain the strategy in this
   * {@link HintInfo} if defined, otherwise the strategy in the other {@link HintInfo}. The
   * <code>hintOverriddenCallback</code> will be called if this {@link HintInfo} and the other {@link HintInfo}
   * both have a strategy defined but the join strategies are different.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.HintInfo merge (org.apache.spark.sql.catalyst.plans.logical.HintInfo other, org.apache.spark.sql.catalyst.plans.logical.HintErrorHandler hintErrorHandler)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
