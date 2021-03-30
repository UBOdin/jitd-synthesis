package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule rewrites an aggregate query with distinct aggregations into an expanded double
 * aggregation in which the regular aggregation expressions and every distinct clause is aggregated
 * in a separate group. The results are then combined in a second aggregate.
 * <p>
 * First example: query without filter clauses (in scala):
 * <pre><code>
 *   val data = Seq(
 *     ("a", "ca1", "cb1", 10),
 *     ("a", "ca1", "cb2", 5),
 *     ("b", "ca1", "cb1", 13))
 *     .toDF("key", "cat1", "cat2", "value")
 *   data.createOrReplaceTempView("data")
 *
 *   val agg = data.groupBy($"key")
 *     .agg(
 *       count_distinct($"cat1").as("cat1_cnt"),
 *       count_distinct($"cat2").as("cat2_cnt"),
 *       sum($"value").as("total"))
 * </code></pre>
 * <p>
 * This translates to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [COUNT(DISTINCT 'cat1),
 *                 COUNT(DISTINCT 'cat2),
 *                 sum('value)]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   LocalTableScan [...]
 * </code></pre>
 * <p>
 * This rule rewrites this logical plan to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [count(if (('gid = 1)) 'cat1 else null),
 *                 count(if (('gid = 2)) 'cat2 else null),
 *                 first(if (('gid = 0)) 'total else null) ignore nulls]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   Aggregate(
 *      key = ['key, 'cat1, 'cat2, 'gid]
 *      functions = [sum('value)]
 *      output = ['key, 'cat1, 'cat2, 'gid, 'total])
 *     Expand(
 *        projections = [('key, null, null, 0, cast('value as bigint)),
 *                       ('key, 'cat1, null, 1, null),
 *                       ('key, null, 'cat2, 2, null)]
 *        output = ['key, 'cat1, 'cat2, 'gid, 'value])
 *       LocalTableScan [...]
 * </code></pre>
 * <p>
 * Second example: aggregate function without distinct and with filter clauses (in sql):
 * <pre><code>
 *   SELECT
 *     COUNT(DISTINCT cat1) as cat1_cnt,
 *     COUNT(DISTINCT cat2) as cat2_cnt,
 *     SUM(value) FILTER (WHERE id &gt; 1) AS total
 *   FROM
 *     data
 *   GROUP BY
 *     key
 * </code></pre>
 * <p>
 * This translates to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [COUNT(DISTINCT 'cat1),
 *                 COUNT(DISTINCT 'cat2),
 *                 sum('value) FILTER (WHERE 'id &gt; 1)]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   LocalTableScan [...]
 * </code></pre>
 * <p>
 * This rule rewrites this logical plan to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [count(if (('gid = 1)) 'cat1 else null),
 *                 count(if (('gid = 2)) 'cat2 else null),
 *                 first(if (('gid = 0)) 'total else null) ignore nulls]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   Aggregate(
 *      key = ['key, 'cat1, 'cat2, 'gid]
 *      functions = [sum('value) FILTER (WHERE 'id &gt; 1)]
 *      output = ['key, 'cat1, 'cat2, 'gid, 'total])
 *     Expand(
 *        projections = [('key, null, null, 0, cast('value as bigint), 'id),
 *                       ('key, 'cat1, null, 1, null, null),
 *                       ('key, null, 'cat2, 2, null, null)]
 *        output = ['key, 'cat1, 'cat2, 'gid, 'value, 'id])
 *       LocalTableScan [...]
 * </code></pre>
 * <p>
 * Third example: aggregate function with distinct and filter clauses (in sql):
 * <pre><code>
 *   SELECT
 *     COUNT(DISTINCT cat1) FILTER (WHERE id &gt; 1) as cat1_cnt,
 *     COUNT(DISTINCT cat2) FILTER (WHERE id &gt; 2) as cat2_cnt,
 *     SUM(value) FILTER (WHERE id &gt; 3) AS total
 *   FROM
 *     data
 *   GROUP BY
 *     key
 * </code></pre>
 * <p>
 * This translates to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [COUNT(DISTINCT 'cat1) FILTER (WHERE 'id &gt; 1),
 *                 COUNT(DISTINCT 'cat2) FILTER (WHERE 'id &gt; 2),
 *                 sum('value) FILTER (WHERE 'id &gt; 3)]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   LocalTableScan [...]
 * </code></pre>
 * <p>
 * This rule rewrites this logical plan to the following (pseudo) logical plan:
 * <pre><code>
 * Aggregate(
 *    key = ['key]
 *    functions = [count(if (('gid = 1) and 'max_cond1) 'cat1 else null),
 *                 count(if (('gid = 2) and 'max_cond2) 'cat2 else null),
 *                 first(if (('gid = 0)) 'total else null) ignore nulls]
 *    output = ['key, 'cat1_cnt, 'cat2_cnt, 'total])
 *   Aggregate(
 *      key = ['key, 'cat1, 'cat2, 'gid]
 *      functions = [max('cond1), max('cond2), sum('value) FILTER (WHERE 'id &gt; 3)]
 *      output = ['key, 'cat1, 'cat2, 'gid, 'max_cond1, 'max_cond2, 'total])
 *     Expand(
 *        projections = [('key, null, null, 0, null, null, cast('value as bigint), 'id),
 *                       ('key, 'cat1, null, 1, 'id &gt; 1, null, null, null),
 *                       ('key, null, 'cat2, 2, null, 'id &gt; 2, null, null)]
 *        output = ['key, 'cat1, 'cat2, 'gid, 'cond1, 'cond2, 'value, 'id])
 *       LocalTableScan [...]
 * </code></pre>
 * <p>
 * The rule does the following things here:
 * 1. Expand the data. There are three aggregation groups in this query:
 *    i. the non-distinct group;
 *    ii. the distinct 'cat1 group;
 *    iii. the distinct 'cat2 group.
 *    An expand operator is inserted to expand the child data for each group. The expand will null
 *    out all unused columns for the given group; this must be done in order to ensure correctness
 *    later on. Groups can by identified by a group id (gid) column added by the expand operator.
 *    If distinct group exists filter clause, the expand will calculate the filter and output it's
 *    result (e.g. cond1) which will be used to calculate the global conditions (e.g. max_cond1)
 *    equivalent to filter clauses.
 * 2. De-duplicate the distinct paths and aggregate the non-aggregate path. The group by clause of
 *    this aggregate consists of the original group by clause, all the requested distinct columns
 *    and the group id. Both de-duplication of distinct column and the aggregation of the
 *    non-distinct group take advantage of the fact that we group by the group id (gid) and that we
 *    have nulled out all non-relevant columns the given group. If distinct group exists filter
 *    clause, we will use max to aggregate the results (e.g. cond1) of the filter output in the
 *    previous step. These aggregate will output the global conditions (e.g. max_cond1) equivalent
 *    to filter clauses.
 * 3. Aggregating the distinct groups and combining this with the results of the non-distinct
 *    aggregation. In this step we use the group id and the global condition to filter the inputs
 *    for the aggregate functions. If the global condition (e.g. max_cond1) is true, it means at
 *    least one row of a distinct value satisfies the filter. This distinct value should be included
 *    in the aggregate function. The result of the non-distinct group are 'aggregated' by using
 *    the first operator, it might be more elegant to use the native UDAF merge mechanism for this
 *    in the future.
 * <p>
 * This rule duplicates the input data by two or more times (# distinct groups + an optional
 * non-distinct group). This will put quite a bit of memory pressure of the used aggregate and
 * exchange operators. Keeping the number of distinct groups as low as possible should be priority,
 * we could improve this in the current rule by applying more advanced expression canonicalization
 * techniques.
 */
public  class RewriteDistinctAggregates$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RewriteDistinctAggregates$ MODULE$ = null;
  public   RewriteDistinctAggregates$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Aggregate rewrite (org.apache.spark.sql.catalyst.plans.logical.Aggregate a)  { throw new RuntimeException(); }
}
