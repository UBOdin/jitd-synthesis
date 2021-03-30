package org.apache.spark.sql.types;
 abstract class IntegralType extends org.apache.spark.sql.types.NumericType {
  /**
   * Enables matching against IntegralType for expressions:
   * <pre><code>
   *   case Cast(child &#64; IntegralType(), StringType) =&gt;
   *     ...
   * </code></pre>
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   java.lang.String simpleString ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  public   IntegralType ()  { throw new RuntimeException(); }
   abstract  scala.math.Integral<java.lang.Object> integral ()  ;
}
