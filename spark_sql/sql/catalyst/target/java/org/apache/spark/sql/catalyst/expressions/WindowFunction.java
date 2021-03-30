package org.apache.spark.sql.catalyst.expressions;
/**
 * A window function is a function that can only be evaluated in the context of a window operator.
 */
public  interface WindowFunction {
  /** Frame in which the window operator must be executed. */
  public  org.apache.spark.sql.catalyst.expressions.WindowFrame frame ()  ;
}
