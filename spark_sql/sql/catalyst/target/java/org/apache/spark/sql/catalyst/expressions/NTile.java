package org.apache.spark.sql.catalyst.expressions;
/**
 * The NTile function divides the rows for each window partition into <code>n</code> buckets ranging from 1 to
 * at most <code>n</code>. Bucket values will differ by at most 1. If the number of rows in the partition does
 * not divide evenly into the number of buckets, then the remainder values are distributed one per
 * bucket, starting with the first bucket.
 * <p>
 * The NTile function is particularly useful for the calculation of tertiles, quartiles, deciles and
 * other common summary statistics
 * <p>
 * The function calculates two variables during initialization: The size of a regular bucket, and
 * the number of buckets that will have one extra row added to it (when the rows do not evenly fit
 * into the number of buckets); both variables are based on the size of the current partition.
 * During the calculation process the function keeps track of the current row number, the current
 * bucket number, and the row number at which the bucket will change (bucketThreshold). When the
 * current row number reaches bucket threshold, the bucket value is increased by one and the
 * threshold is increased by the bucket size (plus one extra if the current bucket is padded).
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public  class NTile extends org.apache.spark.sql.catalyst.expressions.RowNumberLike implements org.apache.spark.sql.catalyst.expressions.SizeBasedWindowFunction, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference n ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression buckets ()  { throw new RuntimeException(); }
  // not preceding
  public   NTile (org.apache.spark.sql.catalyst.expressions.Expression buckets)  { throw new RuntimeException(); }
  public   NTile ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference evaluateExpression ()  { throw new RuntimeException(); }
}
