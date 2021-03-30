package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for dropping a table.
 */
public  class DropTableExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier ident ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> invalidateCache ()  { throw new RuntimeException(); }
  // not preceding
  public   DropTableExec (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier ident, boolean ifExists, boolean purge, scala.Function0<scala.runtime.BoxedUnit> invalidateCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
