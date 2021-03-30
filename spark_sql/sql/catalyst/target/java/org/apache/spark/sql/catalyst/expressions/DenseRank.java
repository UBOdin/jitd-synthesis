package org.apache.spark.sql.catalyst.expressions;
/**
 * The DenseRank function computes the rank of a value in a group of values. The result is one plus
 * the previously assigned rank value. Unlike {@link Rank}, {@link DenseRank} will not produce gaps in the
 * ranking sequence.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class DenseRank extends org.apache.spark.sql.catalyst.expressions.RankLike implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   DenseRank (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public   DenseRank ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.DenseRank withOrder (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> order)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression rankSource ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
