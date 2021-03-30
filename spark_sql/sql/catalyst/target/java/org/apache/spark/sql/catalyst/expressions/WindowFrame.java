package org.apache.spark.sql.catalyst.expressions;
/**
 * Represents a window frame.
 */
public  interface WindowFrame extends org.apache.spark.sql.catalyst.expressions.Unevaluable {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  ;
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  public  boolean nullable ()  ;
}
