package org.apache.spark.sql.execution.datasources.v2;
/**
 * Deprecated logical plan for writing data into data source v2. This is being replaced by more
 * specific logical plans, like {@link org.apache.spark.sql.catalyst.plans.logical.AppendData}.
 *
 * @deprecated Use specific logical plans like AppendData instead. Since 2.4.0. 
 */
public  class WriteToDataSourceV2 extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.BatchWrite batchWrite ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  // not preceding
  public   WriteToDataSourceV2 (org.apache.spark.sql.connector.write.BatchWrite batchWrite, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
