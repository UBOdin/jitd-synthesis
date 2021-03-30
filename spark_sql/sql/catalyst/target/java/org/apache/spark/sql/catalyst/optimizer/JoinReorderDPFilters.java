package org.apache.spark.sql.catalyst.optimizer;
/**
 * Implements optional filters to reduce the search space for join enumeration.
 * <p>
 * 1) Star-join filters: Plan star-joins together since they are assumed
 *    to have an optimal execution based on their RI relationship.
 * 2) Cartesian products: Defer their planning later in the graph to avoid
 *    large intermediate results (expanding joins, in general).
 * 3) Composite inners: Don't generate "bushy tree" plans to avoid materializing
 *   intermediate results.
 * <p>
 * Filters (2) and (3) are not implemented.
 */
public  class JoinReorderDPFilters {
  /**
   * Builds join graph information to be used by the filtering strategies.
   * Currently, it builds the sets of star/non-star joins.
   * It can be extended with the sets of connected/unconnected joins, which
   * can be used to filter Cartesian products.
   * @param conf (undocumented)
   * @param items (undocumented)
   * @param conditions (undocumented)
   * @param itemIndex (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.catalyst.optimizer.JoinGraphInfo> buildJoinGraphInfo (org.apache.spark.sql.internal.SQLConf conf, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> items, org.apache.spark.sql.catalyst.expressions.ExpressionSet conditions, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, java.lang.Object>> itemIndex)  { throw new RuntimeException(); }
  /**
   * Applies the star-join filter that eliminates join combinations among star
   * and non-star tables until the star join is built.
   * <p>
   * Given the oneSideJoinPlan/otherSideJoinPlan, which represent all the plan
   * permutations generated by the DP join enumeration, and the star/non-star plans,
   * the following plan combinations are allowed:
   * 1. (oneSideJoinPlan U otherSideJoinPlan) is a subset of star-join
   * 2. star-join is a subset of (oneSideJoinPlan U otherSideJoinPlan)
   * 3. (oneSideJoinPlan U otherSideJoinPlan) is a subset of non star-join
   * <p>
   * It assumes the sets are disjoint.
   * <p>
   * Example query graph:
   * <p>
   * t1   d1 - t2 - t3
   *  \  /
   *   f1
   *   |
   *   d2
   * <p>
   * star: {d1, f1, d2}
   * non-star: {t2, t1, t3}
   * <p>
   * level 0: (f1 ), (d2 ), (t3 ), (d1 ), (t1 ), (t2 )
   * level 1: {t3 t2 }, {f1 d2 }, {f1 d1 }
   * level 2: {d2 f1 d1 }
   * level 3: {t1 d1 f1 d2 }, {t2 d1 f1 d2 }
   * level 4: {d1 t2 f1 t1 d2 }, {d1 t3 t2 f1 d2 }
   * level 5: {d1 t3 t2 f1 t1 d2 }
   * <p>
   * @param oneSideJoinPlan One side of the join represented as a set of plan ids.
   * @param otherSideJoinPlan The other side of the join represented as a set of plan ids.
   * @param filters Star and non-star plans represented as sets of plan ids
   * @return (undocumented)
   */
  static public  boolean starJoinFilter (scala.collection.immutable.Set<java.lang.Object> oneSideJoinPlan, scala.collection.immutable.Set<java.lang.Object> otherSideJoinPlan, org.apache.spark.sql.catalyst.optimizer.JoinGraphInfo filters)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (org.apache.spark.sql.catalyst.plans.logical.Project plan)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (org.apache.spark.sql.catalyst.plans.logical.Aggregate plan)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> exprs)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression replaceAlias (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> aliasMap)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.NamedExpression replaceAliasButKeepName (org.apache.spark.sql.catalyst.expressions.NamedExpression expr, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> aliasMap)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression trimAliases (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static protected <T extends org.apache.spark.sql.catalyst.expressions.Expression> T trimNonTopLevelAliases (T e)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitConjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> findExpressionAndTrackLineageDown (org.apache.spark.sql.catalyst.expressions.Expression exp, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitDisjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression buildBalancedPredicate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> op)  { throw new RuntimeException(); }
  static protected  boolean canEvaluate (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  boolean canEvaluateWithinJoin (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static protected  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> extractPredicatesWithinOutputSet (org.apache.spark.sql.catalyst.expressions.Expression condition, org.apache.spark.sql.catalyst.expressions.AttributeSet outputSet)  { throw new RuntimeException(); }
  static protected  boolean isNullIntolerant (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputWithNullability (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.ExprId> nonNullAttrExprIds)  { throw new RuntimeException(); }
}
