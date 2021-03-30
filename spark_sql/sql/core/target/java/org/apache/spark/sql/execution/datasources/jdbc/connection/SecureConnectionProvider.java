package org.apache.spark.sql.execution.datasources.jdbc.connection;
 abstract class SecureConnectionProvider extends org.apache.spark.sql.execution.datasources.jdbc.connection.BasicConnectionProvider implements org.apache.spark.internal.Logging {
  static public  class JDBCConfiguration extends javax.security.auth.login.Configuration {
    public   JDBCConfiguration (javax.security.auth.login.Configuration parent, java.lang.String appEntry, java.lang.String keytab, java.lang.String principal)  { throw new RuntimeException(); }
    public  javax.security.auth.login.AppConfigurationEntry entry ()  { throw new RuntimeException(); }
    public  javax.security.auth.login.AppConfigurationEntry[] getAppConfigurationEntry (java.lang.String name)  { throw new RuntimeException(); }
  }
  public   SecureConnectionProvider ()  { throw new RuntimeException(); }
  /**
   * Returns the driver canonical class name which the connection provider supports.
   * @return (undocumented)
   */
  protected abstract  java.lang.String driverClass ()  ;
  public  boolean canHandle (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public  java.sql.Connection getConnection (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Returns JAAS application name. This is sometimes configurable on the JDBC driver level.
   * @param driver (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public abstract  java.lang.String appEntry (java.sql.Driver driver, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions options)  ;
    void setAuthenticationConfig (java.sql.Driver driver, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions options)  { throw new RuntimeException(); }
}
