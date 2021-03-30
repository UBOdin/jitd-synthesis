package org.apache.spark.sql.api.r;
public  class SQLUtils {
  static public  org.apache.spark.sql.SparkSession getOrCreateSparkSession (org.apache.spark.api.java.JavaSparkContext jsc, java.util.Map<java.lang.Object, java.lang.Object> sparkConfigMap, boolean enableHiveSupport)  { throw new RuntimeException(); }
  static public  void setSparkContextSessionConf (org.apache.spark.sql.SparkSession spark, java.util.Map<java.lang.Object, java.lang.Object> sparkConfigMap)  { throw new RuntimeException(); }
  static public  java.util.Map<java.lang.String, java.lang.String> getSessionConf (org.apache.spark.sql.SparkSession spark)  { throw new RuntimeException(); }
  static public  org.apache.spark.api.java.JavaSparkContext getJavaSparkContext (org.apache.spark.sql.SparkSession spark)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType createStructType (scala.collection.Seq<org.apache.spark.sql.types.StructField> fields)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructField createStructField (java.lang.String name, java.lang.String dataType, boolean nullable)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDF (org.apache.spark.rdd.RDD<byte[]> rdd, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  static public  org.apache.spark.api.java.JavaRDD<byte[]> dfToRowRDD (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.Row bytesToRow (byte[] bytes, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static   byte[] rowToRBytes (org.apache.spark.sql.Row row)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType SERIALIZED_R_DATA_SCHEMA ()  { throw new RuntimeException(); }
  /**
   * The helper function for dapply() on R side.
   * @param df (undocumented)
   * @param func (undocumented)
   * @param packageNames (undocumented)
   * @param broadcastVars (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> dapply (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, byte[] func, byte[] packageNames, java.lang.Object[] broadcastVars, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * The helper function for gapply() on R side.
   * @param gd (undocumented)
   * @param func (undocumented)
   * @param packageNames (undocumented)
   * @param broadcastVars (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> gapply (org.apache.spark.sql.RelationalGroupedDataset gd, byte[] func, byte[] packageNames, java.lang.Object[] broadcastVars, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  java.lang.Object[][] dfToCols (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df)  { throw new RuntimeException(); }
  static public  java.lang.Object readSqlObject (java.io.DataInputStream dis, char dataType)  { throw new RuntimeException(); }
  static public  boolean writeSqlObject (java.io.DataOutputStream dos, java.lang.Object obj)  { throw new RuntimeException(); }
  static public  java.lang.String[] getTableNames (org.apache.spark.sql.SparkSession sparkSession, java.lang.String databaseName)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.ArrayType createArrayType (org.apache.spark.sql.Column column)  { throw new RuntimeException(); }
  /**
   * R callable function to read a file in Arrow stream format and create an <code>RDD</code>
   * using each serialized ArrowRecordBatch as a partition.
   * @param sparkSession (undocumented)
   * @param filename (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.api.java.JavaRDD<byte[]> readArrowStreamFromFile (org.apache.spark.sql.SparkSession sparkSession, java.lang.String filename)  { throw new RuntimeException(); }
  /**
   * R callable function to create a <code>DataFrame</code> from a <code>JavaRDD</code> of serialized
   * ArrowRecordBatches.
   * @param arrowBatchRDD (undocumented)
   * @param schema (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDataFrame (org.apache.spark.api.java.JavaRDD<byte[]> arrowBatchRDD, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
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
}
