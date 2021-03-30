package org.apache.spark.sql.catalyst.expressions;
/**
 * The Rank function computes the rank of a value in a group of values. The result is one plus the
 * number of rows preceding or equal to the current row in the ordering of the partition. The values
 * will produce gaps in the sequence.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class Rank extends org.apache.spark.sql.catalyst.expressions.RankLike implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   Rank (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public   Rank ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Rank withOrder (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> order)  { throw new RuntimeException(); }
}
