package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents all of the input attributes to a given relational operator, for example in
 * "SELECT <code>(id)?+.+</code> FROM ...".
 * <p>
 * param:  table an optional table that should be the target of the expansion.  If omitted all
 *              tables' columns are produced.
 */
public  class UnresolvedRegex extends org.apache.spark.sql.catalyst.analysis.Star implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  java.lang.String regexPattern ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> table ()  { throw new RuntimeException(); }
  public  boolean caseSensitive ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedRegex (java.lang.String regexPattern, scala.Option<java.lang.String> table, boolean caseSensitive)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan input, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
