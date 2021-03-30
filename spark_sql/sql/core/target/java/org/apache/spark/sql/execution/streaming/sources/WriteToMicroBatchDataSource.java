package org.apache.spark.sql.execution.streaming.sources;
/**
 * The logical plan for writing data to a micro-batch stream.
 * <p>
 * Note that this logical plan does not have a corresponding physical plan, as it will be converted
 * to {@link WriteToDataSourceV2} with {@link MicroBatchWrite} before execution.
 */
public  class WriteToMicroBatchDataSource extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.streaming.StreamingWrite write ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  // not preceding
  public   WriteToMicroBatchDataSource (org.apache.spark.sql.connector.write.streaming.StreamingWrite write, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.v2.WriteToDataSourceV2 createPlan (long batchId)  { throw new RuntimeException(); }
}
