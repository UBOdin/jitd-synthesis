package org.apache.spark.sql.internal;
/**
 * Builder class that coordinates construction of a new {@link SessionState}.
 * <p>
 * The builder explicitly defines all components needed by the session state, and creates a session
 * state when <code>build</code> is called. Components should only be initialized once. This is not a problem
 * for most components as they are only used in the <code>build</code> function. However some components
 * (<code>conf</code>, <code>catalog</code>, <code>functionRegistry</code>, <code>experimentalMethods</code> &amp; <code>sqlParser</code>) are as dependencies
 * for other components and are shared as a result. These components are defined as lazy vals to
 * make sure the component is created only once.
 * <p>
 * A developer can modify the builder by providing custom versions of components, or by using the
 * hooks provided for the analyzer, optimizer &amp; planner. There are some dependencies between the
 * components (they are documented per dependency), a developer should respect these when making
 * modifications in order to prevent initialization problems.
 * <p>
 * A parent {@link SessionState} can be used to initialize the new {@link SessionState}. The new session
 * state will clone the parent sessions state's <code>conf</code>, <code>functionRegistry</code>, <code>experimentalMethods</code>
 * and <code>catalog</code> fields. Note that the state is cloned when <code>build</code> is called, and not before.
 */
public abstract class BaseSessionStateBuilder {
  // not preceding
  public   BaseSessionStateBuilder (org.apache.spark.sql.SparkSession session, scala.Option<org.apache.spark.sql.internal.SessionState> parentState)  { throw new RuntimeException(); }
  /**
   * Logical query plan analyzer for resolving unresolved attributes and relations.
   * <p>
   * Note: this depends on the <code>conf</code> and <code>catalog</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.analysis.Analyzer analyzer ()  { throw new RuntimeException(); }
  /**
   * Build the {@link SessionState}.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.internal.SessionState build ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.execution.ColumnarRule> columnarRules ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  /**
   * Function used to make clones of the session state.
   * @return (undocumented)
   */
  protected  scala.Function2<org.apache.spark.sql.SparkSession, org.apache.spark.sql.internal.SessionState, org.apache.spark.sql.internal.SessionState> createClone ()  { throw new RuntimeException(); }
  /**
   * Create a query execution object.
   * @return (undocumented)
   */
  protected  scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.execution.QueryExecution> createQueryExecution ()  { throw new RuntimeException(); }
  /**
   * Custom check rules to add to the Analyzer. Prefer overriding this instead of creating
   * your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.runtime.BoxedUnit>> customCheckRules ()  { throw new RuntimeException(); }
  /**
   * Custom early scan push down rules to add to the Optimizer. Prefer overriding this instead
   * of creating your own Optimizer.
   * <p>
   * Note that this may NOT depend on the <code>optimizer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customEarlyScanPushDownRules ()  { throw new RuntimeException(); }
  /**
   * Custom operator optimization rules to add to the Optimizer. Prefer overriding this instead
   * of creating your own Optimizer.
   * <p>
   * Note that this may NOT depend on the <code>optimizer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customOperatorOptimizationRules ()  { throw new RuntimeException(); }
  /**
   * Custom strategies to add to the planner. Prefer overriding this instead of creating
   * your own Planner.
   * <p>
   * Note that this may NOT depend on the <code>planner</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.execution.SparkStrategy> customPlanningStrategies ()  { throw new RuntimeException(); }
  /**
   * Custom post resolution rules to add to the Analyzer. Prefer overriding this instead of
   * creating your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customPostHocResolutionRules ()  { throw new RuntimeException(); }
  /**
   * Custom rules for rewriting plans after operator optimization and before CBO.
   * Prefer overriding this instead of creating your own Optimizer.
   * <p>
   * Note that this may NOT depend on the <code>optimizer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customPreCBORules ()  { throw new RuntimeException(); }
  /**
   * Custom resolution rules to add to the Analyzer. Prefer overriding this instead of creating
   * your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customResolutionRules ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.ExperimentalMethods experimentalMethods ()  { throw new RuntimeException(); }
  /**
   * Session extensions defined in the {@link SparkSession}.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.SparkSessionExtensions extensions ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry ()  { throw new RuntimeException(); }
  /**
   * An interface to register custom {@link org.apache.spark.sql.util.QueryExecutionListener}s
   * that listen for execution metrics.
   * <p>
   * This gets cloned from parent if available, otherwise a new instance is created.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.util.ExecutionListenerManager listenerManager ()  { throw new RuntimeException(); }
  /**
   * Function that produces a new instance of the <code>BaseSessionStateBuilder</code>. This is used by the
   * {@link SessionState}'s clone functionality. Make sure to override this when implementing your own
   * {@link SessionStateBuilder}.
   * @return (undocumented)
   */
  protected abstract  scala.Function2<org.apache.spark.sql.SparkSession, scala.Option<org.apache.spark.sql.internal.SessionState>, org.apache.spark.sql.internal.BaseSessionStateBuilder> newBuilder ()  ;
  /**
   * Logical query plan optimizer.
   * <p>
   * Note: this depends on <code>catalog</code> and <code>experimentalMethods</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.optimizer.Optimizer optimizer ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.internal.SessionState> parentState ()  { throw new RuntimeException(); }
  /**
   * Planner that converts optimized logical plans to physical plans.
   * <p>
   * Note: this depends on the <code>conf</code> and <code>experimentalMethods</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> queryStagePrepRules ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.internal.SessionResourceLoader resourceLoader ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession session ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.parser.ParserInterface sqlParser ()  { throw new RuntimeException(); }
  /**
   * Interface to start and stop streaming queries.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.streaming.StreamingQueryManager streamingQueryManager ()  { throw new RuntimeException(); }
  /**
   * Interface exposed to the user for registering user-defined functions.
   * <p>
   * Note 1: The user-defined functions must be deterministic.
   * Note 2: This depends on the <code>functionRegistry</code> field.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.UDFRegistration udfRegistration ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.execution.datasources.v2.V2SessionCatalog v2SessionCatalog ()  { throw new RuntimeException(); }
}
