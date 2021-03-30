package org.apache.spark.sql.execution.command;
public  class ViewHelper {
  /**
   * Generate the view properties in CatalogTable, including:
   * 1. view default database that is used to provide the default database name on view resolution.
   * 2. the output column names of the query that creates a view, this is used to map the output of
   *    the view child to the view output during view resolution.
   * 3. the SQL configs when creating the view.
   * <p>
   * @param properties the <code>properties</code> in CatalogTable.
   * @param session the spark session.
   * @param analyzedPlan the analyzed logical plan that represents the child of a view.
   * @return new view properties including view default database and query column names properties.
   * @param fieldNames (undocumented)
   * @param tempViewNames (undocumented)
   * @param tempFunctionNames (undocumented)
   */
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> generateViewProperties (scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, org.apache.spark.sql.SparkSession session, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzedPlan, java.lang.String[] fieldNames, scala.collection.Seq<scala.collection.Seq<java.lang.String>> tempViewNames, scala.collection.Seq<java.lang.String> tempFunctionNames)  { throw new RuntimeException(); }
  /**
   * Recursively search the logical plan to detect cyclic view references, throw an
   * AnalysisException if cycle detected.
   * <p>
   * A cyclic view reference is a cycle of reference dependencies, for example, if the following
   * statements are executed:
   * CREATE VIEW testView AS SELECT id FROM tbl
   * CREATE VIEW testView2 AS SELECT id FROM testView
   * ALTER VIEW testView AS SELECT * FROM testView2
   * The view <code>testView</code> references <code>testView2</code>, and <code>testView2</code> also references <code>testView</code>,
   * therefore a reference cycle (testView -> testView2 -> testView) exists.
   * <p>
   * @param plan the logical plan we detect cyclic view references from.
   * @param path the path between the altered view and current node.
   * @param viewIdent the table identifier of the altered view, we compare two views by the
   *                  <code>desc.identifier</code>.
   */
  static public  void checkCyclicViewReference (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> path, org.apache.spark.sql.catalyst.TableIdentifier viewIdent)  { throw new RuntimeException(); }
  /**
   * Permanent views are not allowed to reference temp objects, including temp function and views
   * @param catalog (undocumented)
   * @param isTemporary (undocumented)
   * @param name (undocumented)
   * @param child (undocumented)
   */
  static public  void verifyTemporaryObjectsNotExists (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, boolean isTemporary, org.apache.spark.sql.catalyst.TableIdentifier name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  /**
   * Returns a {@link TemporaryViewRelation} that contains information about a temporary view
   * to create, given an analyzed plan of the view. If a temp view is to be replaced and it is
   * cached, it will be uncached before being replaced.
   * <p>
   * @param name the name of the temporary view to create/replace.
   * @param session the spark session.
   * @param replace if true and the existing view is cached, it will be uncached.
   * @param getRawTempView the function that returns an optional raw plan of the local or
   *                       global temporary view.
   * @param originalText the original SQL text of this view, can be None if this view is created via
   *                     Dataset API or spark.sql.legacy.storeAnalyzedPlanForView is set to true.
   * @param analyzedPlan the logical plan that represents the view; this is used to generate the
   *                     logical plan for temporary view and the view schema.
   * @param aliasedPlan the aliased logical plan based on the user specified columns. If there are
   *                    no user specified plans, this should be same as <code>analyzedPlan</code>.
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.catalog.TemporaryViewRelation createTemporaryViewRelation (org.apache.spark.sql.catalyst.TableIdentifier name, org.apache.spark.sql.SparkSession session, boolean replace, scala.Function1<java.lang.String, scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> getRawTempView, scala.Option<java.lang.String> originalText, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzedPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan aliasedPlan)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
}
