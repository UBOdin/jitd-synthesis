package org.apache.spark.sql.execution.datasources.v2;
/**
 * Sink progress information collected after commit.
 */
  class StreamWriterCommitProgress implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long numOutputRows ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamWriterCommitProgress (long numOutputRows)  { throw new RuntimeException(); }
}
