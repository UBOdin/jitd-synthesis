package org.apache.spark.sql.execution;
/** Physical plan node for scanning data from an RDD. */
public  class ExternalRDDScanExec<T extends java.lang.Object> extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LeafExecNode, org.apache.spark.sql.execution.ObjectProducerExec, scala.Product, scala.Serializable {
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<T> rdd ()  { throw new RuntimeException(); }
  // not preceding
  public   ExternalRDDScanExec (org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.rdd.RDD<T> rdd)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
