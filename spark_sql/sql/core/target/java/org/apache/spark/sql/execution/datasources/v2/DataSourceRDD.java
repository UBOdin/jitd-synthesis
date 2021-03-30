package org.apache.spark.sql.execution.datasources.v2;
public  class DataSourceRDD extends org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> {
  // not preceding
  public   DataSourceRDD (org.apache.spark.SparkContext sc, scala.collection.Seq<org.apache.spark.sql.connector.read.InputPartition> inputPartitions, org.apache.spark.sql.connector.read.PartitionReaderFactory partitionReaderFactory, boolean columnarReads)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  protected  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getPreferredLocations (org.apache.spark.Partition split)  { throw new RuntimeException(); }
}
