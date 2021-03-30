package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a partitioning where rows are split up across partitions based on the hash
 * of <code>expressions</code>.  All rows where <code>expressions</code> evaluate to the same values are guaranteed to be
 * in the same partition.
 */
public  class HashPartitioning extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.plans.physical.Partitioning, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   HashPartitioning (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, int numPartitions)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean satisfies0 (org.apache.spark.sql.catalyst.plans.physical.Distribution required)  { throw new RuntimeException(); }
  /**
   * Returns an expression that will produce a valid partition ID(i.e. non-negative and is less
   * than numPartitions) based on hashing expressions.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression partitionIdExpression ()  { throw new RuntimeException(); }
}
