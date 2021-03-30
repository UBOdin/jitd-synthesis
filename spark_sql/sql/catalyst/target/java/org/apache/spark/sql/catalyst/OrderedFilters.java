package org.apache.spark.sql.catalyst;
/**
 * An instance of the class compiles filters to predicates and sorts them in
 * the order which allows to apply the predicates to an internal row with partially
 * initialized values, for instance converted from parsed CSV fields.
 * <p>
 * param:  filters The filters pushed down to a datasource.
 * param:  requiredSchema The schema with only fields requested by the upper layer.
 */
public  class OrderedFilters extends org.apache.spark.sql.catalyst.StructFilters {
  public   OrderedFilters (scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, org.apache.spark.sql.types.StructType requiredSchema)  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  /**
   * Applies all filters that refer to row fields at the positions from 0 to <code>index</code>.
   * @param row The internal row to check.
   * @param index Maximum field index. The function assumes that all fields
   *              from 0 to <code>index</code> position are set.
   * @return false<code> iff row fields at the position from 0 to </code>index<code> pass filters
   *         or there are no applicable filters
   *         otherwise </code>false<code> if at least one of the filters returns </code>false<code>.
   */
  public  boolean skipRow (org.apache.spark.sql.catalyst.InternalRow row, int index)  { throw new RuntimeException(); }
}
