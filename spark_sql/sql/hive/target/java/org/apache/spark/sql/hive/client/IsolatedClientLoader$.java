package org.apache.spark.sql.hive.client;
/** Factory for `IsolatedClientLoader` with specific versions of hive. */
public  class IsolatedClientLoader$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final IsolatedClientLoader$ MODULE$ = null;
  public   IsolatedClientLoader$ ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.hive.client.IsolatedClientLoader forVersion (java.lang.String hiveMetastoreVersion, java.lang.String hadoopVersion, org.apache.spark.SparkConf sparkConf, org.apache.hadoop.conf.Configuration hadoopConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> config, scala.Option<java.lang.String> ivyPath, scala.collection.Seq<java.lang.String> sharedPrefixes, scala.collection.Seq<java.lang.String> barrierPrefixes)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.client.HiveVersion hiveVersion (java.lang.String version)  { throw new RuntimeException(); }
  public  boolean supportsHadoopShadedClient (java.lang.String hadoopVersion)  { throw new RuntimeException(); }
}
