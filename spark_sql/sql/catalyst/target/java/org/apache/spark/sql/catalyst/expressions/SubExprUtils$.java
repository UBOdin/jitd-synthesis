package org.apache.spark.sql.catalyst.expressions;
public  class SubExprUtils$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SubExprUtils$ MODULE$ = null;
  public   SubExprUtils$ ()  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains correlated predicates i.e outer references and
   * returns false otherwise.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  boolean containsOuter (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns an expression after removing the OuterReference shell.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression stripOuterReference (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns the list of expressions after removing the OuterReference shell from each of
   * the expression.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> stripOuterReferences (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> e)  { throw new RuntimeException(); }
  /**
   * Returns the logical plan after removing the OuterReference shell from all the expressions
   * of the input logical plan.
   * @param p (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan stripOuterReferences (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan p)  { throw new RuntimeException(); }
  /**
   * Given a logical plan, returns TRUE if it has an outer reference and false otherwise.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  boolean hasOuterReferences (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Given a list of expressions, returns the expressions which have outer references. Aggregate
   * expressions are treated in a special way. If the children of aggregate expression contains an
   * outer reference, then the entire aggregate expression is marked as an outer reference.
   * Example (SQL):
   * <pre><code>
   *   SELECT a FROM l GROUP by 1 HAVING EXISTS (SELECT 1 FROM r WHERE d &lt; min(b))
   * </code></pre>
   * In the above case, we want to mark the entire min(b) as an outer reference
   * OuterReference(min(b)) instead of min(OuterReference(b)).
   * TODO: Currently we don't allow deep correlation. Also, we don't allow mixing of
   * outer references and local references under an aggregate expression.
   * For example (SQL):
   * <pre><code>
   *   SELECT .. FROM p1
   *   WHERE EXISTS (SELECT ...
   *                 FROM p2
   *                 WHERE EXISTS (SELECT ...
   *                               FROM sq
   *                               WHERE min(p1.a + p2.b) = sq.c))
   *
   *   SELECT .. FROM p1
   *   WHERE EXISTS (SELECT ...
   *                 FROM p2
   *                 WHERE EXISTS (SELECT ...
   *                               FROM sq
   *                               WHERE min(p1.a) + max(p2.b) = sq.c))
   *
   *   SELECT .. FROM p1
   *   WHERE EXISTS (SELECT ...
   *                 FROM p2
   *                 WHERE EXISTS (SELECT ...
   *                               FROM sq
   *                               WHERE min(p1.a + sq.c) &gt; 1))
   * </code></pre>
   * The code below needs to change when we support the above cases.
   * @param conditions (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> getOuterReferences (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> conditions)  { throw new RuntimeException(); }
  /**
   * Returns all the expressions that have outer references from a logical plan. Currently only
   * Filter operator can host outer references.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> getOuterReferences (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Returns the correlated predicates from a logical plan. The OuterReference wrapper
   * is removed before returning the predicate to the caller.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> getCorrelatedPredicates (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
