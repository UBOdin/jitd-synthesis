package org.apache.spark.sql.hive.orc;
public  class OrcFileOperator {
  /**
   * Retrieves an ORC file reader from a given path.  The path can point to either a directory or a
   * single ORC file.  If it points to a directory, it picks any non-empty ORC file within that
   * directory.
   * <p>
   * The reader returned by this method is mainly used for two purposes:
   * <p>
   * 1. Retrieving file metadata (schema and compression codecs, etc.)
   * 2. Read the actual file content (in this case, the given path should point to the target file)
   * <p>
   * @note As recorded by SPARK-8501, ORC writes an empty schema (<code>struct&amp;lt;&amp;gt;</code>) to an
   *       ORC file if the file contains zero rows. This is OK for Hive since the schema of the
   *       table is managed by metastore.  But this becomes a problem when reading ORC files
   *       directly from HDFS via Spark SQL, because we have to discover the schema from raw ORC
   *       files. So this method always tries to find an ORC file whose schema is non-empty, and
   *       create the result reader from that file.  If no such file is found, it returns <code>None</code>.
   * @todo Needs to consider all files when schema evolution is taken into account.
   * @param basePath (undocumented)
   * @param config (undocumented)
   * @param ignoreCorruptFiles (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.hadoop.hive.ql.io.orc.Reader> getFileReader (java.lang.String basePath, scala.Option<org.apache.hadoop.conf.Configuration> config, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.StructType> readSchema (scala.collection.Seq<java.lang.String> paths, scala.Option<org.apache.hadoop.conf.Configuration> conf, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  /**
   * Reads ORC file schemas in multi-threaded manner, using Hive ORC library.
   * This is visible for testing.
   * @param partFiles (undocumented)
   * @param conf (undocumented)
   * @param ignoreCorruptFiles (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<org.apache.spark.sql.types.StructType> readOrcSchemasInParallel (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> partFiles, org.apache.hadoop.conf.Configuration conf, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector> getObjectInspector (java.lang.String path, scala.Option<org.apache.hadoop.conf.Configuration> conf)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.hadoop.fs.Path> listOrcFiles (java.lang.String pathStr, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
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
