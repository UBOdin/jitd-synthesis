package org.apache.spark.sql.internal;
public  class SQLConf$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SQLConf$ MODULE$ = null;
  public   SQLConf$ ()  { throw new RuntimeException(); }
    java.util.concurrent.ConcurrentHashMap<java.lang.String, org.apache.spark.internal.config.ConfigEntry<?>> sqlConfEntries ()  { throw new RuntimeException(); }
  public  java.util.Set<java.lang.String> staticConfKeys ()  { throw new RuntimeException(); }
    void unregister (org.apache.spark.internal.config.ConfigEntry<?> entry)  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigBuilder buildConf (java.lang.String key)  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigBuilder buildStaticConf (java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Merge all non-static configs to the SQLConf. For example, when the 1st {@link SparkSession} and
   * the global {@link SharedState} have been initialized, all static configs have taken affect and
   * should not be set to other values. Other later created sessions should respect all static
   * configs and only be able to change non-static configs.
   * @param sqlConf (undocumented)
   * @param configs (undocumented)
   */
    void mergeNonStaticSQLConfigs (org.apache.spark.sql.internal.SQLConf sqlConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> configs)  { throw new RuntimeException(); }
  /**
   * Extract entries from <code>SparkConf</code> and put them in the <code>SQLConf</code>
   * @param sqlConf (undocumented)
   * @param sparkConf (undocumented)
   */
    void mergeSparkConf (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  /** See {@link get} for more information. */
  public  org.apache.spark.sql.internal.SQLConf getFallbackConf ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> T withExistingConf (org.apache.spark.sql.internal.SQLConf conf, scala.Function0<T> f)  { throw new RuntimeException(); }
  /**
   * Sets the active config object within the current scope.
   * See {@link get} for more information.
   * @param getter (undocumented)
   */
  public  void setSQLConfGetter (scala.Function0<org.apache.spark.sql.internal.SQLConf> getter)  { throw new RuntimeException(); }
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
  public  org.apache.spark.sql.internal.SQLConf get ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ANALYZER_MAX_ITERATIONS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> OPTIMIZER_EXCLUDED_RULES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_MAX_ITERATIONS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_INSET_CONVERSION_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_INSET_SWITCH_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PLAN_CHANGE_LOG_LEVEL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> PLAN_CHANGE_LOG_RULES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> PLAN_CHANGE_LOG_BATCHES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_USE_STATS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_FALLBACK_FILTER_RATIO ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DYNAMIC_PARTITION_PRUNING_REUSE_BROADCAST_ONLY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COMPRESS_CACHED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COLUMN_BATCH_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IN_MEMORY_PARTITION_PRUNING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IN_MEMORY_TABLE_SCAN_STATISTICS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CACHE_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COLUMN_VECTOR_OFFHEAP_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PREFER_SORTMERGEJOIN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RADIX_SORT_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_BROADCASTJOIN_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LIMIT_SCALE_UP_FACTOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADVANCED_PARTITION_PREDICATE_PUSHDOWN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> LEAF_NODE_DEFAULT_PARALLELISM ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SHUFFLE_PARTITIONS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SHUFFLE_TARGET_POSTSHUFFLE_INPUT_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADAPTIVE_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADAPTIVE_EXECUTION_FORCE_APPLY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ADAPTIVE_EXECUTION_LOG_LEVEL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADVISORY_PARTITION_SIZE_IN_BYTES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_PARTITIONS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> COALESCE_PARTITIONS_MIN_PARTITION_NUM ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> COALESCE_PARTITIONS_INITIAL_PARTITION_NUM ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FETCH_SHUFFLE_BLOCKS_IN_BATCH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LOCAL_SHUFFLE_READER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_SKEWED_PARTITION_FACTOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SKEW_JOIN_SKEWED_PARTITION_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NON_EMPTY_PARTITION_RATIO_FOR_BROADCAST_JOIN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> ADAPTIVE_OPTIMIZER_EXCLUDED_RULES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBEXPRESSION_ELIMINATION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBEXPRESSION_ELIMINATION_CACHE_MAX_ENTRIES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CASE_SENSITIVE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONSTRAINT_PROPAGATION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ESCAPED_STRING_LITERALS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_COMPRESSION_FACTOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_SCHEMA_MERGING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_SCHEMA_RESPECT_SUMMARIES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_BINARY_AS_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_INT96_AS_TIMESTAMP ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_INT96_TIMESTAMP_CONVERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_OUTPUT_TIMESTAMP_TYPE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_COMPRESSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_DATE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_TIMESTAMP_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_STRING_STARTSWITH_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_FILTER_PUSHDOWN_INFILTERTHRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_WRITE_LEGACY_FORMAT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_OUTPUT_COMMITTER_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_RECORD_FILTER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARQUET_VECTORIZED_READER_BATCH_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ORC_COMPRESSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ORC_IMPLEMENTATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_VECTORIZED_READER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_VECTORIZED_READER_BATCH_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORC_SCHEMA_MERGING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_VERIFY_PARTITION_PATH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_METASTORE_PARTITION_PRUNING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_METASTORE_PARTITION_PRUNING_INSET_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_MANAGE_FILESOURCE_PARTITIONS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_FILESOURCE_PARTITION_FILE_CACHE_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> HIVE_CASE_SENSITIVE_INFERENCE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> HIVE_TABLE_PROPERTY_LENGTH_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZER_METADATA_ONLY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> COLUMN_NAME_OF_CORRUPT_RECORD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BROADCAST_TIMEOUT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> THRIFTSERVER_POOL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_INCREMENTAL_COLLECT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_FORCE_CANCEL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_QUERY_TIMEOUT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_UI_STATEMENT_LIMIT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> THRIFTSERVER_UI_SESSION_LIMIT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DEFAULT_DATA_SOURCE_NAME ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_CTAS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GATHER_FASTSTAT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARTITION_COLUMN_TYPE_INFERENCE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BUCKETING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BUCKETING_MAX_BUCKETS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_BUCKETED_SCAN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CROSS_JOINS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ORDER_BY_ORDINAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GROUP_BY_ORDINAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> GROUP_BY_ALIASES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> OUTPUT_COMMITTER_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> FILE_COMMIT_PROTOCOL_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_PARTITION_DISCOVERY_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_PARTITION_DISCOVERY_PARALLELISM ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_DATA_LOCALITY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_SELF_JOIN_AUTO_RESOLVE_AMBIGUITY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FAIL_AMBIGUOUS_SELF_JOIN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_RETAIN_GROUP_COLUMNS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATAFRAME_PIVOT_MAX_VALUES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RUN_SQL_ON_FILES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_CODEGEN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_CODEGEN_USE_ID_IN_CLASS_NAME ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_MAX_NUM_FIELDS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> CODEGEN_FACTORY_MODE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_FALLBACK ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_LOGGING_MAX_LINES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_HUGE_METHOD_LIMIT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_METHOD_SPLIT_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WHOLESTAGE_SPLIT_CONSUME_FUNC_BY_OPERATOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILES_MAX_PARTITION_BYTES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILES_OPEN_COST_IN_BYTES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.Object> FILES_MIN_PARTITION_NUM ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_CORRUPT_FILES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> IGNORE_MISSING_FILES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_RECORDS_PER_FILE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> EXCHANGE_REUSE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUBQUERY_REUSE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REMOVE_REDUNDANT_PROJECTS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REMOVE_REDUNDANT_SORTS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STATE_STORE_PROVIDER_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_SCHEMA_CHECK_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_STORE_MIN_DELTAS_FOR_SNAPSHOT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATE_STORE_FORMAT_VALIDATION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FLATMAPGROUPSWITHSTATE_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> CHECKPOINT_LOCATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FORCE_DELETE_TEMP_CHECKPOINT_LOCATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MIN_BATCHES_TO_RETAIN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_BATCHES_TO_RETAIN_IN_MEMORY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_MAINTENANCE_INTERVAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STATE_STORE_COMPRESSION_CODEC ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_AGGREGATION_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_STOP_ACTIVE_RUN_ON_RESTART ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_JOIN_STATE_FORMAT_VERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> UNSUPPORTED_OPERATION_CHECK_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_DEPRECATED_KAFKA_OFFSET_FETCHING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STATEFUL_OPERATOR_CHECK_CORRECTNESS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> VARIABLE_SUBSTITUTE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_TWOLEVEL_AGG_MAP ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_VECTORIZED_HASH_MAP ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CODEGEN_SPLIT_AGGREGATE_FUNC ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_NESTED_VIEW_DEPTH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ALLOW_PARAMETERLESS_COUNT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ALLOW_STAR_WITH_SINGLE_TABLE_IDENTIFIER_IN_COUNT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_CURRENT_SQL_CONFIGS_FOR_VIEW ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STORE_ANALYZED_PLAN_FOR_VIEW ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STREAMING_FILE_COMMIT_PROTOCOL_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STREAMING_MULTIPLE_WATERMARK_POLICY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OBJECT_AGG_SORT_BASED_FALLBACK_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> USE_OBJECT_HASH_AGG ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_GENERATOR_IGNORE_NULL_FIELDS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_EXPRESSION_OPTIMIZATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_EXPRESSION_OPTIMIZATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_DELETION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_COMPACT_INTERVAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SINK_LOG_CLEANUP_DELAY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_DELETION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_COMPACT_INTERVAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_LOG_CLEANUP_DELAY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_SCHEMA_FORCE_NULLABLE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FILE_SOURCE_CLEANER_NUM_THREADS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_SCHEMA_INFERENCE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_POLLING_DELAY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_STOP_TIMEOUT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_NO_DATA_PROGRESS_EVENT_INTERVAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_NO_DATA_MICRO_BATCHES_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_METRICS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_PROGRESS_RETENTION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.TypedConfigBuilder<java.lang.String> STREAMING_CHECKPOINT_FILE_MANAGER_CLASS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STREAMING_CHECKPOINT_ESCAPED_PATH_CHECK_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PARALLEL_FILE_LISTING_IN_STATS_COMPUTATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DEFAULT_SIZE_IN_BYTES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ENABLE_FALL_BACK_TO_HDFS_FOR_STATS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NDV_MAX_ERROR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HISTOGRAM_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HISTOGRAM_NUM_BINS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PERCENTILE_ACCURACY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AUTO_SIZE_UPDATE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CBO_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PLAN_STATS_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_DP_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_CARD_WEIGHT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JOIN_REORDER_DP_STAR_FILTER ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STARSCHEMA_DETECTION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> STARSCHEMA_FACT_TABLE_RATIO ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> SESSION_LOCAL_TIMEZONE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WINDOW_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> WINDOW_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_MERGE_JOIN_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_MERGE_JOIN_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CARTESIAN_PRODUCT_EXEC_BUFFER_IN_MEMORY_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CARTESIAN_PRODUCT_EXEC_BUFFER_SPILL_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SUPPORT_QUOTED_REGEX_COLUMN_NAME ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> RANGE_EXCHANGE_SAMPLE_SIZE_PER_PARTITION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_SELF_DESTRUCT_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PYSPARK_JVM_STACKTRACE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_SPARKR_EXECUTION_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_FALLBACK_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_PYSPARK_FALLBACK_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ARROW_EXECUTION_MAX_RECORDS_PER_BATCH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_UDF_BUFFER_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PYSPARK_SIMPLIFIEID_TRACEBACK ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_GROUPED_MAP_ASSIGN_COLUMNS_BY_NAME ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> PANDAS_ARROW_SAFE_TYPE_CONVERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPLACE_EXCEPT_WITH_FILTER ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DECIMAL_OPERATIONS_ALLOW_PREC_LOSS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LITERAL_PICK_MINIMUM_PRECISION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<scala.util.matching.Regex> SQL_OPTIONS_REDACTION_PATTERN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<scala.Option<scala.util.matching.Regex>> SQL_STRING_REDACTION_PATTERN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONCAT_BINARY_AS_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ELT_OUTPUT_AS_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> VALIDATE_PARTITION_COLUMNS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EPOCH_BACKLOG_QUEUE_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EXECUTOR_QUEUE_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONTINUOUS_STREAMING_EXECUTOR_POLL_INTERVAL_MS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> USE_V1_SOURCE_LIST ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_V2_STREAMING_WRITERS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_V2_STREAMING_MICROBATCH_READERS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FASTFAIL_ON_FILEFORMAT_OUTPUT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARTITION_OVERWRITE_MODE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> STORE_ASSIGNMENT_POLICY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ANSI_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SORT_BEFORE_REPARTITION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NESTED_SCHEMA_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DISABLE_HINTS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> NESTED_PREDICATE_PUSHDOWN_FILE_SOURCE_LIST ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SERIALIZER_NESTED_SCHEMA_PRUNING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NESTED_PRUNING_ON_EXPRESSIONS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> TOP_K_SORT_FALLBACK_THRESHOLD ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_PARSER_COLUMN_PRUNING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_MAX_NUM_ROWS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> REPL_EAGER_EVAL_TRUNCATE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> FAST_HASH_AGGREGATE_MAX_ROWS_CAPACITY_BIT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_COMPRESSION_CODEC ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AVRO_DEFLATE_LEVEL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_SIZE_OF_NULL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PARSE_NULL_PARTITION_SPEC_AS_STRING_LITERAL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_REPLACE_DATABRICKS_SPARK_AVRO_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_SETOPS_PRECEDENCE_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_EXPONENT_LITERAL_AS_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_NEGATIVE_SCALE_OF_DECIMAL_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_BUCKETED_TABLE_SCAN_OUTPUT_ORDERING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_HAVING_WITHOUT_GROUP_BY_AS_WHERE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_EMPTY_STRING_IN_JSON ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CREATE_EMPTY_COLLECTION_USING_STRING_TYPE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_UNTYPED_SCALA_UDF ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_STATISTICAL_AGGREGATE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> TRUNCATE_TABLE_IGNORE_PERMISSION_ACL ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> NAME_NON_STRUCT_GROUPING_KEY_AS_VALUE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_TO_STRING_FIELDS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_PLAN_STRING_LENGTH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> MAX_METADATA_STRING_LENGTH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SET_COMMAND_REJECTS_SPARK_CORE_CONFS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> DATETIME_JAVA8API_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> UI_EXPLAIN_MODE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SOURCES_BINARY_FILE_MAX_LENGTH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CAST_DATETIME_TO_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DEFAULT_CATALOG ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.OptionalConfigEntry<java.lang.String> V2_SESSION_CATALOG_IMPLEMENTATION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> MAP_KEY_DEDUP_POLICY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_LOOSE_UPCAST ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> LEGACY_CTE_PRECEDENCE_POLICY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> LEGACY_TIME_PARSER_POLICY ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ARRAY_EXISTS_FOLLOWS_THREE_VALUED_LOGIC ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> ADDITIONAL_REMOTE_REPOSITORIES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_FROM_DAYTIME_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PROPERTY_NON_RESERVED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ADD_SINGLE_FILE_IN_ADD_FILE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_MSSQLSERVER_NUMERIC_MAPPING_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CSV_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> JSON_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> AVRO_FILTER_PUSHDOWN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> ADD_PARTITION_BATCH_SIZE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_ALLOW_HASH_ON_MAPTYPE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_INTEGER_GROUPING_ID ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_INT96_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_INT96_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> PARQUET_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_REBASE_MODE_IN_WRITE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> AVRO_REBASE_MODE_IN_READ ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> SCRIPT_TRANSFORMATION_EXIT_TIMEOUT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_BUCKETS_IN_JOIN_ENABLED ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> COALESCE_BUCKETS_IN_JOIN_MAX_BUCKET_RATIO ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> BROADCAST_HASH_JOIN_OUTPUT_PARTITIONING_EXPAND_LIMIT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> OPTIMIZE_NULL_AWARE_ANTI_JOIN ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_COMPLEX_TYPES_TO_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_PATH_OPTION_BEHAVIOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_EXTRA_OPTIONS_BEHAVIOR ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> DISABLED_JDBC_CONN_PROVIDER_LIST ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CREATE_HIVE_TABLE_BY_DEFAULT ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_CHAR_VARCHAR_AS_STRING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CLI_PRINT_HEADER ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> LEGACY_KEEP_COMMAND_OUTPUT_SCHEMA ()  { throw new RuntimeException(); }
  /**
   * Maps deprecated SQL config keys to information about the deprecation.
   * <p>
   * The extra information is logged as a warning when the SQL config is present
   * in the user's configuration.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.SQLConf.DeprecatedConfig> deprecatedSQLConfigs ()  { throw new RuntimeException(); }
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
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.internal.SQLConf.RemovedConfig> removedSQLConfigs ()  { throw new RuntimeException(); }
}
