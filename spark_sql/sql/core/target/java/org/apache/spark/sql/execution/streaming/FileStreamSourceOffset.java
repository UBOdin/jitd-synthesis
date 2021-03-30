package org.apache.spark.sql.execution.streaming;
/**
 * Offset for the {@link FileStreamSource}.
 * <p>
 * param:  logOffset  Position in the {@link FileStreamSourceLog}
 */
public  class FileStreamSourceOffset extends org.apache.spark.sql.execution.streaming.Offset implements scala.Product, scala.Serializable {
  static public  java.lang.Object format ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.FileStreamSourceOffset apply (org.apache.spark.sql.execution.streaming.Offset offset)  { throw new RuntimeException(); }
  public  long logOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   FileStreamSourceOffset (long logOffset)  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
