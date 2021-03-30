package org.apache.spark.sql.hive;
/**
 * Builder that produces a Hive-aware <code>SessionState</code>.
 */
public  class HiveSessionStateBuilder extends org.apache.spark.sql.internal.BaseSessionStateBuilder {
  // not preceding
  public   HiveSessionStateBuilder (org.apache.spark.sql.SparkSession session, scala.Option<org.apache.spark.sql.internal.SessionState> parentState)  { throw new RuntimeException(); }
  /**
   * A logical query plan <code>Analyzer</code> with rules specific to Hive.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.analysis.Analyzer analyzer ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.hive.HiveSessionCatalog catalog ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customEarlyScanPushDownRules ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.Function2<org.apache.spark.sql.SparkSession, scala.Option<org.apache.spark.sql.internal.SessionState>, org.apache.spark.sql.internal.BaseSessionStateBuilder> newBuilder ()  { throw new RuntimeException(); }
  /**
   * Planner that takes into account Hive-specific strategies.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.hive.HiveSessionResourceLoader resourceLoader ()  { throw new RuntimeException(); }
}
