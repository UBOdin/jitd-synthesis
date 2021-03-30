package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents all of the input attributes to a given relational operator, for example in
 * "SELECT * FROM ...".
 * <p>
 * This is also used to expand structs. For example:
 * "SELECT record.* from (SELECT struct(a,b,c) as record ...)
 * <p>
 * param:  target an optional name that should be the target of the expansion.  If omitted all
 *              targets' columns are produced. This can either be a table name or struct name. This
 *              is a list of identifiers that is the path of the expansion.
 */
public  class UnresolvedStar extends org.apache.spark.sql.catalyst.analysis.Star implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.Option<scala.collection.Seq<java.lang.String>> target ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedStar (scala.Option<scala.collection.Seq<java.lang.String>> target)  { throw new RuntimeException(); }
  public  boolean isQualifiedByTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan input, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan input, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
