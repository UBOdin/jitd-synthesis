package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A visitor pattern for traversing a {@link LogicalPlan} tree and computing some properties.
 */
public  interface LogicalPlanVisitor<T extends java.lang.Object> {
  public  T visit (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan p)  ;
  public  T visitAggregate (org.apache.spark.sql.catalyst.plans.logical.Aggregate p)  ;
  public  T visitDistinct (org.apache.spark.sql.catalyst.plans.logical.Distinct p)  ;
  public  T visitExcept (org.apache.spark.sql.catalyst.plans.logical.Except p)  ;
  public  T visitExpand (org.apache.spark.sql.catalyst.plans.logical.Expand p)  ;
  public  T visitFilter (org.apache.spark.sql.catalyst.plans.logical.Filter p)  ;
  public  T visitGenerate (org.apache.spark.sql.catalyst.plans.logical.Generate p)  ;
  public  T visitGlobalLimit (org.apache.spark.sql.catalyst.plans.logical.GlobalLimit p)  ;
  public  T visitIntersect (org.apache.spark.sql.catalyst.plans.logical.Intersect p)  ;
  public  T visitJoin (org.apache.spark.sql.catalyst.plans.logical.Join p)  ;
  public  T visitLocalLimit (org.apache.spark.sql.catalyst.plans.logical.LocalLimit p)  ;
  public  T visitPivot (org.apache.spark.sql.catalyst.plans.logical.Pivot p)  ;
  public  T visitProject (org.apache.spark.sql.catalyst.plans.logical.Project p)  ;
  public  T visitRepartition (org.apache.spark.sql.catalyst.plans.logical.Repartition p)  ;
  public  T visitRepartitionByExpr (org.apache.spark.sql.catalyst.plans.logical.RepartitionByExpression p)  ;
  public  T visitSample (org.apache.spark.sql.catalyst.plans.logical.Sample p)  ;
  public  T visitScriptTransform (org.apache.spark.sql.catalyst.plans.logical.ScriptTransformation p)  ;
  public  T visitTail (org.apache.spark.sql.catalyst.plans.logical.Tail p)  ;
  public  T visitUnion (org.apache.spark.sql.catalyst.plans.logical.Union p)  ;
  public  T visitWindow (org.apache.spark.sql.catalyst.plans.logical.Window p)  ;
}
