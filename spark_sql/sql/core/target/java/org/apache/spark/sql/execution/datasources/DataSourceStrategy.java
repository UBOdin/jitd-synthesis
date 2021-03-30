package org.apache.spark.sql.execution.datasources;
/**
 * A Strategy for planning scans over data sources defined using the sources API.
 */
public  class DataSourceStrategy {
  static public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * The attribute name may differ from the one in the schema if the query analyzer
   * is case insensitive. We should change attribute names to match the ones in the schema,
   * so we do not need to worry about case sensitivity anymore.
   * @param exprs (undocumented)
   * @param attributes (undocumented)
   * @return (undocumented)
   */
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> normalizeExprs (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> attributes)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.ExpressionSet getPushedDownFilters (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> normalizedFilters)  { throw new RuntimeException(); }
  /**
   * Tries to translate a Catalyst {@link Expression} into data source {@link Filter}.
   * <p>
   * @return a <code>Some[Filter]</code> if the input {@link Expression} is convertible, otherwise a <code>None</code>.
   * @param predicate (undocumented)
   * @param supportNestedPredicatePushdown (undocumented)
   */
  static protected  scala.Option<org.apache.spark.sql.sources.Filter> translateFilter (org.apache.spark.sql.catalyst.expressions.Expression predicate, boolean supportNestedPredicatePushdown)  { throw new RuntimeException(); }
  /**
   * Tries to translate a Catalyst {@link Expression} into data source {@link Filter}.
   * <p>
   * @param predicate The input {@link Expression} to be translated as {@link Filter}
   * @param translatedFilterToExpr An optional map from leaf node filter expressions to its
   *                               translated {@link Filter}. The map is used for rebuilding
   *                               {@link Expression} from {@link Filter}.
   * @param nestedPredicatePushdownEnabled Whether nested predicate pushdown is enabled.
   * @return a <code>Some[Filter]</code> if the input {@link Expression} is convertible, otherwise a <code>None</code>.
   */
  static protected  scala.Option<org.apache.spark.sql.sources.Filter> translateFilterWithMapping (org.apache.spark.sql.catalyst.expressions.Expression predicate, scala.Option<scala.collection.mutable.HashMap<org.apache.spark.sql.sources.Filter, org.apache.spark.sql.catalyst.expressions.Expression>> translatedFilterToExpr, boolean nestedPredicatePushdownEnabled)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression rebuildExpressionFromFilter (org.apache.spark.sql.sources.Filter filter, scala.collection.mutable.HashMap<org.apache.spark.sql.sources.Filter, org.apache.spark.sql.catalyst.expressions.Expression> translatedFilterToExpr)  { throw new RuntimeException(); }
  /**
   * Selects Catalyst predicate {@link Expression}s which are convertible into data source {@link Filter}s
   * and can be handled by <code>relation</code>.
   * <p>
   * @return A triplet of <code>Seq[Expression]</code>, <code>Seq[Filter]</code>, and <code>Seq[Filter]</code> . The first element
   *         contains all Catalyst predicate {@link Expression}s that are either not convertible or
   *         cannot be handled by <code>relation</code>. The second element contains all converted data source
   *         {@link Filter}s that will be pushed down to the data source. The third element contains
   *         all {@link Filter}s that are completely filtered at the DataSource.
   * @param relation (undocumented)
   * @param predicates (undocumented)
   */
  static protected  scala.Tuple3<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.sources.Filter>, scala.collection.immutable.Set<org.apache.spark.sql.sources.Filter>> selectFilters (org.apache.spark.sql.sources.BaseRelation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates)  { throw new RuntimeException(); }
  /**
   * Convert RDD of Row into RDD of InternalRow with objects in catalyst types
   * @param relation (undocumented)
   * @param output (undocumented)
   * @param rdd (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> toCatalystRDD (org.apache.spark.sql.sources.BaseRelation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> rdd)  { throw new RuntimeException(); }
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
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.execution.SparkPlan planLater (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Cast cast (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (org.apache.spark.sql.catalyst.plans.logical.Project plan)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (org.apache.spark.sql.catalyst.plans.logical.Aggregate plan)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> getAliasMap (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> exprs)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression replaceAlias (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> aliasMap)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.NamedExpression replaceAliasButKeepName (org.apache.spark.sql.catalyst.expressions.NamedExpression expr, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Alias> aliasMap)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression trimAliases (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static protected <T extends org.apache.spark.sql.catalyst.expressions.Expression> T trimNonTopLevelAliases (T e)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitConjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> findExpressionAndTrackLineageDown (org.apache.spark.sql.catalyst.expressions.Expression exp, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitDisjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression buildBalancedPredicate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> op)  { throw new RuntimeException(); }
  static protected  boolean canEvaluate (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  boolean canEvaluateWithinJoin (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static protected  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> extractPredicatesWithinOutputSet (org.apache.spark.sql.catalyst.expressions.Expression condition, org.apache.spark.sql.catalyst.expressions.AttributeSet outputSet)  { throw new RuntimeException(); }
  static protected  boolean isNullIntolerant (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputWithNullability (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.ExprId> nonNullAttrExprIds)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
}
