package org.apache.spark.sql.execution.aggregate;
/**
 * A helper class to hook {@link Aggregator} into the aggregation system.
 */
public  interface TypedAggregateExpression {
  public  org.apache.spark.sql.expressions.Aggregator<java.lang.Object, java.lang.Object, java.lang.Object> aggregator ()  ;
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> inputDeserializer ()  ;
  public  scala.Option<java.lang.Class<?>> inputClass ()  ;
  public  scala.Option<org.apache.spark.sql.types.StructType> inputSchema ()  ;
  public  org.apache.spark.sql.execution.aggregate.TypedAggregateExpression withInputInfo (org.apache.spark.sql.catalyst.expressions.Expression deser, java.lang.Class<?> cls, org.apache.spark.sql.types.StructType schema)  ;
  public  java.lang.String toString ()  ;
  public  java.lang.String nodeName ()  ;
}
