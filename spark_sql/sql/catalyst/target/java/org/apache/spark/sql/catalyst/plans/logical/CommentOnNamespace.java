package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan that defines or changes the comment of an NAMESPACE for v2 catalogs.
 * <p>
 * <pre><code>
 *   COMMENT ON (DATABASE|SCHEMA|NAMESPACE) namespaceIdentifier IS ('text' | NULL)
 * </code></pre>
 * <p>
 * where the <code>text</code> is the new comment written as a string literal; or <code>NULL</code> to drop the comment.
 * <p>
 */
public  class CommentOnNamespace extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  java.lang.String comment ()  { throw new RuntimeException(); }
  // not preceding
  public   CommentOnNamespace (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, java.lang.String comment)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
