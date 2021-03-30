package org.apache.spark.sql.api.python;
public  class PythonSQLUtils {
  static public  org.apache.spark.sql.types.DataType parseDataType (java.lang.String typeText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.ExpressionInfo[] listBuiltinFunctionInfos ()  { throw new RuntimeException(); }
  static public  scala.Tuple4<java.lang.String, java.lang.String, java.lang.String, java.lang.String>[] listRuntimeSQLConfigs ()  { throw new RuntimeException(); }
  static public  scala.Tuple4<java.lang.String, java.lang.String, java.lang.String, java.lang.String>[] listStaticSQLConfigs ()  { throw new RuntimeException(); }
  /**
   * Python callable function to read a file in Arrow stream format and create a {@link RDD}
   * using each serialized ArrowRecordBatch as a partition.
   * @param sqlContext (undocumented)
   * @param filename (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.api.java.JavaRDD<byte[]> readArrowStreamFromFile (org.apache.spark.sql.SQLContext sqlContext, java.lang.String filename)  { throw new RuntimeException(); }
  /**
   * Python callable function to read a file in Arrow stream format and create a {@link DataFrame}
   * from an RDD.
   * @param arrowBatchRDD (undocumented)
   * @param schemaString (undocumented)
   * @param sqlContext (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDataFrame (org.apache.spark.api.java.JavaRDD<byte[]> arrowBatchRDD, java.lang.String schemaString, org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  static public  java.lang.String explainString (org.apache.spark.sql.execution.QueryExecution queryExecution, java.lang.String mode)  { throw new RuntimeException(); }
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
