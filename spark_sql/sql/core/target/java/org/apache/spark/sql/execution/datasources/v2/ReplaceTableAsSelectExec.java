package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for v2 replace table as select when the catalog does not support staging
 * table replacement.
 * <p>
 * A new table will be created using the schema of the query, and rows from the query are appended.
 * If the table exists, its contents and schema should be replaced with the schema and the contents
 * of the query. This is a non-atomic implementation that drops the table and then runs non-atomic
 * CTAS. For an atomic implementation for catalogs with the appropriate support, see
 * ReplaceTableAsSelectStagingExec.
 */
public  class ReplaceTableAsSelectExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.TableWriteExecHelper, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> commitProgress ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier ident ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan query ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap writeOptions ()  { throw new RuntimeException(); }
  public  boolean orCreate ()  { throw new RuntimeException(); }
  public  scala.Function3<org.apache.spark.sql.connector.catalog.TableCatalog, org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.Identifier, scala.runtime.BoxedUnit> invalidateCache ()  { throw new RuntimeException(); }
  // not preceding
  public   ReplaceTableAsSelectExec (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier ident, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.execution.SparkPlan query, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, org.apache.spark.sql.util.CaseInsensitiveStringMap writeOptions, boolean orCreate, scala.Function3<org.apache.spark.sql.connector.catalog.TableCatalog, org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.Identifier, scala.runtime.BoxedUnit> invalidateCache)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
