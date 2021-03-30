package org.apache.spark.sql.columnar;
/**
 * A {@link CachedBatch} that stores some simple metrics that can be used for filtering of batches with
 * the {@link SimpleMetricsCachedBatchSerializer}.
 * The metrics are returned by the stats value. For each column in the batch 5 columns of metadata
 * are needed in the row.
 */
public  interface SimpleMetricsCachedBatch extends org.apache.spark.sql.columnar.CachedBatch {
  public  long sizeInBytes ()  ;
  /**
   * Holds stats for each cached column. The optional <code>upperBound</code> and <code>lowerBound</code> should be
   * of the same type as the original column. If they are null, then it is assumed that they
   * are not provided, and will not be used for filtering.
   * <ul>
   *   <li><code>upperBound</code> (optional)</li>
   *   <li><code>lowerBound</code> (Optional)</li>
   *   <li><code>nullCount</code>: <code>Int</code></li>
   *   <li><code>rowCount</code>: <code>Int</code></li>
   *   <li><code>sizeInBytes</code>: <code>Long</code></li>
   * </ul>
   * These are repeated for each column in the original cached data.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow stats ()  ;
}
