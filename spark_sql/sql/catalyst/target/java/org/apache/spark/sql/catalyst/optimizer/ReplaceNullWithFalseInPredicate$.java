package org.apache.spark.sql.catalyst.optimizer;
/**
 * A rule that replaces <code>Literal(null, BooleanType)</code> with <code>FalseLiteral</code>, if possible, in the search
 * condition of the WHERE/HAVING/ON(JOIN) clauses, which contain an implicit Boolean operator
 * "(search condition) = TRUE". The replacement is only valid when <code>Literal(null, BooleanType)</code> is
 * semantically equivalent to <code>FalseLiteral</code> when evaluating the whole search condition.
 * <p>
 * Please note that FALSE and NULL are not exchangeable in most cases, when the search condition
 * contains NOT and NULL-tolerant expressions. Thus, the rule is very conservative and applicable
 * in very limited cases.
 * <p>
 * For example, <code>Filter(Literal(null, BooleanType))</code> is equal to <code>Filter(FalseLiteral)</code>.
 * <p>
 * Another example containing branches is <code>Filter(If(cond, FalseLiteral, Literal(null, _)))</code>;
 * this can be optimized to <code>Filter(If(cond, FalseLiteral, FalseLiteral))</code>, and eventually
 * <code>Filter(FalseLiteral)</code>.
 * <p>
 * Moreover, this rule also transforms predicates in all {@link If} expressions as well as branch
 * conditions in all {@link CaseWhen} expressions, even if they are not part of the search conditions.
 * <p>
 * For example, <code>Project(If(And(cond, Literal(null)), Literal(1), Literal(2)))</code> can be simplified
 * into <code>Project(Literal(2))</code>.
 */
public  class ReplaceNullWithFalseInPredicate$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReplaceNullWithFalseInPredicate$ MODULE$ = null;
  public   ReplaceNullWithFalseInPredicate$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
