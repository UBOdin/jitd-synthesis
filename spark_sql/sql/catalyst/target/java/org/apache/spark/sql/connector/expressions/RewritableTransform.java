package org.apache.spark.sql.connector.expressions;
/**
 * Allows Spark to rewrite the given references of the transform during analysis.
 */
public  interface RewritableTransform extends org.apache.spark.sql.connector.expressions.Transform {
  /** Creates a copy of this transform with the new analyzed references. */
  public  org.apache.spark.sql.connector.expressions.Transform withReferences (scala.collection.Seq<org.apache.spark.sql.connector.expressions.NamedReference> newReferences)  ;
}
