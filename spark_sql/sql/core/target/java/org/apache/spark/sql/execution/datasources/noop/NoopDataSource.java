package org.apache.spark.sql.execution.datasources.noop;
/**
 * This is no-op datasource. It does not do anything besides consuming its input.
 * This can be useful for benchmarking or to cache data without any additional overhead.
 */
public  class NoopDataSource implements org.apache.spark.sql.internal.connector.SimpleTableProvider, org.apache.spark.sql.sources.DataSourceRegister {
  public   NoopDataSource ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
}
