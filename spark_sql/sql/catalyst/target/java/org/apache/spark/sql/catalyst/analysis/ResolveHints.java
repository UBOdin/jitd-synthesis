package org.apache.spark.sql.catalyst.analysis;
/**
 * Collection of rules related to hints. The only hint currently available is join strategy hint.
 * <p>
 * Note that this is separately into two rules because in the future we might introduce new hint
 * rules that have different ordering requirements from join strategies.
 */
public  class ResolveHints {
  /**
   * The list of allowed join strategy hints is defined in {@link JoinStrategyHint.strategies}, and a
   * sequence of relation aliases can be specified with a join strategy hint, e.g., "MERGE(a, c)",
   * "BROADCAST(a)". A join strategy hint plan node will be inserted on top of any relation (that
   * is not aliased differently), subquery, or common table expression that match the specified
   * name.
   * <p>
   * The hint resolution works by recursively traversing down the query plan to find a relation or
   * subquery that matches one of the specified relation aliases. The traversal does not go past
   * beyond any view reference, with clause or subquery alias.
   * <p>
   * This rule must happen before common table expressions.
   */
  static public  class ResolveJoinStrategyHints$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ResolveJoinStrategyHints$ MODULE$ = null;
    public   ResolveJoinStrategyHints$ ()  { throw new RuntimeException(); }
    public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * COALESCE Hint accepts names "COALESCE", "REPARTITION", and "REPARTITION_BY_RANGE".
   */
  static public  class ResolveCoalesceHints$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ResolveCoalesceHints$ MODULE$ = null;
    public   ResolveCoalesceHints$ ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Set<java.lang.String> COALESCE_HINT_NAMES ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * Removes all the hints, used to remove invalid hints provided by the user.
   * This must be executed after all the other hint rules are executed.
   */
  static public  class RemoveAllHints extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    public   RemoveAllHints ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * Removes all the hints when <code>spark.sql.optimizer.disableHints</code> is set.
   * This is executed at the very beginning of the Analyzer to disable
   * the hint functionality.
   */
  static public  class DisableHints extends org.apache.spark.sql.catalyst.analysis.ResolveHints.RemoveAllHints {
    public   DisableHints ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
}
