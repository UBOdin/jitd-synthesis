package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that invokes a method on a class via reflection.
 * <p>
 * For now, only types defined in <code>Reflect.typeMapping</code> are supported (basically primitives
 * and string) as input types, and the output is turned automatically to a string.
 * <p>
 * Note that unlike Hive's reflect function, this expression calls only static methods
 * (i.e. does not support calling non-static methods).
 * <p>
 * We should also look into how to consolidate this expression with
 * {@link org.apache.spark.sql.catalyst.expressions.objects.StaticInvoke} in the future.
 * <p>
 * param:  children the first element should be a literal string for the class name,
 *                 and the second element should be a literal string for the method name,
 *                 and the remaining are input arguments to the Java method.
 */
public  class CallMethodViaReflection extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Nondeterministic, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  /** Mapping from Spark's type to acceptable JVM types. */
  static public  scala.collection.immutable.Map<org.apache.spark.sql.types.DataType, scala.collection.Seq<java.lang.Class<?>>> typeMapping ()  { throw new RuntimeException(); }
  /**
   * Finds a Java static method using reflection that matches the given argument types,
   * and whose return type is string.
   * <p>
   * The types sequence must be the valid types defined in {@link typeMapping}.
   * <p>
   * This is made public for unit testing.
   * @param className (undocumented)
   * @param methodName (undocumented)
   * @param argTypes (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.reflect.Method> findMethod (java.lang.String className, java.lang.String methodName, scala.collection.Seq<org.apache.spark.sql.types.DataType> argTypes)  { throw new RuntimeException(); }
  public final  boolean deterministic ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   CallMethodViaReflection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  protected  void initializeInternal (int partitionIndex)  { throw new RuntimeException(); }
  protected  Object evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  // not preceding
  public  java.lang.reflect.Method method ()  { throw new RuntimeException(); }
}
