package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/**
 * This class contains the original column stats from child, and maintains the updated column stats.
 * We will update the corresponding ColumnStats for a column after we apply a predicate condition.
 * For example, column c has [min, max] value as [0, 100].  In a range condition such as
 * (c > 40 AND c <= 50), we need to set the column's [min, max] value to [40, 100] after we
 * evaluate the first condition c > 40. We also need to set the column's [min, max] value to
 * [40, 50] after we evaluate the second condition c <= 50.
 * <p>
 * param:  originalMap Original column stats from child.
 */
public  class ColumnStatsMap implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> originalMap ()  { throw new RuntimeException(); }
  // not preceding
  public   ColumnStatsMap (org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> originalMap)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  /**
   * Gets an Option of column stat for the given attribute.
   * Prefer the column stat in updatedMap than that in originalMap,
   * because updatedMap has the latest (updated) column stats.
   * @param a (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> get (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  public  boolean hasCountStats (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  public  boolean hasDistinctCount (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  public  boolean hasMinMaxStats (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  /**
   * Gets column stat for the given attribute. Prefer the column stat in updatedMap than that in
   * originalMap, because updatedMap has the latest (updated) column stats.
   * @param a (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.ColumnStat apply (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  /** Updates column stats in updatedMap. */
  public  void update (org.apache.spark.sql.catalyst.expressions.Attribute a, org.apache.spark.sql.catalyst.plans.logical.ColumnStat stats)  { throw new RuntimeException(); }
  /**
   * Collects updated column stats, and scales down ndv for other column stats if the number of rows
   * decreases after this Filter operator.
   * @param rowsBeforeFilter (undocumented)
   * @param rowsAfterFilter (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> outputColumnStats (scala.math.BigInt rowsBeforeFilter, scala.math.BigInt rowsAfterFilter)  { throw new RuntimeException(); }
}
