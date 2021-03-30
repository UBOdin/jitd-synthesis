package org.apache.spark.sql.internal;
/**
 * A class that enables the setting and getting of mutable config parameters/hints.
 * <p>
 * In the presence of a SQLContext, these can be set and queried by passing SET commands
 * into Spark SQL's query functions (i.e. sql()). Otherwise, users of this class can
 * modify the hints by programmatically calling the setters and getters of this class.
 * <p>
 * SQLConf is thread-safe (internally synchronized, so safe to be used in multiple threads).
 */
public  class SQLConf implements scala.Serializable, org.apache.spark.internal.Logging {
  static public  class ParquetOutputTimestampType$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ParquetOutputTimestampType$ MODULE$ = null;
    public   ParquetOutputTimestampType$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value INT96 ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value TIMESTAMP_MICROS ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value TIMESTAMP_MILLIS ()  { throw new RuntimeException(); }
  }
  static public  class HiveCaseSensitiveInferenceMode$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final HiveCaseSensitiveInferenceMode$ MODULE$ = null;
    public   HiveCaseSensitiveInferenceMode$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value INFER_AND_SAVE ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value INFER_ONLY ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value NEVER_INFER ()  { throw new RuntimeException(); }
  }
  static public  class PartitionOverwriteMode$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final PartitionOverwriteMode$ MODULE$ = null;
    public   PartitionOverwriteMode$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value STATIC ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value DYNAMIC ()  { throw new RuntimeException(); }
  }
  static public  class StoreAssignmentPolicy$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final StoreAssignmentPolicy$ MODULE$ = null;
    public   StoreAssignmentPolicy$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value ANSI ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value LEGACY ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value STRICT ()  { throw new RuntimeException(); }
  }
  static public  class Deprecated$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Deprecated$ MODULE$ = null;
    public   Deprecated$ ()  { throw new RuntimeException(); }
    public  java.lang.String MAPRED_REDUCE_TASKS ()  { throw new RuntimeException(); }
  }
  static public  class Replaced$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Replaced$ MODULE$ = null;
    public   Replaced$ ()  { throw new RuntimeException(); }
    public  java.lang.String MAPREDUCE_JOB_REDUCES ()  { throw new RuntimeException(); }
  }
  static public  class MapKeyDedupPolicy$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final MapKeyDedupPolicy$ MODULE$ = null;
    public   MapKeyDedupPolicy$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value EXCEPTION ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value LAST_WIN ()  { throw new RuntimeException(); }
  }
  static public  class LegacyBehaviorPolicy$ extends scala.Enumeration {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final LegacyBehaviorPolicy$ MODULE$ = null;
    public   LegacyBehaviorPolicy$ ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value EXCEPTION ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value LEGACY ()  { throw new RuntimeException(); }
    public  scala.Enumeration.Value CORRECTED ()  { throw new RuntimeException(); }
  }
  /**
   * Holds information about keys that have been deprecated.
   * <p>
   * param:  key The deprecated key.
   * param:  version Version of Spark where key was deprecated.
   * param:  comment Additional info regarding to the removed config. For example,
   *                reasons of config deprecation, what users should use instead of it.
   */
  static public  class DeprecatedConfig implements scala.Product, scala.Serializable {
    public  java.lang.String key ()  { throw new RuntimeException(); }
    public  java.lang.String version ()  { throw new RuntimeException(); }
    public  java.lang.String comment ()  { throw new RuntimeException(); }
    // not preceding
    public   DeprecatedConfig (java.lang.String key, java.lang.String version, java.lang.String comment)  { throw new RuntimeException(); }
  }
  static public  class DeprecatedConfig$ extends scala.runtime.AbstractFunction3<java.lang.String, java.lang.String, java.lang.String, org.apache.spark.sql.internal.SQLConf.DeprecatedConfig> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final DeprecatedConfig$ MODULE$ = null;
    public   DeprecatedConfig$ ()  { throw new RuntimeException(); }
  }
  /**
   * Holds information about keys that have been removed.
   * <p>
   * param:  key The removed config key.
   * param:  version Version of Spark where key was removed.
   * param:  defaultValue The default config value. It can be used to notice
   *                     users that they set non-default value to an already removed config.
   * param:  comment Additional info regarding to the removed config.
   */
  static public  class RemovedConfig implements scala.Product, scala.Serializable {
    public  java.lang.String key ()  { throw new RuntimeException(); }
    public  java.lang.String version ()  { throw new RuntimeException(); }
    public  java.lang.String defaultValue ()  { throw new RuntimeException(); }
    public  java.lang.String comment ()  { throw new RuntimeException(); }
    // not preceding
    public   RemovedConfig (java.lang.String key, java.lang.String version, java.lang.String defaultValue, java.lang.String comment)  { throw new RuntimeException(); }
  }
  static public  class RemovedConfig$ extends scala.runtime.AbstractFunction4<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.apache.spark.sql.internal.SQLConf.RemovedConfig> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final RemovedConfig$ MODULE$ = null;
    public   RemovedConfig$ ()  { throw new RuntimeException(); }
  }
  static   java.util.concurrent.ConcurrentHashMap<java.lang.String, org.apache.spark.internal.config.ConfigEntry<?>> sqlConfEntries ()  { throw new RuntimeException(); }
  static public  java.util.Set<java.lang.String> staticConfKeys ()  { throw new RuntimeException(); }
  static   void unregister (org.apache.spark.internal.config.ConfigEntry<?> entry)  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigBuilder buildConf (java.lang.String key)  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigBuilder buildStaticConf (java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Merge all non-static configs to the SQLConf. For example, when the 1st {@link SparkSession} and
   * the global {@link SharedState} have been initialized, all static configs have taken affect and
   * should not be set to other values. Other later created sessions should respect all static
   * configs and only be able to change non-static configs.
   * @param sqlConf (undocumented)
   * @param configs (undocumented)
   */
  static   void mergeNonStaticSQLConfigs (org.apache.spark.sql.internal.SQLConf sqlConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> configs)  { throw new RuntimeException(); }
  /**
   * Extract entries from <code>SparkConf</code> and put them in the <code>SQLConf</code>
   * @param sqlConf (undocumented)
   * @param sparkConf (undocumented)
   */
  static   void mergeSparkConf (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  /** See {@link get} for more information. */
  static public  org.apache.spark.sql.internal.SQLConf getFallbackConf ()  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T withExistingConf (org.apache.spark.sql.internal.SQLConf conf, scala.Function0<T> f)  { throw new RuntimeException(); }
  /**
   * Sets the active config object within the current scope.
   * See {@link get} for more information.
   * @param getter (undocumented)
   */
  static public  void setSQLConfGetter (scala.Function0<org.apache.spark.sql.internal.SQLConf> getter)  { throw new RuntimeException(); }
  /**
   * Returns the active config object within the current scope. If there is an active SparkSession,
   * the proper SQLConf associated with the thread's active session is used. If it's called from
   * tasks in the executor side, a SQLConf will be created from job local properties, which are set
   * and propagated from the driver side, unless a <code>SQLConf</code> has been set in the scope by
   * <code>withExistingConf</code> as done for propagating SQLConf for operations performed on RDDs created
   * from DataFrames.
   * <p>
   * The way this works is a little bit convoluted, due to the fact that config was added initially
   * only for physical plans (and as a result not in sql/catalyst module).
   * <p>
   * The first time a SparkSession is instantiated, we set the {@link confGetter} to return the
   * active SparkSession's config. If there is no active SparkSession, it returns using the thread
   * local {@link fallbackConf}. The reason {@link fallbackConf} is a thread local (rather than just a conf)
   * is to support setting different config options for different threads so we can potentially
   * run tests in parallel. At the time this feature was implemented, this was a no-op since we
   * run unit tests (that does not involve SparkSession) in serial order.
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.internal.SQLConf get ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ANALYZER_MAX_ITERATIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> OPTIMIZER_EXCLUDED_RULES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_MAX_ITERATIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_INSET_CONVERSION_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_INSET_SWITCH_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PLAN_CHANGE_LOG_LEVEL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> PLAN_CHANGE_LOG_RULES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> PLAN_CHANGE_LOG_BATCHES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_USE_STATS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_FALLBACK_FILTER_RATIO ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_REUSE_BROADCAST_ONLY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COMPRESS_CACHED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COLUMN_BATCH_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IN_MEMORY_PARTITION_PRUNING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IN_MEMORY_TABLE_SCAN_STATISTICS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CACHE_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COLUMN_VECTOR_OFFHEAP_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PREFER_SORTMERGEJOIN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RADIX_SORT_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_BROADCASTJOIN_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LIMIT_SCALE_UP_FACTOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADVANCED_PARTITION_PREDICATE_PUSHDOWN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> LEAF_NODE_DEFAULT_PARALLELISM ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SHUFFLE_PARTITIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SHUFFLE_TARGET_POSTSHUFFLE_INPUT_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADAPTIVE_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADAPTIVE_EXECUTION_FORCE_APPLY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ADAPTIVE_EXECUTION_LOG_LEVEL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADVISORY_PARTITION_SIZE_IN_BYTES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_PARTITIONS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> COALESCE_PARTITIONS_MIN_PARTITION_NUM ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> COALESCE_PARTITIONS_INITIAL_PARTITION_NUM ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FETCH_SHUFFLE_BLOCKS_IN_BATCH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LOCAL_SHUFFLE_READER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_SKEWED_PARTITION_FACTOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_SKEWED_PARTITION_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NON_EMPTY_PARTITION_RATIO_FOR_BROADCAST_JOIN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> ADAPTIVE_OPTIMIZER_EXCLUDED_RULES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBEXPRESSION_ELIMINATION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBEXPRESSION_ELIMINATION_CACHE_MAX_ENTRIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CASE_SENSITIVE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONSTRAINT_PROPAGATION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ESCAPED_STRING_LITERALS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_COMPRESSION_FACTOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_SCHEMA_MERGING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_SCHEMA_RESPECT_SUMMARIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_BINARY_AS_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_INT96_AS_TIMESTAMP ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_INT96_TIMESTAMP_CONVERSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_OUTPUT_TIMESTAMP_TYPE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_COMPRESSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_DATE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_TIMESTAMP_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_STRING_STARTSWITH_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_INFILTERTHRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_WRITE_LEGACY_FORMAT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_OUTPUT_COMMITTER_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_RECORD_FILTER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_VECTORIZED_READER_BATCH_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ORC_COMPRESSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ORC_IMPLEMENTATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_VECTORIZED_READER_BATCH_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_SCHEMA_MERGING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_VERIFY_PARTITION_PATH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_METASTORE_PARTITION_PRUNING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_METASTORE_PARTITION_PRUNING_INSET_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_MANAGE_FILESOURCE_PARTITIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_FILESOURCE_PARTITION_FILE_CACHE_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> HIVE_CASE_SENSITIVE_INFERENCE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> HIVE_TABLE_PROPERTY_LENGTH_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_METADATA_ONLY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> COLUMN_NAME_OF_CORRUPT_RECORD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BROADCAST_TIMEOUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> THRIFTSERVER_POOL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_INCREMENTAL_COLLECT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_FORCE_CANCEL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_QUERY_TIMEOUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_UI_STATEMENT_LIMIT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_UI_SESSION_LIMIT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DEFAULT_DATA_SOURCE_NAME ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_CTAS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GATHER_FASTSTAT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARTITION_COLUMN_TYPE_INFERENCE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BUCKETING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BUCKETING_MAX_BUCKETS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_BUCKETED_SCAN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CROSS_JOINS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORDER_BY_ORDINAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GROUP_BY_ORDINAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GROUP_BY_ALIASES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> OUTPUT_COMMITTER_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> FILE_COMMIT_PROTOCOL_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_PARTITION_DISCOVERY_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_PARTITION_DISCOVERY_PARALLELISM ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_DATA_LOCALITY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_SELF_JOIN_AUTO_RESOLVE_AMBIGUITY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FAIL_AMBIGUOUS_SELF_JOIN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_RETAIN_GROUP_COLUMNS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_PIVOT_MAX_VALUES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RUN_SQL_ON_FILES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_CODEGEN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_CODEGEN_USE_ID_IN_CLASS_NAME ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_MAX_NUM_FIELDS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> CODEGEN_FACTORY_MODE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_FALLBACK ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_LOGGING_MAX_LINES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_HUGE_METHOD_LIMIT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_METHOD_SPLIT_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_SPLIT_CONSUME_FUNC_BY_OPERATOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILES_MAX_PARTITION_BYTES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILES_OPEN_COST_IN_BYTES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> FILES_MIN_PARTITION_NUM ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_CORRUPT_FILES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_MISSING_FILES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_RECORDS_PER_FILE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> EXCHANGE_REUSE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBQUERY_REUSE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REMOVE_REDUNDANT_PROJECTS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REMOVE_REDUNDANT_SORTS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STATE_STORE_PROVIDER_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_SCHEMA_CHECK_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_STORE_MIN_DELTAS_FOR_SNAPSHOT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_STORE_FORMAT_VALIDATION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FLATMAPGROUPSWITHSTATE_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> CHECKPOINT_LOCATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FORCE_DELETE_TEMP_CHECKPOINT_LOCATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MIN_BATCHES_TO_RETAIN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_BATCHES_TO_RETAIN_IN_MEMORY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_MAINTENANCE_INTERVAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STATE_STORE_COMPRESSION_CODEC ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_AGGREGATION_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_STOP_ACTIVE_RUN_ON_RESTART ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_JOIN_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> UNSUPPORTED_OPERATION_CHECK_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_DEPRECATED_KAFKA_OFFSET_FETCHING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATEFUL_OPERATOR_CHECK_CORRECTNESS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> VARIABLE_SUBSTITUTE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_TWOLEVEL_AGG_MAP ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_VECTORIZED_HASH_MAP ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_SPLIT_AGGREGATE_FUNC ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_NESTED_VIEW_DEPTH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ALLOW_PARAMETERLESS_COUNT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ALLOW_STAR_WITH_SINGLE_TABLE_IDENTIFIER_IN_COUNT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_CURRENT_SQL_CONFIGS_FOR_VIEW ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STORE_ANALYZED_PLAN_FOR_VIEW ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STREAMING_FILE_COMMIT_PROTOCOL_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STREAMING_MULTIPLE_WATERMARK_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OBJECT_AGG_SORT_BASED_FALLBACK_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_OBJECT_HASH_AGG ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_GENERATOR_IGNORE_NULL_FIELDS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_EXPRESSION_OPTIMIZATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_EXPRESSION_OPTIMIZATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_DELETION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_COMPACT_INTERVAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_CLEANUP_DELAY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_DELETION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_COMPACT_INTERVAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_CLEANUP_DELAY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_SCHEMA_FORCE_NULLABLE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_CLEANER_NUM_THREADS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_SCHEMA_INFERENCE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_POLLING_DELAY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_STOP_TIMEOUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_NO_DATA_PROGRESS_EVENT_INTERVAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_NO_DATA_MICRO_BATCHES_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_METRICS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_PROGRESS_RETENTION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.TypedConfigBuilder<java.lang.String> STREAMING_CHECKPOINT_FILE_MANAGER_CLASS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_CHECKPOINT_ESCAPED_PATH_CHECK_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_FILE_LISTING_IN_STATS_COMPUTATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DEFAULT_SIZE_IN_BYTES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_FALL_BACK_TO_HDFS_FOR_STATS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NDV_MAX_ERROR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HISTOGRAM_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HISTOGRAM_NUM_BINS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PERCENTILE_ACCURACY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_SIZE_UPDATE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CBO_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PLAN_STATS_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_DP_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_CARD_WEIGHT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_DP_STAR_FILTER ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STARSCHEMA_DETECTION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STARSCHEMA_FACT_TABLE_RATIO ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> SESSION_LOCAL_TIMEZONE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WINDOW_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WINDOW_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_MERGE_JOIN_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_MERGE_JOIN_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CARTESIAN_PRODUCT_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CARTESIAN_PRODUCT_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUPPORT_QUOTED_REGEX_COLUMN_NAME ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RANGE_EXCHANGE_SAMPLE_SIZE_PER_PARTITION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_SELF_DESTRUCT_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PYSPARK_JVM_STACKTRACE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_SPARKR_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_FALLBACK_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_FALLBACK_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_EXECUTION_MAX_RECORDS_PER_BATCH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_UDF_BUFFER_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PYSPARK_SIMPLIFIEID_TRACEBACK ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_GROUPED_MAP_ASSIGN_COLUMNS_BY_NAME ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_ARROW_SAFE_TYPE_CONVERSION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPLACE_EXCEPT_WITH_FILTER ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DECIMAL_OPERATIONS_ALLOW_PREC_LOSS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LITERAL_PICK_MINIMUM_PRECISION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<scala.util.matching.Regex> SQL_OPTIONS_REDACTION_PATTERN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<scala.Option<scala.util.matching.Regex>> SQL_STRING_REDACTION_PATTERN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONCAT_BINARY_AS_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ELT_OUTPUT_AS_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> VALIDATE_PARTITION_COLUMNS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EPOCH_BACKLOG_QUEUE_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EXECUTOR_QUEUE_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EXECUTOR_POLL_INTERVAL_MS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> USE_V1_SOURCE_LIST ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_V2_STREAMING_WRITERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_V2_STREAMING_MICROBATCH_READERS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FASTFAIL_ON_FILEFORMAT_OUTPUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARTITION_OVERWRITE_MODE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STORE_ASSIGNMENT_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ANSI_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_BEFORE_REPARTITION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NESTED_SCHEMA_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DISABLE_HINTS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> NESTED_PREDICATE_PUSHDOWN_FILE_SOURCE_LIST ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SERIALIZER_NESTED_SCHEMA_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NESTED_PRUNING_ON_EXPRESSIONS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> TOP_K_SORT_FALLBACK_THRESHOLD ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_PARSER_COLUMN_PRUNING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_MAX_NUM_ROWS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_TRUNCATE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FAST_HASH_AGGREGATE_MAX_ROWS_CAPACITY_BIT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_COMPRESSION_CODEC ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AVRO_DEFLATE_LEVEL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_SIZE_OF_NULL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PARSE_NULL_PARTITION_SPEC_AS_STRING_LITERAL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_REPLACE_DATABRICKS_SPARK_AVRO_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_SETOPS_PRECEDENCE_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_EXPONENT_LITERAL_AS_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_NEGATIVE_SCALE_OF_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_BUCKETED_TABLE_SCAN_OUTPUT_ORDERING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_HAVING_WITHOUT_GROUP_BY_AS_WHERE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_EMPTY_STRING_IN_JSON ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CREATE_EMPTY_COLLECTION_USING_STRING_TYPE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_UNTYPED_SCALA_UDF ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_STATISTICAL_AGGREGATE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> TRUNCATE_TABLE_IGNORE_PERMISSION_ACL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NAME_NON_STRUCT_GROUPING_KEY_AS_VALUE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_TO_STRING_FIELDS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_PLAN_STRING_LENGTH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_METADATA_STRING_LENGTH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SET_COMMAND_REJECTS_SPARK_CORE_CONFS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATETIME_JAVA8API_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> UI_EXPLAIN_MODE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SOURCES_BINARY_FILE_MAX_LENGTH ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CAST_DATETIME_TO_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DEFAULT_CATALOG ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> V2_SESSION_CATALOG_IMPLEMENTATION ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> MAP_KEY_DEDUP_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_LOOSE_UPCAST ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> LEGACY_CTE_PRECEDENCE_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> LEGACY_TIME_PARSER_POLICY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ARRAY_EXISTS_FOLLOWS_THREE_VALUED_LOGIC ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ADDITIONAL_REMOTE_REPOSITORIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_FROM_DAYTIME_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PROPERTY_NON_RESERVED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ADD_SINGLE_FILE_IN_ADD_FILE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_MSSQLSERVER_NUMERIC_MAPPING_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AVRO_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADD_PARTITION_BATCH_SIZE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_HASH_ON_MAPTYPE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_INTEGER_GROUPING_ID ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_INT96_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_INT96_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SCRIPT_TRANSFORMATION_EXIT_TIMEOUT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_BUCKETS_IN_JOIN_ENABLED ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_BUCKETS_IN_JOIN_MAX_BUCKET_RATIO ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BROADCAST_HASH_JOIN_OUTPUT_PARTITIONING_EXPAND_LIMIT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZE_NULL_AWARE_ANTI_JOIN ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_COMPLEX_TYPES_TO_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PATH_OPTION_BEHAVIOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_EXTRA_OPTIONS_BEHAVIOR ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_JDBC_CONN_PROVIDER_LIST ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CREATE_HIVE_TABLE_BY_DEFAULT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CHAR_VARCHAR_AS_STRING ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CLI_PRINT_HEADER ()  { throw new RuntimeException(); }
  static public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_KEEP_COMMAND_OUTPUT_SCHEMA ()  { throw new RuntimeException(); }
  /**
   * Maps deprecated SQL config keys to information about the deprecation.
   * <p>
   * The extra information is logged as a warning when the SQL config is present
   * in the user's configuration.
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.SQLConf.DeprecatedConfig> deprecatedSQLConfigs ()  { throw new RuntimeException(); }
  /**
   * The map contains info about removed SQL configs. Keys are SQL config names,
   * map values contain extra information like the version in which the config was removed,
   * config's default value and a comment.
   * <p>
   * Please, add a removed SQL configuration property here only when it affects behaviours.
   * For example, <code>spark.sql.variable.substitute.depth</code> was not added as it virtually
   * became no-op later. By this, it makes migrations to new Spark versions painless.
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.SQLConf.RemovedConfig> removedSQLConfigs ()  { throw new RuntimeException(); }
  public   SQLConf ()  { throw new RuntimeException(); }
  /** Only low degree of contention is expected for conf, thus NOT using ConcurrentHashMap. */
  protected  java.util.Map<java.lang.String, java.lang.String> settings ()  { throw new RuntimeException(); }
  protected  org.apache.spark.internal.config.ConfigReader reader ()  { throw new RuntimeException(); }
  /** ************************ Spark SQL Params/Hints ******************* */
  public  int analyzerMaxIterations ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> optimizerExcludedRules ()  { throw new RuntimeException(); }
  public  int optimizerMaxIterations ()  { throw new RuntimeException(); }
  public  int optimizerInSetConversionThreshold ()  { throw new RuntimeException(); }
  public  int optimizerInSetSwitchThreshold ()  { throw new RuntimeException(); }
  public  java.lang.String planChangeLogLevel ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> planChangeRules ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> planChangeBatches ()  { throw new RuntimeException(); }
  public  boolean dynamicPartitionPruningEnabled ()  { throw new RuntimeException(); }
  public  boolean dynamicPartitionPruningUseStats ()  { throw new RuntimeException(); }
  public  double dynamicPartitionPruningFallbackFilterRatio ()  { throw new RuntimeException(); }
  public  boolean dynamicPartitionPruningReuseBroadcastOnly ()  { throw new RuntimeException(); }
  public  java.lang.String stateStoreProviderClass ()  { throw new RuntimeException(); }
  public  boolean isStateSchemaCheckEnabled ()  { throw new RuntimeException(); }
  public  int stateStoreMinDeltasForSnapshot ()  { throw new RuntimeException(); }
  public  boolean stateStoreFormatValidationEnabled ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> checkpointLocation ()  { throw new RuntimeException(); }
  public  boolean isUnsupportedOperationCheckEnabled ()  { throw new RuntimeException(); }
  public  boolean useDeprecatedKafkaOffsetFetching ()  { throw new RuntimeException(); }
  public  boolean statefulOperatorCorrectnessCheckEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String streamingFileCommitProtocolClass ()  { throw new RuntimeException(); }
  public  boolean fileSinkLogDeletion ()  { throw new RuntimeException(); }
  public  int fileSinkLogCompactInterval ()  { throw new RuntimeException(); }
  public  long fileSinkLogCleanupDelay ()  { throw new RuntimeException(); }
  public  boolean fileSourceLogDeletion ()  { throw new RuntimeException(); }
  public  int fileSourceLogCompactInterval ()  { throw new RuntimeException(); }
  public  long fileSourceLogCleanupDelay ()  { throw new RuntimeException(); }
  public  boolean streamingSchemaInference ()  { throw new RuntimeException(); }
  public  long streamingPollingDelay ()  { throw new RuntimeException(); }
  public  long streamingNoDataProgressEventInterval ()  { throw new RuntimeException(); }
  public  boolean streamingNoDataMicroBatchesEnabled ()  { throw new RuntimeException(); }
  public  boolean streamingMetricsEnabled ()  { throw new RuntimeException(); }
  public  int streamingProgressRetention ()  { throw new RuntimeException(); }
  public  long filesMaxPartitionBytes ()  { throw new RuntimeException(); }
  public  long filesOpenCostInBytes ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> filesMinPartitionNum ()  { throw new RuntimeException(); }
  public  boolean ignoreCorruptFiles ()  { throw new RuntimeException(); }
  public  boolean ignoreMissingFiles ()  { throw new RuntimeException(); }
  public  long maxRecordsPerFile ()  { throw new RuntimeException(); }
  public  boolean useCompression ()  { throw new RuntimeException(); }
  public  java.lang.String orcCompressionCodec ()  { throw new RuntimeException(); }
  public  boolean orcVectorizedReaderEnabled ()  { throw new RuntimeException(); }
  public  int orcVectorizedReaderBatchSize ()  { throw new RuntimeException(); }
  public  java.lang.String parquetCompressionCodec ()  { throw new RuntimeException(); }
  public  boolean parquetVectorizedReaderEnabled ()  { throw new RuntimeException(); }
  public  int parquetVectorizedReaderBatchSize ()  { throw new RuntimeException(); }
  public  int columnBatchSize ()  { throw new RuntimeException(); }
  public  boolean cacheVectorizedReaderEnabled ()  { throw new RuntimeException(); }
  public  int defaultNumShufflePartitions ()  { throw new RuntimeException(); }
  public  int numShufflePartitions ()  { throw new RuntimeException(); }
  public  boolean adaptiveExecutionEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String adaptiveExecutionLogLevel ()  { throw new RuntimeException(); }
  public  boolean fetchShuffleBlocksInBatch ()  { throw new RuntimeException(); }
  public  double nonEmptyPartitionRatioForBroadcastJoin ()  { throw new RuntimeException(); }
  public  boolean coalesceShufflePartitionsEnabled ()  { throw new RuntimeException(); }
  public  int minBatchesToRetain ()  { throw new RuntimeException(); }
  public  int maxBatchesToRetainInMemory ()  { throw new RuntimeException(); }
  public  long streamingMaintenanceInterval ()  { throw new RuntimeException(); }
  public  java.lang.String stateStoreCompressionCodec ()  { throw new RuntimeException(); }
  public  boolean parquetFilterPushDown ()  { throw new RuntimeException(); }
  public  boolean parquetFilterPushDownDate ()  { throw new RuntimeException(); }
  public  boolean parquetFilterPushDownTimestamp ()  { throw new RuntimeException(); }
  public  boolean parquetFilterPushDownDecimal ()  { throw new RuntimeException(); }
  public  boolean parquetFilterPushDownStringStartWith ()  { throw new RuntimeException(); }
  public  int parquetFilterPushDownInFilterThreshold ()  { throw new RuntimeException(); }
  public  boolean orcFilterPushDown ()  { throw new RuntimeException(); }
  public  boolean isOrcSchemaMergingEnabled ()  { throw new RuntimeException(); }
  public  boolean verifyPartitionPath ()  { throw new RuntimeException(); }
  public  boolean metastorePartitionPruning ()  { throw new RuntimeException(); }
  public  int metastorePartitionPruningInSetThreshold ()  { throw new RuntimeException(); }
  public  boolean manageFilesourcePartitions ()  { throw new RuntimeException(); }
  public  long filesourcePartitionFileCacheSize ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value caseSensitiveInferenceMode ()  { throw new RuntimeException(); }
  public  boolean gatherFastStats ()  { throw new RuntimeException(); }
  public  boolean optimizerMetadataOnly ()  { throw new RuntimeException(); }
  public  boolean wholeStageEnabled ()  { throw new RuntimeException(); }
  public  boolean wholeStageUseIdInClassName ()  { throw new RuntimeException(); }
  public  int wholeStageMaxNumFields ()  { throw new RuntimeException(); }
  public  boolean codegenFallback ()  { throw new RuntimeException(); }
  public  boolean codegenComments ()  { throw new RuntimeException(); }
  public  int loggingMaxLinesForCodegen ()  { throw new RuntimeException(); }
  public  int hugeMethodLimit ()  { throw new RuntimeException(); }
  public  int methodSplitThreshold ()  { throw new RuntimeException(); }
  public  boolean wholeStageSplitConsumeFuncByOperator ()  { throw new RuntimeException(); }
  public  int tableRelationCacheSize ()  { throw new RuntimeException(); }
  public  int codegenCacheMaxEntries ()  { throw new RuntimeException(); }
  public  boolean exchangeReuseEnabled ()  { throw new RuntimeException(); }
  public  boolean subqueryReuseEnabled ()  { throw new RuntimeException(); }
  public  boolean caseSensitiveAnalysis ()  { throw new RuntimeException(); }
  public  boolean constraintPropagationEnabled ()  { throw new RuntimeException(); }
  public  boolean escapedStringLiterals ()  { throw new RuntimeException(); }
  public  double fileCompressionFactor ()  { throw new RuntimeException(); }
  public  scala.Option<scala.util.matching.Regex> stringRedactionPattern ()  { throw new RuntimeException(); }
  public  boolean sortBeforeRepartition ()  { throw new RuntimeException(); }
  public  int topKSortFallbackThreshold ()  { throw new RuntimeException(); }
  public  int fastHashAggregateRowMaxCapacityBit ()  { throw new RuntimeException(); }
  public  boolean datetimeJava8ApiEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String uiExplainMode ()  { throw new RuntimeException(); }
  public  boolean addSingleFileInAddFile ()  { throw new RuntimeException(); }
  public  boolean legacyMsSqlServerNumericMappingEnabled ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value legacyTimeParserPolicy ()  { throw new RuntimeException(); }
  public  int broadcastHashJoinOutputPartitioningExpandLimit ()  { throw new RuntimeException(); }
  /**
   * Returns the {@link Resolver} for the current configuration, which can be used to determine if two
   * identifiers are equal.
   * @return (undocumented)
   */
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
  /**
   * Returns the error handler for handling hint errors.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.HintErrorHandler hintErrorHandler ()  { throw new RuntimeException(); }
  public  boolean subexpressionEliminationEnabled ()  { throw new RuntimeException(); }
  public  int subexpressionEliminationCacheMaxEntries ()  { throw new RuntimeException(); }
  public  long autoBroadcastJoinThreshold ()  { throw new RuntimeException(); }
  public  int limitScaleUpFactor ()  { throw new RuntimeException(); }
  public  boolean advancedPartitionPredicatePushdownEnabled ()  { throw new RuntimeException(); }
  public  boolean preferSortMergeJoin ()  { throw new RuntimeException(); }
  public  boolean enableRadixSort ()  { throw new RuntimeException(); }
  public  boolean isParquetSchemaMergingEnabled ()  { throw new RuntimeException(); }
  public  boolean isParquetSchemaRespectSummaries ()  { throw new RuntimeException(); }
  public  java.lang.String parquetOutputCommitterClass ()  { throw new RuntimeException(); }
  public  boolean isParquetBinaryAsString ()  { throw new RuntimeException(); }
  public  boolean isParquetINT96AsTimestamp ()  { throw new RuntimeException(); }
  public  boolean isParquetINT96TimestampConversion ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value parquetOutputTimestampType ()  { throw new RuntimeException(); }
  public  boolean writeLegacyParquetFormat ()  { throw new RuntimeException(); }
  public  boolean parquetRecordFilterEnabled ()  { throw new RuntimeException(); }
  public  boolean inMemoryPartitionPruning ()  { throw new RuntimeException(); }
  public  boolean inMemoryTableScanStatisticsEnabled ()  { throw new RuntimeException(); }
  public  boolean offHeapColumnVectorEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  public  long broadcastTimeout ()  { throw new RuntimeException(); }
  public  java.lang.String defaultDataSourceName ()  { throw new RuntimeException(); }
  public  boolean convertCTAS ()  { throw new RuntimeException(); }
  public  boolean partitionColumnTypeInferenceEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String fileCommitProtocolClass ()  { throw new RuntimeException(); }
  public  int parallelPartitionDiscoveryThreshold ()  { throw new RuntimeException(); }
  public  int parallelPartitionDiscoveryParallelism ()  { throw new RuntimeException(); }
  public  boolean bucketingEnabled ()  { throw new RuntimeException(); }
  public  int bucketingMaxBuckets ()  { throw new RuntimeException(); }
  public  boolean autoBucketedScanEnabled ()  { throw new RuntimeException(); }
  public  boolean dataFrameSelfJoinAutoResolveAmbiguity ()  { throw new RuntimeException(); }
  public  boolean dataFrameRetainGroupColumns ()  { throw new RuntimeException(); }
  public  int dataFramePivotMaxValues ()  { throw new RuntimeException(); }
  public  boolean runSQLonFile ()  { throw new RuntimeException(); }
  public  boolean enableTwoLevelAggMap ()  { throw new RuntimeException(); }
  public  boolean enableVectorizedHashMap ()  { throw new RuntimeException(); }
  public  boolean useObjectHashAggregation ()  { throw new RuntimeException(); }
  public  int objectAggSortBasedFallbackThreshold ()  { throw new RuntimeException(); }
  public  boolean variableSubstituteEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String warehousePath ()  { throw new RuntimeException(); }
  public  boolean hiveThriftServerSingleSession ()  { throw new RuntimeException(); }
  public  boolean orderByOrdinal ()  { throw new RuntimeException(); }
  public  boolean groupByOrdinal ()  { throw new RuntimeException(); }
  public  boolean groupByAliases ()  { throw new RuntimeException(); }
  public  boolean crossJoinEnabled ()  { throw new RuntimeException(); }
  public  java.lang.String sessionLocalTimeZone ()  { throw new RuntimeException(); }
  public  boolean jsonGeneratorIgnoreNullFields ()  { throw new RuntimeException(); }
  public  boolean jsonExpressionOptimization ()  { throw new RuntimeException(); }
  public  boolean csvExpressionOptimization ()  { throw new RuntimeException(); }
  public  boolean parallelFileListingInStatsComputation ()  { throw new RuntimeException(); }
  public  boolean fallBackToHdfsForStatsEnabled ()  { throw new RuntimeException(); }
  public  long defaultSizeInBytes ()  { throw new RuntimeException(); }
  public  double ndvMaxError ()  { throw new RuntimeException(); }
  public  boolean histogramEnabled ()  { throw new RuntimeException(); }
  public  int histogramNumBins ()  { throw new RuntimeException(); }
  public  int percentileAccuracy ()  { throw new RuntimeException(); }
  public  boolean cboEnabled ()  { throw new RuntimeException(); }
  public  boolean planStatsEnabled ()  { throw new RuntimeException(); }
  public  boolean autoSizeUpdateEnabled ()  { throw new RuntimeException(); }
  public  boolean joinReorderEnabled ()  { throw new RuntimeException(); }
  public  int joinReorderDPThreshold ()  { throw new RuntimeException(); }
  public  double joinReorderCardWeight ()  { throw new RuntimeException(); }
  public  boolean joinReorderDPStarFilter ()  { throw new RuntimeException(); }
  public  int windowExecBufferInMemoryThreshold ()  { throw new RuntimeException(); }
  public  int windowExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  public  int sortMergeJoinExecBufferInMemoryThreshold ()  { throw new RuntimeException(); }
  public  int sortMergeJoinExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  public  int cartesianProductExecBufferInMemoryThreshold ()  { throw new RuntimeException(); }
  public  int cartesianProductExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  public  boolean codegenSplitAggregateFunc ()  { throw new RuntimeException(); }
  public  int maxNestedViewDepth ()  { throw new RuntimeException(); }
  public  boolean useCurrentSQLConfigsForView ()  { throw new RuntimeException(); }
  public  boolean storeAnalyzedPlanForView ()  { throw new RuntimeException(); }
  public  boolean allowStarWithSingleTableIdentifierInCount ()  { throw new RuntimeException(); }
  public  boolean starSchemaDetection ()  { throw new RuntimeException(); }
  public  double starSchemaFTRatio ()  { throw new RuntimeException(); }
  public  boolean supportQuotedRegexColumnName ()  { throw new RuntimeException(); }
  public  int rangeExchangeSampleSizePerPartition ()  { throw new RuntimeException(); }
  public  boolean arrowPySparkEnabled ()  { throw new RuntimeException(); }
  public  boolean arrowPySparkSelfDestructEnabled ()  { throw new RuntimeException(); }
  public  boolean pysparkJVMStacktraceEnabled ()  { throw new RuntimeException(); }
  public  boolean arrowSparkREnabled ()  { throw new RuntimeException(); }
  public  boolean arrowPySparkFallbackEnabled ()  { throw new RuntimeException(); }
  public  int arrowMaxRecordsPerBatch ()  { throw new RuntimeException(); }
  public  int pandasUDFBufferSize ()  { throw new RuntimeException(); }
  public  boolean pysparkSimplifiedTraceback ()  { throw new RuntimeException(); }
  public  boolean pandasGroupedMapAssignColumnsByName ()  { throw new RuntimeException(); }
  public  boolean arrowSafeTypeConversion ()  { throw new RuntimeException(); }
  public  boolean replaceExceptWithFilter ()  { throw new RuntimeException(); }
  public  boolean decimalOperationsAllowPrecisionLoss ()  { throw new RuntimeException(); }
  public  boolean literalPickMinimumPrecision ()  { throw new RuntimeException(); }
  public  int continuousStreamingEpochBacklogQueueSize ()  { throw new RuntimeException(); }
  public  int continuousStreamingExecutorQueueSize ()  { throw new RuntimeException(); }
  public  long continuousStreamingExecutorPollIntervalMs ()  { throw new RuntimeException(); }
  public  java.lang.String disabledV2StreamingWriters ()  { throw new RuntimeException(); }
  public  java.lang.String disabledV2StreamingMicroBatchReaders ()  { throw new RuntimeException(); }
  public  boolean fastFailFileFormatOutput ()  { throw new RuntimeException(); }
  public  boolean concatBinaryAsString ()  { throw new RuntimeException(); }
  public  boolean eltOutputAsString ()  { throw new RuntimeException(); }
  public  boolean validatePartitionColumns ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value partitionOverwriteMode ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value storeAssignmentPolicy ()  { throw new RuntimeException(); }
  public  boolean ansiEnabled ()  { throw new RuntimeException(); }
  public  boolean nestedSchemaPruningEnabled ()  { throw new RuntimeException(); }
  public  boolean serializerNestedSchemaPruningEnabled ()  { throw new RuntimeException(); }
  public  boolean nestedPruningOnExpressions ()  { throw new RuntimeException(); }
  public  boolean csvColumnPruning ()  { throw new RuntimeException(); }
  public  boolean legacySizeOfNull ()  { throw new RuntimeException(); }
  public  boolean isReplEagerEvalEnabled ()  { throw new RuntimeException(); }
  public  int replEagerEvalMaxNumRows ()  { throw new RuntimeException(); }
  public  int replEagerEvalTruncate ()  { throw new RuntimeException(); }
  public  java.lang.String avroCompressionCodec ()  { throw new RuntimeException(); }
  public  int avroDeflateLevel ()  { throw new RuntimeException(); }
  public  boolean replaceDatabricksSparkAvroEnabled ()  { throw new RuntimeException(); }
  public  boolean setOpsPrecedenceEnforced ()  { throw new RuntimeException(); }
  public  boolean exponentLiteralAsDecimalEnabled ()  { throw new RuntimeException(); }
  public  boolean allowNegativeScaleOfDecimalEnabled ()  { throw new RuntimeException(); }
  public  boolean legacyStatisticalAggregate ()  { throw new RuntimeException(); }
  public  boolean truncateTableIgnorePermissionAcl ()  { throw new RuntimeException(); }
  public  boolean nameNonStructGroupingKeyAsValue ()  { throw new RuntimeException(); }
  public  int maxToStringFields ()  { throw new RuntimeException(); }
  public  int maxPlanStringLength ()  { throw new RuntimeException(); }
  public  int maxMetadataStringLength ()  { throw new RuntimeException(); }
  public  boolean setCommandRejectsSparkCoreConfs ()  { throw new RuntimeException(); }
  public  boolean castDatetimeToString ()  { throw new RuntimeException(); }
  public  boolean ignoreDataLocality ()  { throw new RuntimeException(); }
  public  boolean csvFilterPushDown ()  { throw new RuntimeException(); }
  public  boolean jsonFilterPushDown ()  { throw new RuntimeException(); }
  public  boolean avroFilterPushDown ()  { throw new RuntimeException(); }
  public  boolean integerGroupingIdEnabled ()  { throw new RuntimeException(); }
  public  long metadataCacheTTL ()  { throw new RuntimeException(); }
  public  boolean coalesceBucketsInJoinEnabled ()  { throw new RuntimeException(); }
  public  int coalesceBucketsInJoinMaxBucketRatio ()  { throw new RuntimeException(); }
  public  boolean optimizeNullAwareAntiJoin ()  { throw new RuntimeException(); }
  public  boolean legacyPathOptionBehavior ()  { throw new RuntimeException(); }
  public  java.lang.String disabledJdbcConnectionProviders ()  { throw new RuntimeException(); }
  public  boolean charVarcharAsString ()  { throw new RuntimeException(); }
  public  boolean cliPrintHeader ()  { throw new RuntimeException(); }
  /** Set Spark SQL configuration properties. */
  public  void setConf (java.util.Properties props)  { throw new RuntimeException(); }
  /** Set the given Spark SQL configuration property using a `string` value. */
  public  void setConfString (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /** Set the given Spark SQL configuration property. */
  public <T extends java.lang.Object> void setConf (org.apache.spark.internal.config.ConfigEntry<T> entry, T value)  { throw new RuntimeException(); }
  /** Return the value of Spark SQL configuration property for the given key. */
  public  java.lang.String getConfString (java.lang.String key) throws java.util.NoSuchElementException { throw new RuntimeException(); }
  /**
   * Return the value of Spark SQL configuration property for the given key. If the key is not set
   * yet, return <code>defaultValue</code>. This is useful when <code>defaultValue</code> in ConfigEntry is not the
   * desired one.
   * @param entry (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T getConf (org.apache.spark.internal.config.ConfigEntry<T> entry, T defaultValue)  { throw new RuntimeException(); }
  /**
   * Return the value of Spark SQL configuration property for the given key. If the key is not set
   * yet, return <code>defaultValue</code> in {@link ConfigEntry}.
   * @param entry (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T getConf (org.apache.spark.internal.config.ConfigEntry<T> entry)  { throw new RuntimeException(); }
  /**
   * Return the value of an optional Spark SQL configuration property for the given key. If the key
   * is not set yet, returns None.
   * @param entry (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.Option<T> getConf (org.apache.spark.internal.config.OptionalConfigEntry<T> entry)  { throw new RuntimeException(); }
  /**
   * Return the <code>string</code> value of Spark SQL configuration property for the given key. If the key is
   * not set yet, return <code>defaultValue</code>.
   * @param key (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getConfString (java.lang.String key, java.lang.String defaultValue)  { throw new RuntimeException(); }
  /**
   * Return all the configuration properties that have been set (i.e. not the default).
   * This creates a new copy of the config properties in the form of a Map.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getAllConfs ()  { throw new RuntimeException(); }
  /**
   * Return all the configuration definitions that have been defined in {@link SQLConf}. Each
   * definition contains key, defaultValue and doc.
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple4<java.lang.String, java.lang.String, java.lang.String, java.lang.String>> getAllDefinedConfs ()  { throw new RuntimeException(); }
  /**
   * Redacts the given option map according to the description of SQL_OPTIONS_REDACTION_PATTERN.
   * @param options (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.immutable.Map<K, V> redactOptions (scala.collection.immutable.Map<K, V> options)  { throw new RuntimeException(); }
  /**
   * Return whether a given key is set in this {@link SQLConf}.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  boolean contains (java.lang.String key)  { throw new RuntimeException(); }
  protected  void setConfWithCheck (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  public  void unsetConf (java.lang.String key)  { throw new RuntimeException(); }
  public  void unsetConf (org.apache.spark.internal.config.ConfigEntry<?> entry)  { throw new RuntimeException(); }
  public  void clear ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf clone ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf copy (scala.collection.Seq<scala.Tuple2<org.apache.spark.internal.config.ConfigEntry<?>, java.lang.Object>> entries)  { throw new RuntimeException(); }
  public  boolean isModifiable (java.lang.String key)  { throw new RuntimeException(); }
}
