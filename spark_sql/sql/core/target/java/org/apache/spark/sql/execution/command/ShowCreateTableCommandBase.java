package org.apache.spark.sql.execution.command;
/**
 * Provides common utilities between <code>ShowCreateTableCommand</code> and <code>ShowCreateTableAsSparkCommand</code>.
 */
public  interface ShowCreateTableCommandBase {
  public  java.lang.String concatByMultiLines (scala.collection.Iterable<java.lang.String> iter)  ;
  public  void showCreateView (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showTableComment (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showTableLocation (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showTableProperties (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showViewDataColumns (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showViewProperties (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  void showViewText (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, scala.collection.mutable.StringBuilder builder)  ;
  public  org.apache.spark.sql.catalyst.TableIdentifier table ()  ;
}
