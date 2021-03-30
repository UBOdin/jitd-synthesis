package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for setting properties of namespace.
 */
public  class AlterNamespaceSetPropertiesExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsNamespaces catalog ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> namespace ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> props ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterNamespaceSetPropertiesExec (org.apache.spark.sql.connector.catalog.SupportsNamespaces catalog, scala.collection.Seq<java.lang.String> namespace, scala.collection.immutable.Map<java.lang.String, java.lang.String> props)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
