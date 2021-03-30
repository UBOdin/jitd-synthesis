package org.apache.spark.sql.catalyst.expressions;
/**
 * An interface for expressions that contain a {@link QueryPlan}.
 */
public abstract class PlanExpression<T extends org.apache.spark.sql.catalyst.plans.QueryPlan<?>> extends org.apache.spark.sql.catalyst.expressions.Expression {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(ExistentialTypeTree(AppliedTypeTree(Select(Select(Select(Select(Select(Select(Ident(org), org.apache), org.apache.spark), org.apache.spark.sql), org.apache.spark.sql.catalyst), org.apache.spark.sql.catalyst.plans), org.apache.spark.sql.catalyst.plans.QueryPlan), List(TypeTree().setOriginal(Ident(TypeName("_$1"))))), List(TypeDef(Modifiers(DEFERRED | SYNTHETIC), TypeName("_$1"), List(), TypeBoundsTree(EmptyTree, EmptyTree)))))))
  public   PlanExpression ()  { throw new RuntimeException(); }
  protected  java.lang.String conditionString ()  { throw new RuntimeException(); }
  /**  The id of the subquery expression. */
  public abstract  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  ;
  /** The plan being wrapped in the query. */
  public abstract  T plan ()  ;
  /** Updates the expression with a new plan. */
  public abstract  org.apache.spark.sql.catalyst.expressions.PlanExpression<T> withNewPlan (T plan)  ;
}
