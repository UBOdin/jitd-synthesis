package org.apache.spark.sql;
/**
 * A {@link Column} where an {@link Encoder} has been given for the expected input and return type.
 * To create a {@link TypedColumn}, use the <code>as</code> function on a {@link Column}.
 * <p>
 * @param <T>  The input type expected for this expression.  Can be <code>Any</code> if the expression is type
 *           checked by the analyzer instead of the compiler (i.e. <code>expr("sum(...)")</code>).
 * @param <U>  The output type of this column.
 * <p>
 * @since 1.6.0
 */
public  class TypedColumn<T extends java.lang.Object, U extends java.lang.Object> extends org.apache.spark.sql.Column {
  // not preceding
  public   TypedColumn (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<U> encoder)  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<U> encoder ()  { throw new RuntimeException(); }
  /**
   * Gives the {@link TypedColumn} a name (alias).
   * If the current <code>TypedColumn</code> has metadata associated with it, this metadata will be propagated
   * to the new column.
   * <p>
   * @group expr_ops
   * @since 2.0.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.TypedColumn<T, U> name (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * Inserts the specific input type and schema into any expressions that are expected to operate
   * on a decoded object.
   * @param inputEncoder (undocumented)
   * @param inputAttributes (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.TypedColumn<T, U> withInputType (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?> inputEncoder, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes)  { throw new RuntimeException(); }
}
