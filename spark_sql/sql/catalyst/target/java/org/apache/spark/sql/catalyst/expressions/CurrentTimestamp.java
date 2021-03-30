package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns the current timestamp at the start of query evaluation.
 * There is no code generation since this expression should get constant folded by the optimizer.
 */
public  class CurrentTimestamp extends org.apache.spark.sql.catalyst.expressions.CurrentTimestampLike implements scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public   CurrentTimestamp ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
