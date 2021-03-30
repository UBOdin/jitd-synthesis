package org.apache.spark.sql.catalyst;
/**
 * Type-inference utilities for POJOs and Java collections.
 */
public  class JavaTypeInference$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JavaTypeInference$ MODULE$ = null;
  public   JavaTypeInference$ ()  { throw new RuntimeException(); }
  /**
   * Infers the corresponding SQL data type of a JavaBean class.
   * @param beanClass Java type
   * @return (SQL data type, nullable)
   */
  public  scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object> inferDataType (java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  /**
   * Infers the corresponding SQL data type of a Java type.
   * @param beanType Java type
   * @return (SQL data type, nullable)
   */
    scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object> inferDataType (java.lang.reflect.Type beanType)  { throw new RuntimeException(); }
  public  java.beans.PropertyDescriptor[] getJavaBeanReadableProperties (java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  /**
   * Returns an expression that can be used to deserialize a Spark SQL representation to an object
   * of java bean <code>T</code> with a compatible schema.  The Spark SQL representation is located at ordinal
   * 0 of a row, i.e., <code>GetColumnByOrdinal(0, _)</code>. Nested classes will have their fields accessed
   * using <code>UnresolvedExtractValue</code>.
   * @param beanClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializerFor (java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  /**
   * Returns an expression for serializing an object of the given type to a Spark SQL
   * representation. The input object is located at ordinal 0 of a row, i.e.,
   * <code>BoundReference(0, _)</code>.
   * @param beanClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression serializerFor (java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
}
