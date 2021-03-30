package org.apache.spark.sql.execution.datasources.v2;
public  class ReplaceTableExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier ident ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType tableSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> tableProperties ()  { throw new RuntimeException(); }
  public  boolean orCreate ()  { throw new RuntimeException(); }
  public  scala.Function3<org.apache.spark.sql.connector.catalog.TableCatalog, org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.Identifier, scala.runtime.BoxedUnit> invalidateCache ()  { throw new RuntimeException(); }
  // not preceding
  public   ReplaceTableExec (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.types.StructType tableSchema, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning, scala.collection.immutable.Map<java.lang.String, java.lang.String> tableProperties, boolean orCreate, scala.Function3<org.apache.spark.sql.connector.catalog.TableCatalog, org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.Identifier, scala.runtime.BoxedUnit> invalidateCache)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
