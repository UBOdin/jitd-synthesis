package org.apache.spark.sql.execution.datasources.v2;
/**
 * The base physical plan for writing data into data source v2.
 */
public  interface V2TableWriteExec extends org.apache.spark.sql.execution.UnaryExecNode {
  public  org.apache.spark.sql.execution.SparkPlan child ()  ;
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> commitProgress ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.execution.SparkPlan query ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> writeWithV2 (org.apache.spark.sql.connector.write.BatchWrite batchWrite)  ;
}
