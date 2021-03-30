package org.apache.spark.sql.catalyst;
/**
 * Support for generating catalyst schemas for scala objects.  Note that unlike its companion
 * object, this trait able to work in both the runtime and the compile time (macro) universe.
 */
public  interface ScalaReflection extends org.apache.spark.internal.Logging {
  static public  class Schema implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
    public  boolean nullable ()  { throw new RuntimeException(); }
    // not preceding
    public   Schema (org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  }
  static public  class Schema$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.types.DataType, java.lang.Object, org.apache.spark.sql.catalyst.ScalaReflection.Schema> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Schema$ MODULE$ = null;
    public   Schema$ ()  { throw new RuntimeException(); }
  }
  /** The universe we work in (runtime or macro) */
  public  scala.reflect.api.Universe universe ()  ;
  /** The mirror used to access types in the universe */
  public  org.apache.spark.sql.catalyst.ScalaReflection.universe mirror ()  ;
  /**
   * Any codes calling <code>scala.reflect.api.Types.TypeApi.<:<</code> should be wrapped by this method to
   * clean up the Scala reflection garbage automatically. Otherwise, it will leak some objects to
   * <code>scala.reflect.runtime.JavaUniverse.undoLog</code>.
   * <p>
   * @see https://github.com/scala/bug/issues/8302
   * @param func (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T cleanUpReflectionObjects (scala.Function0<T> func)  ;
  /**
   * Return the Scala Type for <code>T</code> in the current classloader mirror.
   * <p>
   * Use this method instead of the convenience method <code>universe.typeOf</code>, which
   * assumes that all types can be found in the classloader that loaded scala-reflect classes.
   * That's not necessarily the case when running using Eclipse launchers or even
   * Sbt console or test (without <code>fork := true</code>).
   * <p>
   * @see SPARK-5281
   * @param evidence$4 (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.ScalaReflection.universe localTypeOf (scala.reflect.api.TypeTags.TypeTag<T> evidence$4)  ;
  /**
   * Returns the parameter names and types for the primary constructor of this type.
   * <p>
   * Note that it only works for scala classes with primary constructor, and currently doesn't
   * support inner class.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, scala.reflect.api.Types.TypeApi>> getConstructorParameters (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  ;
  /**
   * If our type is a Scala trait it may have a companion object that
   * only defines a constructor via <code>apply</code> method.
   * @param tpe (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.ScalaReflection.universe getCompanionConstructor (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  ;
  public  scala.collection.Seq<scala.reflect.api.Symbols.SymbolApi> constructParams (org.apache.spark.sql.catalyst.ScalaReflection.universe tpe)  ;
}
