package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a partitioning where rows are split across partitions based on some total ordering of
 * the expressions specified in <code>ordering</code>.  When data is partitioned in this manner, it guarantees:
 * Given any 2 adjacent partitions, all the rows of the second partition must be larger than any row
 * in the first partition, according to the <code>ordering</code> expressions.
 * <p>
 * This is a strictly stronger guarantee than what <code>OrderedDistribution(ordering)</code> requires, as
 * there is no overlap between partitions.
 * <p>
 * This class extends expression primarily so that transformations over expression will descend
 * into its child.
 */
public  class RangePartitioning extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.plans.physical.Partitioning, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   RangePartitioning (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering, int numPartitions)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean satisfies0 (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  { throw new RuntimeException(); }
}
