package org.apache.spark.sql.catalyst.expressions;
/**
 * The trait used to represent special boundaries used in a window frame.
 */
public  interface SpecialFrameBoundary extends org.apache.spark.sql.catalyst.expressions.Unevaluable {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  ;
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  public  boolean nullable ()  ;
}
