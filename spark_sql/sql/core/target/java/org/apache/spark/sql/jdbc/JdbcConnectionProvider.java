package org.apache.spark.sql.jdbc;
/**
 * ::DeveloperApi::
 * Connection provider which opens connection toward various databases (database specific instance
 * needed). If any authentication required then it's the provider's responsibility to set all
 * the parameters.
 * Important to mention connection providers within a JVM used from multiple threads so adding
 * internal state is not advised. If any state added then it must be synchronized properly.
 * <p>
 * @since 3.1.0
 */
public abstract class JdbcConnectionProvider {
  public   JdbcConnectionProvider ()  { throw new RuntimeException(); }
  /**
   * Checks if this connection provider instance can handle the connection initiated by the driver.
   * There must be exactly one active connection provider which can handle the connection for a
   * specific driver. If this requirement doesn't met then <code>IllegalArgumentException</code>
   * will be thrown by the provider framework.
   * <p>
   * @param driver  Java driver which initiates the connection
   * @param options Driver options which initiates the connection
   * @return True if the connection provider can handle the driver with the given options.
   */
  public abstract  boolean canHandle (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Opens connection toward the database. Since global JVM security configuration change may needed
   * this API is called synchronized by <code>SecurityConfigurationLock</code> to avoid race.
   * <p>
   * @param driver  Java driver which initiates the connection
   * @param options Driver options which initiates the connection
   * @return a <code>Connection</code> object that represents a connection to the URL
   */
  public abstract  java.sql.Connection getConnection (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Name of the service to provide JDBC connections. This name should be unique. Spark will
   * internally use this name to differentiate JDBC connection providers.
   * @return (undocumented)
   */
  public abstract  java.lang.String name ()  ;
}
