package org.apache.spark.sql.catalyst;
/**
 * The class provides API for applying pushed down filters to partially or
 * fully set internal rows that have the struct schema.
 * <p>
 * <code>StructFilters</code> assumes that:
 *   - <code>reset()</code> is called before any <code>skipRow()</code> calls for new row.
 * <p>
 * param:  pushedFilters The pushed down source filters. The filters should refer to
 *                      the fields of the provided schema.
 * param:  schema The required schema of records from datasource files.
 */
public abstract class StructFilters {
  /**
   * Returns the filters currently supported by the datasource.
   * @param filters The filters pushed down to the datasource.
   * @param schema data schema of datasource files.
   * @return a sub-set of <code>filters</code> that can be handled by the datasource.
   */
  static public  org.apache.spark.sql.sources.Filter[] pushedFilters (org.apache.spark.sql.sources.Filter[] filters, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Converts a filter to an expression and binds it to row positions.
   * <p>
   * @param filter The filter to convert.
   * @param toRef The function converts a filter attribute to a bound reference.
   * @return some expression with resolved attributes or <code>None</code> if the conversion
   *         of the given filter to an expression is impossible.
   */
  static public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> filterToExpression (org.apache.spark.sql.sources.Filter filter, scala.Function1<java.lang.String, scala.Option<org.apache.spark.sql.catalyst.expressions.BoundReference>> toRef)  { throw new RuntimeException(); }
  public   StructFilters (scala.collection.Seq<org.apache.spark.sql.sources.Filter> pushedFilters, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.sources.Filter[] filters ()  { throw new RuntimeException(); }
  /**
   * Applies pushed down source filters to the given row assuming that
   * value at <code>index</code> has been already set.
   * <p>
   * @param row The row with fully or partially set values.
   * @param index The index of already set value.
   * @return <code>true</code> if currently processed row can be skipped otherwise false.
   */
  public abstract  boolean skipRow (org.apache.spark.sql.catalyst.InternalRow row, int index)  ;
  /**
   * Resets states of pushed down filters. The method must be called before
   * processing any new row otherwise <code>skipRow()</code> may return wrong result.
   */
  public abstract  void reset ()  ;
  /**
   * Compiles source filters to a predicate.
   * @param filters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.BasePredicate toPredicate (scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
}
