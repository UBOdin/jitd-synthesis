package org.apache.spark.sql.types;
 abstract class FractionalType extends org.apache.spark.sql.types.NumericType {
  /**
   * Enables matching against FractionalType for expressions:
   * <pre><code>
   *   case Cast(child &#64; FractionalType(), StringType) =&gt;
   *     ...
   * </code></pre>
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public   FractionalType ()  { throw new RuntimeException(); }
   abstract  scala.math.Fractional<java.lang.Object> fractional ()  ;
   abstract  scala.math.Integral<java.lang.Object> asIntegral ()  ;
}
