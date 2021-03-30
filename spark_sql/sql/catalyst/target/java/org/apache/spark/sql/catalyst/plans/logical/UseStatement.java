package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A USE statement, as parsed from SQL.
 */
public  class UseStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean isNamespaceSet ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> nameParts ()  { throw new RuntimeException(); }
  // not preceding
  public   UseStatement (boolean isNamespaceSet, scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
}
