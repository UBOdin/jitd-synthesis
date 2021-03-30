package org.apache.spark.sql.catalyst.expressions;
/**
 * A {@link MutableProjection} that is calculated by calling <code>eval</code> on each of the specified
 * expressions.
 * <p>
 * param:  expressions a sequence of expressions that determine the value of each column of the
 *                    output row.
 */
public  class InterpretedMutableProjection extends org.apache.spark.sql.catalyst.expressions.MutableProjection {
  /**
   * Returns a {@link MutableProjection} for given sequence of bound Expressions.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.MutableProjection createProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  public   InterpretedMutableProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
  public   InterpretedMutableProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  void initialize (int partitionIndex)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow currentValue ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.MutableProjection target (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow apply (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
}
