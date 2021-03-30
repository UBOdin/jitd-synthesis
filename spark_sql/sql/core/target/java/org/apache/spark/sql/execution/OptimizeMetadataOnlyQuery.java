package org.apache.spark.sql.execution;
/**
 * This rule optimizes the execution of queries that can be answered by looking only at
 * partition-level metadata. This applies when all the columns scanned are partition columns, and
 * the query has an aggregate operator that satisfies the following conditions:
 * 1. aggregate expression is partition columns.
 *  e.g. SELECT col FROM tbl GROUP BY col.
 * 2. aggregate function on partition columns with DISTINCT.
 *  e.g. SELECT col1, count(DISTINCT col2) FROM tbl GROUP BY col1.
 * 3. aggregate function on partition columns which have same result w or w/o DISTINCT keyword.
 *  e.g. SELECT col1, Max(col2) FROM tbl GROUP BY col1.
 */
public  class OptimizeMetadataOnlyQuery extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements scala.Product, scala.Serializable {
  /**
   * A pattern that finds the partitioned table relation node inside the given plan, and returns a
   * pair of the partition attributes and the table relation node.
   */
  public  class PartitionedRelation$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
    public   PartitionedRelation$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.AttributeSet, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  /**
   * Accessor for nested Scala object
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.OptimizeMetadataOnlyQuery.PartitionedRelation$ PartitionedRelation ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  // not preceding
  public   OptimizeMetadataOnlyQuery (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
