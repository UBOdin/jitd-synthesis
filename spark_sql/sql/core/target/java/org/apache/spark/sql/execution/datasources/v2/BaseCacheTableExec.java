package org.apache.spark.sql.execution.datasources.v2;
public  interface BaseCacheTableExec {
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> dataFrameForCachedPlan ()  ;
  public  boolean isLazy ()  ;
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan planToCache ()  ;
  public  java.lang.String relationName ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  ;
  public  org.apache.spark.sql.SparkSession sparkSession ()  ;
}
