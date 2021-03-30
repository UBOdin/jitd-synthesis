package org.apache.spark.sql.execution.streaming;
/**
 * An interface to abstract out all operation related to streaming checkpoints. Most importantly,
 * the key operation this interface provides is <code>createAtomic(path, overwrite)</code> which returns a
 * <code>CancellableFSDataOutputStream</code>. This method is used by {@link HDFSMetadataLog} and
 * {@link org.apache.spark.sql.execution.streaming.state.StateStore StateStore} implementations
 * to write a complete checkpoint file atomically (i.e. no partial file will be visible), with or
 * without overwrite.
 * <p>
 * This higher-level interface above the Hadoop FileSystem is necessary because
 * different implementation of FileSystem/FileContext may have different combination of operations
 * to provide the desired atomic guarantees (e.g. write-to-temp-file-and-rename,
 * direct-write-and-cancel-on-failure) and this abstraction allow different implementations while
 * keeping the usage simple (<code>createAtomic</code> -> <code>close</code> or <code>cancel</code>).
 */
public  interface CheckpointFileManager {
  /**
   * Additional methods in CheckpointFileManager implementations that allows
   * {@link RenameBasedFSDataOutputStream} get atomicity by write-to-temp-file-and-rename
   */
  static public  interface RenameHelperMethods {
    /** Create a file with overwrite. */
    public  org.apache.hadoop.fs.FSDataOutputStream createTempFile (org.apache.hadoop.fs.Path path)  ;
    /**
     * Rename a file.
     * <p>
     * @param srcPath             Source path to rename
     * @param dstPath             Destination path to rename to
     * @param overwriteIfPossible If true, then the implementations must do a best-effort attempt to
     *                            overwrite the file if it already exists. It should not throw
     *                            any exception if the file exists. However, if false, then the
     *                            implementation must not overwrite if the file already exists and
     *                            must throw <code>FileAlreadyExistsException</code> in that case.
     */
    public  void renameTempFile (org.apache.hadoop.fs.Path srcPath, org.apache.hadoop.fs.Path dstPath, boolean overwriteIfPossible)  ;
  }
  /**
   * An interface to add the cancel() operation to {@link FSDataOutputStream}. This is used
   * mainly by <code>CheckpointFileManager.createAtomic</code> to write a file atomically.
   * <p>
   * @see {@link CheckpointFileManager}.
   */
  static public abstract class CancellableFSDataOutputStream extends org.apache.hadoop.fs.FSDataOutputStream {
    // not preceding
    public   CancellableFSDataOutputStream (java.io.OutputStream underlyingStream)  { throw new RuntimeException(); }
    /** Cancel the `underlyingStream` and ensure that the output file is not generated. */
    public abstract  void cancel ()  ;
    protected  java.io.OutputStream underlyingStream ()  { throw new RuntimeException(); }
  }
  /**
   * An implementation of {@link CancellableFSDataOutputStream} that writes a file atomically by writing
   * to a temporary file and then renames.
   */
  static public  class RenameBasedFSDataOutputStream extends org.apache.spark.sql.execution.streaming.CheckpointFileManager.CancellableFSDataOutputStream {
    public   RenameBasedFSDataOutputStream (org.apache.spark.sql.execution.streaming.CheckpointFileManager fm, org.apache.hadoop.fs.Path finalPath, org.apache.hadoop.fs.Path tempPath, boolean overwriteIfPossible)  { throw new RuntimeException(); }
    public   RenameBasedFSDataOutputStream (org.apache.spark.sql.execution.streaming.CheckpointFileManager fm, org.apache.hadoop.fs.Path path, boolean overwrite)  { throw new RuntimeException(); }
    public  void cancel ()  { throw new RuntimeException(); }
    public  void close ()  { throw new RuntimeException(); }
  }
  /**
   * Create a file and make its contents available atomically after the output stream is closed.
   * <p>
   * @param path                Path to create
   * @param overwriteIfPossible If true, then the implementations must do a best-effort attempt to
   *                            overwrite the file if it already exists. It should not throw
   *                            any exception if the file exists. However, if false, then the
   *                            implementation must not overwrite if the file already exists and
   *                            must throw <code>FileAlreadyExistsException</code> in that case.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.CheckpointFileManager.CancellableFSDataOutputStream createAtomic (org.apache.hadoop.fs.Path path, boolean overwriteIfPossible)  ;
  /** Open a file for reading, or throw exception if it does not exist. */
  public  org.apache.hadoop.fs.FSDataInputStream open (org.apache.hadoop.fs.Path path)  ;
  /** List the files in a path that match a filter. */
  public  org.apache.hadoop.fs.FileStatus[] list (org.apache.hadoop.fs.Path path, org.apache.hadoop.fs.PathFilter filter)  ;
  /** List all the files in a path. */
  public  org.apache.hadoop.fs.FileStatus[] list (org.apache.hadoop.fs.Path path)  ;
  /** Make directory at the give path and all its parent directories as needed. */
  public  void mkdirs (org.apache.hadoop.fs.Path path)  ;
  /** Whether path exists */
  public  boolean exists (org.apache.hadoop.fs.Path path)  ;
  /** Recursively delete a path if it exists. Should not throw exception if file doesn't exist. */
  public  void delete (org.apache.hadoop.fs.Path path)  ;
  /** Is the default file system this implementation is operating on the local file system. */
  public  boolean isLocal ()  ;
}
