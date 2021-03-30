package org.apache.spark.sql.catalyst.expressions;
public  interface PredicateHelper extends org.apache.spark.sql.catalyst.expressions.AliasHelper, org.apache.spark.internal.Logging {
  /**
   * Builds a balanced output predicate in bottom up approach, by applying binary operator op
   * pair by pair on input predicates exprs recursively.
   * Example:  exprs = [a, b, c, d], op = And, returns (a And b) And (c And d)
   * exprs = [a, b, c, d, e, f], op = And, returns ((a And b) And (c And d)) And (e And f)
   * @param expressions (undocumented)
   * @param op (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression buildBalancedPredicate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> op)  ;
  /**
   * Returns true if <code>expr</code> can be evaluated using only the output of <code>plan</code>.  This method
   * can be used to determine when it is acceptable to move expression evaluation within a query
   * plan.
   * <p>
   * For example consider a join between two relations R(a, b) and S(c, d).
   * <p>
   * - <code>canEvaluate(EqualTo(a,b), R)</code> returns <code>true</code>
   * - <code>canEvaluate(EqualTo(a,c), R)</code> returns <code>false</code>
   * - <code>canEvaluate(Literal(1), R)</code> returns <code>true</code> as literals CAN be evaluated on any plan
   * @param expr (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  boolean canEvaluate (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  /**
   * Returns true iff <code>expr</code> could be evaluated as a condition within join.
   * @param expr (undocumented)
   * @return (undocumented)
   */
  public  boolean canEvaluateWithinJoin (org.apache.spark.sql.catalyst.expressions.Expression expr)  ;
  /**
   * Returns a filter that its reference is a subset of <code>outputSet</code> and it contains the maximum
   * constraints from <code>condition</code>. This is used for predicate pushdown.
   * When there is no such filter, <code>None</code> is returned.
   * @param condition (undocumented)
   * @param outputSet (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> extractPredicatesWithinOutputSet (org.apache.spark.sql.catalyst.expressions.Expression condition, org.apache.spark.sql.catalyst.expressions.AttributeSet outputSet)  ;
  /**
   * Find the origin of where the input references of expression exp were scanned in the tree of
   * plan, and if they originate from a single leaf node.
   * Returns optional tuple with Expression, undoing any projections and aliasing that has been done
   * along the way from plan to origin, and the origin LeafNode plan from which all the exp
   * @param exp (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> findExpressionAndTrackLineageDown (org.apache.spark.sql.catalyst.expressions.Expression exp, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  public  boolean isNullIntolerant (org.apache.spark.sql.catalyst.expressions.Expression expr)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputWithNullability (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.ExprId> nonNullAttrExprIds)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitConjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitDisjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  ;
}
