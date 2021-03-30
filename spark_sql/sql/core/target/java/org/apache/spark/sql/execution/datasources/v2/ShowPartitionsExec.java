package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for showing partitions.
 */
public  class ShowPartitionsExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.LeafExecNode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partitionSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowPartitionsExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table, scala.Option<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partitionSpec)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
