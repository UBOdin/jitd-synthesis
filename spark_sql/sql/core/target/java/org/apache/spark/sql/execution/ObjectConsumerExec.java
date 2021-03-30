package org.apache.spark.sql.execution;
/**
 * Physical version of <code>ObjectConsumer</code>.
 */
public  interface ObjectConsumerExec extends org.apache.spark.sql.execution.UnaryExecNode {
  public  org.apache.spark.sql.types.DataType inputObjectType ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  ;
}
