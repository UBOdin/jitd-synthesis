package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Returns a new RDD that has exactly <code>numPartitions</code> partitions. Differs from
 * {@link RepartitionByExpression} as this method is called directly by DataFrame's, because the user
 * asked for <code>coalesce</code> or <code>repartition</code>. {@link RepartitionByExpression} is used when the consumer
 * of the output requires some specific ordering or distribution of the data.
 */
public  class Repartition extends org.apache.spark.sql.catalyst.plans.logical.RepartitionOperation implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  public  boolean shuffle ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   Repartition (int numPartitions, boolean shuffle, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
}
