package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A trait for logical operators that produces domain objects as output.
 * The output of this operator is a single-field safe row containing the produced object.
 */
public  interface ObjectProducer {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
}
