package org.apache.spark.sql.execution.streaming;
/** An implementation of {@link CheckpointFileManager} using Hadoop's {@link FileSystem} API. */
public  class FileSystemBasedCheckpointFileManager implements org.apache.spark.sql.execution.streaming.CheckpointFileManager, org.apache.spark.sql.execution.streaming.CheckpointFileManager.RenameHelperMethods, org.apache.spark.internal.Logging {
  public   FileSystemBasedCheckpointFileManager (org.apache.hadoop.fs.Path path, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.CheckpointFileManager.CancellableFSDataOutputStream createAtomic (org.apache.hadoop.fs.Path path, boolean overwriteIfPossible)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.FSDataOutputStream createTempFile (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  void delete (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  boolean exists (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  protected  org.apache.hadoop.fs.FileSystem fs ()  { throw new RuntimeException(); }
  public  boolean isLocal ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.FileStatus[] list (org.apache.hadoop.fs.Path path, org.apache.hadoop.fs.PathFilter filter)  { throw new RuntimeException(); }
  public  void mkdirs (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.FSDataInputStream open (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  void renameTempFile (org.apache.hadoop.fs.Path srcPath, org.apache.hadoop.fs.Path dstPath, boolean overwriteIfPossible)  { throw new RuntimeException(); }
}
