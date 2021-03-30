package org.apache.spark.sql.catalyst.plans.physical;
/**
 * A collection of {@link Partitioning}s that can be used to describe the partitioning
 * scheme of the output of a physical operator. It is usually used for an operator
 * that has multiple children. In this case, a {@link Partitioning} in this collection
 * describes how this operator's output is partitioned based on expressions from
 * a child. For example, for a Join operator on two tables <code>A</code> and <code>B</code>
 * with a join condition <code>A.key1 = B.key2</code>, assuming we use HashPartitioning schema,
 * there are two {@link Partitioning}s can be used to describe how the output of
 * this Join operator is partitioned, which are <code>HashPartitioning(A.key1)</code> and
 * <code>HashPartitioning(B.key2)</code>. It is also worth noting that <code>partitionings</code>
 * in this collection do not need to be equivalent, which is useful for
 * Outer Join operators.
 */
public  class PartitioningCollection extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.plans.physical.Partitioning, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Partitioning> partitionings ()  { throw new RuntimeException(); }
  // not preceding
  public   PartitioningCollection (scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Partitioning> partitionings)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  /**
   * Returns true if any <code>partitioning</code> of this collection satisfies the given
   * {@link Distribution}.
   * @param required (undocumented)
   * @return (undocumented)
   */
  public  boolean satisfies0 (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
