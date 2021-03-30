package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression with two inputs and one output. The output is by default evaluated to null
 * if any input is evaluated to null.
 */
public abstract class BinaryExpression extends org.apache.spark.sql.catalyst.expressions.Expression {
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> unapply (org.apache.spark.sql.catalyst.expressions.BinaryExpression e)  { throw new RuntimeException(); }
  public   BinaryExpression ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression left ()  ;
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression right ()  ;
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  /**
   * Default behavior of evaluation according to the default nullability of BinaryExpression.
   * If subclass of BinaryExpression override nullable, probably should also override this.
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /**
   * Called by default {@link eval} implementation.  If subclass of BinaryExpression keep the default
   * nullability, they can override this method to save null-check code.  If we need full control
   * of evaluation process, we should override {@link eval}.
   * @param input1 (undocumented)
   * @param input2 (undocumented)
   * @return (undocumented)
   */
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  /**
   * Short hand for generating binary evaluation code.
   * If either of the sub-expressions is null, the result of this computation
   * is assumed to be null.
   * <p>
   * @param f accepts two variable names and returns Java code to compute the output.
   * @param ctx (undocumented)
   * @param ev (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode defineCodeGen (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, scala.Function2<java.lang.String, java.lang.String, java.lang.String> f)  { throw new RuntimeException(); }
  /**
   * Short hand for generating binary evaluation code.
   * If either of the sub-expressions is null, the result of this computation
   * is assumed to be null.
   * <p>
   * @param f function that accepts the 2 non-null evaluation result names of children
   *          and returns Java code to compute the output.
   * @param ctx (undocumented)
   * @param ev (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode nullSafeCodeGen (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, scala.Function2<java.lang.String, java.lang.String, java.lang.String> f)  { throw new RuntimeException(); }
}
