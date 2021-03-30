package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for renaming a table partition.
 */
public  class RenamePartitionExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec from ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec to ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  // not preceding
  public   RenamePartitionExec (org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table, org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec from, org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec to, scala.Function0<scala.runtime.BoxedUnit> refreshCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
