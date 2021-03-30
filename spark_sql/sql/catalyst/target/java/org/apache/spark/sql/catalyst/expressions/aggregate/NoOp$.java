package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * A place holder expressions used in code-gen, it does not change the corresponding value
 * in the row.
 */
public  class NoOp$ extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoOp$ MODULE$ = null;
  public   NoOp$ ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
}
