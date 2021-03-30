package org.apache.spark.sql.internal;
/**
 * Session shared {@link FunctionResourceLoader}.
 */
public  class SessionResourceLoader implements org.apache.spark.sql.catalyst.catalog.FunctionResourceLoader {
  public   SessionResourceLoader (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /**
   * Add a jar path to {@link SparkContext} and the classloader.
   * <p>
   * Note: this method seems not access any session state, but a Hive based <code>SessionState</code> needs
   * to add the jar to its hive client for the current session. Hence, it still needs to be in
   * {@link SessionState}.
   * @param path (undocumented)
   */
  public  void addJar (java.lang.String path)  { throw new RuntimeException(); }
  public  void loadResource (org.apache.spark.sql.catalyst.catalog.FunctionResource resource)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> resolveJars (java.net.URI path)  { throw new RuntimeException(); }
}
