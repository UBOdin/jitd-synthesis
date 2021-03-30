package org.apache.spark.sql.catalyst.expressions;
/**
 * An interpreted version of a safe projection.
 * <p>
 * param:  expressions that produces the resulting fields. These expressions must be bound
 *                    to a schema.
 */
public  class InterpretedSafeProjection extends org.apache.spark.sql.catalyst.expressions.Projection {
  /**
   * Returns an {@link SafeProjection} for given sequence of bound Expressions.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.Projection createProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  public   InterpretedSafeProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow apply (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
