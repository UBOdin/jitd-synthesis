package org.apache.spark.sql.execution.streaming.sources;
public  class MemoryWriterCommitMessage implements org.apache.spark.sql.connector.write.WriterCommitMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int partition ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> data ()  { throw new RuntimeException(); }
  // not preceding
  public   MemoryWriterCommitMessage (int partition, scala.collection.Seq<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
}
