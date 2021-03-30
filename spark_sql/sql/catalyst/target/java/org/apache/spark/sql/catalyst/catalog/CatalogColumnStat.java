package org.apache.spark.sql.catalyst.catalog;
/**
 * This class of statistics for a column is used in {@link CatalogTable} to interact with metastore.
 */
public  class CatalogColumnStat implements scala.Product, scala.Serializable {
  static public  java.lang.String KEY_VERSION ()  { throw new RuntimeException(); }
  static public  int VERSION ()  { throw new RuntimeException(); }
  /**
   * Converts from string representation of data type to the corresponding Catalyst data type.
   * @param s (undocumented)
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param version (undocumented)
   * @return (undocumented)
   */
  static public  Object fromExternalString (java.lang.String s, java.lang.String name, org.apache.spark.sql.types.DataType dataType, int version)  { throw new RuntimeException(); }
  /**
   * Converts the given value from Catalyst data type to string representation of external
   * data type.
   * @param v (undocumented)
   * @param colName (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  java.lang.String toExternalString (Object v, java.lang.String colName, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Creates a {@link CatalogColumnStat} object from the given map.
   * This is used to deserialize column stats from some external storage.
   * The serialization side is defined in {@link CatalogColumnStat.toMap}.
   * @param table (undocumented)
   * @param colName (undocumented)
   * @param map (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogColumnStat> fromMap (java.lang.String table, java.lang.String colName, scala.collection.immutable.Map<java.lang.String, java.lang.String> map)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  public  scala.Option<scala.math.BigInt> distinctCount ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> min ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> max ()  { throw new RuntimeException(); }
  public  scala.Option<scala.math.BigInt> nullCount ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> avgLen ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxLen ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Histogram> histogram ()  { throw new RuntimeException(); }
  public  int version ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogColumnStat (scala.Option<scala.math.BigInt> distinctCount, scala.Option<java.lang.String> min, scala.Option<java.lang.String> max, scala.Option<scala.math.BigInt> nullCount, scala.Option<java.lang.Object> avgLen, scala.Option<java.lang.Object> maxLen, scala.Option<org.apache.spark.sql.catalyst.plans.logical.Histogram> histogram, int version)  { throw new RuntimeException(); }
  /**
   * Returns a map from string to string that can be used to serialize the column stats.
   * The key is the name of the column and name of the field (e.g. "colName.distinctCount"),
   * and the value is the string representation for the value.
   * min/max values are stored as Strings. They can be deserialized using
   * {@link CatalogColumnStat.fromExternalString}.
   * <p>
   * As part of the protocol, the returned map always contains a key called "version".
   * Any of the fields that are null (None) won't appear in the map.
   * @param colName (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> toMap (java.lang.String colName)  { throw new RuntimeException(); }
  /** Convert {@link CatalogColumnStat} to {@link ColumnStat}. */
  public  org.apache.spark.sql.catalyst.plans.logical.ColumnStat toPlanStat (java.lang.String colName, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
