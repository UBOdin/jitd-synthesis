package org.apache.spark.sql.execution.datasources.v2;
/** Some helper interfaces that use V2 write semantics through the V1 writer interface. */
public  interface V1FallbackWriters extends org.apache.spark.sql.execution.datasources.v2.SupportsV1Write {
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  ;
  public  org.apache.spark.sql.connector.catalog.SupportsWrite table ()  ;
  public  org.apache.spark.sql.connector.write.V1Write write ()  ;
}
