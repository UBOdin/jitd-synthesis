package org.apache.spark.sql.catalyst.plans.logical;
/**
 *  CREATE FUNCTION statement, as parsed from SQL
 */
public  class CreateFunctionStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> functionName ()  { throw new RuntimeException(); }
  public  java.lang.String className ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources ()  { throw new RuntimeException(); }
  public  boolean isTemp ()  { throw new RuntimeException(); }
  public  boolean ignoreIfExists ()  { throw new RuntimeException(); }
  public  boolean replace ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateFunctionStatement (scala.collection.Seq<java.lang.String> functionName, java.lang.String className, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources, boolean isTemp, boolean ignoreIfExists, boolean replace)  { throw new RuntimeException(); }
}
