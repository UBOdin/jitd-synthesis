package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for describing a namespace.
 */
public  class DescribeNamespaceExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsNamespaces catalog ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> namespace ()  { throw new RuntimeException(); }
  public  boolean isExtended ()  { throw new RuntimeException(); }
  // not preceding
  public   DescribeNamespaceExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.connector.catalog.SupportsNamespaces catalog, scala.collection.Seq<java.lang.String> namespace, boolean isExtended)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
