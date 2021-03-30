package org.apache.spark.sql.execution.columnar;
public  class InMemoryRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static   void clearSerializer ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.SparkPlan convertToColumnarIfPossible (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.execution.QueryExecution qe, scala.Option<java.lang.String> tableName)  { throw new RuntimeException(); }
  /**
   * This API is intended only to be used for testing.
   * @param serializer (undocumented)
   * @param storageLevel (undocumented)
   * @param child (undocumented)
   * @param tableName (undocumented)
   * @param optimizedPlan (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.sql.columnar.CachedBatchSerializer serializer, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.execution.SparkPlan child, scala.Option<java.lang.String> tableName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optimizedPlan)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder, org.apache.spark.sql.execution.QueryExecution qe)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering, org.apache.spark.sql.catalyst.plans.logical.Statistics statsOfPlanToCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  // not preceding
  public   InMemoryRelation (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics statsOfPlanToCache ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> innerChildren ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan doCanonicalize ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.PartitionStatistics partitionStatistics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan cachedPlan ()  { throw new RuntimeException(); }
    void updateStats (long rowCount, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat> newColStats)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation withOutput (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> newOutput)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan clone ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
