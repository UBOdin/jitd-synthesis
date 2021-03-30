package org.apache.spark.sql.hive;
public  class HiveExternalCatalog$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveExternalCatalog$ MODULE$ = null;
  public   HiveExternalCatalog$ ()  { throw new RuntimeException(); }
  public  java.lang.String SPARK_SQL_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_PROVIDER ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_NUMPARTCOLS ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_NUMSORTCOLS ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_NUMBUCKETS ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_NUMBUCKETCOLS ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_PART_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_PARTCOL_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_BUCKETCOL_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String DATASOURCE_SCHEMA_SORTCOL_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String STATISTICS_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String STATISTICS_TOTAL_SIZE ()  { throw new RuntimeException(); }
  public  java.lang.String STATISTICS_NUM_ROWS ()  { throw new RuntimeException(); }
  public  java.lang.String STATISTICS_COL_STATS_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String TABLE_PARTITION_PROVIDER ()  { throw new RuntimeException(); }
  public  java.lang.String TABLE_PARTITION_PROVIDER_CATALOG ()  { throw new RuntimeException(); }
  public  java.lang.String TABLE_PARTITION_PROVIDER_FILESYSTEM ()  { throw new RuntimeException(); }
  public  java.lang.String CREATED_SPARK_VERSION ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> HIVE_GENERATED_TABLE_PROPERTIES ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.String> HIVE_GENERATED_STORAGE_PROPERTIES ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType EMPTY_DATA_SCHEMA ()  { throw new RuntimeException(); }
  /**
   * Detects a data source table. This checks both the table provider and the table properties,
   * unlike DDLUtils which just checks the former.
   * @param table (undocumented)
   * @return (undocumented)
   */
    boolean isDatasourceTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
}
