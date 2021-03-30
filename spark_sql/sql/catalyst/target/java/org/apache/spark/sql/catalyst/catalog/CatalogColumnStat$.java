package org.apache.spark.sql.catalyst.catalog;
public  class CatalogColumnStat$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CatalogColumnStat$ MODULE$ = null;
  public   CatalogColumnStat$ ()  { throw new RuntimeException(); }
  public  java.lang.String KEY_VERSION ()  { throw new RuntimeException(); }
  public  int VERSION ()  { throw new RuntimeException(); }
  /**
   * Converts from string representation of data type to the corresponding Catalyst data type.
   * @param s (undocumented)
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param version (undocumented)
   * @return (undocumented)
   */
  public  Object fromExternalString (java.lang.String s, java.lang.String name, org.apache.spark.sql.types.DataType dataType, int version)  { throw new RuntimeException(); }
  /**
   * Converts the given value from Catalyst data type to string representation of external
   * data type.
   * @param v (undocumented)
   * @param colName (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String toExternalString (Object v, java.lang.String colName, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Creates a {@link CatalogColumnStat} object from the given map.
   * This is used to deserialize column stats from some external storage.
   * The serialization side is defined in {@link CatalogColumnStat.toMap}.
   * @param table (undocumented)
   * @param colName (undocumented)
   * @param map (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogColumnStat> fromMap (java.lang.String table, java.lang.String colName, scala.collection.immutable.Map<java.lang.String, java.lang.String> map)  { throw new RuntimeException(); }
}
