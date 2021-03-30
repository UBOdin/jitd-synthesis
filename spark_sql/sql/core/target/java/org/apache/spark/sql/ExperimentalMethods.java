package org.apache.spark.sql;
/**
 * :: Experimental ::
 * Holder for experimental methods for the bravest. We make NO guarantee about the stability
 * regarding binary compatibility and source compatibility of methods here.
 * <p>
 * <pre><code>
 *   spark.experimental.extraStrategies += ...
 * </code></pre>
 * <p>
 * @since 1.3.0
 */
public  class ExperimentalMethods {
     ExperimentalMethods ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.ExperimentalMethods clone ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> extraOptimizations ()  { throw new RuntimeException(); }
  /**
   * Allows extra strategies to be injected into the query planner at runtime.  Note this API
   * should be considered experimental and is not intended to be stable across releases.
   * <p>
   * @since 1.3.0
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkStrategy> extraStrategies ()  { throw new RuntimeException(); }
}
