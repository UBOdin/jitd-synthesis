package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A container for holding the view description(CatalogTable) and info whether the view is temporary
 * or not. If it's a SQL (temp) view, the child should be a logical plan parsed from the
 * <code>CatalogTable.viewText</code>. Otherwise, the view is a temporary one created from a dataframe and the
 * view description should contain a <code>VIEW_CREATED_FROM_DATAFRAME</code> property; in this case, the child
 * must be already resolved.
 * <p>
 * This operator will be removed at the end of analysis stage.
 * <p>
 * param:  desc A view description(CatalogTable) that provides necessary information to resolve the
 *             view.
 * param:  isTempView A flag to indicate whether the view is temporary or not.
 * param:  child The logical plan of a view operator. If the view description is available, it should
 *              be a logical plan parsed from the <code>CatalogTable.viewText</code>.
 */
public  class View extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.internal.SQLConf effectiveSQLConf (scala.collection.immutable.Map<java.lang.String, java.lang.String> configs, boolean isTempView)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable desc ()  { throw new RuntimeException(); }
  public  boolean isTempView ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   View (org.apache.spark.sql.catalyst.catalog.CatalogTable desc, boolean isTempView, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan doCanonicalize ()  { throw new RuntimeException(); }
  public  boolean isTempViewStoringAnalyzedPlan ()  { throw new RuntimeException(); }
}
