package org.apache.spark.sql.catalyst.optimizer;
/**
 * Abstract class all optimizers should inherit of, contains the standard batches (extending
 * Optimizers can override this.
 */
public abstract class Optimizer extends org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Optimize all the subqueries inside expression.
   */
  public  class OptimizeSubqueries {
    static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
    static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
    static protected  java.lang.String logName ()  { throw new RuntimeException(); }
    static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
    static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
    static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
    static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
    static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
    static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
    static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
    static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
    static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
    static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
    static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
    static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
    static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
    static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
    static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
    static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
    static public  java.lang.String ruleName ()  { throw new RuntimeException(); }
    static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
    static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  }
  /**
   * Optimize all the subqueries inside expression.
   */
  public  class OptimizeSubqueries$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final OptimizeSubqueries$ MODULE$ = null;
    public   OptimizeSubqueries$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.catalyst.optimizer.Optimizer.OptimizeSubqueries$ OptimizeSubqueries ()  { throw new RuntimeException(); }
  public   Optimizer (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager)  { throw new RuntimeException(); }
  /**
   * Returns (defaultBatches - (excludedRules - nonExcludableRules)), the rule batches that
   * eventually run in the Optimizer.
   * <p>
   * Implementations of this class should override {@link defaultBatches}, and {@link nonExcludableRules}
   * if necessary, instead of this method.
   * @return (undocumented)
   */
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> batches ()  { throw new RuntimeException(); }
  /**
   * Defines the default rule batches in the Optimizer.
   * <p>
   * Implementations of this class should override this method, and {@link nonExcludableRules} if
   * necessary, instead of {@link batches}. The rule batches that eventually run in the Optimizer,
   * i.e., returned by {@link batches}, will be (defaultBatches - (excludedRules - nonExcludableRules)).
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> defaultBatches ()  { throw new RuntimeException(); }
  /**
   * Override to provide additional rules for early projection and filter pushdown to scans.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> earlyScanPushDownRules ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.Set<java.lang.String> excludedOnceBatches ()  { throw new RuntimeException(); }
  /**
   * Override to provide additional rules for the operator optimization batch.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> extendedOperatorOptimizationRules ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.FixedPoint fixedPoint ()  { throw new RuntimeException(); }
  protected  boolean isPlanIntegral (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Defines rules that cannot be excluded from the Optimizer even if they are specified in
   * SQL config "excludedRules".
   * <p>
   * Implementations of this class can override this method if necessary. The rule batches
   * that eventually run in the Optimizer, i.e., returned by {@link batches}, will be
   * (defaultBatches - (excludedRules - nonExcludableRules)).
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> nonExcludableRules ()  { throw new RuntimeException(); }
  /**
   * Override to provide additional rules for rewriting plans after operator optimization rules and
   * before any cost-based optimization rules that depend on stats.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> preCBORules ()  { throw new RuntimeException(); }
}
