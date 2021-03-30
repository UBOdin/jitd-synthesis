package org.apache.spark.sql.types;
public  class NumericType$ extends org.apache.spark.sql.types.AbstractDataType {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NumericType$ MODULE$ = null;
  public   NumericType$ ()  { throw new RuntimeException(); }
  /**
   * Enables matching against NumericType for expressions:
   * <pre><code>
   *   case Cast(child &#64; NumericType(), StringType) =&gt;
   *     ...
   * </code></pre>
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
}
