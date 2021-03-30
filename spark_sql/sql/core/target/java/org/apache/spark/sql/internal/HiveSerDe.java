package org.apache.spark.sql.internal;
public  class HiveSerDe implements scala.Product, scala.Serializable {
  static public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.HiveSerDe> serdeMap ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Map<org.apache.spark.sql.internal.HiveSerDe, java.lang.String> serdeInverseMap ()  { throw new RuntimeException(); }
  /**
   * Get the Hive SerDe information from the data source abbreviation string or classname.
   * <p>
   * @param source Currently the source abbreviation can be one of the following:
   *               SequenceFile, RCFile, ORC, PARQUET, and case insensitive.
   * @return HiveSerDe associated with the specified source
   */
  static public  scala.Option<org.apache.spark.sql.internal.HiveSerDe> sourceToSerDe (java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Get the Spark data source name from the Hive SerDe information.
   * <p>
   * @param serde Hive SerDe information.
   * @return Spark data source name associated with the specified Hive Serde.
   */
  static public  scala.Option<java.lang.String> serdeToSource (org.apache.spark.sql.internal.HiveSerDe serde)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat getDefaultStorage (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> inputFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> outputFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> serde ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveSerDe (scala.Option<java.lang.String> inputFormat, scala.Option<java.lang.String> outputFormat, scala.Option<java.lang.String> serde)  { throw new RuntimeException(); }
}
