package org.apache.spark.sql.execution.datasources.v2;
public  class PartitionRecordReader<T extends java.lang.Object> implements org.apache.spark.sql.connector.read.PartitionReader<T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   PartitionRecordReader (org.apache.hadoop.mapreduce.RecordReader<?, T> rowReader)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  T get ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
