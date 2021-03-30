package org.apache.spark.sql.execution.datasources.v2;
/**
 * A {@link PartitionReader} with empty output.
 */
public  class EmptyPartitionReader<T extends java.lang.Object> implements org.apache.spark.sql.connector.read.PartitionReader<T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   EmptyPartitionReader ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  T get ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
