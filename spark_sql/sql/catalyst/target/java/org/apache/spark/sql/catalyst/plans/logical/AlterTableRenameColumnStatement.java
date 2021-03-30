package org.apache.spark.sql.catalyst.plans.logical;
/**
 * ALTER TABLE ... RENAME COLUMN command, as parsed from SQL.
 */
public  class AlterTableRenameColumnStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> column ()  { throw new RuntimeException(); }
  public  java.lang.String newName ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableRenameColumnStatement (scala.collection.Seq<java.lang.String> tableName, scala.collection.Seq<java.lang.String> column, java.lang.String newName)  { throw new RuntimeException(); }
}
