package org.apache.spark.sql.catalyst.expressions;
/**
 * A Window specification reference that refers to the {@link WindowSpecDefinition} defined
 * under the name <code>name</code>.
 */
public  class WindowSpecReference implements org.apache.spark.sql.catalyst.expressions.WindowSpec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  public   WindowSpecReference (java.lang.String name)  { throw new RuntimeException(); }
}
