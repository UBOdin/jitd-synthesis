package org.apache.spark.sql.execution.datasources.jdbc;
/**
 * java.sql.DriverManager is always loaded by bootstrap classloader,
 * so it can't load JDBC drivers accessible by Spark ClassLoader.
 * <p>
 * To solve the problem, drivers from user-supplied jars are wrapped into thin wrapper.
 */
public  class DriverRegistry$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DriverRegistry$ MODULE$ = null;
  public   DriverRegistry$ ()  { throw new RuntimeException(); }
  public  void register (java.lang.String className)  { throw new RuntimeException(); }
  public  java.sql.Driver get (java.lang.String className)  { throw new RuntimeException(); }
}
