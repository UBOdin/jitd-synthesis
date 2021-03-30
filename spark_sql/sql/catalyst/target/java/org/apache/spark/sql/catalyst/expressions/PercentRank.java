package org.apache.spark.sql.catalyst.expressions;
/**
 * The PercentRank function computes the percentage ranking of a value in a group of values. The
 * result the rank of the minus one divided by the total number of rows in the partition minus one:
 * (r - 1) / (n - 1). If a partition only contains one row, the function will return 0.
 * <p>
 * The PercentRank function is similar to the CumeDist function, but it uses rank values instead of
 * row counts in the its numerator.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class PercentRank extends org.apache.spark.sql.catalyst.expressions.RankLike implements org.apache.spark.sql.catalyst.expressions.SizeBasedWindowFunction, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference n ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   PercentRank (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public   PercentRank ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.PercentRank withOrder (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> order)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.If evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
