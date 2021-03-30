package org.apache.spark.sql.catalyst.plans.logical;
public abstract class LogicalPlan extends org.apache.spark.sql.catalyst.plans.QueryPlan<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.plans.logical.AnalysisHelper, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.LogicalPlanStats, org.apache.spark.sql.catalyst.plans.logical.QueryPlanConstraints, org.apache.spark.internal.Logging {
  public   LogicalPlan ()  { throw new RuntimeException(); }
  /**
   * Returns true if all its children of this query plan have been resolved.
   * @return (undocumented)
   */
  public  boolean childrenResolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet constraints ()  { throw new RuntimeException(); }
  /** Returns true if this subtree has data from a streaming data source. */
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  /**
   * Returns the maximum number of rows that this plan may compute.
   * <p>
   * Any operator that a Limit can be pushed passed should override this function (e.g., Union).
   * Any operator that can push through a Limit should override this function (e.g., Project).
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  /**
   * Returns the maximum number of rows this plan may compute on each partition.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> maxRowsPerPartition ()  { throw new RuntimeException(); }
  /** Metadata fields that can be projected from this node */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> metadataOutput ()  { throw new RuntimeException(); }
  /**
   * Returns the output ordering that this plan generates.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  /**
   * Refreshes (or invalidates) any metadata/data cached in the plan recursively.
   */
  public  void refresh ()  { throw new RuntimeException(); }
  /**
   * Resolves a given schema to concrete {@link Attribute} references in this query plan. This function
   * should only be called on analyzed plans since it will throw {@link AnalysisException} for
   * unresolved {@link Attribute}s.
   * @param schema (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resolve (org.apache.spark.sql.types.StructType schema, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Optionally resolves the given strings to a {@link NamedExpression} based on the output of this
   * LogicalPlan. The attribute is expressed as string in the following form:
   * <code>[scope].AttributeName.[nested].[fields]...</code>.
   * @param nameParts (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.NamedExpression> resolve (scala.collection.Seq<java.lang.String> nameParts, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Optionally resolves the given strings to a {@link NamedExpression} using the input from all child
   * nodes of this LogicalPlan. The attribute is expressed as
   * string in the following form: <code>[scope].AttributeName.[nested].[fields]...</code>.
   * @param nameParts (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.NamedExpression> resolveChildren (scala.collection.Seq<java.lang.String> nameParts, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Given an attribute name, split it to name parts by dot, but
   * don't split the name parts quoted by backticks, for example,
   * <code>ab.cd</code>.<code>efg</code> should be split into two parts "ab.cd" and "efg".
   * @param name (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.NamedExpression> resolveQuoted (java.lang.String name, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  /**
   * Returns true iff <code>other</code>'s output is semantically the same, i.e.:
   *  - it contains the same number of <code>Attribute</code>s;
   *  - references are the same;
   *  - the order is equal too.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean sameOutput (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan other)  { throw new RuntimeException(); }
  protected  java.lang.String statePrefix ()  { throw new RuntimeException(); }
  protected  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> statsCache ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.ExpressionSet validConstraints ()  { throw new RuntimeException(); }
  public  java.lang.String verboseStringWithSuffix (int maxFields)  { throw new RuntimeException(); }
}
