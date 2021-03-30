package org.apache.spark.sql.connector.expressions;
/**
 * Convenience extractor for any Literal.
 */
public  class Lit {
  static public <T extends java.lang.Object> scala.Some<scala.Tuple2<T, org.apache.spark.sql.types.DataType>> unapply (org.apache.spark.sql.connector.expressions.Literal<T> literal)  { throw new RuntimeException(); }
}
