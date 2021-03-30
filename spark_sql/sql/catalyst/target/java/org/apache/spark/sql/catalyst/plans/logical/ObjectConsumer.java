package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A trait for logical operators that consumes domain objects as input.
 * The output of its child must be a single-field row containing the input object.
 */
public  interface ObjectConsumer {
  public  org.apache.spark.sql.catalyst.expressions.Attribute inputObjAttr ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  ;
}
