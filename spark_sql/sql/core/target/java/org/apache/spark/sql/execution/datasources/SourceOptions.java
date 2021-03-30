package org.apache.spark.sql.execution.datasources;
/**
 * Options for the data source.
 */
public  class SourceOptions implements scala.Serializable {
  static public  java.lang.String SKIP_HIVE_METADATA ()  { throw new RuntimeException(); }
  static public  boolean DEFAULT_SKIP_HIVE_METADATA ()  { throw new RuntimeException(); }
  static public  java.lang.String RESPECT_SPARK_SCHEMA ()  { throw new RuntimeException(); }
  static public  boolean DEFAULT_RESPECT_SPARK_SCHEMA ()  { throw new RuntimeException(); }
  // not preceding
  public   SourceOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   SourceOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public  boolean skipHiveMetadata ()  { throw new RuntimeException(); }
  public  boolean respectSparkSchema ()  { throw new RuntimeException(); }
}
