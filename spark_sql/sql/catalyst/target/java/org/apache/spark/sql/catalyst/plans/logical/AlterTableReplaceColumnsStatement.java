package org.apache.spark.sql.catalyst.plans.logical;
public  class AlterTableReplaceColumnsStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.QualifiedColType> columnsToAdd ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableReplaceColumnsStatement (scala.collection.Seq<java.lang.String> tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.QualifiedColType> columnsToAdd)  { throw new RuntimeException(); }
}
