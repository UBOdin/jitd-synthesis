package org.apache.spark.sql.types;
/**
 * A collection of types that can be used to specify type constraints. The sequence also specifies
 * precedence: an earlier type takes precedence over a latter type.
 * <p>
 * <pre><code>
 *   TypeCollection(StringType, BinaryType)
 * </code></pre>
 * <p>
 * This means that we prefer StringType over BinaryType if it is possible to cast to StringType.
 */
  class TypeCollection extends org.apache.spark.sql.types.AbstractDataType {
  /**
   * Types that include numeric types and interval type. They are only used in unary_minus,
   * unary_positive, add and subtract operations.
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.TypeCollection NumericAndInterval ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.TypeCollection apply (scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> types)  { throw new RuntimeException(); }
  static public  scala.Option<scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType>> unapply (org.apache.spark.sql.types.AbstractDataType typ)  { throw new RuntimeException(); }
  // not preceding
  public   TypeCollection (scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> types)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
}
