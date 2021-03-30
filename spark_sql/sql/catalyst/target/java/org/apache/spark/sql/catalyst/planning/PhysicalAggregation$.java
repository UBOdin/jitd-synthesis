package org.apache.spark.sql.catalyst.planning;
/**
 * An extractor used when planning the physical execution of an aggregation. Compared with a logical
 * aggregation, the following transformations are performed:
 *  - Unnamed grouping expressions are named so that they can be referred to across phases of
 *    aggregation
 *  - Aggregations that appear multiple times are deduplicated.
 *  - The computation of the aggregations themselves is separated from the final result. For
 *    example, the <code>count</code> in <code>count + 1</code> will be split into an {@link AggregateExpression} and a final
 *    computation that computes <code>count.resultAttribute + 1</code>.
 */
public  class PhysicalAggregation$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PhysicalAggregation$ MODULE$ = null;
  public   PhysicalAggregation$ ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple4<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> unapply (Object a)  { throw new RuntimeException(); }
}
