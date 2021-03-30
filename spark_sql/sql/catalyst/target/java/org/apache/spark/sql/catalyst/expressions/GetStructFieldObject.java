package org.apache.spark.sql.catalyst.expressions;
/**
 * A Scala extractor that extracts the child expression and struct field from a {@link GetStructField}.
 * This is in contrast to the {@link GetStructField} case class extractor which returns the field
 * ordinal instead of the field itself.
 */
public  class GetStructFieldObject {
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.types.StructField>> unapply (org.apache.spark.sql.catalyst.expressions.GetStructField getStructField)  { throw new RuntimeException(); }
}
