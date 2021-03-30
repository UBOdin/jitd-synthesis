package org.apache.spark.sql.execution;
public  class SparkScriptTransformationWriterThread extends org.apache.spark.sql.execution.BaseScriptTransformationWriterThread implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ScriptTransformationIOSchema ioSchema ()  { throw new RuntimeException(); }
  public  java.io.OutputStream outputStream ()  { throw new RuntimeException(); }
  public  java.lang.Process proc ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.CircularBuffer stderrBuffer ()  { throw new RuntimeException(); }
  public  org.apache.spark.TaskContext taskContext ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration conf ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkScriptTransformationWriterThread (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter, scala.collection.Seq<org.apache.spark.sql.types.DataType> inputSchema, org.apache.spark.sql.execution.ScriptTransformationIOSchema ioSchema, java.io.OutputStream outputStream, java.lang.Process proc, org.apache.spark.util.CircularBuffer stderrBuffer, org.apache.spark.TaskContext taskContext, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  public  void processRows ()  { throw new RuntimeException(); }
}
