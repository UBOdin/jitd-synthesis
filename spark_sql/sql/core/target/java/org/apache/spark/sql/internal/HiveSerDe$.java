package org.apache.spark.sql.internal;
public  class HiveSerDe$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveSerDe$ MODULE$ = null;
  public   HiveSerDe$ ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.HiveSerDe> serdeMap ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<org.apache.spark.sql.internal.HiveSerDe, java.lang.String> serdeInverseMap ()  { throw new RuntimeException(); }
  /**
   * Get the Hive SerDe information from the data source abbreviation string or classname.
   * <p>
   * @param source Currently the source abbreviation can be one of the following:
   *               SequenceFile, RCFile, ORC, PARQUET, and case insensitive.
   * @return HiveSerDe associated with the specified source
   */
  public  scala.Option<org.apache.spark.sql.internal.HiveSerDe> sourceToSerDe (java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Get the Spark data source name from the Hive SerDe information.
   * <p>
   * @param serde Hive SerDe information.
   * @return Spark data source name associated with the specified Hive Serde.
   */
  public  scala.Option<java.lang.String> serdeToSource (org.apache.spark.sql.internal.HiveSerDe serde)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat getDefaultStorage (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
}
