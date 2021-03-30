package org.apache.spark.sql.types;
/**
 * @since 1.3.0
 */
public  class MapType$ extends org.apache.spark.sql.types.AbstractDataType implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MapType$ MODULE$ = null;
  public   MapType$ ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
  /**
   * Construct a {@link MapType} object with the given key type and value type.
   * The <code>valueContainsNull</code> is true.
   * @param keyType (undocumented)
   * @param valueType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.MapType apply (org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType)  { throw new RuntimeException(); }
}
