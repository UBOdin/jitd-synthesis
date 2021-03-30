package org.apache.spark.sql.types;
/**
 * An internal type used to represent everything that is not null, UDTs, arrays, structs, and maps.
 */
 abstract class AtomicType extends org.apache.spark.sql.types.DataType {
  /**
   * Enables matching against AtomicType for expressions:
   * <pre><code>
   *   case Cast(child &#64; AtomicType(), StringType) =&gt;
   *     ...
   * </code></pre>
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public   AtomicType ()  { throw new RuntimeException(); }
   abstract  scala.reflect.api.TypeTags.TypeTag<java.lang.Object> tag ()  ;
   abstract  scala.math.Ordering<java.lang.Object> ordering ()  ;
}
