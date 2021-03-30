package org.apache.spark.sql.types;
/**
 * Companion object for ArrayType.
 * <p>
 * @since 1.3.0
 */
public  class ArrayType$ extends org.apache.spark.sql.types.AbstractDataType implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ArrayType$ MODULE$ = null;
  public   ArrayType$ ()  { throw new RuntimeException(); }
  /**
   * Construct a {@link ArrayType} object with the given element type. The <code>containsNull</code> is true.
   * @param elementType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.ArrayType apply (org.apache.spark.sql.types.DataType elementType)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
}
