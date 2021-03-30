package org.apache.spark.sql.execution.streaming;
/**
 * The status of a file outputted by {@link FileStreamSink}. A file is visible only if it appears in
 * the sink log and its action is not "delete".
 * <p>
 * param:  path the file path.
 * param:  size the file size.
 * param:  isDir whether this file is a directory.
 * param:  modificationTime the file last modification time.
 * param:  blockReplication the block replication.
 * param:  blockSize the block size.
 * param:  action the file action. Must be either "add" or "delete".
 */
public  class SinkFileStatus implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.SinkFileStatus apply (org.apache.hadoop.fs.FileStatus f)  { throw new RuntimeException(); }
  public  java.lang.String path ()  { throw new RuntimeException(); }
  public  long size ()  { throw new RuntimeException(); }
  public  boolean isDir ()  { throw new RuntimeException(); }
  public  long modificationTime ()  { throw new RuntimeException(); }
  public  int blockReplication ()  { throw new RuntimeException(); }
  public  long blockSize ()  { throw new RuntimeException(); }
  public  java.lang.String action ()  { throw new RuntimeException(); }
  // not preceding
  public   SinkFileStatus (java.lang.String path, long size, boolean isDir, long modificationTime, int blockReplication, long blockSize, java.lang.String action)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.FileStatus toFileStatus ()  { throw new RuntimeException(); }
}
