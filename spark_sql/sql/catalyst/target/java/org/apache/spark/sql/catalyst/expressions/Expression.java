package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression in Catalyst.
 * <p>
 * If an expression wants to be exposed in the function registry (so users can call it with
 * "name(arguments...)", the concrete implementation must be a case class whose constructor
 * arguments are all Expressions types. See {@link Substring} for an example.
 * <p>
 * There are a few important traits or abstract classes:
 * <p>
 * - {@link Nondeterministic}: an expression that is not deterministic.
 * - {@link Stateful}: an expression that contains mutable state. For example, MonotonicallyIncreasingID
 *                 and Rand. A stateful expression is always non-deterministic.
 * - {@link Unevaluable}: an expression that is not supposed to be evaluated.
 * - {@link CodegenFallback}: an expression that does not have code gen implemented and falls back to
 *                        interpreted mode.
 * - {@link NullIntolerant}: an expression that is null intolerant (i.e. any null input will result in
 *                       null output).
 * - {@link NonSQLExpression}: a common base trait for the expressions that do not have SQL
 *                         expressions like representation. For example, <code>ScalaUDF</code>, <code>ScalaUDAF</code>,
 *                         and object <code>MapObjects</code> and <code>Invoke</code>.
 * - {@link UserDefinedExpression}: a common base trait for user-defined functions, including
 *                              UDF/UDAF/UDTF.
 * - {@link HigherOrderFunction}: a common base trait for higher order functions that take one or more
 *                            (lambda) functions and applies these to some objects. The function
 *                            produces a number of variables which can be consumed by some lambda
 *                            functions.
 * - {@link NamedExpression}: An {@link Expression} that is named.
 * - {@link TimeZoneAwareExpression}: A common base trait for time zone aware expressions.
 * - {@link SubqueryExpression}: A base interface for expressions that contain a
 *                           {@link org.apache.spark.sql.catalyst.plans.logical.LogicalPlan}.
 * <p>
 * - {@link LeafExpression}: an expression that has no child.
 * - {@link UnaryExpression}: an expression that has one child.
 * - {@link BinaryExpression}: an expression that has two children.
 * - {@link TernaryExpression}: an expression that has three children.
 * - {@link QuaternaryExpression}: an expression that has four children.
 * - {@link BinaryOperator}: a special case of {@link BinaryExpression} that requires two children to have
 *                       the same output data type.
 * <p>
 * A few important traits used for type coercion rules:
 * - {@link ExpectsInputTypes}: an expression that has the expected input types. This trait is typically
 *                          used by operator expressions (e.g. {@link Add}, {@link Subtract}) to define
 *                          expected input types without any implicit casting.
 * - {@link ImplicitCastInputTypes}: an expression that has the expected input types, which can be
 *                               implicitly castable using {@link TypeCoercion.ImplicitTypeCasts}.
 * - {@link ComplexTypeMergingExpression}: to resolve output types of the complex expressions
 *                                     (e.g., {@link CaseWhen}).
 */
public abstract class Expression extends org.apache.spark.sql.catalyst.trees.TreeNode<org.apache.spark.sql.catalyst.expressions.Expression> {
  public   Expression ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  /**
   * Checks the input data types, returns <code>TypeCheckResult.success</code> if it's valid,
   * or returns a <code>TypeCheckResult</code> with an error message if invalid.
   * Note: it's not valid to call this method until <code>childrenResolved == true</code>.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  /**
   * Returns true if  all the children of this expression have been resolved to a specific schema
   * and false if any still contains any unresolved placeholders.
   * @return (undocumented)
   */
  public  boolean childrenResolved ()  { throw new RuntimeException(); }
  /**
   * Returns the {@link DataType} of the result of evaluating this expression.  It is
   * invalid to query the dataType of an unresolved expression (i.e., when <code>resolved</code> == false).
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.types.DataType dataType ()  ;
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  /**
   * Returns Java source code that can be compiled to evaluate this expression.
   * The default behavior is to call the eval method of the expression. Concrete expression
   * implementations should override this to do actual code generation.
   * <p>
   * @param ctx a {@link CodegenContext}
   * @param ev an {@link ExprCode} with unique terms.
   * @return an {@link ExprCode} containing the Java source code to generate the given expression
   */
  protected abstract  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
  /** Returns the result of evaluating this expression on a given input Row */
  public abstract  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  protected  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  /**
   * Returns true when an expression is a candidate for static evaluation before the query is
   * executed. A typical use case: {@link org.apache.spark.sql.catalyst.optimizer.ConstantFolding}
   * <p>
   * The following conditions are used to determine suitability for constant folding:
   *  - A {@link Coalesce} is foldable if all of its children are foldable
   *  - A {@link BinaryExpression} is foldable if its both left and right child are foldable
   *  - A {@link Not}, {@link IsNull}, or {@link IsNotNull} is foldable if its child is foldable
   *  - A {@link Literal} is foldable
   *  - A {@link Cast} or {@link UnaryMinus} is foldable if its child is foldable
   * @return (undocumented)
   */
  public  boolean foldable ()  { throw new RuntimeException(); }
  /**
   * Returns an {@link ExprCode}, that contains the Java source code to generate the result of
   * evaluating the expression on an input row.
   * <p>
   * @param ctx a {@link CodegenContext}
   * @return {@link ExprCode}
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode genCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public abstract  boolean nullable ()  ;
  /**
   * Returns a user-facing string representation of this expression's name.
   * This should usually match the name of the function in SQL.
   * @return (undocumented)
   */
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  /**
   * Returns true when two expressions will always compute the same result, even if they differ
   * cosmetically (i.e. capitalization of names in attributes may be different).
   * <p>
   * See {@link Canonicalize} for more details.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  /**
   * Returns a <code>hashCode</code> for the calculation performed by this expression. Unlike the standard
   * <code>hashCode</code>, an attempt has been made to eliminate cosmetic differences.
   * <p>
   * See {@link Canonicalize} for more details.
   * @return (undocumented)
   */
  public  int semanticHash ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  java.lang.String simpleStringWithNodeId ()  { throw new RuntimeException(); }
  /**
   * Returns SQL representation of this expression.  For expressions extending {@link NonSQLExpression},
   * this method may return an arbitrary user facing string.
   * @return (undocumented)
   */
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public final  java.lang.String verboseString (int maxFields)  { throw new RuntimeException(); }
}
