package org.apache.spark.sql.internal;
/**
 * A class that holds all session-specific state in a given {@link SparkSession}.
 * <p>
 * param:  sharedState The state shared across sessions, e.g. global view manager, external catalog.
 * param:  conf SQL-specific key-value configurations.
 * param:  experimentalMethods Interface to add custom planning strategies and optimizers.
 * param:  functionRegistry Internal catalog for managing functions registered by the user.
 * param:  udfRegistration Interface exposed to the user for registering user-defined functions.
 * param:  catalogBuilder a function to create an internal catalog for managing table and database
 *                       states.
 * param:  sqlParser Parser that extracts expressions, plans, table identifiers etc. from SQL texts.
 * param:  analyzerBuilder A function to create the logical query plan analyzer for resolving
 *                        unresolved attributes and relations.
 * param:  optimizerBuilder a function to create the logical query plan optimizer.
 * param:  planner Planner that converts optimized logical plans to physical plans.
 * param:  streamingQueryManagerBuilder A function to create a streaming query manager to
 *                                     start and stop streaming queries.
 * param:  listenerManager Interface to register custominternal/SessionState.scala
 *                        {@link org.apache.spark.sql.util.QueryExecutionListener}s.
 * param:  resourceLoaderBuilder a function to create a session shared resource loader to load JARs,
 *                              files, etc.
 * param:  createQueryExecution Function used to create QueryExecution objects.
 * param:  createClone Function used to create clones of the session state.
 */
  class SessionState {
  public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.ExperimentalMethods experimentalMethods ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.UDFRegistration udfRegistration ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.parser.ParserInterface sqlParser ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  public  scala.Function0<org.apache.spark.sql.streaming.StreamingQueryManager> streamingQueryManagerBuilder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.ExecutionListenerManager listenerManager ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ColumnarRule> columnarRules ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> queryStagePrepRules ()  { throw new RuntimeException(); }
  // not preceding
  public   SessionState (org.apache.spark.sql.internal.SharedState sharedState, org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.ExperimentalMethods experimentalMethods, org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry, org.apache.spark.sql.UDFRegistration udfRegistration, scala.Function0<org.apache.spark.sql.catalyst.catalog.SessionCatalog> catalogBuilder, org.apache.spark.sql.catalyst.parser.ParserInterface sqlParser, scala.Function0<org.apache.spark.sql.catalyst.analysis.Analyzer> analyzerBuilder, scala.Function0<org.apache.spark.sql.catalyst.optimizer.Optimizer> optimizerBuilder, org.apache.spark.sql.execution.SparkPlanner planner, scala.Function0<org.apache.spark.sql.streaming.StreamingQueryManager> streamingQueryManagerBuilder, org.apache.spark.sql.util.ExecutionListenerManager listenerManager, scala.Function0<org.apache.spark.sql.internal.SessionResourceLoader> resourceLoaderBuilder, scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.execution.QueryExecution> createQueryExecution, scala.Function2<org.apache.spark.sql.SparkSession, org.apache.spark.sql.internal.SessionState, org.apache.spark.sql.internal.SessionState> createClone, scala.collection.Seq<org.apache.spark.sql.execution.ColumnarRule> columnarRules, scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> queryStagePrepRules)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.analysis.Analyzer analyzer ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.optimizer.Optimizer optimizer ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.internal.SessionResourceLoader resourceLoader ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.streaming.StreamingQueryManager streamingQueryManager ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration newHadoopConf ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration newHadoopConfWithOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Get an identical copy of the <code>SessionState</code> and associate it with the given <code>SparkSession</code>
   * @param newSparkSession (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.internal.SessionState clone (org.apache.spark.sql.SparkSession newSparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.QueryExecution executePlan (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
