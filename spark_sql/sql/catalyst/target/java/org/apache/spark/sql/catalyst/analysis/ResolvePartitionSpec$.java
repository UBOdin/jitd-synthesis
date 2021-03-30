package org.apache.spark.sql.catalyst.analysis;
/**
 * Resolve {@link UnresolvedPartitionSpec} to {@link ResolvedPartitionSpec} in partition related commands.
 */
public  class ResolvePartitionSpec$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResolvePartitionSpec$ MODULE$ = null;
  public   ResolvePartitionSpec$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.InternalRow convertToPartIdent (scala.collection.immutable.Map<java.lang.String, java.lang.String> partitionSpec, scala.collection.Seq<org.apache.spark.sql.types.StructField> schema)  { throw new RuntimeException(); }
}
