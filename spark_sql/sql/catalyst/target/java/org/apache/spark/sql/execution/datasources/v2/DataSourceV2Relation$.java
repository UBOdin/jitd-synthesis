package org.apache.spark.sql.execution.datasources.v2;
public  class DataSourceV2Relation$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataSourceV2Relation$ MODULE$ = null;
  public   DataSourceV2Relation$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation create (org.apache.spark.sql.connector.catalog.Table table, scala.Option<org.apache.spark.sql.connector.catalog.CatalogPlugin> catalog, scala.Option<org.apache.spark.sql.connector.catalog.Identifier> identifier, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation create (org.apache.spark.sql.connector.catalog.Table table, scala.Option<org.apache.spark.sql.connector.catalog.CatalogPlugin> catalog, scala.Option<org.apache.spark.sql.connector.catalog.Identifier> identifier)  { throw new RuntimeException(); }
  /**
   * This is used to transform data source v2 statistics to logical.Statistics.
   * @param v2Statistics (undocumented)
   * @param defaultRowCount (undocumented)
   * @param defaultSizeInBytes (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics transformV2Stats (org.apache.spark.sql.connector.read.Statistics v2Statistics, scala.Option<scala.math.BigInt> defaultRowCount, long defaultSizeInBytes)  { throw new RuntimeException(); }
}
