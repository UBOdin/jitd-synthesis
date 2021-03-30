package org.apache.spark.sql.catalyst.analysis;
/**
 * Provides a way to keep state during the analysis, mostly for resolving views. This enables us to
 * decouple the concerns of analysis environment from the catalog.
 * The state that is kept here is per-query.
 * <p>
 * Note this is thread local.
 * <p>
 * param:  catalogAndNamespace The catalog and namespace used in the view resolution. This overrides
 *                            the current catalog and namespace when resolving relations inside
 *                            views.
 * param:  nestedViewDepth The nested depth in the view resolution, this enables us to limit the
 *                        depth of nested views.
 * param:  maxNestedViewDepth The maximum allowed depth of nested view resolution.
 * param:  relationCache A mapping from qualified table names to resolved relations. This can ensure
 *                      that the table is resolved only once if a table is used multiple times
 *                      in a query.
 * param:  referredTempViewNames All the temp view names referred by the current view we are
 *                              resolving. It's used to make sure the relation resolution is
 *                              consistent between view creation and view resolution. For example,
 *                              if <code>t</code> was a permanent table when the current view was created, it
 *                              should still be a permanent table when resolving the current view,
 *                              even if a temp view <code>t</code> has been created.
 */
public  class AnalysisContext implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.analysis.AnalysisContext get ()  { throw new RuntimeException(); }
  static public  void reset ()  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> A withAnalysisContext (org.apache.spark.sql.catalyst.catalog.CatalogTable viewDesc, scala.Function0<A> f)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> catalogAndNamespace ()  { throw new RuntimeException(); }
  public  int nestedViewDepth ()  { throw new RuntimeException(); }
  public  int maxNestedViewDepth ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Map<scala.collection.Seq<java.lang.String>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> relationCache ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<java.lang.String>> referredTempViewNames ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> referredTempFunctionNames ()  { throw new RuntimeException(); }
  // not preceding
  public   AnalysisContext (scala.collection.Seq<java.lang.String> catalogAndNamespace, int nestedViewDepth, int maxNestedViewDepth, scala.collection.mutable.Map<scala.collection.Seq<java.lang.String>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> relationCache, scala.collection.Seq<scala.collection.Seq<java.lang.String>> referredTempViewNames, scala.collection.Seq<java.lang.String> referredTempFunctionNames)  { throw new RuntimeException(); }
}
