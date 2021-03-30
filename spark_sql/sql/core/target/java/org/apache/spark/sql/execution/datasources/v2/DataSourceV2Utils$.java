package org.apache.spark.sql.execution.datasources.v2;
public  class DataSourceV2Utils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataSourceV2Utils$ MODULE$ = null;
  public   DataSourceV2Utils$ ()  { throw new RuntimeException(); }
  /**
   * Helper method that extracts and transforms session configs into k/v pairs, the k/v pairs will
   * be used to create data source options.
   * Only extract when <code>ds</code> implements {@link SessionConfigSupport}, in this case we may fetch the
   * specified key-prefix from <code>ds</code>, and extract session configs with config keys that start with
   * <code>spark.datasource.$keyPrefix</code>. A session config <code>spark.datasource.$keyPrefix.xxx -> yyy</code> will
   * be transformed into <code>xxx -> yyy</code>.
   * <p>
   * @param source a {@link TableProvider} object
   * @param conf the session conf
   * @return an immutable map that contains all the extracted and transformed k/v pairs.
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> extractSessionConfigs (org.apache.spark.sql.connector.catalog.TableProvider source, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table getTableFromProvider (org.apache.spark.sql.connector.catalog.TableProvider provider, org.apache.spark.sql.util.CaseInsensitiveStringMap options, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema)  { throw new RuntimeException(); }
}
