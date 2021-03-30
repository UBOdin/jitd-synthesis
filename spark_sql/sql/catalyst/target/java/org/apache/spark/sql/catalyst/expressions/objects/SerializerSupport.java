package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Common trait for {@link DecodeUsingSerializer} and {@link EncodeUsingSerializer}
 */
public  interface SerializerSupport {
  /**
   * If true, Kryo serialization is used, otherwise the Java one is used
   * @return (undocumented)
   */
  public  boolean kryo ()  ;
  /**
   * The serializer instance to be used for serialization/deserialization in interpreted execution
   * @return (undocumented)
   */
  public  org.apache.spark.serializer.SerializerInstance serializerInstance ()  ;
  /**
   * Adds a immutable state to the generated class containing a reference to the serializer.
   * @return a string containing the name of the variable referencing the serializer
   * @param ctx (undocumented)
   */
  public  java.lang.String addImmutableSerializerIfNeeded (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
}
