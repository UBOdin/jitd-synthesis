package org.apache.spark.sql.execution.datasources.v2;
  class DataWritingSparkTaskResult implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long numRows ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriterCommitMessage writerCommitMessage ()  { throw new RuntimeException(); }
  // not preceding
  public   DataWritingSparkTaskResult (long numRows, org.apache.spark.sql.connector.write.WriterCommitMessage writerCommitMessage)  { throw new RuntimeException(); }
}
