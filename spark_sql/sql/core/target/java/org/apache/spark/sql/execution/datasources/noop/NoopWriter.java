package org.apache.spark.sql.execution.datasources.noop;
public  class NoopWriter {
  static public  void write (org.apache.spark.sql.catalyst.InternalRow record)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.write.WriterCommitMessage commit ()  { throw new RuntimeException(); }
  static public  void abort ()  { throw new RuntimeException(); }
  static public  void close ()  { throw new RuntimeException(); }
}
