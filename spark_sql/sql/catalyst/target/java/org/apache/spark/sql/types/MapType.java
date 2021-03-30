package org.apache.spark.sql.types;
/**
 * The data type for Maps. Keys in a map are not allowed to have <code>null</code> values.
 * <p>
 * Please use <code>DataTypes.createMapType()</code> to create a specific instance.
 * <p>
 * param:  keyType The data type of map keys.
 * param:  valueType The data type of map values.
 * param:  valueContainsNull Indicates if map values have <code>null</code> values.
 */
public  class MapType extends org.apache.spark.sql.types.DataType implements scala.Product, scala.Serializable {
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  /**
   * Construct a {@link MapType} object with the given key type and value type.
   * The <code>valueContainsNull</code> is true.
   * @param keyType (undocumented)
   * @param valueType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.MapType apply (org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType keyType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType valueType ()  { throw new RuntimeException(); }
  public  boolean valueContainsNull ()  { throw new RuntimeException(); }
  // not preceding
  public   MapType (org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType, boolean valueContainsNull)  { throw new RuntimeException(); }
  /** No-arg constructor for kryo. */
  public   MapType ()  { throw new RuntimeException(); }
    void buildFormattedString (java.lang.String prefix, org.apache.spark.sql.catalyst.util.StringUtils.StringConcat stringConcat, int maxDepth)  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the MapType is
   * (the default size of the key type + the default size of the value type).
   * We assume that there is only 1 element on average in a map. See SPARK-18853.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.MapType asNullable ()  { throw new RuntimeException(); }
    boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
}
