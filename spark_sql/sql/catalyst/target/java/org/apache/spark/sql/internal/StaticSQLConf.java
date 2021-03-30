package org.apache.spark.sql.internal;
/**
 * Static SQL configuration is a cross-session, immutable Spark configuration. External users can
 * see the static sql configs via <code>SparkSession.conf</code>, but can NOT set/unset them.
 */
public  class StaticSQLConf {
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> WAREHOUSE_PATH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> CATALOG_IMPLEMENTATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> GLOBAL_TEMP_DATABASE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SCHEMA_STRING_LENGTH_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILESOURCE_TABLE_RELATION_CACHE_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_CACHE_MAX_ENTRIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_COMMENTS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DEBUG_MODE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_THRIFT_SERVER_SINGLESESSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<scala.collection.Seq<java.lang.String>> SPARK_SESSION_EXTENSIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> SPARK_CACHE_SERIALIZER ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<scala.collection.Seq<java.lang.String>> QUERY_EXECUTION_LISTENERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<scala.collection.Seq<java.lang.String>> STREAMING_QUERY_LISTENERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> UI_RETAINED_EXECUTIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BROADCAST_EXCHANGE_MAX_THREAD_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBQUERY_MAX_THREAD_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SQL_EVENT_TRUNCATE_LENGTH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SQL_LEGACY_SESSION_INIT_WITH_DEFAULTS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DEFAULT_URL_STREAM_HANDLER_FACTORY_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_UI_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_UI_RETAINED_PROGRESS_UPDATES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_UI_RETAINED_QUERIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> METADATA_CACHE_TTL_SECONDS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<scala.collection.Seq<java.lang.String>> ENABLED_STREAMING_UI_CUSTOM_METRIC_LIST ()  { throw new RuntimeException(); }
}
