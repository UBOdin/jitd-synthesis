package org.apache.spark.sql.connector.expressions;
/**
 * Base class for simple transforms of a single column.
 */
 abstract class SingleColumnTransform implements org.apache.spark.sql.connector.expressions.RewritableTransform {
  public   SingleColumnTransform (org.apache.spark.sql.connector.expressions.NamedReference ref)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Expression[] arguments ()  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NamedReference reference ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NamedReference[] references ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected abstract  org.apache.spark.sql.connector.expressions.Transform withNewRef (org.apache.spark.sql.connector.expressions.NamedReference ref)  ;
  public  org.apache.spark.sql.connector.expressions.Transform withReferences (scala.collection.Seq<org.apache.spark.sql.connector.expressions.NamedReference> newReferences)  { throw new RuntimeException(); }
}
