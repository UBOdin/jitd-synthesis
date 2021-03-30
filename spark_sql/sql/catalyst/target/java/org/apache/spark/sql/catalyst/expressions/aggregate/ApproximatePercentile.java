package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * The ApproximatePercentile function returns the approximate percentile(s) of a column at the given
 * percentage(s). A percentile is a watermark value below which a given percentage of the column
 * values fall. For example, the percentile of column <code>col</code> at percentage 50% is the median of
 * column <code>col</code>.
 * <p>
 * This function supports partial aggregation.
 * <p>
 * param:  child child expression that can produce column value with <code>child.eval(inputRow)</code>
 * param:  percentageExpression Expression that represents a single percentage value or
 *                             an array of percentage values. Each percentage value must be between
 *                             0.0 and 1.0.
 * param:  accuracyExpression Integer literal expression of approximation accuracy. Higher value
 *                           yields better accuracy, the default value is
 *                           DEFAULT_PERCENTILE_ACCURACY.
 */
public  class ApproximatePercentile extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest> implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, scala.Product, scala.Serializable {
  /**
   * PercentileDigest is a probabilistic data structure used for approximating percentiles
   * with limited memory. PercentileDigest is backed by {@link QuantileSummaries}.
   * <p>
   * param:  summaries underlying probabilistic data structure {@link QuantileSummaries}.
   */
  static public  class PercentileDigest {
    // not preceding
    public   PercentileDigest (org.apache.spark.sql.catalyst.util.QuantileSummaries summaries)  { throw new RuntimeException(); }
    public   PercentileDigest (double relativeError)  { throw new RuntimeException(); }
    /** Insert an observation value into the PercentileDigest data structure. */
    public  void add (double value)  { throw new RuntimeException(); }
    /**
     * Returns the approximate percentiles of all observation values at the given percentages.
     * A percentile is a watermark value below which a given percentage of observation values fall.
     * For example, the following code returns the 25th, median, and 75th percentiles of
     * all observation values:
     * <p>
     * <pre><code>
     *   val Array(p25, median, p75) = percentileDigest.getPercentiles(Array(0.25, 0.5, 0.75))
     * </code></pre>
     * @param percentages (undocumented)
     * @return (undocumented)
     */
    public  double[] getPercentiles (double[] percentages)  { throw new RuntimeException(); }
      boolean isCompressed ()  { throw new RuntimeException(); }
    /** In-place merges in another PercentileDigest. */
    public  void merge (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest other)  { throw new RuntimeException(); }
    /** Returns compressed object of {@link QuantileSummaries} */
    public  org.apache.spark.sql.catalyst.util.QuantileSummaries quantileSummaries ()  { throw new RuntimeException(); }
  }
  /**
   * Serializer  for class {@link PercentileDigest}
   * <p>
   * This class is thread safe.
   */
  static public  class PercentileDigestSerializer {
    public   PercentileDigestSerializer ()  { throw new RuntimeException(); }
    public final  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest deserialize (byte[] bytes)  { throw new RuntimeException(); }
    public final  byte[] serialize (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest obj)  { throw new RuntimeException(); }
  }
  static public  int DEFAULT_PERCENTILE_ACCURACY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigestSerializer serializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression percentageExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression accuracyExpression ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   ApproximatePercentile (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression percentageExpression, org.apache.spark.sql.catalyst.expressions.Expression accuracyExpression, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public   ApproximatePercentile (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression percentageExpression, org.apache.spark.sql.catalyst.expressions.Expression accuracyExpression)  { throw new RuntimeException(); }
  public   ApproximatePercentile (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression percentageExpression)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest createAggregationBuffer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest update (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest buffer, org.apache.spark.sql.catalyst.InternalRow inputRow)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest merge (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest buffer, org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest other)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile withNewMutableAggBufferOffset (int newOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile withNewInputAggBufferOffset (int newOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest obj)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ApproximatePercentile.PercentileDigest deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
