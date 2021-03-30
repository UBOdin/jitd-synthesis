package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for table truncation.
 */
public  class TruncateTableExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TruncatableTable table ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  // not preceding
  public   TruncateTableExec (org.apache.spark.sql.connector.catalog.TruncatableTable table, scala.Function0<scala.runtime.BoxedUnit> refreshCache)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
}
