package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Utility functions for creating {@link JavaCode} fragments.
 */
public  class JavaCode$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JavaCode$ MODULE$ = null;
  public   JavaCode$ ()  { throw new RuntimeException(); }
  /**
   * Create a java literal.
   * @param v (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.LiteralValue literal (java.lang.String v, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create a default literal. This is null for reference types, false for boolean types and
   * -1 for other primitive types.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.LiteralValue defaultLiteral (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create a local java variable.
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.VariableValue variable (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create a local java variable.
   * @param name (undocumented)
   * @param javaClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.VariableValue variable (java.lang.String name, java.lang.Class<?> javaClass)  { throw new RuntimeException(); }
  /**
   * Create a local isNull variable.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.VariableValue isNullVariable (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Create a global java variable.
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.GlobalValue global (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create a global java variable.
   * @param name (undocumented)
   * @param javaClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.GlobalValue global (java.lang.String name, java.lang.Class<?> javaClass)  { throw new RuntimeException(); }
  /**
   * Create a global isNull variable.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.GlobalValue isNullGlobal (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Create an expression fragment.
   * @param code (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.SimpleExprValue expression (java.lang.String code, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create an expression fragment.
   * @param code (undocumented)
   * @param javaClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.SimpleExprValue expression (java.lang.String code, java.lang.Class<?> javaClass)  { throw new RuntimeException(); }
  /**
   * Create a isNull expression fragment.
   * @param code (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.SimpleExprValue isNullExpression (java.lang.String code)  { throw new RuntimeException(); }
  /**
   * Create an <code>Inline</code> for Java Class name.
   * @param javaClass (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.Inline javaType (java.lang.Class<?> javaClass)  { throw new RuntimeException(); }
  /**
   * Create an <code>Inline</code> for Java Type name.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.Inline javaType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Create an <code>Inline</code> for boxed Java Type name.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.Inline boxedType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
