package org.apache.spark.sql.catalyst.expressions;
/**
 * Common trait for {@link GetArrayItem} and {@link ElementAt}.
 */
public  interface GetArrayItemUtil {
  /** `Null` is returned for invalid ordinals. */
  public  boolean computeNullabilityFromArray (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression ordinal, boolean failOnError, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, java.lang.Object, java.lang.Object> nullability)  ;
}
