package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces logical {@link Except} operator using a combination of Union, Aggregate
 * and Generate operator.
 * <p>
 * Input Query :
 * <pre><code>
 *    SELECT c1 FROM ut1 EXCEPT ALL SELECT c1 FROM ut2
 * </code></pre>
 * <p>
 * Rewritten Query:
 * <pre><code>
 *   SELECT c1
 *   FROM (
 *     SELECT replicate_rows(sum_val, c1)
 *       FROM (
 *         SELECT c1, sum_val
 *           FROM (
 *             SELECT c1, sum(vcol) AS sum_val
 *               FROM (
 *                 SELECT 1L as vcol, c1 FROM ut1
 *                 UNION ALL
 *                 SELECT -1L as vcol, c1 FROM ut2
 *              ) AS union_all
 *            GROUP BY union_all.c1
 *          )
 *        WHERE sum_val &gt; 0
 *       )
 *   )
 * </code></pre>
 */
public  class RewriteExceptAll$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RewriteExceptAll$ MODULE$ = null;
  public   RewriteExceptAll$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
