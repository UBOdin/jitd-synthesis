package org.apache.spark.sql.catalyst.analysis;
/**
 * Aliased column names resolved by positions for subquery. We could add alias names for output
 * columns in the subquery:
 * <pre><code>
 *   // Assign alias names for output columns
 *   SELECT col1, col2 FROM testData AS t(col1, col2);
 * </code></pre>
 * <p>
 * param:  outputColumnNames the {@link LogicalPlan} on which this subquery column aliases apply.
 * param:  child the logical plan of this subquery.
 */
public  class UnresolvedSubqueryColumnAliases extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedSubqueryColumnAliases (scala.collection.Seq<java.lang.String> outputColumnNames, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
