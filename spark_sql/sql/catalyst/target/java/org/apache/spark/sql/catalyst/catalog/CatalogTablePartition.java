package org.apache.spark.sql.catalyst.catalog;
/**
 * A partition (Hive style) defined in the catalog.
 * <p>
 * param:  spec partition spec values indexed by column name
 * param:  storage storage format of the partition
 * param:  parameters some parameters for the partition
 * param:  createTime creation time of the partition, in milliseconds
 * param:  lastAccessTime last access time, in milliseconds
 * param:  stats optional statistics (number of rows, total size, etc.)
 */
public  class CatalogTablePartition implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> spec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters ()  { throw new RuntimeException(); }
  public  long createTime ()  { throw new RuntimeException(); }
  public  long lastAccessTime ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogTablePartition (scala.collection.immutable.Map<java.lang.String, java.lang.String> spec, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, long createTime, long lastAccessTime, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats)  { throw new RuntimeException(); }
  public  scala.collection.mutable.LinkedHashMap<java.lang.String, java.lang.String> toLinkedHashMap ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /** Readable string representation for the CatalogTablePartition. */
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  /** Return the partition location, assuming it is specified. */
  public  java.net.URI location ()  { throw new RuntimeException(); }
  /**
   * Given the partition schema, returns a row with that schema holding the partition values.
   * @param partitionSchema (undocumented)
   * @param defaultTimeZondId (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow toRow (org.apache.spark.sql.types.StructType partitionSchema, java.lang.String defaultTimeZondId)  { throw new RuntimeException(); }
}
