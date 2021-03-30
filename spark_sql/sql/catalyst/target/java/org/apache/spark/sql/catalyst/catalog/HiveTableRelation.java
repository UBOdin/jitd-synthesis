package org.apache.spark.sql.catalyst.catalog;
/**
 * A <code>LogicalPlan</code> that represents a hive table.
 * <p>
 * TODO: remove this after we completely make hive as a data source.
 */
public  class HiveTableRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> dataCols ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> partitionCols ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> tableStats ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition>> prunedPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveTableRelation (org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> dataCols, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> partitionCols, scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> tableStats, scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition>> prunedPartitions)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output ()  { throw new RuntimeException(); }
  public  boolean isPartitioned ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.HiveTableRelation doCanonicalize ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.HiveTableRelation newInstance ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
