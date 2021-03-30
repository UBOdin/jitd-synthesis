package org.apache.spark.sql.execution.datasources;
public  class DataSource$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataSource$ MODULE$ = null;
  public   DataSource$ ()  { throw new RuntimeException(); }
  /** Given a provider name, look up the data source class definition. */
  public  java.lang.Class<?> lookupDataSource (java.lang.String provider, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  /**
   * Returns an optional {@link TableProvider} instance for the given provider. It returns None if
   * there is no corresponding Data Source V2 implementation, or the provider is configured to
   * fallback to Data Source V1 code path.
   * @param provider (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.connector.catalog.TableProvider> lookupDataSourceV2 (java.lang.String provider, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  /**
   * The key in the "options" map for deciding whether or not to glob paths before use.
   * @return (undocumented)
   */
  public  java.lang.String GLOB_PATHS_KEY ()  { throw new RuntimeException(); }
  /**
   * Checks and returns files in all the paths.
   * @param pathStrings (undocumented)
   * @param hadoopConf (undocumented)
   * @param checkEmptyGlobPath (undocumented)
   * @param checkFilesExist (undocumented)
   * @param numThreads (undocumented)
   * @param enableGlobbing (undocumented)
   * @return (undocumented)
   */
    scala.collection.Seq<org.apache.hadoop.fs.Path> checkAndGlobPathIfNecessary (scala.collection.Seq<java.lang.String> pathStrings, org.apache.hadoop.conf.Configuration hadoopConf, boolean checkEmptyGlobPath, boolean checkFilesExist, java.lang.Integer numThreads, boolean enableGlobbing)  { throw new RuntimeException(); }
  /**
   * When creating a data source table, the <code>path</code> option has a special meaning: the table location.
   * This method extracts the <code>path</code> option and treat it as table location to build a
   * {@link CatalogStorageFormat}. Note that, the <code>path</code> option is removed from options after this.
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat buildStorageFormatFromOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Called before writing into a FileFormat based data source to make sure the
   * supplied schema is not empty.
   * @param schema
   */
  public  void validateSchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
