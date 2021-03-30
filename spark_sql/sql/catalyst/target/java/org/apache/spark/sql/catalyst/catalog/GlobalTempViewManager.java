package org.apache.spark.sql.catalyst.catalog;
/**
 * A thread-safe manager for global temporary views, providing atomic operations to manage them,
 * e.g. create, update, remove, etc.
 * <p>
 * Note that, the view name is always case-sensitive here, callers are responsible to format the
 * view name w.r.t. case-sensitive config.
 * <p>
 * param:  database The system preserved virtual database that keeps all the global temporary views.
 */
public  class GlobalTempViewManager {
  // not preceding
  public   GlobalTempViewManager (java.lang.String database)  { throw new RuntimeException(); }
  /**
   * Clears all the global temporary views.
   */
  public  void clear ()  { throw new RuntimeException(); }
  /**
   * Creates a global temp view, or issue an exception if the view already exists and
   * <code>overrideIfExists</code> is false.
   * @param name (undocumented)
   * @param viewDefinition (undocumented)
   * @param overrideIfExists (undocumented)
   */
  public  void create (java.lang.String name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan viewDefinition, boolean overrideIfExists)  { throw new RuntimeException(); }
  public  java.lang.String database ()  { throw new RuntimeException(); }
  /**
   * Returns the global view definition which matches the given name, or None if not found.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> get (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Lists the names of all global temporary views.
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> listViewNames (java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * Removes the global temp view if it exists, returns true if removed, false otherwise.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean remove (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Renames the global temp view if the source view exists and the destination view not exists, or
   * issue an exception if the source view exists but the destination view already exists. Returns
   * true if renamed, false otherwise.
   * @param oldName (undocumented)
   * @param newName (undocumented)
   * @return (undocumented)
   */
  public  boolean rename (java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  /**
   * Updates the global temp view if it exists, returns true if updated, false otherwise.
   * @param name (undocumented)
   * @param viewDefinition (undocumented)
   * @return (undocumented)
   */
  public  boolean update (java.lang.String name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan viewDefinition)  { throw new RuntimeException(); }
}
