package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * The main information about a new added function.
 * <p>
 * param:  functionName String representing the name of the function
 * param:  innerClassName Optional value which is empty if the function is added to
 *                       the outer class, otherwise it contains the name of the
 *                       inner class in which the function has been added.
 * param:  innerClassInstance Optional value which is empty if the function is added to
 *                           the outer class, otherwise it contains the name of the
 *                           instance of the inner class in the outer class.
 */
  class NewFunctionSpec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String functionName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> innerClassName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> innerClassInstance ()  { throw new RuntimeException(); }
  // not preceding
  public   NewFunctionSpec (java.lang.String functionName, scala.Option<java.lang.String> innerClassName, scala.Option<java.lang.String> innerClassInstance)  { throw new RuntimeException(); }
}
