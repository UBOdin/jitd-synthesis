package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces logical {@link Intersect} operator using a combination of Union, Aggregate
 * and Generate operator.
 * <p>
 * Input Query :
 * <pre><code>
 *    SELECT c1 FROM ut1 INTERSECT ALL SELECT c1 FROM ut2
 * </code></pre>
 * <p>
 * Rewritten Query:
 * <pre><code>
 *   SELECT c1
 *   FROM (
 *        SELECT replicate_row(min_count, c1)
 *        FROM (
 *             SELECT c1, If (vcol1_cnt &gt; vcol2_cnt, vcol2_cnt, vcol1_cnt) AS min_count
 *             FROM (
 *                  SELECT   c1, count(vcol1) as vcol1_cnt, count(vcol2) as vcol2_cnt
 *                  FROM (
 *                       SELECT true as vcol1, null as , c1 FROM ut1
 *                       UNION ALL
 *                       SELECT null as vcol1, true as vcol2, c1 FROM ut2
 *                       ) AS union_all
 *                  GROUP BY c1
 *                  HAVING vcol1_cnt &gt;= 1 AND vcol2_cnt &gt;= 1
 *                  )
 *             )
 *         )
 * </code></pre>
 */
public  class RewriteIntersectAll$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RewriteIntersectAll$ MODULE$ = null;
  public   RewriteIntersectAll$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
