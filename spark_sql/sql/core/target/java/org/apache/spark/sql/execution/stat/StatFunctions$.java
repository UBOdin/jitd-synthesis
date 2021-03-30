package org.apache.spark.sql.execution.stat;
public  class StatFunctions$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StatFunctions$ MODULE$ = null;
  public   StatFunctions$ ()  { throw new RuntimeException(); }
  /**
   * Calculates the approximate quantiles of multiple numerical columns of a DataFrame in one pass.
   * <p>
   * The result of this algorithm has the following deterministic bound:
   * If the DataFrame has N elements and if we request the quantile at probability <code>p</code> up to error
   * <code>err</code>, then the algorithm will return a sample <code>x</code> from the DataFrame so that the *exact* rank
   * of <code>x</code> is close to (p * N).
   * More precisely,
   * <p>
   *   floor((p - err) * N) <= rank(x) <= ceil((p + err) * N).
   * <p>
   * This method implements a variation of the Greenwald-Khanna algorithm (with some speed
   * optimizations).
   * The algorithm was first present in <a href="https://doi.org/10.1145/375663.375670">
   * Space-efficient Online Computation of Quantile Summaries</a> by Greenwald and Khanna.
   * <p>
   * @param df the dataframe
   * @param cols numerical columns of the dataframe
   * @param probabilities a list of quantile probabilities
   *   Each number must belong to [0, 1].
   *   For example 0 is the minimum, 0.5 is the median, 1 is the maximum.
   * @param relativeError The relative target precision to achieve (greater than or equal 0).
   *   If set to zero, the exact quantiles are computed, which could be very expensive.
   *   Note that values greater than 1 are accepted but give the same result as 1.
   * <p>
   * @return for each column, returns the requested approximations
   * <p>
   * @note null and NaN values will be ignored in numerical columns before calculation. For
   *   a column only containing null or NaN values, an empty array is returned.
   */
  public  scala.collection.Seq<scala.collection.Seq<java.lang.Object>> multipleApproxQuantiles (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, scala.collection.Seq<java.lang.String> cols, scala.collection.Seq<java.lang.Object> probabilities, double relativeError)  { throw new RuntimeException(); }
  /** Calculate the Pearson Correlation Coefficient for the given columns */
  public  double pearsonCorrelation (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Calculate the covariance of two numerical columns of a DataFrame.
   * @param df The DataFrame
   * @param cols the column names
   * @return the covariance of the two columns.
   */
  public  double calculateCov (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /** Generate a table of frequencies for the elements of two columns. */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> crossTabulate (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, java.lang.String col1, java.lang.String col2)  { throw new RuntimeException(); }
  /** Calculate selected summary statistics for a dataset */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> summary (org.apache.spark.sql.Dataset<?> ds, scala.collection.Seq<java.lang.String> statistics)  { throw new RuntimeException(); }
}
