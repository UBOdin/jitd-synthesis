package org.apache.spark.sql.execution.datasources.v2;
public  class CacheTableAsSelectExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.BaseCacheTableExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  java.lang.String tempViewName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  java.lang.String originalText ()  { throw new RuntimeException(); }
  public  boolean isLazy ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  // not preceding
  public   CacheTableAsSelectExec (java.lang.String tempViewName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, java.lang.String originalText, boolean isLazy, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  // not preceding
  public  java.lang.String relationName ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan planToCache ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> dataFrameForCachedPlan ()  { throw new RuntimeException(); }
}
