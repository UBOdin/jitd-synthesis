package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents data where tuples that share the same values for the <code>clustering</code>
 * {@link Expression Expressions} will be co-located in the same partition.
 */
public  class ClusteredDistribution implements org.apache.spark.sql.catalyst.plans.physical.Distribution, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> clustering ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> requiredNumPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   ClusteredDistribution (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> clustering, scala.Option<java.lang.Object> requiredNumPartitions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  { throw new RuntimeException(); }
}
