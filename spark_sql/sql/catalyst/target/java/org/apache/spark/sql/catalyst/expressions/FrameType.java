package org.apache.spark.sql.catalyst.expressions;
/**
 * The trait used to represent the type of a Window Frame.
 */
public  interface FrameType {
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  ;
  public  java.lang.String sql ()  ;
}
