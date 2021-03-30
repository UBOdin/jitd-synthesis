package org.apache.spark.sql.execution.datasources;
/**
 * A collection of data files from a partitioned relation, along with the partition values in the
 * form of an {@link InternalRow}.
 */
public  class PartitionDirectory implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow values ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files ()  { throw new RuntimeException(); }
  // not preceding
  public   PartitionDirectory (org.apache.spark.sql.catalyst.InternalRow values, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
}
