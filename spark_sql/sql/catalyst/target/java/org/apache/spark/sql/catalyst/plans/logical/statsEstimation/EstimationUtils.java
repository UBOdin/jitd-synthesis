package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class EstimationUtils {
  /**
   * A join between two equi-height histograms may produce multiple overlapped ranges.
   * Each overlapped range is produced by a part of one bin in the left histogram and a part of
   * one bin in the right histogram.
   * param:  lo lower bound of this overlapped range.
   * param:  hi higher bound of this overlapped range.
   * param:  leftNdv ndv in the left part.
   * param:  rightNdv ndv in the right part.
   * param:  leftNumRows number of rows in the left part.
   * param:  rightNumRows number of rows in the right part.
   */
  static public  class OverlappedRange implements scala.Product, scala.Serializable {
    public  double lo ()  { throw new RuntimeException(); }
    public  double hi ()  { throw new RuntimeException(); }
    public  double leftNdv ()  { throw new RuntimeException(); }
    public  double rightNdv ()  { throw new RuntimeException(); }
    public  double leftNumRows ()  { throw new RuntimeException(); }
    public  double rightNumRows ()  { throw new RuntimeException(); }
    // not preceding
    public   OverlappedRange (double lo, double hi, double leftNdv, double rightNdv, double leftNumRows, double rightNumRows)  { throw new RuntimeException(); }
  }
  static public  class OverlappedRange$ extends scala.runtime.AbstractFunction6<java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.EstimationUtils.OverlappedRange> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final OverlappedRange$ MODULE$ = null;
    public   OverlappedRange$ ()  { throw new RuntimeException(); }
  }
  /** Check if each plan has rowCount in its statistics. */
  static public  boolean rowCountsExist (scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> plans)  { throw new RuntimeException(); }
  /** Check if each attribute has column stat in the corresponding statistics. */
  static public  boolean columnStatsExist (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.Statistics, org.apache.spark.sql.catalyst.expressions.Attribute>> statsAndAttr)  { throw new RuntimeException(); }
  /** Check if each attribute has column stat containing distinct and null counts
   * @param statsAndAttr (undocumented)
   * @return (undocumented)
   *  in the corresponding statistic. */
  static public  boolean columnStatsWithCountsExist (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.Statistics, org.apache.spark.sql.catalyst.expressions.Attribute>> statsAndAttr)  { throw new RuntimeException(); }
  /** Statistics for a Column containing only NULLs. */
  static public  org.apache.spark.sql.catalyst.plans.logical.ColumnStat nullColumnStat (org.apache.spark.sql.types.DataType dataType, scala.math.BigInt rowCount)  { throw new RuntimeException(); }
  /**
   * Updates (scales down) the number of distinct values if the number of rows decreases after
   * some operation (such as filter, join). Otherwise keep it unchanged.
   * @param oldNumRows (undocumented)
   * @param newNumRows (undocumented)
   * @param oldNdv (undocumented)
   * @return (undocumented)
   */
  static public  scala.math.BigInt updateNdv (scala.math.BigInt oldNumRows, scala.math.BigInt newNumRows, scala.math.BigInt oldNdv)  { throw new RuntimeException(); }
  static public  scala.math.BigInt ceil (scala.math.BigDecimal bigDecimal)  { throw new RuntimeException(); }
  /** Get column stats for output attributes. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> getOutputMap (org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> inputMap, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  /**
   * Returns the stats for aliases of child's attributes
   * @param expressions (undocumented)
   * @param attributeStats (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat>> getAliasStats (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attributeStats)  { throw new RuntimeException(); }
  static public  scala.math.BigInt getSizePerRow (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attrStats)  { throw new RuntimeException(); }
  static public  scala.math.BigInt getOutputSize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.math.BigInt outputRowCount, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attrStats)  { throw new RuntimeException(); }
  /**
   * For simplicity we use Double to unify operations for data types whose min/max values can be
   * represented as numbers, e.g. Boolean can be represented as 0 (false) or 1 (true).
   * The two methods below are the contract of conversion.
   * @param value (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  double toDouble (Object value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  Object fromDouble (double double_, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Returns the number of histogram bins holding values within the given range
   * [lowerBound, upperBound].
   * <p>
   * Note that the returned value is double type, because the range boundaries usually occupy a
   * portion of a bin. An extreme case is [value, value] which is generated by equal predicate
   * <code>col = value</code>, we can get higher accuracy by allowing returning portion of histogram bins.
   * <p>
   * @param upperBound the highest value of the given range
   * @param upperBoundInclusive whether the upperBound is included in the range
   * @param lowerBound the lowest value of the given range
   * @param lowerBoundInclusive whether the lowerBound is included in the range
   * @param bins an array of bins for a given numeric equi-height histogram
   * @return (undocumented)
   */
  static public  double numBinsHoldingRange (double upperBound, boolean upperBoundInclusive, double lowerBound, boolean lowerBoundInclusive, org.apache.spark.sql.catalyst.plans.logical.HistogramBin[] bins)  { throw new RuntimeException(); }
  /**
   * Returns overlapped ranges between two histograms, in the given value range
   * [lowerBound, upperBound].
   * @param leftHistogram (undocumented)
   * @param rightHistogram (undocumented)
   * @param lowerBound (undocumented)
   * @param upperBound (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.statsEstimation.EstimationUtils.OverlappedRange> getOverlappedRanges (org.apache.spark.sql.catalyst.plans.logical.Histogram leftHistogram, org.apache.spark.sql.catalyst.plans.logical.Histogram rightHistogram, double lowerBound, double upperBound)  { throw new RuntimeException(); }
  /**
   * Given an original bin and a value range [lowerBound, upperBound], returns the trimmed part
   * of the bin in that range and its number of rows.
   * @param bin the input histogram bin.
   * @param height the number of rows of the given histogram bin inside an equi-height histogram.
   * @param lowerBound lower bound of the given range.
   * @param upperBound upper bound of the given range.
   * @return trimmed part of the given bin and its number of rows.
   */
  static public  scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.HistogramBin, java.lang.Object> trimBin (org.apache.spark.sql.catalyst.plans.logical.HistogramBin bin, double height, double lowerBound, double upperBound)  { throw new RuntimeException(); }
}
