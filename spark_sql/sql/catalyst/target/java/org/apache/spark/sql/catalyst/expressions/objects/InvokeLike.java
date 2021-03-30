package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Common base class for {@link StaticInvoke}, {@link Invoke}, and {@link NewInstance}.
 */
public  interface InvokeLike extends org.apache.spark.sql.catalyst.expressions.NonSQLExpression {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  ;
  /**
   * Evaluate each argument with a given row, invoke a method with a given object and arguments,
   * and cast a return value if the return type can be mapped to a Java Boxed type
   * <p>
   * @param obj the object for the method to be called. If null, perform s static method call
   * @param method the method object to be called
   * @param arguments the arguments used for the method call
   * @param input the row used for evaluating arguments
   * @param dataType the data type of the return object
   * @return the return object of a method call
   */
  public  Object invoke (Object obj, java.lang.reflect.Method method, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments, org.apache.spark.sql.catalyst.InternalRow input, org.apache.spark.sql.types.DataType dataType)  ;
  public  boolean needNullCheck ()  ;
  /**
   * Prepares codes for arguments.
   * <p>
   * - generate codes for argument.
   * - use ctx.splitExpressions() to not exceed 64kb JVM limit while preparing arguments.
   * - avoid some of nullability checking which are not needed because the expression is not
   *   nullable.
   * - when needNullCheck == true, short circuit if we found one of arguments is null because
   *   preparing rest of arguments can be skipped in the case.
   * <p>
   * @param ctx a {@link CodegenContext}
   * @return (code to prepare arguments, argument string, result of argument null check)
   */
  public  scala.Tuple3<java.lang.String, java.lang.String, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue> prepareArguments (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
  public  boolean propagateNull ()  ;
}
