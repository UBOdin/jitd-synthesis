package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/**
 * An {@link LogicalPlanVisitor} that computes a single dimension for plan stats: size in bytes.
 */
public  class SizeInBytesOnlyStatsPlanVisitor$ implements org.apache.spark.sql.catalyst.plans.logical.LogicalPlanVisitor<org.apache.spark.sql.catalyst.plans.logical.Statistics> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SizeInBytesOnlyStatsPlanVisitor$ MODULE$ = null;
  public   SizeInBytesOnlyStatsPlanVisitor$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitAggregate (org.apache.spark.sql.catalyst.plans.logical.Aggregate p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitDistinct (org.apache.spark.sql.catalyst.plans.logical.Distinct p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitExcept (org.apache.spark.sql.catalyst.plans.logical.Except p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitExpand (org.apache.spark.sql.catalyst.plans.logical.Expand p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitFilter (org.apache.spark.sql.catalyst.plans.logical.Filter p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitGenerate (org.apache.spark.sql.catalyst.plans.logical.Generate p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitGlobalLimit (org.apache.spark.sql.catalyst.plans.logical.GlobalLimit p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitIntersect (org.apache.spark.sql.catalyst.plans.logical.Intersect p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitJoin (org.apache.spark.sql.catalyst.plans.logical.Join p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitLocalLimit (org.apache.spark.sql.catalyst.plans.logical.LocalLimit p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitPivot (org.apache.spark.sql.catalyst.plans.logical.Pivot p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitProject (org.apache.spark.sql.catalyst.plans.logical.Project p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitRepartition (org.apache.spark.sql.catalyst.plans.logical.Repartition p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitRepartitionByExpr (org.apache.spark.sql.catalyst.plans.logical.RepartitionByExpression p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitSample (org.apache.spark.sql.catalyst.plans.logical.Sample p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitScriptTransform (org.apache.spark.sql.catalyst.plans.logical.ScriptTransformation p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitUnion (org.apache.spark.sql.catalyst.plans.logical.Union p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitWindow (org.apache.spark.sql.catalyst.plans.logical.Window p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics visitTail (org.apache.spark.sql.catalyst.plans.logical.Tail p)  { throw new RuntimeException(); }
}
