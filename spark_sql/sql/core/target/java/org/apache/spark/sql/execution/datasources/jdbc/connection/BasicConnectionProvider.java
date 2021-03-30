package org.apache.spark.sql.execution.datasources.jdbc.connection;
  class BasicConnectionProvider extends org.apache.spark.sql.jdbc.JdbcConnectionProvider implements org.apache.spark.internal.Logging {
  public   BasicConnectionProvider ()  { throw new RuntimeException(); }
  public  boolean canHandle (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Additional properties for data connection (Data source property takes precedence).
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  java.util.Properties getAdditionalProperties (org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions options)  { throw new RuntimeException(); }
  public  java.sql.Connection getConnection (java.sql.Driver driver, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
}
