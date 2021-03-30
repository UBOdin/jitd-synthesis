package org.apache.spark.sql.hive.client;
public  class HiveClientImpl$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveClientImpl$ MODULE$ = null;
  public   HiveClientImpl$ ()  { throw new RuntimeException(); }
  /** Converts the native StructField to Hive's FieldSchema. */
  public  org.apache.hadoop.hive.metastore.api.FieldSchema toHiveColumn (org.apache.spark.sql.types.StructField c)  { throw new RuntimeException(); }
  /** Builds the native StructField from Hive's FieldSchema. */
  public  org.apache.spark.sql.types.StructField fromHiveColumn (org.apache.hadoop.hive.metastore.api.FieldSchema hc)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.metastore.TableType toHiveTableType (org.apache.spark.sql.catalyst.catalog.CatalogTableType catalogTableType)  { throw new RuntimeException(); }
  /**
   * Converts the native table metadata representation format CatalogTable to Hive's Table.
   * @param table (undocumented)
   * @param userName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.hive.ql.metadata.Table toHiveTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table, scala.Option<java.lang.String> userName)  { throw new RuntimeException(); }
  /**
   * Converts the native partition metadata representation format CatalogTablePartition to
   * Hive's Partition.
   * @param p (undocumented)
   * @param ht (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.hive.ql.metadata.Partition toHivePartition (org.apache.spark.sql.catalyst.catalog.CatalogTablePartition p, org.apache.hadoop.hive.ql.metadata.Table ht)  { throw new RuntimeException(); }
  /**
   * Build the native partition metadata from Hive's Partition.
   * @param hp (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition fromHivePartition (org.apache.hadoop.hive.ql.metadata.Partition hp)  { throw new RuntimeException(); }
  /**
   * This is the same process copied from the method <code>getTable()</code>
   * of {@link org.apache.hadoop.hive.ql.metadata.Hive} to do some extra fixes for non-views.
   * Methods of extracting multiple {@link HiveTable} like <code>getRawTablesByName()</code>
   * should invoke this before return.
   * @param tTable (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.hive.metastore.api.Table extraFixesForNonView (org.apache.hadoop.hive.metastore.api.Table tTable)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.conf.HiveConf newHiveConf (org.apache.spark.SparkConf sparkConf, java.lang.Iterable<java.util.Map.Entry<java.lang.String, java.lang.String>> hadoopConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraConfig, scala.Option<java.lang.ClassLoader> classLoader)  { throw new RuntimeException(); }
}
