package org.apache.spark.sql.execution.aggregate;
/**
 * Utility functions used by the query planner to convert our plan to new aggregation code path.
 */
public  class AggUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AggUtils$ MODULE$ = null;
  public   AggUtils$ ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> planAggregateWithoutDistinct (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> planAggregateWithOneDistinct (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> functionsWithDistinct, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> functionsWithoutDistinct, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> distinctExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> normalizedNamedDistinctExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  /**
   * Plans a streaming aggregation using the following progression:
   *  - Partial Aggregation
   *  - Shuffle
   *  - Partial Merge (now there is at most 1 tuple per group)
   *  - StateStoreRestore (now there is 1 tuple from this batch + optionally one from the previous)
   *  - PartialMerge (now there is at most 1 tuple per group)
   *  - StateStoreSave (saves the tuple for the next batch)
   *  - Complete (output the current result of the aggregation)
   * @param groupingExpressions (undocumented)
   * @param functionsWithoutDistinct (undocumented)
   * @param resultExpressions (undocumented)
   * @param stateFormatVersion (undocumented)
   * @param child (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> planStreamingAggregation (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> functionsWithoutDistinct, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, int stateFormatVersion, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
}
