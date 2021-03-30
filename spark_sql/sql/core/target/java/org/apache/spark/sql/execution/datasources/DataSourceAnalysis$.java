package org.apache.spark.sql.execution.datasources;
/**
 * Replaces generic operations with specific variants that are designed to work with Spark
 * SQL Data Sources.
 * <p>
 * Note that, this rule must be run after <code>PreprocessTableCreation</code> and
 * <code>PreprocessTableInsertion</code>.
 */
public  class DataSourceAnalysis$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.analysis.CastSupport {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataSourceAnalysis$ MODULE$ = null;
  public   DataSourceAnalysis$ ()  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> convertStaticPartitions (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> sourceAttributes, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> providedPartitions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> targetAttributes, org.apache.spark.sql.types.StructType targetPartitionSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
