package org.apache.spark.sql.expressions;
/**
 * Utility functions for defining window in DataFrames.
 * <p>
 * <pre><code>
 *   // PARTITION BY country ORDER BY date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
 *   Window.partitionBy("country").orderBy("date")
 *     .rowsBetween(Window.unboundedPreceding, Window.currentRow)
 *
 *   // PARTITION BY country ORDER BY date ROWS BETWEEN 3 PRECEDING AND 3 FOLLOWING
 *   Window.partitionBy("country").orderBy("date").rowsBetween(-3, 3)
 * </code></pre>
 * <p>
 * @since 1.4.0
 */
public  class Window {
  /**
   * Creates a {@link WindowSpec} with the partitioning defined.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec partitionBy (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the partitioning defined.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec partitionBy (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the ordering defined.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec orderBy (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the ordering defined.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec orderBy (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the partitioning defined.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec partitionBy (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the partitioning defined.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec partitionBy (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the ordering defined.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec orderBy (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the ordering defined.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec orderBy (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Value representing the first row in the partition, equivalent to "UNBOUNDED PRECEDING" in SQL.
   * This can be used to specify the frame boundaries:
   * <p>
   * <pre><code>
   *   Window.rowsBetween(Window.unboundedPreceding, Window.currentRow)
   * </code></pre>
   * <p>
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  long unboundedPreceding ()  { throw new RuntimeException(); }
  /**
   * Value representing the last row in the partition, equivalent to "UNBOUNDED FOLLOWING" in SQL.
   * This can be used to specify the frame boundaries:
   * <p>
   * <pre><code>
   *   Window.rowsBetween(Window.unboundedPreceding, Window.unboundedFollowing)
   * </code></pre>
   * <p>
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  long unboundedFollowing ()  { throw new RuntimeException(); }
  /**
   * Value representing the current row. This can be used to specify the frame boundaries:
   * <p>
   * <pre><code>
   *   Window.rowsBetween(Window.unboundedPreceding, Window.currentRow)
   * </code></pre>
   * <p>
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  long currentRow ()  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the frame boundaries defined,
   * from <code>start</code> (inclusive) to <code>end</code> (inclusive).
   * <p>
   * Both <code>start</code> and <code>end</code> are positions relative to the current row. For example, "0" means
   * "current row", while "-1" means the row before the current row, and "5" means the fifth row
   * after the current row.
   * <p>
   * We recommend users use <code>Window.unboundedPreceding</code>, <code>Window.unboundedFollowing</code>,
   * and <code>Window.currentRow</code> to specify special boundary values, rather than using integral
   * values directly.
   * <p>
   * A row based boundary is based on the position of the row within the partition.
   * An offset indicates the number of rows above or below the current row, the frame for the
   * current row starts or ends. For instance, given a row based sliding frame with a lower bound
   * offset of -1 and a upper bound offset of +2. The frame for row with index 5 would range from
   * index 4 to index 7.
   * <p>
   * <pre><code>
   *   import org.apache.spark.sql.expressions.Window
   *   val df = Seq((1, "a"), (1, "a"), (2, "a"), (1, "b"), (2, "b"), (3, "b"))
   *     .toDF("id", "category")
   *   val byCategoryOrderedById =
   *     Window.partitionBy($"category").orderBy($"id").rowsBetween(Window.currentRow, 1)
   *   df.withColumn("sum", sum($"id") over byCategoryOrderedById).show()
   *
   *   +---+--------+---+
   *   | id|category|sum|
   *   +---+--------+---+
   *   |  1|       b|  3|
   *   |  2|       b|  5|
   *   |  3|       b|  3|
   *   |  1|       a|  2|
   *   |  1|       a|  3|
   *   |  2|       a|  2|
   *   +---+--------+---+
   * </code></pre>
   * <p>
   * @param start boundary start, inclusive. The frame is unbounded if this is
   *              the minimum long value (<code>Window.unboundedPreceding</code>).
   * @param end boundary end, inclusive. The frame is unbounded if this is the
   *            maximum long value (<code>Window.unboundedFollowing</code>).
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec rowsBetween (long start, long end)  { throw new RuntimeException(); }
  /**
   * Creates a {@link WindowSpec} with the frame boundaries defined,
   * from <code>start</code> (inclusive) to <code>end</code> (inclusive).
   * <p>
   * Both <code>start</code> and <code>end</code> are relative to the current row. For example, "0" means "current row",
   * while "-1" means one off before the current row, and "5" means the five off after the
   * current row.
   * <p>
   * We recommend users use <code>Window.unboundedPreceding</code>, <code>Window.unboundedFollowing</code>,
   * and <code>Window.currentRow</code> to specify special boundary values, rather than using long values
   * directly.
   * <p>
   * A range-based boundary is based on the actual value of the ORDER BY
   * expression(s). An offset is used to alter the value of the ORDER BY expression,
   * for instance if the current ORDER BY expression has a value of 10 and the lower bound offset
   * is -3, the resulting lower bound for the current row will be 10 - 3 = 7. This however puts a
   * number of constraints on the ORDER BY expressions: there can be only one expression and this
   * expression must have a numerical data type. An exception can be made when the offset is
   * unbounded, because no value modification is needed, in this case multiple and non-numeric
   * ORDER BY expression are allowed.
   * <p>
   * <pre><code>
   *   import org.apache.spark.sql.expressions.Window
   *   val df = Seq((1, "a"), (1, "a"), (2, "a"), (1, "b"), (2, "b"), (3, "b"))
   *     .toDF("id", "category")
   *   val byCategoryOrderedById =
   *     Window.partitionBy($"category").orderBy($"id").rangeBetween(Window.currentRow, 1)
   *   df.withColumn("sum", sum($"id") over byCategoryOrderedById).show()
   *
   *   +---+--------+---+
   *   | id|category|sum|
   *   +---+--------+---+
   *   |  1|       b|  3|
   *   |  2|       b|  5|
   *   |  3|       b|  3|
   *   |  1|       a|  4|
   *   |  1|       a|  4|
   *   |  2|       a|  2|
   *   +---+--------+---+
   * </code></pre>
   * <p>
   * @param start boundary start, inclusive. The frame is unbounded if this is
   *              the minimum long value (<code>Window.unboundedPreceding</code>).
   * @param end boundary end, inclusive. The frame is unbounded if this is the
   *            maximum long value (<code>Window.unboundedFollowing</code>).
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.WindowSpec rangeBetween (long start, long end)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.expressions.WindowSpec spec ()  { throw new RuntimeException(); }
}
