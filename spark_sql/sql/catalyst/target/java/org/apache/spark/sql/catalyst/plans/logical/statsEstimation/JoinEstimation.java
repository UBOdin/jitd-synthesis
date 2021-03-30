package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class JoinEstimation implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Join join ()  { throw new RuntimeException(); }
  // not preceding
  public   JoinEstimation (org.apache.spark.sql.catalyst.plans.logical.Join join)  { throw new RuntimeException(); }
  /**
   * Estimate statistics after join. Return <code>None</code> if the join type is not supported, or we don't
   * have enough statistics for estimation.
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> estimate ()  { throw new RuntimeException(); }
}
