package org.apache.spark.sql.execution.datasources.v2;
  class PartitionedFileReader<T extends java.lang.Object> implements org.apache.spark.sql.connector.read.PartitionReader<T>, scala.Product, scala.Serializable {
  public  org.apache.spark.sql.execution.datasources.PartitionedFile file ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<T> reader ()  { throw new RuntimeException(); }
  // not preceding
  public   PartitionedFileReader (org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.connector.read.PartitionReader<T> reader)  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
  public  T get ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
