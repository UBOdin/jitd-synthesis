package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for showing table properties.
 */
public  class ShowTablePropertiesExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table catalogTable ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> propertyKey ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowTablePropertiesExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.connector.catalog.Table catalogTable, scala.Option<java.lang.String> propertyKey)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
