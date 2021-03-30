package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * API for aggregation functions that are expressed in terms of Catalyst expressions.
 * <p>
 * When implementing a new expression-based aggregate function, start by implementing
 * <code>bufferAttributes</code>, defining attributes for the fields of the mutable aggregation buffer. You
 * can then use these attributes when defining <code>updateExpressions</code>, <code>mergeExpressions</code>, and
 * <code>evaluateExpressions</code>.
 * <p>
 * Please note that children of an aggregate function can be unresolved (it will happen when
 * we create this function in DataFrame API). So, if there is any fields in
 * the implemented class that need to access fields of its children, please make
 * those fields <code>lazy val</code>s.
 */
public abstract class DeclarativeAggregate extends org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction implements scala.Serializable {
  /**
   * A helper class for representing an attribute used in merging two
   * aggregation buffers. When merging two buffers, <code>bufferLeft</code> and <code>bufferRight</code>,
   * we merge buffer values and then update bufferLeft. A {@link RichAttribute}
   * of an {@link AttributeReference} <code>a</code> has two functions <code>left</code> and <code>right</code>,
   * which represent <code>a</code> in <code>bufferLeft</code> and <code>bufferRight</code>, respectively.
   */
  public  class RichAttribute {
    public   RichAttribute (org.apache.spark.sql.catalyst.expressions.AttributeReference a)  { throw new RuntimeException(); }
    /** Represents this attribute at the mutable buffer side. */
    public  org.apache.spark.sql.catalyst.expressions.AttributeReference left ()  { throw new RuntimeException(); }
    /** Represents this attribute at the input buffer side (the data value is read-only). */
    public  org.apache.spark.sql.catalyst.expressions.AttributeReference right ()  { throw new RuntimeException(); }
  }
  public   DeclarativeAggregate ()  { throw new RuntimeException(); }
  /** An expression-based aggregate's bufferSchema is derived from bufferAttributes. */
  public final  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  protected final  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public final  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /**
   * An expression which returns the final value for this aggregate function. Its data type should
   * match this expression's {@link dataType}.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  ;
  /**
   * Expressions for initializing empty aggregation buffers.
   * @return (undocumented)
   */
  public abstract  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  ;
  // not preceding
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
  /**
   * A sequence of expressions for merging two aggregation buffers together. When defining these
   * expressions, you can use the syntax <code>attributeName.left</code> and <code>attributeName.right</code> to refer
   * to the attributes corresponding to each of the buffers being merged (this magic is enabled
   * by the {@link RichAttribute} implicit class).
   * @return (undocumented)
   */
  public abstract  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> mergeExpressions ()  ;
  /**
   * Expressions for updating the mutable aggregation buffer based on an input row.
   * @return (undocumented)
   */
  public abstract  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  ;
}
