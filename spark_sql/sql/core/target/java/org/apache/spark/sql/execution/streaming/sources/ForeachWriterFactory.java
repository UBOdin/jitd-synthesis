package org.apache.spark.sql.execution.streaming.sources;
public  class ForeachWriterFactory<T extends java.lang.Object> implements org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory, scala.Product, scala.Serializable {
  public  org.apache.spark.sql.ForeachWriter<T> writer ()  { throw new RuntimeException(); }
  public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T> rowConverter ()  { throw new RuntimeException(); }
  // not preceding
  public   ForeachWriterFactory (org.apache.spark.sql.ForeachWriter<T> writer, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T> rowConverter)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.ForeachDataWriter<T> createWriter (int partitionId, long taskId, long epochId)  { throw new RuntimeException(); }
}
