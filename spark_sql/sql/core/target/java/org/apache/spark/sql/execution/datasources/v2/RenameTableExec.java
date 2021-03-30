package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for renaming a table.
 */
public  class RenameTableExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier oldIdent ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier newIdent ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.Option<org.apache.spark.storage.StorageLevel>> invalidateCache ()  { throw new RuntimeException(); }
  public  scala.Function4<org.apache.spark.sql.SparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.Option<java.lang.String>, org.apache.spark.storage.StorageLevel, scala.runtime.BoxedUnit> cacheTable ()  { throw new RuntimeException(); }
  // not preceding
  public   RenameTableExec (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier oldIdent, org.apache.spark.sql.connector.catalog.Identifier newIdent, scala.Function0<scala.Option<org.apache.spark.storage.StorageLevel>> invalidateCache, scala.Function4<org.apache.spark.sql.SparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.Option<java.lang.String>, org.apache.spark.storage.StorageLevel, scala.runtime.BoxedUnit> cacheTable)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
