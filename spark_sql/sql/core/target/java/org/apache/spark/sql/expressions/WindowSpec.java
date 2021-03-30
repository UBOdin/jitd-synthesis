package org.apache.spark.sql.expressions;
/**
 * A window specification that defines the partitioning, ordering, and frame boundaries.
 * <p>
 * Use the static methods in {@link Window} to create a {@link WindowSpec}.
 * <p>
 * @since 1.4.0
 */
public  class WindowSpec {
  // not preceding
     WindowSpec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec, org.apache.spark.sql.catalyst.expressions.WindowFrame frame)  { throw new RuntimeException(); }
  /**
   * Defines the ordering columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec orderBy (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Defines the ordering columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec orderBy (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Defines the ordering columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec orderBy (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Defines the ordering columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec orderBy (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Defines the partitioning columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec partitionBy (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Defines the partitioning columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec partitionBy (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Defines the partitioning columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec partitionBy (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Defines the partitioning columns in a {@link WindowSpec}.
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec partitionBy (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Defines the frame boundaries, from <code>start</code> (inclusive) to <code>end</code> (inclusive).
   * <p>
   * Both <code>start</code> and <code>end</code> are relative from the current row. For example, "0" means
   * "current row", while "-1" means one off before the current row, and "5" means the five off
   * after the current row.
   * <p>
   * We recommend users use <code>Window.unboundedPreceding</code>, <code>Window.unboundedFollowing</code>,
   * and <code>Window.currentRow</code> to specify special boundary values, rather than using long values
   * directly.
   * <p>
   * A range-based boundary is based on the actual value of the ORDER BY
   * expression(s). An offset is used to alter the value of the ORDER BY expression, for
   * instance if the current order by expression has a value of 10 and the lower bound offset
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
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec rangeBetween (long start, long end)  { throw new RuntimeException(); }
  /**
   * Defines the frame boundaries, from <code>start</code> (inclusive) to <code>end</code> (inclusive).
   * <p>
   * Both <code>start</code> and <code>end</code> are relative positions from the current row. For example, "0" means
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
   * index 4 to index 6.
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
   * @since 1.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.expressions.WindowSpec rowsBetween (long start, long end)  { throw new RuntimeException(); }
  /**
   * Converts this {@link WindowSpec} into a {@link Column} with an aggregate expression.
   * @param aggregate (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Column withAggregate (org.apache.spark.sql.Column aggregate)  { throw new RuntimeException(); }
}
