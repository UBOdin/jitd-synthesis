package org.apache.spark.sql.execution.datasources;
public  class PartitionPath implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.datasources.PartitionPath apply (org.apache.spark.sql.catalyst.InternalRow values, java.lang.String path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow values ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path path ()  { throw new RuntimeException(); }
  // not preceding
  public   PartitionPath (org.apache.spark.sql.catalyst.InternalRow values, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
}
