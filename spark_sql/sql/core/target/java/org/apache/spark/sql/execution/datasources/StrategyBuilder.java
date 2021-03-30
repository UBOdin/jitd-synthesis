package org.apache.spark.sql.execution.datasources;
public  interface StrategyBuilder {
  public  scala.Option<org.apache.spark.sql.execution.datasources.PathFilterStrategy> create (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  ;
}
