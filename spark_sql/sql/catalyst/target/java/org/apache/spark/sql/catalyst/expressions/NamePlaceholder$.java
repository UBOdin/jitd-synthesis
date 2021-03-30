package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression representing a not yet available attribute name. This expression is unevaluable
 * and as its name suggests it is a temporary place holder until we're able to determine the
 * actual attribute name.
 */
public  class NamePlaceholder$ extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NamePlaceholder$ MODULE$ = null;
  public   NamePlaceholder$ ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
