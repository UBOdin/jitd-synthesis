package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents data where tuples have been ordered according to the <code>ordering</code>
 * {@link Expression Expressions}. Its requirement is defined as the following:
 *   - Given any 2 adjacent partitions, all the rows of the second partition must be larger than or
 *     equal to any row in the first partition, according to the <code>ordering</code> expressions.
 * <p>
 * In other words, this distribution requires the rows to be ordered across partitions, but not
 * necessarily within a partition.
 */
public  class OrderedDistribution implements org.apache.spark.sql.catalyst.plans.physical.Distribution, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering ()  { throw new RuntimeException(); }
  // not preceding
  public   OrderedDistribution (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> requiredNumPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  { throw new RuntimeException(); }
}
