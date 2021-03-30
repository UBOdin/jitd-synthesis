package org.apache.spark.sql.catalyst.catalog;
public  class FunctionResource implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.FunctionResourceType resourceType ()  { throw new RuntimeException(); }
  public  java.lang.String uri ()  { throw new RuntimeException(); }
  // not preceding
  public   FunctionResource (org.apache.spark.sql.catalyst.catalog.FunctionResourceType resourceType, java.lang.String uri)  { throw new RuntimeException(); }
}
