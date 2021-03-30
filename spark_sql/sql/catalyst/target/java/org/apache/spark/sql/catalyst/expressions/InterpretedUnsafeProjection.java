package org.apache.spark.sql.catalyst.expressions;
/**
 * An interpreted unsafe projection. This class reuses the {@link UnsafeRow} it produces, a consumer
 * should copy the row if it is being buffered. This class is not thread safe.
 * <p>
 * param:  expressions that produces the resulting fields. These expressions must be bound
 *                    to a schema.
 */
public  class InterpretedUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
  /**
   * Returns an {@link UnsafeProjection} for given sequence of bound Expressions.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.UnsafeProjection createProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  public   InterpretedUnsafeProjection (org.apache.spark.sql.catalyst.expressions.Expression[] expressions)  { throw new RuntimeException(); }
  /** The writer that writes the intermediate result to the result row. */
  public  void initialize (int partitionIndex)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow apply (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
