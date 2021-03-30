package org.apache.spark.sql;
/**
 * Statistic functions for <code>DataFrame</code>s.
 * <p>
 * @since 1.4.0
 */
public final class DataFrameStatFunctions {
     DataFrameStatFunctions (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df)  { throw new RuntimeException(); }
  /**
   * Calculates the approximate quantiles of a numerical column of a DataFrame.
   * <p>
   * The result of this algorithm has the following deterministic bound:
   * If the DataFrame has N elements and if we request the quantile at probability <code>p</code> up to error
   * <code>err</code>, then the algorithm will return a sample <code>x</code> from the DataFrame so that the *exact* rank
   * of <code>x</code> is close to (p * N).
   * More precisely,
   * <p>
   * <pre><code>
   *   floor((p - err) * N) &lt;= rank(x) &lt;= ceil((p + err) * N)
   * </code></pre>
   * <p>
   * This method implements a variation of the Greenwald-Khanna algorithm (with some speed
   * optimizations).
   * The algorithm was first present in <a href="https://doi.org/10.1145/375663.375670">
   * Space-efficient Online Computation of Quantile Summaries</a> by Greenwald and Khanna.
   * <p>
   * @param col the name of the numerical column
   * @param probabilities a list of quantile probabilities
   *   Each number must belong to [0, 1].
   *   For example 0 is the minimum, 0.5 is the median, 1 is the maximum.
   * @param relativeError The relative target precision to achieve (greater than or equal to 0).
   *   If set to zero, the exact quantiles are computed, which could be very expensive.
   *   Note that values greater than 1 are accepted but give the same result as 1.
   * @return the approximate quantiles at the given probabilities
   * <p>
   * @note null and NaN values will be removed from the numerical column before calculation. If
   *   the dataframe is empty or the column only contains null or NaN, an empty array is returned.
   * <p>
   * @since 2.0.0
   */
  public  double[] approxQuantile (java.lang.String col, double[] probabilities, double relativeError)  { throw new RuntimeException(); }
  /**
   * Calculates the approximate quantiles of numerical columns of a DataFrame.
   * @see <code>approxQuantile(col:Str* approxQuantile)</code> for detailed description.
   * <p>
   * @param cols the names of the numerical columns
   * @param probabilities a list of quantile probabilities
   *   Each number must belong to [0, 1].
   *   For example 0 is the minimum, 0.5 is the median, 1 is the maximum.
   * @param relativeError The relative target precision to achieve (greater than or equal to 0).
   *   If set to zero, the exact quantiles are computed, which could be very expensive.
   *   Note that values greater than 1 are accepted but give the same result as 1.
   * @return the approximate quantiles at the given probabilities of each column
   * <p>
   * @note null and NaN values will be ignored in numerical columns before calculation. For
   *   columns only containing null or NaN values, an empty array is returned.
   * <p>
   * @since 2.2.0
   */
  public  double[][] approxQuantile (java.lang.String[] cols, double[] probabilities, double relativeError)  { throw new RuntimeException(); }
  /**
   * Python-friendly version of {@link approxQuantile()}
   * @param cols (undocumented)
   * @param probabilities (undocumented)
   * @param relativeError (undocumented)
   * @return (undocumented)
   */
    java.util.List<java.util.List<java.lang.Object>> approxQuantile (scala.collection.immutable.List<java.lang.String> cols, scala.collection.immutable.List<java.lang.Object> probabilities, double relativeError)  { throw new RuntimeException(); }
  /**
   * Builds a Bloom filter over a specified column.
   * <p>
   * @param colName name of the column over which the filter is built
   * @param expectedNumItems expected number of items which will be put into the filter.
   * @param fpp expected false positive probability of the filter.
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.util.sketch.BloomFilter bloomFilter (java.lang.String colName, long expectedNumItems, double fpp)  { throw new RuntimeException(); }
  /**
   * Builds a Bloom filter over a specified column.
   * <p>
   * @param col the column over which the filter is built
   * @param expectedNumItems expected number of items which will be put into the filter.
   * @param fpp expected false positive probability of the filter.
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.util.sketch.BloomFilter bloomFilter (org.apache.spark.sql.Column col, long expectedNumItems, double fpp)  { throw new RuntimeException(); }
  /**
   * Builds a Bloom filter over a specified column.
   * <p>
   * @param colName name of the column over which the filter is built
   * @param expectedNumItems expected number of items which will be put into the filter.
   * @param numBits expected number of bits of the filter.
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.util.sketch.BloomFilter bloomFilter (java.lang.String colName, long expectedNumItems, long numBits)  { throw new RuntimeException(); }
  /**
   * Builds a Bloom filter over a specified column.
   * <p>
   * @param col the column over which the filter is built
   * @param expectedNumItems expected number of items which will be put into the filter.
   * @param numBits expected number of bits of the filter.
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.util.sketch.BloomFilter bloomFilter (org.apache.spark.sql.Column col, long expectedNumItems, long numBits)  { throw new RuntimeException(); }
  /**
   * Calculates the correlation of two columns of a DataFrame. Currently only supports the Pearson
   * Correlation Coefficient. For Spearman Correlation, consider using RDD methods found in
   * MLlib's Statistics.
   * <p>
   * @param col1 the name of the column
   * @param col2 the name of the column to calculate the correlation against
   * @return The Pearson Correlation Coefficient as a Double.
   * <p>
   * <pre><code>
   *    val df = sc.parallelize(0 until 10).toDF("id").withColumn("rand1", rand(seed=10))
   *      .withColumn("rand2", rand(seed=27))
   *    df.stat.corr("rand1", "rand2")
   *    res1: Double = 0.613...
   * </code></pre>
   * <p>
   * @since 1.4.0
   * @param method (undocumented)
   */
  public  double corr (java.lang.String col1, java.lang.String col2, java.lang.String method)  { throw new RuntimeException(); }
  /**
   * Calculates the Pearson Correlation Coefficient of two columns of a DataFrame.
   * <p>
   * @param col1 the name of the column
   * @param col2 the name of the column to calculate the correlation against
   * @return The Pearson Correlation Coefficient as a Double.
   * <p>
   * <pre><code>
   *    val df = sc.parallelize(0 until 10).toDF("id").withColumn("rand1", rand(seed=10))
   *      .withColumn("rand2", rand(seed=27))
   *    df.stat.corr("rand1", "rand2", "pearson")
   *    res1: Double = 0.613...
   * </code></pre>
   * <p>
   * @since 1.4.0
   */
  public  double corr (java.lang.String col1, java.lang.String col2)  { throw new RuntimeException(); }
  /**
   * Builds a Count-min Sketch over a specified column.
   * <p>
   * @param colName name of the column over which the sketch is built
   * @param depth depth of the sketch
   * @param width width of the sketch
   * @param seed random seed
   * @return a <code>CountMinSketch</code> over column <code>colName</code>
   * @since 2.0.0
   */
  public  org.apache.spark.util.sketch.CountMinSketch countMinSketch (java.lang.String colName, int depth, int width, int seed)  { throw new RuntimeException(); }
  /**
   * Builds a Count-min Sketch over a specified column.
   * <p>
   * @param colName name of the column over which the sketch is built
   * @param eps relative error of the sketch
   * @param confidence confidence of the sketch
   * @param seed random seed
   * @return a <code>CountMinSketch</code> over column <code>colName</code>
   * @since 2.0.0
   */
  public  org.apache.spark.util.sketch.CountMinSketch countMinSketch (java.lang.String colName, double eps, double confidence, int seed)  { throw new RuntimeException(); }
  /**
   * Builds a Count-min Sketch over a specified column.
   * <p>
   * @param col the column over which the sketch is built
   * @param depth depth of the sketch
   * @param width width of the sketch
   * @param seed random seed
   * @return a <code>CountMinSketch</code> over column <code>colName</code>
   * @since 2.0.0
   */
  public  org.apache.spark.util.sketch.CountMinSketch countMinSketch (org.apache.spark.sql.Column col, int depth, int width, int seed)  { throw new RuntimeException(); }
  /**
   * Builds a Count-min Sketch over a specified column.
   * <p>
   * @param col the column over which the sketch is built
   * @param eps relative error of the sketch
   * @param confidence confidence of the sketch
   * @param seed random seed
   * @return a <code>CountMinSketch</code> over column <code>colName</code>
   * @since 2.0.0
   */
  public  org.apache.spark.util.sketch.CountMinSketch countMinSketch (org.apache.spark.sql.Column col, double eps, double confidence, int seed)  { throw new RuntimeException(); }
  /**
   * Calculate the sample covariance of two numerical columns of a DataFrame.
   * @param col1 the name of the first column
   * @param col2 the name of the second column
   * @return the covariance of the two columns.
   * <p>
   * <pre><code>
   *    val df = sc.parallelize(0 until 10).toDF("id").withColumn("rand1", rand(seed=10))
   *      .withColumn("rand2", rand(seed=27))
   *    df.stat.cov("rand1", "rand2")
   *    res1: Double = 0.065...
   * </code></pre>
   * <p>
   * @since 1.4.0
   */
  public  double cov (java.lang.String col1, java.lang.String col2)  { throw new RuntimeException(); }
  /**
   * Computes a pair-wise frequency table of the given columns. Also known as a contingency table.
   * The number of distinct values for each column should be less than 1e4. At most 1e6 non-zero
   * pair frequencies will be returned.
   * The first column of each row will be the distinct values of <code>col1</code> and the column names will
   * be the distinct values of <code>col2</code>. The name of the first column will be <code>col1_col2</code>. Counts
   * will be returned as <code>Long</code>s. Pairs that have no occurrences will have zero as their counts.
   * Null elements will be replaced by "null", and back ticks will be dropped from elements if they
   * exist.
   * <p>
   * @param col1 The name of the first column. Distinct items will make the first item of
   *             each row.
   * @param col2 The name of the second column. Distinct items will make the column names
   *             of the DataFrame.
   * @return A DataFrame containing for the contingency table.
   * <p>
   * <pre><code>
   *    val df = spark.createDataFrame(Seq((1, 1), (1, 2), (2, 1), (2, 1), (2, 3), (3, 2), (3, 3)))
   *      .toDF("key", "value")
   *    val ct = df.stat.crosstab("key", "value")
   *    ct.show()
   *    +---------+---+---+---+
   *    |key_value|  1|  2|  3|
   *    +---------+---+---+---+
   *    |        2|  2|  0|  1|
   *    |        1|  1|  1|  0|
   *    |        3|  0|  1|  1|
   *    +---------+---+---+---+
   * </code></pre>
   * <p>
   * @since 1.4.0
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> crosstab (java.lang.String col1, java.lang.String col2)  { throw new RuntimeException(); }
  /**
   * Finding frequent items for columns, possibly with false positives. Using the
   * frequent element count algorithm described in
   * <a href="https://doi.org/10.1145/762471.762473">here</a>, proposed by Karp,
   * Schenker, and Papadimitriou.
   * The <code>support</code> should be greater than 1e-4.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting <code>DataFrame</code>.
   * <p>
   * @param cols the names of the columns to search frequent items in.
   * @param support The minimum frequency for an item to be considered <code>frequent</code>. Should be greater
   *                than 1e-4.
   * @return A Local DataFrame with the Array of frequent items for each column.
   * <p>
   * <pre><code>
   *    val rows = Seq.tabulate(100) { i =&gt;
   *      if (i % 2 == 0) (1, -1.0) else (i, i * -1.0)
   *    }
   *    val df = spark.createDataFrame(rows).toDF("a", "b")
   *    // find the items with a frequency greater than 0.4 (observed 40% of the time) for columns
   *    // "a" and "b"
   *    val freqSingles = df.stat.freqItems(Array("a", "b"), 0.4)
   *    freqSingles.show()
   *    +-----------+-------------+
   *    |a_freqItems|  b_freqItems|
   *    +-----------+-------------+
   *    |    [1, 99]|[-1.0, -99.0]|
   *    +-----------+-------------+
   *    // find the pair of items with a frequency greater than 0.1 in columns "a" and "b"
   *    val pairDf = df.select(struct("a", "b").as("a-b"))
   *    val freqPairs = pairDf.stat.freqItems(Array("a-b"), 0.1)
   *    freqPairs.select(explode($"a-b_freqItems").as("freq_ab")).show()
   *    +----------+
   *    |   freq_ab|
   *    +----------+
   *    |  [1,-1.0]|
   *    |   ...    |
   *    +----------+
   * </code></pre>
   * <p>
   * @since 1.4.0
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> freqItems (java.lang.String[] cols, double support)  { throw new RuntimeException(); }
  /**
   * Finding frequent items for columns, possibly with false positives. Using the
   * frequent element count algorithm described in
   * <a href="https://doi.org/10.1145/762471.762473">here</a>, proposed by Karp,
   * Schenker, and Papadimitriou.
   * Uses a <code>default</code> support of 1%.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting <code>DataFrame</code>.
   * <p>
   * @param cols the names of the columns to search frequent items in.
   * @return A Local DataFrame with the Array of frequent items for each column.
   * <p>
   * @since 1.4.0
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> freqItems (java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Finding frequent items for columns, possibly with false positives. Using the
   * frequent element count algorithm described in
   * <a href="https://doi.org/10.1145/762471.762473">here</a>, proposed by Karp, Schenker,
   * and Papadimitriou.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting <code>DataFrame</code>.
   * <p>
   * @param cols the names of the columns to search frequent items in.
   * @return A Local DataFrame with the Array of frequent items for each column.
   * <p>
   * <pre><code>
   *    val rows = Seq.tabulate(100) { i =&gt;
   *      if (i % 2 == 0) (1, -1.0) else (i, i * -1.0)
   *    }
   *    val df = spark.createDataFrame(rows).toDF("a", "b")
   *    // find the items with a frequency greater than 0.4 (observed 40% of the time) for columns
   *    // "a" and "b"
   *    val freqSingles = df.stat.freqItems(Seq("a", "b"), 0.4)
   *    freqSingles.show()
   *    +-----------+-------------+
   *    |a_freqItems|  b_freqItems|
   *    +-----------+-------------+
   *    |    [1, 99]|[-1.0, -99.0]|
   *    +-----------+-------------+
   *    // find the pair of items with a frequency greater than 0.1 in columns "a" and "b"
   *    val pairDf = df.select(struct("a", "b").as("a-b"))
   *    val freqPairs = pairDf.stat.freqItems(Seq("a-b"), 0.1)
   *    freqPairs.select(explode($"a-b_freqItems").as("freq_ab")).show()
   *    +----------+
   *    |   freq_ab|
   *    +----------+
   *    |  [1,-1.0]|
   *    |   ...    |
   *    +----------+
   * </code></pre>
   * <p>
   * @since 1.4.0
   * @param support (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> freqItems (scala.collection.Seq<java.lang.String> cols, double support)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Finding frequent items for columns, possibly with false positives. Using the
   * frequent element count algorithm described in
   * <a href="https://doi.org/10.1145/762471.762473">here</a>, proposed by Karp, Schenker,
   * and Papadimitriou.
   * Uses a <code>default</code> support of 1%.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting <code>DataFrame</code>.
   * <p>
   * @param cols the names of the columns to search frequent items in.
   * @return A Local DataFrame with the Array of frequent items for each column.
   * <p>
   * @since 1.4.0
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> freqItems (scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a stratified sample without replacement based on the fraction given on each stratum.
   * @param col column that defines strata
   * @param fractions sampling fraction for each stratum. If a stratum is not specified, we treat
   *                  its fraction as zero.
   * @param seed random seed
   * @tparam T stratum type
   * @return a new <code>DataFrame</code> that represents the stratified sample
   * <p>
   * <pre><code>
   *    val df = spark.createDataFrame(Seq((1, 1), (1, 2), (2, 1), (2, 1), (2, 3), (3, 2),
   *      (3, 3))).toDF("key", "value")
   *    val fractions = Map(1 -&gt; 1.0, 3 -&gt; 0.5)
   *    df.stat.sampleBy("key", fractions, 36L).show()
   *    +---+-----+
   *    |key|value|
   *    +---+-----+
   *    |  1|    1|
   *    |  1|    2|
   *    |  3|    2|
   *    +---+-----+
   * </code></pre>
   * <p>
   * @since 1.5.0
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> sampleBy (java.lang.String col, scala.collection.immutable.Map<T, java.lang.Object> fractions, long seed)  { throw new RuntimeException(); }
  /**
   * Returns a stratified sample without replacement based on the fraction given on each stratum.
   * @param col column that defines strata
   * @param fractions sampling fraction for each stratum. If a stratum is not specified, we treat
   *                  its fraction as zero.
   * @param seed random seed
   * @tparam T stratum type
   * @return a new <code>DataFrame</code> that represents the stratified sample
   * <p>
   * @since 1.5.0
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> sampleBy (java.lang.String col, java.util.Map<T, java.lang.Double> fractions, long seed)  { throw new RuntimeException(); }
  /**
   * Returns a stratified sample without replacement based on the fraction given on each stratum.
   * @param col column that defines strata
   * @param fractions sampling fraction for each stratum. If a stratum is not specified, we treat
   *                  its fraction as zero.
   * @param seed random seed
   * @tparam T stratum type
   * @return a new <code>DataFrame</code> that represents the stratified sample
   * <p>
   * The stratified sample can be performed over multiple columns:
   * <pre><code>
   *    import org.apache.spark.sql.Row
   *    import org.apache.spark.sql.functions.struct
   *
   *    val df = spark.createDataFrame(Seq(("Bob", 17), ("Alice", 10), ("Nico", 8), ("Bob", 17),
   *      ("Alice", 10))).toDF("name", "age")
   *    val fractions = Map(Row("Alice", 10) -&gt; 0.3, Row("Nico", 8) -&gt; 1.0)
   *    df.stat.sampleBy(struct($"name", $"age"), fractions, 36L).show()
   *    +-----+---+
   *    | name|age|
   *    +-----+---+
   *    | Nico|  8|
   *    |Alice| 10|
   *    +-----+---+
   * </code></pre>
   * <p>
   * @since 3.0.0
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> sampleBy (org.apache.spark.sql.Column col, scala.collection.immutable.Map<T, java.lang.Object> fractions, long seed)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Returns a stratified sample without replacement based on the fraction given
   * on each stratum.
   * @param col column that defines strata
   * @param fractions sampling fraction for each stratum. If a stratum is not specified, we treat
   *                  its fraction as zero.
   * @param seed random seed
   * @tparam T stratum type
   * @return a new <code>DataFrame</code> that represents the stratified sample
   * <p>
   * @since 3.0.0
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> sampleBy (org.apache.spark.sql.Column col, java.util.Map<T, java.lang.Double> fractions, long seed)  { throw new RuntimeException(); }
}
