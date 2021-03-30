package org.apache.spark.sql.catalyst.streaming;
/**
 * Used to link a {@link Table} into a streaming {@link LogicalPlan}.
 */
public  class StreamingRelationV2 extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8)  ;
  public  scala.Option<org.apache.spark.sql.connector.catalog.TableProvider> source ()  { throw new RuntimeException(); }
  public  java.lang.String sourceName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap extraOptions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.catalog.CatalogPlugin> catalog ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> identifier ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> v1Relation ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingRelationV2 (scala.Option<org.apache.spark.sql.connector.catalog.TableProvider> source, java.lang.String sourceName, org.apache.spark.sql.connector.catalog.Table table, org.apache.spark.sql.util.CaseInsensitiveStringMap extraOptions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.Option<org.apache.spark.sql.connector.catalog.CatalogPlugin> catalog, scala.Option<org.apache.spark.sql.connector.catalog.Identifier> identifier, scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> v1Relation)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan newInstance ()  { throw new RuntimeException(); }
}
