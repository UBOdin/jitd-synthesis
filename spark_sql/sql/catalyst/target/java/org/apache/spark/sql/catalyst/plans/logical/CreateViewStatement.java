package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A CREATE VIEW statement, as parsed from SQL.
 */
public  class CreateViewStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> viewName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, scala.Option<java.lang.String>>> userSpecifiedColumns ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> originalText ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  boolean allowExisting ()  { throw new RuntimeException(); }
  public  boolean replace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ViewType viewType ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateViewStatement (scala.collection.Seq<java.lang.String> viewName, scala.collection.Seq<scala.Tuple2<java.lang.String, scala.Option<java.lang.String>>> userSpecifiedColumns, scala.Option<java.lang.String> comment, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, scala.Option<java.lang.String> originalText, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, boolean allowExisting, boolean replace, org.apache.spark.sql.catalyst.analysis.ViewType viewType)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
