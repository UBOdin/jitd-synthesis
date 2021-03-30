package org.apache.spark.sql.catalyst.catalog;
/**
 * A table defined in the catalog.
 * <p>
 * Note that Hive's metastore also tracks skewed columns. We should consider adding that in the
 * future once we have a better understanding of how we want to handle skewed columns.
 * <p>
 * param:  provider the name of the data source provider for this table, e.g. parquet, json, etc.
 *                 Can be None if this table is a View, should be "hive" for hive serde tables.
 * param:  unsupportedFeatures is a list of string descriptions of features that are used by the
 *        underlying table but not supported by Spark SQL yet.
 * param:  tracksPartitionsInCatalog whether this table's partition metadata is stored in the
 *                                  catalog. If false, it is inferred automatically based on file
 *                                  structure.
 * param:  schemaPreservesCase Whether or not the schema resolved for this table is case-sensitive.
 *                           When using a Hive Metastore, this flag is set to false if a case-
 *                           sensitive schema was unable to be read from the table properties.
 *                           Used to trigger case-sensitive schema inference at query time, when
 *                           configured.
 * param:  ignoredProperties is a list of table properties that are used by the underlying table
 *                          but ignored by Spark SQL yet.
 * param:  createVersion records the version of Spark that created this table metadata. The default
 *                      is an empty string. We expect it will be read from the catalog or filled by
 *                      ExternalCatalog.createTable. For temporary views, the value will be empty.
 */
public  class CatalogTable implements scala.Product, scala.Serializable {
  static public  java.lang.String VIEW_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_DEFAULT_DATABASE ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_CATALOG_AND_NAMESPACE ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_CATALOG_AND_NAMESPACE_PART_PREFIX ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> catalogAndNamespaceToProps (java.lang.String currentCatalog, scala.collection.Seq<java.lang.String> currentNamespace)  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_SQL_CONFIG_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_NUM_COLUMNS ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_COLUMN_NAME_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_REFERRED_TEMP_VIEW_NAMES ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_REFERRED_TEMP_FUNCTION_NAMES ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_STORING_ANALYZED_PLAN ()  { throw new RuntimeException(); }
  static public  void splitLargeTableProp (java.lang.String key, java.lang.String value, scala.Function2<java.lang.String, java.lang.String, scala.runtime.BoxedUnit> addProp, int defaultThreshold)  { throw new RuntimeException(); }
  static public  scala.Option<java.lang.String> readLargeTableProp (scala.collection.immutable.Map<java.lang.String, java.lang.String> props, java.lang.String key)  { throw new RuntimeException(); }
  static public  boolean isLargeTableProp (java.lang.String originalKey, java.lang.String propKey)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.catalog.CatalogTable normalize (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier identifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTableType tableType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> partitionColumnNames ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  java.lang.String owner ()  { throw new RuntimeException(); }
  public  long createTime ()  { throw new RuntimeException(); }
  public  long lastAccessTime ()  { throw new RuntimeException(); }
  public  java.lang.String createVersion ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> viewText ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> unsupportedFeatures ()  { throw new RuntimeException(); }
  public  boolean tracksPartitionsInCatalog ()  { throw new RuntimeException(); }
  public  boolean schemaPreservesCase ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> ignoredProperties ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> viewOriginalText ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogTable (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.catalog.CatalogTableType tableType, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, org.apache.spark.sql.types.StructType schema, scala.Option<java.lang.String> provider, scala.collection.Seq<java.lang.String> partitionColumnNames, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, java.lang.String owner, long createTime, long lastAccessTime, java.lang.String createVersion, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats, scala.Option<java.lang.String> viewText, scala.Option<java.lang.String> comment, scala.collection.Seq<java.lang.String> unsupportedFeatures, boolean tracksPartitionsInCatalog, boolean schemaPreservesCase, scala.collection.immutable.Map<java.lang.String, java.lang.String> ignoredProperties, scala.Option<java.lang.String> viewOriginalText)  { throw new RuntimeException(); }
  /**
   * schema of this table's partition columns
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  /**
   * schema of this table's data columns
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  /** Return the database this table was specified to belong to, assuming it exists. */
  public  java.lang.String database ()  { throw new RuntimeException(); }
  /** Return the table location, assuming it is specified. */
  public  java.net.URI location ()  { throw new RuntimeException(); }
  /** Return the fully qualified name of this table, assuming the database was specified. */
  public  java.lang.String qualifiedName ()  { throw new RuntimeException(); }
  /**
   * Return the current catalog and namespace (concatenated as a Seq[String]) of when the view was
   * created.
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> viewCatalogAndNamespace ()  { throw new RuntimeException(); }
  /**
   * Return the SQL configs of when the view was created, the configs are applied when parsing and
   * analyzing the view, should be empty if the CatalogTable is not a View or created by older
   * versions of Spark(before 3.1.0).
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> viewSQLConfigs ()  { throw new RuntimeException(); }
  /**
   * Return the output column names of the query that creates a view, the column names are used to
   * resolve a view, should be empty if the CatalogTable is not a View or created by older versions
   * of Spark(before 2.2.0).
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> viewQueryColumnNames ()  { throw new RuntimeException(); }
  /**
   * Return temporary view names the current view was referred. should be empty if the
   * CatalogTable is not a Temporary View or created by older versions of Spark(before 3.1.0).
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.collection.Seq<java.lang.String>> viewReferredTempViewNames ()  { throw new RuntimeException(); }
  /**
   * Return temporary function names the current view was referred. should be empty if the
   * CatalogTable is not a Temporary View or created by older versions of Spark(before 3.1.0).
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> viewReferredTempFunctionNames ()  { throw new RuntimeException(); }
  /** Syntactic sugar to update a field in `storage`. */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable withNewStorage (scala.Option<java.net.URI> locationUri, scala.Option<java.lang.String> inputFormat, scala.Option<java.lang.String> outputFormat, boolean compressed, scala.Option<java.lang.String> serde, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  public  scala.collection.mutable.LinkedHashMap<java.lang.String, java.lang.String> toLinkedHashMap ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /** Readable string representation for the CatalogTable. */
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
}
