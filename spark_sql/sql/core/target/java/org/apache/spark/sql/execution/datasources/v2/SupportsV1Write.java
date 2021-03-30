package org.apache.spark.sql.execution.datasources.v2;
/**
 * A trait that allows Tables that use V1 Writer interfaces to append data.
 */
public  interface SupportsV1Write {
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> writeWithV1 (org.apache.spark.sql.sources.InsertableRelation relation)  ;
}
