package org.apache.spark.sql.execution.datasources.v2;
public  class FileWriterFactory implements org.apache.spark.sql.connector.write.DataWriterFactory, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.WriteJobDescription description ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.io.FileCommitProtocol committer ()  { throw new RuntimeException(); }
  // not preceding
  public   FileWriterFactory (org.apache.spark.sql.execution.datasources.WriteJobDescription description, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow> createWriter (int partitionId, long realTaskId)  { throw new RuntimeException(); }
}
