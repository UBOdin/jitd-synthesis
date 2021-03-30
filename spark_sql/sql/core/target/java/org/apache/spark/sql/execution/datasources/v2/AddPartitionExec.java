package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for adding partitions of table.
 */
public  class AddPartitionExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partSpecs ()  { throw new RuntimeException(); }
  public  boolean ignoreIfExists ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  // not preceding
  public   AddPartitionExec (org.apache.spark.sql.connector.catalog.SupportsPartitionManagement table, scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> partSpecs, boolean ignoreIfExists, scala.Function0<scala.runtime.BoxedUnit> refreshCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
