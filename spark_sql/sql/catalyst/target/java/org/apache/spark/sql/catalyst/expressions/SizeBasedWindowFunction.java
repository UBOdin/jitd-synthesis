package org.apache.spark.sql.catalyst.expressions;
/**
 * A {@link SizeBasedWindowFunction} needs the size of the current window for its calculation.
 */
public  interface SizeBasedWindowFunction {
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference n ()  ;
}
