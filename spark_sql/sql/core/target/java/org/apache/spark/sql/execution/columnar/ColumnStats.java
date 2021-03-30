package org.apache.spark.sql.execution.columnar;
/**
 * Used to collect statistical information when building in-memory columns.
 * <p>
 * NOTE: we intentionally avoid using <code>Ordering[T]</code> to compare values here because <code>Ordering[T]</code>
 * brings significant performance penalty.
 */
public  interface ColumnStats extends scala.Serializable {
  /**
   * Column statistics represented as an array, currently including closed lower bound, closed
   * upper bound and null count.
   * @return (undocumented)
   */
  public  java.lang.Object[] collectedStatistics ()  ;
  public  int count ()  ;
  /**
   * Gathers statistics information on <code>null</code>.
   */
  public  void gatherNullStats ()  ;
  /**
   * Gathers statistics information from <code>row(ordinal)</code>.
   * @param row (undocumented)
   * @param ordinal (undocumented)
   */
  public  void gatherStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
  public  int nullCount ()  ;
    long sizeInBytes ()  ;
}
