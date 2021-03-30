package org.apache.spark.sql.execution.streaming.sources;
public  class MemoryWriterFactory implements org.apache.spark.sql.connector.write.DataWriterFactory, org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  // not preceding
  public   MemoryWriterFactory (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow> createWriter (int partitionId, long taskId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow> createWriter (int partitionId, long taskId, long epochId)  { throw new RuntimeException(); }
}
