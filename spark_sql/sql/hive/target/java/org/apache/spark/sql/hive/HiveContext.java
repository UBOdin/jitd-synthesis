package org.apache.spark.sql.hive;
/**
 * An instance of the Spark SQL execution engine that integrates with data stored in Hive.
 * Configuration for Hive is read from hive-site.xml on the classpath.
 *
 * @deprecated Use SparkSession.builder.enableHiveSupport instead. Since 2.0.0. 
 */
public  class HiveContext extends org.apache.spark.sql.SQLContext implements org.apache.spark.internal.Logging {
     HiveContext (org.apache.spark.sql.SparkSession _sparkSession)  { throw new RuntimeException(); }
  public   HiveContext (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  public   HiveContext (org.apache.spark.api.java.JavaSparkContext sc)  { throw new RuntimeException(); }
  /**
   * Returns a new HiveContext as new session, which will have separated SQLConf, UDF/UDAF,
   * temporary tables and SessionState, but sharing the same CacheManager, IsolatedClientLoader
   * and Hive client (both of execution and metadata) with existing HiveContext.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.hive.HiveContext newSession ()  { throw new RuntimeException(); }
  /**
   * Invalidate and refresh all the cached the metadata of the given table. For performance reasons,
   * Spark SQL or the external data source library it uses might cache certain metadata about a
   * table, such as the location of blocks. When those change outside of Spark SQL, users should
   * call this function to invalidate the cache.
   * <p>
   * @since 1.3.0
   * @param tableName (undocumented)
   */
  public  void refreshTable (java.lang.String tableName)  { throw new RuntimeException(); }
}
