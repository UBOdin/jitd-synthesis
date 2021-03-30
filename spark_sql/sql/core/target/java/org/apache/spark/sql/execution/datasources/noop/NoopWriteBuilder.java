package org.apache.spark.sql.execution.datasources.noop;
public  class NoopWriteBuilder {
  static public  org.apache.spark.sql.connector.write.WriteBuilder truncate ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.write.BatchWrite buildForBatch ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.write.streaming.StreamingWrite buildForStreaming ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.write.Write build ()  { throw new RuntimeException(); }
}
