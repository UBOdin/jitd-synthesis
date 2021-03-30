package org.apache.spark.sql.execution.columnar;
public  class InMemoryRelation$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final InMemoryRelation$ MODULE$ = null;
  public   InMemoryRelation$ ()  { throw new RuntimeException(); }
    void clearSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan convertToColumnarIfPossible (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.execution.QueryExecution qe, scala.Option<java.lang.String> tableName)  { throw new RuntimeException(); }
  /**
   * This API is intended only to be used for testing.
   * @param serializer (undocumented)
   * @param storageLevel (undocumented)
   * @param child (undocumented)
   * @param tableName (undocumented)
   * @param optimizedPlan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.sql.columnar.CachedBatchSerializer serializer, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.execution.SparkPlan child, scala.Option<java.lang.String> tableName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optimizedPlan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder, org.apache.spark.sql.execution.QueryExecution qe)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation apply (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.execution.columnar.CachedRDDBuilder cacheBuilder, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering, org.apache.spark.sql.catalyst.plans.logical.Statistics statsOfPlanToCache)  { throw new RuntimeException(); }
}
