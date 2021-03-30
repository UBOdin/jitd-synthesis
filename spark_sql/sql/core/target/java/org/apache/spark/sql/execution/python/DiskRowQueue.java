package org.apache.spark.sql.execution.python;
/**
 * A RowQueue that is backed by a file on disk. This queue will stop accepting new rows once any
 * reader has begun reading from the queue.
 */
  class DiskRowQueue implements org.apache.spark.sql.execution.python.RowQueue, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.io.File file ()  { throw new RuntimeException(); }
  public  int fields ()  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.SerializerManager serMgr ()  { throw new RuntimeException(); }
  // not preceding
  public   DiskRowQueue (java.io.File file, int fields, org.apache.spark.serializer.SerializerManager serMgr)  { throw new RuntimeException(); }
  public  boolean add (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow remove ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
}
