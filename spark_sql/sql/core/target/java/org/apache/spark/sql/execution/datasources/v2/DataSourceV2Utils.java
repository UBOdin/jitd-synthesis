package org.apache.spark.sql.execution.datasources.v2;
public  class DataSourceV2Utils {
  /**
   * Helper method that extracts and transforms session configs into k/v pairs, the k/v pairs will
   * be used to create data source options.
   * Only extract when <code>ds</code> implements {@link SessionConfigSupport}, in this case we may fetch the
   * specified key-prefix from <code>ds</code>, and extract session configs with config keys that start with
   * <code>spark.datasource.$keyPrefix</code>. A session config <code>spark.datasource.$keyPrefix.xxx -> yyy</code> will
   * be transformed into <code>xxx -> yyy</code>.
   * <p>
   * @param source a {@link TableProvider} object
   * @param conf the session conf
   * @return an immutable map that contains all the extracted and transformed k/v pairs.
   */
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> extractSessionConfigs (org.apache.spark.sql.connector.catalog.TableProvider source, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.catalog.Table getTableFromProvider (org.apache.spark.sql.connector.catalog.TableProvider provider, org.apache.spark.sql.util.CaseInsensitiveStringMap options, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema)  { throw new RuntimeException(); }
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
