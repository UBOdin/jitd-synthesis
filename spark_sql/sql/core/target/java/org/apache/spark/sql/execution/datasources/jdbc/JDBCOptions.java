package org.apache.spark.sql.execution.datasources.jdbc;
/**
 * Options for the JDBC data source.
 */
public  class JDBCOptions implements scala.Serializable, org.apache.spark.internal.Logging {
  static public  java.lang.String JDBC_URL ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_TABLE_NAME ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_QUERY_STRING ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_DRIVER_CLASS ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_PARTITION_COLUMN ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_LOWER_BOUND ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_UPPER_BOUND ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_NUM_PARTITIONS ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_QUERY_TIMEOUT ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_BATCH_FETCH_SIZE ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_TRUNCATE ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_CASCADE_TRUNCATE ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_CREATE_TABLE_OPTIONS ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_CREATE_TABLE_COLUMN_TYPES ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_CUSTOM_DATAFRAME_COLUMN_TYPES ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_BATCH_INSERT_SIZE ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_TXN_ISOLATION_LEVEL ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_SESSION_INIT_STATEMENT ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_PUSHDOWN_PREDICATE ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_KEYTAB ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_PRINCIPAL ()  { throw new RuntimeException(); }
  static public  java.lang.String JDBC_TABLE_COMMENT ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   JDBCOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public   JDBCOptions (java.lang.String url, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  /**
   * Returns a property with all options.
   * @return (undocumented)
   */
  public  java.util.Properties asProperties ()  { throw new RuntimeException(); }
  /**
   * Returns a property with all options except Spark internal data source options like <code>url</code>,
   * <code>dbtable</code>, and <code>numPartition</code>. This should be used when invoking JDBC API like <code>Driver.connect</code>
   * because each DBMS vendor has its own property list for JDBC driver. See SPARK-17776.
   * @return (undocumented)
   */
  public  java.util.Properties asConnectionProperties ()  { throw new RuntimeException(); }
  public  java.lang.String url ()  { throw new RuntimeException(); }
  public  java.lang.String tableOrQuery ()  { throw new RuntimeException(); }
  public  java.lang.String driverClass ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> numPartitions ()  { throw new RuntimeException(); }
  public  int queryTimeout ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> partitionColumn ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> lowerBound ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> upperBound ()  { throw new RuntimeException(); }
  public  int fetchSize ()  { throw new RuntimeException(); }
  public  boolean isTruncate ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> isCascadeTruncate ()  { throw new RuntimeException(); }
  public  java.lang.String createTableOptions ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> createTableColumnTypes ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> customSchema ()  { throw new RuntimeException(); }
  public  int batchSize ()  { throw new RuntimeException(); }
  public  int isolationLevel ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> sessionInitStatement ()  { throw new RuntimeException(); }
  public  boolean pushDownPredicate ()  { throw new RuntimeException(); }
  public  java.lang.String keytab ()  { throw new RuntimeException(); }
  public  java.lang.String principal ()  { throw new RuntimeException(); }
  public  java.lang.String tableComment ()  { throw new RuntimeException(); }
}
