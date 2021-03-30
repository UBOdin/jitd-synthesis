package org.apache.spark.sql.execution.streaming.sources;
/** Common methods used to create writes for the console sink */
public  class ConsoleWrite implements org.apache.spark.sql.connector.write.streaming.StreamingWrite, org.apache.spark.internal.Logging {
  public   ConsoleWrite (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  void abort (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void commit (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory createStreamingWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  protected  boolean isTruncated ()  { throw new RuntimeException(); }
  protected  int numRowsToShow ()  { throw new RuntimeException(); }
  protected  void printRows (org.apache.spark.sql.connector.write.WriterCommitMessage[] commitMessages, org.apache.spark.sql.types.StructType schema, java.lang.String printMessage)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.SparkSession spark ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
