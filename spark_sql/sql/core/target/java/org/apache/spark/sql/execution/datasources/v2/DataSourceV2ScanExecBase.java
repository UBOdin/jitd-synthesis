package org.apache.spark.sql.execution.datasources.v2;
public  interface DataSourceV2ScanExecBase extends org.apache.spark.sql.execution.LeafExecNode {
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  ;
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  ;
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  ;
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  ;
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  ;
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.connector.read.InputPartition> partitions ()  ;
  public  org.apache.spark.sql.connector.read.PartitionReaderFactory readerFactory ()  ;
  /**
   * Shorthand for calling redact() without specifying redacting rules
   * @param text (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String redact (java.lang.String text)  ;
  public  org.apache.spark.sql.connector.read.Scan scan ()  ;
  public  java.lang.String simpleString (int maxFields)  ;
  public  boolean supportsColumnar ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
