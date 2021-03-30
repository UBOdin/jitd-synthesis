package org.apache.spark.sql.execution.datasources.jdbc;
  class JDBCRelation extends org.apache.spark.sql.sources.BaseRelation implements org.apache.spark.sql.sources.PrunedFilteredScan, org.apache.spark.sql.sources.InsertableRelation, scala.Product, scala.Serializable {
  /**
   * Given a partitioning schematic (a column of integral type, a number of
   * partitions, and upper and lower bounds on the column's value), generate
   * WHERE clauses for each partition so that each row in the table appears
   * exactly once.  The parameters minValue and maxValue are advisory in that
   * incorrect values may cause the partitioning to be poor, but no data
   * will fail to be represented.
   * <p>
   * Null value predicate is added to the first partition where clause to include
   * the rows with null value for the partitions column.
   * <p>
   * @param schema resolved schema of a JDBC table
   * @param resolver function used to determine if two identifiers are equal
   * @param timeZoneId timezone ID to be used if a partition column type is date or timestamp
   * @param jdbcOptions JDBC options that contains url
   * @return an array of partitions with where clause for each partition
   */
  static public  org.apache.spark.Partition[] columnPartition (org.apache.spark.sql.types.StructType schema, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver, java.lang.String timeZoneId, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions)  { throw new RuntimeException(); }
  /**
   * Takes a (schema, table) specification and returns the table's Catalyst schema.
   * If <code>customSchema</code> defined in the JDBC options, replaces the schema's dataType with the
   * custom schema's type.
   * <p>
   * @param resolver function used to determine if two identifiers are equal
   * @param jdbcOptions JDBC options that contains url, table and other information.
   * @return resolved Catalyst schema of a JDBC table
   */
  static public  org.apache.spark.sql.types.StructType getSchema (scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions)  { throw new RuntimeException(); }
  /**
   * Resolves a Catalyst schema of a JDBC table and returns {@link JDBCRelation} with the schema.
   * @param parts (undocumented)
   * @param jdbcOptions (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation apply (org.apache.spark.Partition[] parts, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] parts ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCRelation (org.apache.spark.sql.types.StructType schema, org.apache.spark.Partition[] parts, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  public  boolean needConversion ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] unhandledFilters (org.apache.spark.sql.sources.Filter[] filters)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> buildScan (java.lang.String[] requiredColumns, org.apache.spark.sql.sources.Filter[] filters)  { throw new RuntimeException(); }
  public  void insert (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data, boolean overwrite)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
