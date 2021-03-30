package org.apache.spark.sql.catalyst;
/**
 * A default version of ScalaReflection that uses the runtime universe.
 */
public  class ScalaReflection$ implements org.apache.spark.sql.catalyst.ScalaReflection {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ScalaReflection$ MODULE$ = null;
  public   ScalaReflection$ ()  { throw new RuntimeException(); }
  public  scala.reflect.runtime.universe universe ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.ScalaReflection.universe mirror ()  { throw new RuntimeException(); }
  /**
   * Returns the Spark SQL DataType for a given scala type.  Where this is not an exact mapping
   * to a native type, an ObjectType is returned. Special handling is also used for Arrays including
   * those that hold primitive types.
   * <p>
   * Unlike <code>schemaFor</code>, this function doesn't do any massaging of types into the Spark SQL type
   * system.  As a result, ObjectType will be returned for things like boxed Integers
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.types.DataType dataTypeFor (scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  /**
   * Synchronize to prevent concurrent usage of <code><:<</code> operator.
   * This operator is not thread safe in any current version of scala; i.e.
   * (2.11.12, 2.12.10, 2.13.0-M5).
   * <p>
   * See https://github.com/scala/bug/issues/10766
   * @param tpe1 (undocumented)
   * @param tpe2 (undocumented)
   * @return (undocumented)
   */
    boolean isSubtype (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe1, org.apache.spark.sql.catalyst.ScalaReflection.universe tpe2)  { throw new RuntimeException(); }
  /**
   * Returns true if the value of this data type is same between internal and external.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  boolean isNativeType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns an expression that can be used to deserialize a Spark SQL representation to an object
   * of type <code>T</code> with a compatible schema. The Spark SQL representation is located at ordinal 0 of
   * a row, i.e., <code>GetColumnByOrdinal(0, _)</code>. Nested classes will have their fields accessed using
   * <code>UnresolvedExtractValue</code>.
   * <p>
   * The returned expression is used by <code>ExpressionEncoder</code>. The encoder will resolve and bind this
   * deserializer expression when using it.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializerForType (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  /**
   * Returns an expression for serializing an object of type T to Spark SQL representation. The
   * input object is located at ordinal 0 of a row, i.e., <code>BoundReference(0, _)</code>.
   * <p>
   * If the given type is not supported, i.e. there is no encoder can be built for this type,
   * an {@link UnsupportedOperationException} will be thrown with detailed error message to explain
   * the type path walked so far and which class we are not supporting.
   * There are 4 kinds of type path:
   *  * the root type: <code>root class: "abc.xyz.MyClass"</code>
   *  * the value type of {@link Option}: <code>option value class: "abc.xyz.MyClass"</code>
   *  * the element type of {@link Array} or {@link Seq}: <code>array element class: "abc.xyz.MyClass"</code>
   *  * the field of {@link Product}: <code>field (class: "abc.xyz.MyClass", name: "myField")</code>
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression serializerForType (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  /**
   * Returns true if the given type is option of product type, e.g. <code>Option[Tuple2]</code>. Note that,
   * we also treat {@link DefinedByConstructorParams} as product type.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  boolean optionOfProductType (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  /**
   * Returns the parameter names and types for the primary constructor of this class.
   * <p>
   * Note that it only works for scala classes with primary constructor, and currently doesn't
   * support inner class.
   * @param cls (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, scala.reflect.api.Types.TypeApi>> getConstructorParameters (java.lang.Class<?> cls)  { throw new RuntimeException(); }
  /**
   * Returns the parameter names for the primary constructor of this class.
   * <p>
   * Logically we should call <code>getConstructorParameters</code> and throw away the parameter types to get
   * parameter names, however there are some weird scala reflection problems and this method is a
   * workaround to avoid getting parameter types.
   * @param cls (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> getConstructorParameterNames (java.lang.Class<?> cls)  { throw new RuntimeException(); }
  /**
   * Returns the parameter values for the primary constructor of this class.
   * @param obj (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.Object> getConstructorParameterValues (org.apache.spark.sql.catalyst.DefinedByConstructorParams obj)  { throw new RuntimeException(); }
  /**
   * Returns the full class name for a type. The returned name is the canonical
   * Scala name, where each component is separated by a period. It is NOT the
   * Java-equivalent runtime name (no dollar signs).
   * <p>
   * In simple cases, both the Scala and Java names are the same, however when Scala
   * generates constructs that do not map to a Java equivalent, such as singleton objects
   * or nested classes in package objects, it uses the dollar sign ($) to create
   * synthetic classes, emulating behaviour in Java bytecode.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getClassNameFromType (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  public  java.lang.Class<?> getClassFromType (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  /** Returns a Sequence of attributes for the given case class type. */
  public <T extends java.lang.Object> scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributesFor (scala.reflect.api.TypeTags.TypeTag<T> evidence$2)  { throw new RuntimeException(); }
  /** Returns a catalyst DataType and its nullability for the given Scala Type using reflection. */
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.ScalaReflection.Schema schemaFor (scala.reflect.api.TypeTags.TypeTag<T> evidence$3)  { throw new RuntimeException(); }
  /** Returns a catalyst DataType and its nullability for the given Scala Type using reflection. */
  public  org.apache.spark.sql.catalyst.ScalaReflection.Schema schemaFor (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  /**
   * Finds an accessible constructor with compatible parameters. This is a more flexible search than
   * the exact matching algorithm in <code>Class.getConstructor</code>. The first assignment-compatible
   * matching constructor is returned if it exists. Otherwise, we check for additional compatible
   * constructors defined in the companion object as <code>apply</code> methods. Otherwise, it returns <code>None</code>.
   * @param cls (undocumented)
   * @param paramTypes (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.Option<scala.Function1<scala.collection.Seq<java.lang.Object>, T>> findConstructor (java.lang.Class<T> cls, scala.collection.Seq<java.lang.Class<?>> paramTypes)  { throw new RuntimeException(); }
  /**
   * Whether the fields of the given type is defined entirely by its constructor parameters.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  boolean definedByConstructorParams (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  { throw new RuntimeException(); }
  public  scala.collection.Map<org.apache.spark.sql.types.DataType, java.lang.Class<?>> typeJavaMapping ()  { throw new RuntimeException(); }
  public  scala.collection.Map<org.apache.spark.sql.types.DataType, java.lang.Class<?>> typeBoxedJavaMapping ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> dataTypeJavaClass (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaBoxedType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Class<?>> expressionJavaClasses (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments)  { throw new RuntimeException(); }
  public  java.lang.String encodeFieldNameToIdentifier (java.lang.String fieldName)  { throw new RuntimeException(); }
}
