package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for dropping partitions of table.
 */
public  class DropPartitionExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partSpecs ()  { throw new RuntimeException(); }
  public  boolean ignoreIfNotExists ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  // not preceding
  public   DropPartitionExec (org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table, scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partSpecs, boolean ignoreIfNotExists, boolean purge, scala.Function0<scala.runtime.BoxedUnit> refreshCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
