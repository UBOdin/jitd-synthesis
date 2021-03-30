package org.apache.spark.sql.catalyst.expressions;
/**
 * Base class for expressions that are converted to v2 partition transforms.
 * <p>
 * Subclasses represent abstract transform functions with concrete implementations that are
 * determined by data source implementations. Because the concrete implementation is not known,
 * these expressions are {@link Unevaluable}.
 * <p>
 * These expressions are used to pass transformations from the DataFrame API:
 * <p>
 * <pre><code>
 *   df.writeTo("catalog.db.table").partitionedBy($"category", days($"timestamp")).create()
 * </code></pre>
 */
public abstract class PartitionTransformExpression extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable {
  public   PartitionTransformExpression ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
}
