package org.apache.spark.sql.catalyst.optimizer;
/**
 * A rule that converts conditional expressions to predicate expressions, if possible, in the
 * search condition of the WHERE/HAVING/ON(JOIN) clauses, which contain an implicit Boolean operator
 * "(search condition) = TRUE". After this converting, we can potentially push the filter down to
 * the data source.
 * <p>
 * Supported cases are:
 * - IF(cond, trueVal, false)                   =&gt; AND(cond, trueVal)
 * - IF(cond, trueVal, true)                    =&gt; OR(NOT(cond), trueVal)
 * - IF(cond, false, falseVal)                  =&gt; AND(NOT(cond), elseVal)
 * - IF(cond, true, falseVal)                   =&gt; OR(cond, elseVal)
 * - CASE WHEN cond THEN trueVal ELSE false END =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal END            =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal ELSE null END  =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal ELSE true END  =&gt; OR(NOT(cond), trueVal)
 * - CASE WHEN cond THEN false ELSE elseVal END =&gt; AND(NOT(cond), elseVal)
 * - CASE WHEN cond THEN true ELSE elseVal END  =&gt; OR(cond, elseVal)
 */
public  class SimplifyConditionalsInPredicate$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SimplifyConditionalsInPredicate$ MODULE$ = null;
  public   SimplifyConditionalsInPredicate$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
