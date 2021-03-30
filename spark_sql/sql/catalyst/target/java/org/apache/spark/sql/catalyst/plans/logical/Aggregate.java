package org.apache.spark.sql.catalyst.plans.logical;
/**
 * This is a Group by operator with the aggregate functions and projections.
 * <p>
 * param:  groupingExpressions expressions for grouping keys
 * param:  aggregateExpressions expressions for a project list, which could contain
 *                             {@link AggregateExpression}s.
 * <p>
 * Note: Currently, aggregateExpressions is the project list of this Group by operator. Before
 * separating projection from grouping and aggregate, we should avoid expression-level optimization
 * on aggregateExpressions, which could reference an expression in groupingExpressions.
 * For example, see the rule {@link org.apache.spark.sql.catalyst.optimizer.SimplifyExtractValueOps}
 */
public  class Aggregate extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupingExpressions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> aggregateExpressions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   Aggregate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> aggregateExpressions, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet validConstraints ()  { throw new RuntimeException(); }
}
