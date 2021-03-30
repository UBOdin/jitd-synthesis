package org.apache.spark.sql.execution.datasources;
/**
 * Simple metrics collected during an instance of {@link FileFormatDataWriter}.
 * These were first introduced in https://github.com/apache/spark/pull/18159 (SPARK-20703).
 */
public  class BasicWriteTaskStats implements org.apache.spark.sql.execution.datasources.WriteTaskStats, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> partitions ()  { throw new RuntimeException(); }
  public  int numFiles ()  { throw new RuntimeException(); }
  public  long numBytes ()  { throw new RuntimeException(); }
  public  long numRows ()  { throw new RuntimeException(); }
  // not preceding
  public   BasicWriteTaskStats (scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> partitions, int numFiles, long numBytes, long numRows)  { throw new RuntimeException(); }
}
