package org.apache.spark.sql.execution;
public  class SparkOptimizer extends org.apache.spark.sql.catalyst.optimizer.Optimizer {
  public   SparkOptimizer (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager, org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, org.apache.spark.sql.ExperimentalMethods experimentalMethods)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> defaultBatches ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> earlyScanPushDownRules ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> nonExcludableRules ()  { throw new RuntimeException(); }
  /**
   * Optimization batches that are executed after the regular optimization batches, but before the
   * batch executing the {@link ExperimentalMethods} optimizer rules. This hook can be used to add
   * custom optimizer batches to the Spark optimizer.
   * <p>
   * Note that 'Extract Python UDFs' batch is an exception and ran after the batches defined here.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> postHocOptimizationBatches ()  { throw new RuntimeException(); }
  /**
   * Optimization batches that are executed before the regular optimization batches (also before
   * the finish analysis batch).
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> preOptimizationBatches ()  { throw new RuntimeException(); }
}
