package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Java cannot access Projection (in package object)
 */
public abstract class BaseProjection extends org.apache.spark.sql.catalyst.expressions.Projection {
  public   BaseProjection ()  { throw new RuntimeException(); }
}
