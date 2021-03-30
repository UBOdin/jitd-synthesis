package org.apache.spark.sql.hive.orc;
public  class OrcFileOperator$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OrcFileOperator$ MODULE$ = null;
  public   OrcFileOperator$ ()  { throw new RuntimeException(); }
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
  public  scala.Option<org.apache.hadoop.hive.ql.io.orc.Reader> getFileReader (java.lang.String basePath, scala.Option<org.apache.hadoop.conf.Configuration> config, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> readSchema (scala.collection.Seq<java.lang.String> paths, scala.Option<org.apache.hadoop.conf.Configuration> conf, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  /**
   * Reads ORC file schemas in multi-threaded manner, using Hive ORC library.
   * This is visible for testing.
   * @param partFiles (undocumented)
   * @param conf (undocumented)
   * @param ignoreCorruptFiles (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.types.StructType> readOrcSchemasInParallel (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> partFiles, org.apache.hadoop.conf.Configuration conf, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector> getObjectInspector (java.lang.String path, scala.Option<org.apache.hadoop.conf.Configuration> conf)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.fs.Path> listOrcFiles (java.lang.String pathStr, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
}
