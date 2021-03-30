package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression with one input and one output. The output is by default evaluated to null
 * if the input is evaluated to null.
 */
public abstract class UnaryExpression extends org.apache.spark.sql.catalyst.expressions.Expression {
  static public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> unapply (org.apache.spark.sql.catalyst.expressions.UnaryExpression e)  { throw new RuntimeException(); }
  public   UnaryExpression ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression child ()  ;
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  /**
   * Default behavior of evaluation according to the default nullability of UnaryExpression.
   * If subclass of UnaryExpression override nullable, probably should also override this.
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /**
   * Called by default {@link eval} implementation.  If subclass of UnaryExpression keep the default
   * nullability, they can override this method to save null-check code.  If we need full control
   * of evaluation process, we should override {@link eval}.
   * @param input (undocumented)
   * @return (undocumented)
   */
  protected  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  /**
   * Called by unary expressions to generate a code block that returns null if its parent returns
   * null, and if not null, use <code>f</code> to generate the expression.
   * <p>
   * As an example, the following does a boolean inversion (i.e. NOT).
   * <pre><code>
   *   defineCodeGen(ctx, ev, c =&gt; s"!($c)")
   * </code></pre>
   * <p>
   * @param f function that accepts a variable name and returns Java code to compute the output.
   * @param ctx (undocumented)
   * @param ev (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode defineCodeGen (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, scala.Function1<java.lang.String, java.lang.String> f)  { throw new RuntimeException(); }
  /**
   * Called by unary expressions to generate a code block that returns null if its parent returns
   * null, and if not null, use <code>f</code> to generate the expression.
   * <p>
   * @param f function that accepts the non-null evaluation result name of child and returns Java
   *          code to compute the output.
   * @param ctx (undocumented)
   * @param ev (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode nullSafeCodeGen (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, scala.Function1<java.lang.String, java.lang.String> f)  { throw new RuntimeException(); }
}
