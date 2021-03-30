package org.apache.spark.sql.execution.streaming.sources;
/**
 * A {@link DataWriter} which writes data in this partition to a {@link ForeachWriter}.
 * <p>
 * param:  writer The {@link ForeachWriter} to process all data.
 * param:  rowConverter A function which can convert {@link InternalRow} to the required type {@link T}
 * param:  partitionId
 * param:  epochId
 * @param <T>  The type expected by the writer.
 */
public  class ForeachDataWriter<T extends java.lang.Object> implements org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   ForeachDataWriter (org.apache.spark.sql.ForeachWriter<T> writer, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T> rowConverter, int partitionId, long epochId)  { throw new RuntimeException(); }
  public  void abort ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriterCommitMessage commit ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow record)  { throw new RuntimeException(); }
}
