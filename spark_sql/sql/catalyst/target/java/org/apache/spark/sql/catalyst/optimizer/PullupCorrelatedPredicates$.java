package org.apache.spark.sql.catalyst.optimizer;
/**
 * Pull out all (outer) correlated predicates from a given subquery. This method removes the
 * correlated predicates from subquery {@link Filter}s and adds the references of these predicates
 * to all intermediate {@link Project} and {@link Aggregate} clauses (if they are missing) in order to
 * be able to evaluate the predicates at the top level.
 * <p>
 * TODO: Look to merge this rule with RewritePredicateSubquery.
 */
public  class PullupCorrelatedPredicates$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PullupCorrelatedPredicates$ MODULE$ = null;
  public   PullupCorrelatedPredicates$ ()  { throw new RuntimeException(); }
  /**
   * Pull up the correlated predicates and rewrite all subqueries in an operator tree..
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
