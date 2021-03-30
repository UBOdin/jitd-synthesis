package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A wrapper for generated class, defines a <code>generate</code> method so that we can pass extra objects
 * into generated class.
 */
public abstract class GeneratedClass {
  public   GeneratedClass ()  { throw new RuntimeException(); }
  public abstract  Object generate (java.lang.Object[] references)  ;
}
