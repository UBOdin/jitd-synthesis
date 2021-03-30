package org.apache.spark.sql.execution.streaming.state;
/**
 * Name and description of custom implementation-specific metrics that a
 * state store may wish to expose.
 */
public  interface StateStoreCustomMetric {
  public  java.lang.String desc ()  ;
  public  java.lang.String name ()  ;
}
