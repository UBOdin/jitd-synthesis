package org.apache.spark.sql.catalyst.plans.logical;
/**
 * ALTER TABLE ... DROP COLUMNS command, as parsed from SQL.
 */
public  class AlterTableDropColumnsStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<java.lang.String>> columnsToDrop ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableDropColumnsStatement (scala.collection.Seq<java.lang.String> tableName, scala.collection.Seq<scala.collection.Seq<java.lang.String>> columnsToDrop)  { throw new RuntimeException(); }
}
