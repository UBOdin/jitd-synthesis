package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * This function counts the approximate number of distinct values (ndv) in
 * intervals constructed from endpoints specified in <code>endpointsExpression</code>. The endpoints should be
 * sorted into ascending order. E.g., given an array of endpoints
 * (endpoint_1, endpoint_2, ... endpoint_N), returns the approximate ndv's for intervals
 * [endpoint_1, endpoint_2], (endpoint_2, endpoint_3], ... (endpoint_N-1, endpoint_N].
 * To count ndv's in these intervals, apply the HyperLogLogPlusPlus algorithm in each of them.
 * param:  child to estimate the ndv's of.
 * param:  endpointsExpression An array expression to construct the intervals. It must be foldable,
 *                            and its elements should be sorted into ascending order.
 *                            Duplicate endpoints are allowed, e.g. (1, 5, 5, 10), and ndv for
 *                            interval (5, 5] would be 1.
 * param:  relativeSD The maximum relative standard deviation allowed
 *                   in the HyperLogLogPlusPlus algorithm.
 */
public  class ApproxCountDistinctForIntervals extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<long[]> implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression endpointsExpression ()  { throw new RuntimeException(); }
  public  double relativeSD ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   ApproxCountDistinctForIntervals (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression endpointsExpression, double relativeSD, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public   ApproxCountDistinctForIntervals (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression endpointsExpression, org.apache.spark.sql.catalyst.expressions.Expression relativeSD)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  double[] endpoints ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  /** Allocate enough words to store all registers. */
  public  long[] createAggregationBuffer ()  { throw new RuntimeException(); }
  public  long[] update (long[] buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  int findHllppIndex (double value)  { throw new RuntimeException(); }
  public  long[] merge (long[] buffer1, long[] buffer2)  { throw new RuntimeException(); }
  public  Object eval (long[] buffer)  { throw new RuntimeException(); }
  public  long[] hllppResults (long[] buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproxCountDistinctForIntervals withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproxCountDistinctForIntervals withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  byte[] serialize (long[] obj)  { throw new RuntimeException(); }
  public  long[] deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
