package org.apache.spark.sql.execution.datasources.orc;
/**
 * Options for the ORC data source.
 */
public  class OrcOptions implements scala.Serializable {
  static public  java.lang.String MERGE_SCHEMA ()  { throw new RuntimeException(); }
  static public  java.lang.String getORCCompressionCodecName (java.lang.String name)  { throw new RuntimeException(); }
  // not preceding
  public   OrcOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  public   OrcOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  /**
   * Compression codec to use.
   * Acceptable values are defined in {@link shortOrcCompressionCodecNames}.
   * @return (undocumented)
   */
  public  java.lang.String compressionCodec ()  { throw new RuntimeException(); }
  /**
   * Whether it merges schemas or not. When the given Orc files have different schemas,
   * the schemas can be merged. By default use the value specified in SQLConf.
   * @return (undocumented)
   */
  public  boolean mergeSchema ()  { throw new RuntimeException(); }
}
