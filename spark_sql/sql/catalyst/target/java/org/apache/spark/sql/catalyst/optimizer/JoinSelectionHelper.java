package org.apache.spark.sql.catalyst.optimizer;
public  interface JoinSelectionHelper {
  /**
   * Matches a plan whose output should be small enough to be used in broadcast join.
   * @param plan (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  public  boolean canBroadcastBySize (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.internal.SQLConf conf)  ;
  public  boolean canBuildBroadcastLeft (org.apache.spark.sql.catalyst.plans.JoinType joinType)  ;
  public  boolean canBuildBroadcastRight (org.apache.spark.sql.catalyst.plans.JoinType joinType)  ;
  /**
   * Matches a plan whose single partition should be small enough to build a hash table.
   * <p>
   * Note: this assume that the number of partition is fixed, requires additional work if it's
   * dynamic.
   * @param plan (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  public  boolean canBuildLocalHashMapBySize (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.internal.SQLConf conf)  ;
  public  boolean canBuildShuffledHashJoinLeft (org.apache.spark.sql.catalyst.plans.JoinType joinType)  ;
  public  boolean canBuildShuffledHashJoinRight (org.apache.spark.sql.catalyst.plans.JoinType joinType)  ;
  public  boolean canPlanAsBroadcastHashJoin (org.apache.spark.sql.catalyst.plans.logical.Join join, org.apache.spark.sql.internal.SQLConf conf)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.optimizer.BuildSide> getBroadcastBuildSide (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right, org.apache.spark.sql.catalyst.plans.JoinType joinType, org.apache.spark.sql.catalyst.plans.logical.JoinHint hint, boolean hintOnly, org.apache.spark.sql.internal.SQLConf conf)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.optimizer.BuildSide> getBuildSide (boolean canBuildLeft, boolean canBuildRight, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.optimizer.BuildSide> getShuffleHashJoinBuildSide (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right, org.apache.spark.sql.catalyst.plans.JoinType joinType, org.apache.spark.sql.catalyst.plans.logical.JoinHint hint, boolean hintOnly, org.apache.spark.sql.internal.SQLConf conf)  ;
  public  org.apache.spark.sql.catalyst.optimizer.BuildSide getSmallerSide (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right)  ;
  public  boolean hintToBroadcastLeft (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToBroadcastRight (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToNotBroadcastLeft (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToNotBroadcastRight (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToShuffleHashJoinLeft (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToShuffleHashJoinRight (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToShuffleReplicateNL (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  public  boolean hintToSortMergeJoin (org.apache.spark.sql.catalyst.plans.logical.JoinHint hint)  ;
  /**
   * Returns whether plan a is much smaller (3X) than plan b.
   * <p>
   * The cost to build hash map is higher than sorting, we should only build hash map on a table
   * that is much smaller than other one. Since we does not have the statistic for number of rows,
   * use the size of bytes here as estimation.
   * @param a (undocumented)
   * @param b (undocumented)
   * @return (undocumented)
   */
  public  boolean muchSmaller (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan a, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan b)  ;
}
