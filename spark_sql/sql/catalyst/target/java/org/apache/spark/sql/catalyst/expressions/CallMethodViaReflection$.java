package org.apache.spark.sql.catalyst.expressions;
public  class CallMethodViaReflection$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CallMethodViaReflection$ MODULE$ = null;
  public   CallMethodViaReflection$ ()  { throw new RuntimeException(); }
  /** Mapping from Spark's type to acceptable JVM types. */
  public  scala.collection.immutable.Map<org.apache.spark.sql.types.DataType, scala.collection.Seq<java.lang.Class<?>>> typeMapping ()  { throw new RuntimeException(); }
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
  public  scala.Option<java.lang.reflect.Method> findMethod (java.lang.String className, java.lang.String methodName, scala.collection.Seq<org.apache.spark.sql.types.DataType> argTypes)  { throw new RuntimeException(); }
}
