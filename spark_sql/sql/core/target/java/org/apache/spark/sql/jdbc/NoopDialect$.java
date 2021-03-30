package org.apache.spark.sql.jdbc;
/**
 * NOOP dialect object, always returning the neutral element.
 */
public  class NoopDialect$ extends org.apache.spark.sql.jdbc.JdbcDialect {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoopDialect$ MODULE$ = null;
  public   NoopDialect$ ()  { throw new RuntimeException(); }
  public  boolean canHandle (java.lang.String url)  { throw new RuntimeException(); }
}
