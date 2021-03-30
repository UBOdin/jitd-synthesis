package org.apache.spark.sql.execution.datasources;
/**
 * Used to link a {@link BaseRelation} in to a logical query plan.
 */
public  class LogicalRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.datasources.LogicalRelation apply (org.apache.spark.sql.sources.BaseRelation relation, boolean isStreaming)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.datasources.LogicalRelation apply (org.apache.spark.sql.sources.BaseRelation relation, org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation relation ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTable> catalogTable ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  // not preceding
  public   LogicalRelation (org.apache.spark.sql.sources.BaseRelation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTable> catalogTable, boolean isStreaming)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan doCanonicalize ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  /** Used to lookup original attribute capitalization */
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.AttributeReference> attributeMap ()  { throw new RuntimeException(); }
  /**
   * Returns a new instance of this LogicalRelation. According to the semantics of
   * MultiInstanceRelation, this method returns a copy of this object with
   * unique expression ids. We respect the <code>expectedOutputAttributes</code> and create
   * new instances of attributes in it.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.datasources.LogicalRelation newInstance ()  { throw new RuntimeException(); }
  public  void refresh ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
