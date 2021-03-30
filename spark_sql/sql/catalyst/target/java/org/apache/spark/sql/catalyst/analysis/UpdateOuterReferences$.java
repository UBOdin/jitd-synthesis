package org.apache.spark.sql.catalyst.analysis;
/**
 * The aggregate expressions from subquery referencing outer query block are pushed
 * down to the outer query block for evaluation. This rule below updates such outer references
 * as AttributeReference referring attributes from the parent/outer query block.
 * <p>
 * For example (SQL):
 * <pre><code>
 *   SELECT l.a FROM l GROUP BY 1 HAVING EXISTS (SELECT 1 FROM r WHERE r.d &lt; min(l.b))
 * </code></pre>
 * Plan before the rule.
 *    Project [a#226]
 *    +- Filter exists#245 [min(b#227)#249]
 *       :  +- Project [1 AS 1#247]
 *       :     +- Filter (d#238 < min(outer(b#227)))       <-----
 *       :        +- SubqueryAlias r
 *       :           +- Project [_1#234 AS c#237, _2#235 AS d#238]
 *       :              +- LocalRelation [_1#234, _2#235]
 *       +- Aggregate [a#226], [a#226, min(b#227) AS min(b#227)#249]
 *          +- SubqueryAlias l
 *             +- Project [_1#223 AS a#226, _2#224 AS b#227]
 *                +- LocalRelation [_1#223, _2#224]
 * Plan after the rule.
 *    Project [a#226]
 *    +- Filter exists#245 [min(b#227)#249]
 *       :  +- Project [1 AS 1#247]
 *       :     +- Filter (d#238 < outer(min(b#227)#249))   <-----
 *       :        +- SubqueryAlias r
 *       :           +- Project [_1#234 AS c#237, _2#235 AS d#238]
 *       :              +- LocalRelation [_1#234, _2#235]
 *       +- Aggregate [a#226], [a#226, min(b#227) AS min(b#227)#249]
 *          +- SubqueryAlias l
 *             +- Project [_1#223 AS a#226, _2#224 AS b#227]
 *                +- LocalRelation [_1#223, _2#224]
 */
public  class UpdateOuterReferences$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UpdateOuterReferences$ MODULE$ = null;
  public   UpdateOuterReferences$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
